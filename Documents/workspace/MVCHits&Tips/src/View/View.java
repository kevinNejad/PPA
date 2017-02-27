package View;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Controller;

public class View extends JFrame implements Observer{
	
	public View(Controller controller ){
		JButton reorder = new JButton("Buy it Again");
		reorder.addActionListener(controller);
		setTitle("Delivered");
		
		add(reorder);
		
		setMinimumSize(new Dimension(200, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		setTitle((String)arg);
		// Alternative would be model.setTitle(model.getTitle()); // we need to create getTitle tho and 
		//need to have Model Filed and pass it through View constructor
		
	}

}
