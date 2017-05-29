# JAVA-Vanzare-Bilete

Aplicatia foloseste o baza de date Oracle unde sunt stocate datele. Entitatile si operatiile pe baza de date din aplicatie au fost mapate folosind eclipseLink, endpoint-urile au fost realizate folosind Jersey, iar dependintele au fost realizate folosind Maven.

Pentru a porni aplicatia este necesar sa fie facut build-ul cu Maven si sa fie rulat pe server-ul Tomcat.

Aplicatia a fost testata folosind Postman.

---------------------------------------------------

Exemple de utilizare:

---------------------------------------------------

localhost:9090/VanzareBilete/rest/app/buy_ticket

Inregistreaza un bilet ca fiind achizitionat si scade automat din stocul
biletelor disponibile la eveniment

Exemplu de cerere: localhost:9090/VanzareBilete/rest/app/buy_ticket

Primeste un JSON, avand urmatoarea forma:

	{
		"eventId": value,
		"owner": value,
	}

Unde: 	eventId -> id-ul evenimentului la care se doreste achizitionarea biletului
		owner -> numele celui care achiztioneaza biletul

---------------------------------------------------

http://localhost:9090/VanzareBilet/rest/app/list_events

Resturneaza un JSON cu toate evenimentele in detaliu


---------------------------------------------------

http://localhost:9090/VanzareBilet/rest/app/ticket_details?id=30

Pentru un id dat ca parametru, returneaza un JSON cu toate detaliile unui bilet

---------------------------------------------------

localhost:9090/VanzareBilete/rest/app/cancel_ticket

Functia inregistreaza anularea unui bilet 
	 	
Primeste un JSON avand urmatoarea structura:
	 	
 	{
 		"id": value
 	}
	 	
Unde: id -> id-ul biletului ce va fi anulat

---------------------------------------------------
