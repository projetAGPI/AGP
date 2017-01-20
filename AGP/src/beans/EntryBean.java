package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import business.model.Excursion;
import business.model.Hotel;
import business.model.SystemEntry;
import business.engine.API;
import business.engine.Simulation;

@ManagedBean
@SessionScoped
public class EntryBean {
	
	private static final long serialVersionUID = 6955508471291131930L;
	
	private SystemEntry entries = new SystemEntry();
	private Simulation simulation = new Simulation();
	private List<Hotel> hotels;
	private String request;
	private ArrayList<Excursion> excursions;

	
	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String searchOffers(){
		API api = new API();
		//api = simulation.getApi();
		//simulation.simulate();
		hotels=simulation.simulateHotel(entries.getComfortLevel());
		//excursions=api.seperateRequest(api.mixedRequest(entries.getKeywords()));
		return "result";
	}

	public String getKeywords() {
		return entries.getKeywords();
	}

	public void setKeywords(String keywords) {
		entries.setKeywords(keywords);
	}

	public int getMaxBudget() {
		return entries.getMaxBudget();
	}

	public void setMaxBudget(int maxBudget) {
		entries.setMaxBudget(maxBudget);
	}

	public String getComfortLevel() {
		return entries.getComfortLevel();
	}

	public void setComfortLevel(String comfortLevel) {
		entries.setComfortLevel(comfortLevel);
	}
	
	public SystemEntry getEntries() {
		return entries;
	}

	public void setEntries(SystemEntry entries) {
		this.entries = entries;
	}
	
	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

}
