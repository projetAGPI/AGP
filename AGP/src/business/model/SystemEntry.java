package business.model;

public class SystemEntry {
	private String keywords;
	private int maxBudget;
	private String comfortLevel;
	
	public SystemEntry() {
		super();
	}

	public SystemEntry(String keywords, int maxBudget, String comfortLevel) {
		super();
		this.keywords = keywords;
		this.maxBudget = maxBudget;
		this.comfortLevel = comfortLevel;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(String comfortLevel) {
		this.comfortLevel = comfortLevel;
	}
	
	
}
