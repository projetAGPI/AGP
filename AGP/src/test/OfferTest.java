package test;

import java.util.ArrayList;

import business.engine.ListExcursion;
import business.engine.Offer;
import business.model.Excursion;
import business.model.Hotel;
import business.model.Transport;
import junit.framework.TestCase;

public class OfferTest extends TestCase{

	public OfferTest(String name) {
		super(name);
	}
	
	public void testGetOfferPrice() throws Exception{	
		Transport transport = new Transport();
		Transport transport2 = new Transport();
		Excursion excursion = new Excursion(1, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "53 Rue du Palmier", "Activity", "Akala", transport, "52.12", "12.54", ""); 
		Excursion excursion2 = new Excursion(3, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "1 Rue de la vue", "Activity", "Ula-Ula", transport2, "52.12", "12.54", "3");
		Hotel oneHotel = new Hotel(1, 5, 250, "Banivo Hotel", "Rue de la hauteur", "Akala", "25.14", "2.7", "");
		
		ArrayList<Excursion> excursionList = new ArrayList<Excursion>();	
		excursionList.add(excursion);
		excursionList.add(excursion2);
		
		ListExcursion list = new ListExcursion(excursionList);
		
		Offer offer = new Offer(oneHotel, list);
		
		assertNotNull("List shouldn't be null", offer);
		assertEquals(385.0, offer.getOfferPrice()); 
	}
	
	public void testSetTransportType() throws Exception{	
		Transport transport = new Transport();
		Transport transport2 = new Transport();
		Transport transport3 = new Transport();
		Transport transport4 = new Transport();
		
		Excursion excursion = new Excursion(1, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "53 Rue du Palmier", "Activity", "Akala", transport, "52.12", "12.54", ""); 
		Excursion excursion2 = new Excursion(3, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "1 Rue de la vue", "Activity", "Ula-Ula", transport2, "52.12", "12.54", "3"); 
		Excursion excursion3 = new Excursion(2, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "14 Rue des profondeurs", "Activity", "Majanga", transport3, "52.12", "12.54", "3");
		Excursion excursion4 = new Excursion(4, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "21 Rue du Palmifleur", "Activity", "Akala", transport4, "52.12", "12.54", "");
		
		Hotel oneHotel = new Hotel(1, 5, 250, "Banivo Hotel", "Rue de la hauteur", "Akala", "25.14", "2.7", "");
		
		ArrayList<Excursion> excursionList = new ArrayList<Excursion>();	
		excursionList.add(excursion);
		excursionList.add(excursion2);
		excursionList.add(excursion3);
		excursionList.add(excursion4);
		
		ListExcursion list = new ListExcursion(excursionList);
		
		Offer offer = new Offer(oneHotel, list);
		offer.setTransportType(offer.getExcursionList().getExcursionList().get(0));
		offer.setTransportType(offer.getExcursionList().getExcursionList().get(1));
		offer.setTransportType(offer.getExcursionList().getExcursionList().get(2));
		offer.setTransportType(offer.getExcursionList().getExcursionList().get(3));
		
		assertNotNull("List shouldn't be null", offer);
		assertEquals("Bus", offer.getExcursionList().getExcursionList().get(0).getTransport().getName());
		assertEquals("Boat", offer.getExcursionList().getExcursionList().get(1).getTransport().getName());
		assertEquals("Boat", offer.getExcursionList().getExcursionList().get(2).getTransport().getName());
		assertEquals("Bus", offer.getExcursionList().getExcursionList().get(3).getTransport().getName());	
	}
}
