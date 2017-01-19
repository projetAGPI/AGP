package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import business.model.SystemEntry;

@ManagedBean
@SessionScoped
public class EntryBean {
	
	private static final long serialVersionUID = 6955508471291131930L;
	
	private SystemEntry entries = new SystemEntry();

	
	public String searchOffers(){
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

}
