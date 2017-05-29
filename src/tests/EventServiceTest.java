package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dto.EventDTO;
import model.Event;
import service.EventService;
import service.ServiceFactory;

public class EventServiceTest {

	EventService eventService = ServiceFactory.getEventService();
	
	@Test
	public void getEventsTest() {
		List<EventDTO> eventDTOs = eventService.getEvents();
		
		if(eventDTOs.size()==0){
			fail("Cannot load from the database");
		}


		Assert.assertNotNull(eventDTOs);
		
	}
	
	@Test
	public void getEventByIdTest(){
		int id = 4;
		Event dto = null;
		try {
			 dto = eventService.findEventById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
		if(id != dto.getId()){
			fail("Id's are not equal");
		}
		
	}

}
