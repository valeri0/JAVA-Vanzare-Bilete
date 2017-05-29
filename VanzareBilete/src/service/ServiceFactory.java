package service;

public class ServiceFactory {
	
	private static EventService eventService;
	private static TicketService ticketService;
	
	public static EventService getEventService(){
		if(eventService == null){
			eventService = new EventService();
		}
		return eventService;
	}
	
	public static TicketService getTicketService(){
		if(ticketService == null){
			ticketService = new TicketService();
		}
		return ticketService;
	}
}
