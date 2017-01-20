package business.engine;

import java.util.ArrayList;
import java.util.List;

import business.model.Excursion;

public class ListExcursion {
	private ArrayList<Excursion> excursionList;

	public ListExcursion() {

	}
	
	public ListExcursion(ArrayList<Excursion> excursionList) {
		this.excursionList = excursionList;
	}

	public ArrayList<Excursion> getExcursionList() {
		return excursionList;
	}

	public void setExcursionList(ArrayList<Excursion> excursionList) {
		this.excursionList = excursionList;
	}
	
	public ArrayList<Excursion> addExcursion(Excursion excursion){	
		this.excursionList.add(excursion);
		return excursionList;
	}
	
	public ArrayList<Excursion> deleteExcursion(Excursion excursion){
		this.excursionList.remove(excursion);
		return excursionList;
	}

	@Override
	public String toString() {
		return "ListExcursion [excursionList=" + excursionList + "]";
	}
}
