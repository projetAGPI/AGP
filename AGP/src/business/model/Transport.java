package business.model;

public class Transport {
	private String name;
	private double cost;	
	
	public Transport() {

	}
	
	public Transport(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost() {
		if(this.name.equals("Bus")){
			this.cost = 10;
		}
		else if(this.name.equals("Boat")) {
			this.cost = 25;
		}
	}

	@Override
	public String toString() {
		return "Transport [name=" + name + ", cost=" + cost + "]";
	}
}
