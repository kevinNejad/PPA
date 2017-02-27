package Model;

import java.util.Observable;

public class Model extends Observable {
	
	private String status;
	
	public void setStatus(String status ){
		this.status = status;
		setChanged();
		notifyObservers(status);// it passes status as arg to observer // 
		//Alternative would be notifyObservers();
	}
	
}
