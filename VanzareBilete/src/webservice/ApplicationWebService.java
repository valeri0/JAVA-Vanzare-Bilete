package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.persistence.internal.oxm.record.json.JsonParserReader;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import dto.EventDTO;
import dto.TicketDTO;
import model.Ticket;
import service.EventService;
import service.ServiceFactory;
import service.TicketService;



@Path("/app")
public class ApplicationWebService {
	

	/*
	 * Resturneaza un JSON cu toate evenimentele in detaliu
	 * Exemplu de cerere: http://localhost:9090/VanzareBilet/rest/app/list_events
	 */
	@GET 
	@Path("/list_events") 
	@Produces({MediaType.APPLICATION_JSON})
	public List<EventDTO> getEvents(){
		return ServiceFactory.getEventService().getEvents();
	}
	
	
	/*
	 * Pentru un id dat ca parametru, returneaza un JSON cu toate detaliile unui bilet
	 * 
	 * Exemplu de cerere: http://localhost:9090/VanzareBilet/rest/app/ticket_details?id=1
	 */
	@GET
	@Path("/ticket_details")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getTicketDetails(@QueryParam("id") int id){
		
		TicketDTO ticket = null;
		String message = null;
		
		try {
			ticket = ServiceFactory.getTicketService().getTicketDetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		
		//in caz ca biletul exista, returnam un raspuns pozitiv si detaliile biletului
		if(ticket != null){
			return Response.status(Status.OK).entity(ticket).build();
		}
		
		//in cazul in care nu exista vom afisa un mesaj de eroare
		return Response.status(Status.NOT_FOUND).entity(message).build();
	}
	
	
	
	/*
	 	Inregistreaza un bilet ca fiind achizitionat si scade automat din stocul
	 	biletelor disponibile la eveniment
	 	
	 	Exemplu de cerere: localhost:9090/VanzareBilete/rest/app/buy_ticket
	 	
	 	Primeste un JSON, avand urmatoarea forma:
	 	
	 	{
			"eventId": value,
			"owner": value
		}
		
		Unde: eventId -> id-ul evenimentului la care se doreste achizitionarea biletului
			  owner -> numele celui care achiztioneaza biletul
	 	
	 */
	@POST
	@Path("/buy_ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buyTicket(TicketDTO ticketDTO){
		
		//instantiem serviciile de care avem nevoie
		EventService eventService = ServiceFactory.getEventService();
		TicketService ticketService = ServiceFactory.getTicketService();
		
		//retinem id-ul eventimentului la care utilizatorul doreste sa cumpere bilet
		int eventId = ticketDTO.getEventId();
		
		//mapam informatiile pentru bilet
		Ticket ticket = ticketService.mapDtoToModel(ticketDTO);
		
		String message;
		int status;
		
		try {
			/*
			 	Cazul in care sunt bilete disponibile la eveniment
			 	si se achizitioneaza cu succes biletul
			 */
			
			eventService.buyTicket(ticketDTO.getEventId(), ticket);
			message = "Succesfully bought ticket for the event with id " + eventId;
			status=201;
			 
		} catch (Exception e) {
			//cazul contrar
			message= e.getMessage();
			status=404;
		}
		
		
		return Response.status(status).entity(message).build();
		
	}
	
	/*
	 	Functia inregistreaza anularea unui bilet
	 	Exemplu de cerere: localhost:9090/VanzareBilete/rest/app/cancel_ticket
	 	
	 	Primeste un JSON avand urmatoarea structura:
	 	
	 	{
	 		"id": value
	 	}
	 	
	 	Unde: id -> id-ul biletului ce va fi anulat
	 		  
	 	
	 	
	 */
	@POST
	@Path("/cancel_ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response cancelTicket(String json){
				
		//folosindu-ne de utilitarele de la Gson, preluam valoarea id-ului din JSON-ul primit
		JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
		int id = jsonObject.get("id").getAsInt();
		
		//Mesajul implicit de succes
		String 	message="The ticket with id " + id + " was successfully canceled!";
		int status = 201; //implicit este statusul de succes
		
		//in caz de nereusita, se va schimba mesajul
		try {
			ServiceFactory.getEventService().cancelTicket(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
			status = 404;
		}
		
		return Response.status(status).entity(message).build();
	}
	
	
	
}
