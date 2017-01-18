package business.model;

public class SystemEntry {
	private String searchInformation;
	
	public SystemEntry() {

	}

	public SystemEntry(String searchInformation) {
		
		this.searchInformation = searchInformation;
		
	}

	public String getSearchInformation() {
		return searchInformation;
	}

	public void setSearchInformation(String searchInformation) {
		this.searchInformation = searchInformation;
	}

	@Override
	public String toString() {
		return "SystemEntry [searchInformation=" + searchInformation + "]";
	}
}
