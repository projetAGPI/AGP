package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import business.engine.Simulation;

@ManagedBean
@RequestScoped
public class ResultBean {
	private static final long serialVersionUID = 6955508471291131930L;
	private EntryBean entry=new EntryBean();
	private Simulation simulation= new Simulation();
	
	public ResultBean() {
		
	}
	public void getOffersResult(){
		System.out.println(simulation.getHotels());
		//System.out.println(simulation.getExcursions());
	}
	
	public void setOffersResult(){
		
	}



}

