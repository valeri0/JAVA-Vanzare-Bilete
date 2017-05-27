package dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Ticket",schema="ubis")
@NamedQuery(name="getTicketById",query="SELECT t from TicketDao t where t.id = :value")
public class TicketDao {

	@Id
	@SequenceGenerator(name="ticket_sequence", schema="ubis", sequenceName="ticket_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence")
	private int id;
	
	private String owner;
	
	@Column(name="BOUGHT_AT")
	private Date boughtAt;
	
	public TicketDao(){}

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
	
	
	
}
