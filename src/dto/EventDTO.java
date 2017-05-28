package dto;

import java.util.Date;

public class EventDTO {

	private int id;
	private String name;
	private Date eventDate;
	private String description;
	private int availableTickets;
	private int ticketPrice;
	
	public EventDTO(){}
	
	public EventDTO(int id, String name, Date eventDate, String description, int availableTickets, int ticketPrice) {
		super();
		this.id = id;
		this.name = name;
		this.eventDate = eventDate;
		this.description = description;
		this.availableTickets = availableTickets;
		this.ticketPrice = ticketPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	
	
	
}
