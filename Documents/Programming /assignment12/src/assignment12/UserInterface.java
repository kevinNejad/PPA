package assignment12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

public class UserInterface extends JFrame {

	private JTextArea textArea;
	private JSlider speedSlider, xCoordSlider;
	private JButton reset;
	private int seconds;
	private boolean takeOff;

	//Creating an object of flightSimulator
	FlightSimulator flightSimulator = new FlightSimulator(5, 0);

	//Constructor to create our Frame 
	public UserInterface() {
		super("Flight Simulator");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Make the frame to be centered in the screen  
		initWidget();
	}

	// Main method to run the application
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.setVisible(true);
	
		ui.run();
	}
	
	//Method which creates Widget and set their layout and stick them to the Frame
	public void initWidget() {
		JPanel panel1 = new JPanel(); //Create a new Panel
		panel1.setLayout(new GridLayout(1, 1)); //setLayout of the panel which contains the TextArea 
		textArea = new JTextArea();
		textArea.setEditable(false); // Disable Editable 

		//Set Color of TextArea
		Color c = new Color(102, 198, 233);
		textArea.setBackground(c);

		// Make the textArea to display the last text as scroll goes down
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		reset = new JButton("reset");
		//Add Action Listener  to reset button to reset all system as it's clicked
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds = 0;
				takeOff = false;
				flightSimulator = new FlightSimulator(5, 0);
				textArea.setText("");
				speedSlider.setValue(0);
				xCoordSlider.setValue(5);
			}
		});

		
		
		//create a vertical Slider to set the value of Speed
		speedSlider = new JSlider(JSlider.VERTICAL, 0, 10, 0);
		// Creating an anonymous class for the listener  
		speedSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				flightSimulator.setSpeed(speedSlider.getValue());
			}
		});
	
		//add the ticks on slider 
		speedSlider.setMajorTickSpacing(2);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		
		
		//create Slider to set the value of X Coordinate
		xCoordSlider = new JSlider(0, flightSimulator.RUNWAY_WIDTH);
		// Creating an anonymous class for the listener 
		xCoordSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				flightSimulator.setXCoord(xCoordSlider.getValue());
			}
		});
		
		//ad ticks on slider
		xCoordSlider.setMajorTickSpacing(2);
		xCoordSlider.setMinorTickSpacing(1);
		xCoordSlider.setPaintTicks(true);
		
		// add scroll on text area
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel1.add(scroll);

		//Create another panel to add Slider and reset button / setting borderLayout
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(xCoordSlider, BorderLayout.NORTH);
		panel2.add(speedSlider, BorderLayout.CENTER);
		panel2.add(reset, BorderLayout.SOUTH);

		this.setLayout(new GridLayout(2, 1));
		this.add(panel1);
		this.add(panel2);
		
		

	}

	//<ethdo to check if plane takes off or on 
	public void takeOff() {
		takeOff = flightSimulator.getLeftLength() <= 0;
	}

	//Set the text which should displayed on text area 
	private void printOutput() {
		String output = "";
		takeOff();

		if (takeOff)
			if (flightSimulator.getElevation() >= 5 && flightSimulator.getxCoord() == 5)
				output += "\n Plane in air";
			else
				output += "\n Take off Failed";
		else
			output = "Second : " + seconds + "\n" + flightSimulator.toString() + "\n";

		textArea.append(output);
	}

	// run method to run the the application every second

	public void run() {
		while (true) {
			try {
				if (!takeOff) {
					seconds++;
					flightSimulator.update();
					printOutput();
				}

				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
