package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="TICKET",schema="ubis")
@NamedQuery(name="getTicketById",query="SELECT t from Ticket t where t.id = :value")
public class Ticket {

	@Id
	@SequenceGenerator(name="ticket_sequence", schema="ubis", sequenceName="ticket_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence")
	private int id;
	
	private String owner;
	
	@Column(name="IS_CANCELED")
	private boolean isCanceled;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="BOUGHT_AT")
	private Date boughtAt;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
    		
    		name="EVENT_TICKET",
			joinColumns={
					@JoinColumn(name="TICKET_ID",referencedColumnName="ID",unique=true)
			},
		
			inverseJoinColumns={
					@JoinColumn(name="EVENT_ID",referencedColumnName="ID")
			}
    )
    private Event event;
    
	
	public Ticket(){}

	public Ticket(int id, String owner, boolean isCanceled, Date boughtAt) {
		super();
		this.id = id;
		this.owner = owner;
		this.isCanceled = isCanceled;
		this.boughtAt = boughtAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public Date getBoughtAt() {
		return boughtAt;
	}

	public void setBoughtAt(Date boughtAt) {
		this.boughtAt = boughtAt;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
	 
	
	
	
}
