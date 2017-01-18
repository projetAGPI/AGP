package business.engine;

import business.model.SystemEntry;

public class SystemSimulation {
	private SystemEntry systemEntry;

	public SystemSimulation() {

	}

	public SystemEntry getSystemEntry() {
		return systemEntry;
	}

	public void setSystemEntry(SystemEntry systemEntry) {
		this.systemEntry = systemEntry;
	}

	@Override
	public String toString() {
		return "System [systemEntry=" + systemEntry + "]";
	}
	
	
}
