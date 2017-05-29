package service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import dto.TicketDTO;
import model.Event;
import model.Ticket;

public class TicketService {
	
	EntityManager entityManager;
	
	TicketService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vanzareBilete");
		entityManager = factory.createEntityManager();
	}
	
	//Functie ce mapeaza un obiect de tip Ticket la modelul TicketDTO
	public TicketDTO mapModelToDto(Ticket ticket){
		TicketDTO ticketDTO = new TicketDTO();
		
		ticketDTO.setId(ticket.getId());
		ticketDTO.setOwner(ticket.getOwner());
		ticketDTO.setBoughtAt(ticket.getBoughtAt());
		ticketDTO.setCanceled(ticket.isCanceled());
		ticketDTO.setEventId(ticket.getEvent().getId());
		
		return ticketDTO;
	}
	
	//Functie ce mapeaza un TicketDTO la un obiect de tipul Ticket
	public Ticket mapDtoToModel(TicketDTO model){
		
		Ticket ticket = new Ticket();
		
		ticket.setOwner(model.getOwner());
		ticket.setBoughtAt(new Date());
		ticket.setCanceled(false);
		
		
		return ticket;
	}
	
	//Functie ce returneaza un TicketDTO cautat dupa id-ul sau
	public TicketDTO getTicketDetails(int id) throws Exception{
		
		Ticket ticket = findTicketById(id);
	
		TicketDTO ticketDTO = mapModelToDto(ticket);
		
		return ticketDTO;
		
		
	}

	public Ticket findTicketById(int id) throws Exception{
		Ticket ticket;
		
		ticket = entityManager.find(Ticket.class, id);
		
		if(ticket == null){
			throw new Exception("The ticket with id " + id + " does not exist!");
		}
		
		return ticket;
	}

	
}
