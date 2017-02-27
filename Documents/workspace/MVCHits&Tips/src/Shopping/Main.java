package Shopping;

import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);

		model.addObserver(view);
	}

}
