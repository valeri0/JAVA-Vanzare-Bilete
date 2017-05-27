package model;

import java.util.Date;

public class Ticket {
	
	private int id;
	private String owner;
	private Date boughtAt;
	private int eventId;
	
	public Ticket(){}
	
	

	public Ticket(int id, String owner, Date boughtAt, int eventId) {
		super();
		this.id = id;
		this.owner = owner;
		this.boughtAt = boughtAt;
		this.eventId = eventId;
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

	public Date getBoughtAt() {
		return boughtAt;
	}

	public void setBoughtAt(Date boughtAt) {
		this.boughtAt = boughtAt;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	
	
	
	
	

}
