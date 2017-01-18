package business.model;

import business.engine.ListExcursion;

public class Offer {
	private Hotel hotel;
	private ListExcursion excursionList;
		
	public Offer() {

	}

	public Offer(Hotel hotel, ListExcursion excursionList) {
		this.hotel = hotel;
		this.excursionList = excursionList;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public ListExcursion getExcursionList() {
		return excursionList;
	}

	public void setExcursionList(ListExcursion excursionList) {
		this.excursionList = excursionList;
	}
	
	@Override
	public String toString() {
		return "Offer [hotel=" + hotel + ", excursionList=" + excursionList
				+ "]";
	}
}
