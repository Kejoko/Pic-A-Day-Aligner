//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputWindow {
	
	public Image mainImage;
	public String inputPath;
	public String outputPath;
	
	//	Constructor for InputWindow
	public InputWindow() {
		//	Create a JFileChooser for selecting mainImage
		JFileChooser imageChooser = new JFileChooser();
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("JPEG files", "JPEG");
		imageChooser.setFileFilter(imageFilter);
		
		//	Create a JFrame for getting user input
		JFrame inputWindow = new JFrame();
		inputWindow.setTitle("Pic-A-Day Aligner");
		inputWindow.setSize(500, 500);
		JButton mainImageButton = new JButton("Choose Baseline Image");
		mainImageButton.setBounds(50,50,50,100);
		inputWindow.add(mainImageButton);

		inputWindow.setVisible(true);
		
		//	Check if button is pressed
			//	Get main image file from user in JFrame using JFileChooser
		
		//	Get input path for images from user in JFrame
		
		//	Get output path for video file from user in JFrame
	}

}
