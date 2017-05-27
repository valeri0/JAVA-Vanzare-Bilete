package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.naming.factory.TransactionFactory;

import dao.EventDao;
import dao.TicketDao;
import model.Event;
import model.Ticket;

public class EventService{

	EntityManager entityManager;
	
	public EventService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vanzareBilete");
		entityManager = factory.createEntityManager();
	}
	
	//Functie ce mapeaza un obiect de tipul EventDao la modelul Event
	public Event mapDaoToModel(EventDao dao){
		Event event = new Event();
		
		event.setAvailableTickets(dao.getAvailableTickets());
		event.setDescription(dao.getDescription());
		event.setEventDate(dao.getEventDate());
		event.setId(dao.getId());
		event.setName(dao.getName());
		event.setTicketPrice(dao.getTicketPrice());
		
		return event;
	}
	
	//Functie ce returneaza toate obiectele de tip Event din baza de date
	public List<Event> getEvents(){
		List<EventDao> eventDaos = (List<EventDao>)entityManager.createNamedQuery("getAllEvents").getResultList();
		
		List<Event> events = new ArrayList<>();
		
		for(EventDao dao : eventDaos){
			events.add(this.mapDaoToModel(dao));
		}
	
		
		return events;
	}
	
	public void buyTicket(int eventId,TicketDao ticket) throws Exception{
		
		
		//cautam evenimentul pentru care se doreste a fi cumparat un bilet
		EventDao eventDao = entityManager.find(EventDao.class, eventId);
		
		int availableTickets = eventDao.getAvailableTickets();
		
		if( availableTickets == 0){
			throw new Exception("Sorry there are no more tickets left!");
		}
		else
		{
			
			entityManager.getTransaction().begin();

			//adaugam biletul la lista de bilete cumparate a evenimentului si decrementam numarul de bilete disponibile
			eventDao.addBoughtTicket(ticket);
			eventDao.setAvailableTickets(availableTickets-1);
		
			entityManager.getTransaction().commit();
	
		}
		
	}
	
}