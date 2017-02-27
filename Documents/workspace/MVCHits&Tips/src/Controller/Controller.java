package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Model;

public class Controller implements ActionListener {

	private Model model;
	
	public Controller(Model model){
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("On order");
		// Now we better call model to change the status 
		model.setStatus("On Order");
		
	}

}
