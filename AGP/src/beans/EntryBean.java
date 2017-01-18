package beans;

import business.model.SystemEntry;

public class EntryBean {
	private SystemEntry entry = new SystemEntry();

	private int id;

	public EntryBean() {
		
	}
	
	public SystemEntry getEntry() {
		return entry;
	}

	public void setEntry(SystemEntry entry) {
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
