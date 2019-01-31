//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;

public class InputWindow {
	
	public String inputPath;
	public String outputPath;
	
	//	Constructor for InputWindow
	public InputWindow() {
		//	Create a JFrame for getting user input
		JFrame inputWindow = new JFrame();
		inputWindow.setTitle("Pic-A-Day ALigner");
		inputWindow.setSize(500, 500);
		inputWindow.setVisible(true);
	}

}
