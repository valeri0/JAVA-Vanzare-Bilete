package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.TicketDao;
import model.Event;
import model.Ticket;
import service.EventService;
import service.ServiceFactory;
import service.TicketService;

@Path("/app")
public class ApplicationWebService {
	

	@GET 
	@Path("/list_events") 
	@Produces({MediaType.APPLICATION_JSON})
	public List<Event> getEvents(){
		return ServiceFactory.getEventService().getEvents();
	}
	
	@GET
	@Path("/ticket_details")
	@Produces({MediaType.APPLICATION_JSON})
	public Ticket getTicketDetails(@QueryParam("id") int id){
		
		Ticket ticket = ServiceFactory.getTicketService().getTicketDetails(id);
		
		if(ticket == null){
			ticket = new Ticket();
		}
		return ticket;
	}
	
	@POST
	@Path("/buy_ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buyTicket(Ticket ticket){
		
		//instantiem serviciile de care avem nevoie
		EventService eventService = ServiceFactory.getEventService();
		TicketService ticketService = ServiceFactory.getTicketService();
		
		//retinem id-ul eventimentului la care utilizatorul doreste sa cumpere bilet
		int eventId = ticket.getEventId();
		
		//mapam informatiile pentru bilet
		TicketDao ticketDao = ticketService.mapModelToDao(ticket);
		
		String message;
		
		try {
			//cazul in care sunt bilete disponibile la eveniment
			eventService.buyTicket(ticket.getEventId(), ticketDao);
			 message = "Succesfully bought ticket for the event with id " + eventId;

		} catch (Exception e) {
			//cazul contrar
			message= e.getMessage();
		}
		
		
		return Response.status(201).entity(message).build();
		
	}
	
}
