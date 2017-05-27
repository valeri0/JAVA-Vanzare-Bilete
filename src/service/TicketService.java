package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.TicketDao;
import model.Ticket;

public class TicketService {
	
	EntityManager entityManager;
	
	TicketService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vanzareBilete");
		entityManager = factory.createEntityManager();
	}
	
	//Functie ce mapeaza un obiect de tip TicketDao la modelul Ticket
	public Ticket mapDaoToModel(TicketDao dao){
		Ticket ticket = new Ticket();
		
		ticket.setId(dao.getId());
		ticket.setOwner(dao.getOwner());
		ticket.setBoughtAt(dao.getBoughtAt());
		
		return ticket;
	}
	
	//Functie ce mapeaza un model Ticket la un obiect de tipul TicketDao
	public TicketDao mapModelToDao(Ticket model){
		
		TicketDao dao = new TicketDao();
		
		dao.setBoughtAt(model.getBoughtAt());
		dao.setOwner(model.getOwner());
		
		return dao;
	}
	
	//Functie ce returneaza un Ticket cautat dupa id-ul sau
	public Ticket getTicketDetails(int id){
		
		TicketDao dao = (TicketDao)entityManager.createNamedQuery("getTicketById").setParameter("value", id).getSingleResult();
		
		Ticket ticket = mapDaoToModel(dao);
		
		return ticket;
		
		
	}
}
