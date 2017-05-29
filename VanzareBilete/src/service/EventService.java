package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import dto.EventDTO;
import model.Event;
import model.Ticket;

public class EventService{

	EntityManager entityManager;
	
	public EventService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vanzareBilete");
		entityManager = factory.createEntityManager();
	}
	
	//Functie ce mapeaza un obiect de tipul EventDao la modelul Event
	public EventDTO mapDaoToModel(Event event){
		EventDTO eventDTO = new EventDTO();
		
		eventDTO.setAvailableTickets(event.getAvailableTickets());
		eventDTO.setDescription(event.getDescription());
		eventDTO.setEventDate(event.getEventDate());
		eventDTO.setId(event.getId());
		eventDTO.setName(event.getName());
		eventDTO.setTicketPrice(event.getTicketPrice());
		
		return eventDTO;
	}
	
	//Functie ce returneaza toate obiectele de tip Event din baza de date
	public List<EventDTO> getEvents(){
		
		
		//Preluam evenimentele din baza de date prin interogare
		Query query = entityManager.createNamedQuery("getAllEvents");
		List<Event> events = query.getResultList();

		
		//mapam obiectele obtinute in DTO-uri pentru a fi afisate
		List<EventDTO> eventDTOs = new ArrayList<>();
		
		for(Event dao : events){
			eventDTOs.add(this.mapDaoToModel(dao));
		}
	
		
		return eventDTOs;
	}
	
	public Event findEventById(int eventId) throws Exception{
		
		Event event = entityManager.find(Event.class, eventId);
		if(event == null){
			throw new Exception("Event with id: " + eventId + " does not exist!");
		}
		return event;
	}
	
	public void buyTicket(int eventId,Ticket ticket) throws Exception{
		
		
		//cautam evenimentul pentru care se doreste a fi cumparat un bilet
		Event event = findEventById(eventId);
		
		//retinem numarul de bilete disponibile
		int availableTickets = event.getAvailableTickets();
		
		if( availableTickets == 0){
			throw new Exception("Sorry there are no more tickets left!");
		}
		else
		{
			
			entityManager.getTransaction().begin();

			entityManager.persist(ticket);
			
			//adaugam biletul la lista de bilete cumparate a evenimentului si decrementam numarul de bilete disponibile
			event.addBoughtTicket(ticket);
			event.setAvailableTickets(availableTickets-1);
			
			entityManager.getTransaction().commit();
	
		}
		
	}
	
	public void cancelTicket(int ticketId) throws Exception{
		

		
		//cautam biletul ce trebuie anulat
		Ticket ticket = ServiceFactory.getTicketService().findTicketById(ticketId);

		if(ticket.isCanceled() == true){
			throw new Exception("Ticket is already canceled!");
		}
		
		else{
			
			entityManager.getTransaction().begin();

		
			Event event = findEventById(ticket.getEvent().getId());

			
			//anulam biletul
			ticket.setCanceled(true);
			
			//deoarece am anulat biletul, se va incrementa numarul de bilete disponibile
			event.setAvailableTickets(event.getAvailableTickets()+1);
			
			
			entityManager.getTransaction().commit();
		}
	}
	
}