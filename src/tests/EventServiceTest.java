package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Event;
import service.ServiceFactory;

public class EventServiceTest {

	
	
	@Test
	public void test() {
		List<Event> events = ServiceFactory.getEventService().getEvents();
		
		if(events.size()==0){
			fail("Cannot load from the database");
		}


		for(Event event : events){
			System.out.println(event.getName());
		}
		
	}

}
