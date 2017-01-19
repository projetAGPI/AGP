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
		Excursion excusion = new Excursion(1, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "53 Rue du Palmier", "Activity", "Akala", transport, "52.12", "12.54", ""); 
		Excursion excusion2 = new Excursion(3, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "1 Rue de la vue", "Activity", "Ula-Ula", transport, "52.12", "12.54", "3");
		Hotel oneHotel = new Hotel(1, 5, 250, "Banivo Hotel", "Rue de la hauteur", "Akala", "25.14", "2.7", "");
		
		ArrayList<Excursion> excursionList = new ArrayList<Excursion>();	
		excursionList.add(excusion);
		excursionList.add(excusion2);
		
		ListExcursion list = new ListExcursion(excursionList);
		
		Offer offer = new Offer(oneHotel, list);
		
		assertNotNull("List shouldn't be null", offer);
		assertEquals(385.0, offer.getOfferPrice()); 
	}
}
