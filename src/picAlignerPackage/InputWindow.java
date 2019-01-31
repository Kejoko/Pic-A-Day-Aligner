//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputWindow {
	
	public BufferedImage mainImage;
	public String inputPath;
	public String outputPath;
	
	//	Constructor for InputWindow
	public InputWindow() {
		//	Create a JFileChooser for selecting mainImage
		JFileChooser imageChooser = new JFileChooser();
		FileNameExtensionFilter jpegFilter = new FileNameExtensionFilter("JPEG files", "JPEG");
		imageChooser.setFileFilter(jpegFilter);
		FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("JPG files", "JPG");
		imageChooser.setFileFilter(jpgFilter);
		
		//	Create a JFrame for getting user input
		JFrame mainWindow = new JFrame();
	    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("Pic-A-Day Aligner");
		mainWindow.setSize(500, 500);
		JButton mainImageButton = new JButton("Choose Baseline Image");
		mainImageButton.setBounds(50,50,50,100);
		mainWindow.add(mainImageButton);
		
		mainWindow.setVisible(true);
		
		//	Crteate JFrame for choosing base image
		JFrame imageChooseWindow = new JFrame();
	    imageChooseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageChooseWindow.add(imageChooser);
		imageChooseWindow.setSize(500,500);
		
		//	Check if button is pressed via ActionListener
		mainImageButton.addActionListener(new ActionListener() {
			

			//	Get main image file from user in JFrame using JFileChooser
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the file chooser if mainImageButton is pressed and get file
				imageChooseWindow.setVisible(true);
			}
		});
		
		//	Get input path for images from user in JFrame
		
		//	Get output path for video file from user in JFrame
	}

}
