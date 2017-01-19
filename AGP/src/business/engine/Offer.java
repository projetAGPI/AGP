package business.engine;

import business.model.Excursion;
import business.model.Hotel;

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
	
	public double getOfferPrice(){
		double finalPrice = 0;
		finalPrice = hotel.getPrice();
		for(int i = 0; i < excursionList.getExcursionList().size(); i++){
			setTransportType(excursionList.getExcursionList().get(i));
			finalPrice += excursionList.getExcursionList().get(i).getPrice() + excursionList.getExcursionList().get(i).getTransport().getCost();
		}
		
		return finalPrice;
	}
	
	public void setTransportType(Excursion excursion){		
		if(hotel.getHotel_isle().equals(excursion.getExcursion_isle())){
			excursion.getTransport().setName("Bus");
		}
		else{
			excursion.getTransport().setName("Boat");
		}				
		excursion.getTransport().setCost();
	}
	
	@Override
	public String toString() {
		return "Offer [hotel=" + hotel + ", excursionList=" + excursionList
				+ "]";
	}
}
