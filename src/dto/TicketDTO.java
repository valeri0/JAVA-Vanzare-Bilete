package dto;

import java.util.Date;

public class TicketDTO {
	
	private int id;
	private String owner;
	private Date boughtAt;
	private boolean isCanceled;
	private int eventId;
	
	public TicketDTO(){}
	
	

	public TicketDTO(int id, String owner ,boolean isCanceled, int eventId) {
		this.id = id;
		this.isCanceled=isCanceled;
		this.owner = owner;
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



	public boolean isCanceled() {
		return isCanceled;
	}



	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
	
	

}
