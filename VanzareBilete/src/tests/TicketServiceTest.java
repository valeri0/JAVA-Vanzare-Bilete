package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.TicketDTO;
import service.ServiceFactory;
import service.TicketService;

public class TicketServiceTest {

	TicketService ticketService = ServiceFactory.getTicketService();
	
	@Test
	public void getTicketDetailsTest() {

		int id = 10000;
		
		TicketDTO dto = null;
		
		try {
			dto = ticketService.getTicketDetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			fail(e.getMessage());
			
		}
		
		if(dto.getId() != id){
			fail("Ticket does not match the requested id");
		}
		
	}

}
