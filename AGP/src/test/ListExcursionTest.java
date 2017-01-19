package test;

import java.util.ArrayList;

import business.engine.ListExcursion;
import business.model.Excursion;
import business.model.Transport;

import junit.framework.*;

public class ListExcursionTest extends TestCase{
	public ListExcursionTest(String excursionList){
		super(excursionList);
	}
	public void testAddExcursion() throws Exception{	
		Transport transport = new Transport("Bus",20);
		Excursion excusion = new Excursion(1, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "53 Rue du Palmier", "Activity", "Akala", transport, "52.12", "12.54", ""); 
		Excursion excusion2 = new Excursion(3, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "1 Rue de la vue", "Activity", "Ula-Ula", transport, "52.12", "12.54", "3");
		
		ArrayList<Excursion> excursionList = new ArrayList<Excursion>();
		ArrayList<Excursion> excursionList2 = new ArrayList<Excursion>();
	
		excursionList.add(excusion);
		
		ListExcursion listexcursion = new ListExcursion(excursionList);

		excursionList2 = listexcursion.addExcursion(excusion2);
		
		assertNotNull("List shouldn't be null", excursionList2);
		Assert.assertEquals("wrong size", 2, excursionList2.size());
	    Assert.assertEquals("Wrong 1st element", excusion, excursionList2.get(0));
	    Assert.assertEquals("Wrong 2nd element", excusion2, excursionList2.get(1));
    

	}
	
	public void testDeleteExcursion() throws Exception{
		Transport transport = new Transport("Bus",20);
		Excursion excusion = new Excursion(1, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir escalader les rochers de notre très cher île", "Escalade", "53 Rue du Palmier", "Activity", "Akala", transport, "52.12", "12.54", ""); 
		Excursion excusion2 = new Excursion(3, 50, "Une excursion dans les profondeurs marins de nos mers", "Plongée", "1 Rue de la vue", "Activity", "Ula-Ula", transport, "52.12", "12.54", "");
		Excursion excusion3 = new Excursion(2, 50, "Une excursion dans la montagne dans laquelle vous allez pouvoir découvrir de nouvelle chose", "Mont Hanakila", "2 Rue du Test unitaire", "Historical" , "Mele-Mele", transport, "12.12", "14.54", "");
		
		ArrayList<Excursion> excursionList = new ArrayList<Excursion>();
		ArrayList<Excursion> excursionList2 = new ArrayList<Excursion>();
		
		excursionList.add(excusion);
		excursionList.add(excusion2);
		excursionList.add(excusion3);

		ListExcursion listexcursion = new ListExcursion(excursionList);
		
		excursionList2 = listexcursion.deleteExcursion(excusion2);
		
		assertNotNull("List shouldn't be null", excursionList2);
		Assert.assertEquals("wrong size", 2, excursionList2.size());
	    Assert.assertEquals("Wrong 1st element", excusion, excursionList2.get(0));
	    Assert.assertEquals("Wrong 2nd element", excusion3, excursionList2.get(1));
	}
}
