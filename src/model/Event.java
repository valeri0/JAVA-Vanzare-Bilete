package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EVENT",schema="ubis")
@NamedQuery(name="getAllEvents",query="SELECT e from Event e")
public class Event {
	
	@Id
	@SequenceGenerator(name="event_sequence", schema="ubis", sequenceName="event_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
	private int id;
	
	private String name;
	
	@Column(name="event_date")
	private Date eventDate;
	
	private String description;
	
	@Column(name="available_tickets")
	private int availableTickets;
	
	@Column(name="ticket_price")
	private int ticketPrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable
	(
		name="EVENT_TICKET",
			joinColumns={
					@JoinColumn(name="EVENT_ID",referencedColumnName="ID")
			},
		
			inverseJoinColumns={
					@JoinColumn(name="TICKET_ID",referencedColumnName="ID",unique=true)
			}
		
	)
	//Evenimentul are o lista de bilete cumparate
	private List<Ticket> boughtTickets;

	public Event(){}

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

	public List<Ticket> getBoughtTickets() {
		return boughtTickets;
	}
	
	
	/*
	 	Pentru a cumpara un bilet de la un eveniment, vom adauga biletul solicitat
	 	la lista de bilete din cadrul evenimentului
	*/
	public void addBoughtTicket(Ticket ticket){
		this.boughtTickets.add(ticket);
	}
	
	
	
	
}
