//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PicAligner {
	
	//	ArrayList of BufferedImages to store all of the images
	ArrayList<BufferedImage> imageList;
	//	Image to base the rest of the images translations off
	public BufferedImage baseImage;
	
	//	Constructor for PicAligner
	public PicAligner(File base, ArrayList<File> fileList) {
		//	Create BufferedImage from base
		try {
			baseImage = ImageIO.read(base);
		} catch (IOException e) {
			// Create JFrame and label then report an error
			JFrame errorFrame = new JFrame("Error");
			errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			errorFrame.setSize(150, 50);
			errorFrame.setResizable(false);
			JLabel lblErrorMessage = new JLabel("Could not read " + base.toString() + " as an image");
			lblErrorMessage.setBounds(0, 0, 150, 50);
			lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lblErrorMessage.setVerticalAlignment(SwingConstants.CENTER);
			errorFrame.getContentPane().add(lblErrorMessage);
			errorFrame.setVisible(true);
		}
		
		//	Add all of the images to imageList
		importImages(fileList);
	}
	
	//	Method to import images to add to imageList
	public void importImages(ArrayList<File> fileList) {
		//	Set size of imageList
		imageList = new ArrayList<BufferedImage>(fileList.size());
		
		//	Loop through entire array of files
		for (int i = 0; i < fileList.size(); i++) {
			BufferedImage img = null;
			try {
				//	Create BufferedImage from current file
				img = ImageIO.read(fileList.get(i));
				
				//	Add current BufferedImage to imageList
				imageList.add(img);
				
			} catch (IOException e) {
				// Create JFrame and label then report an error
				JFrame errorFrame = new JFrame("Error");
				errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				errorFrame.setSize(150, 50);
				errorFrame.setResizable(false);
				JLabel lblErrorMessage = new JLabel("Could not read " + fileList.get(i).toString() + " as an image");
				lblErrorMessage.setBounds(0, 0, 150, 50);
				lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
				lblErrorMessage.setVerticalAlignment(SwingConstants.CENTER);
				errorFrame.getContentPane().add(lblErrorMessage);
				errorFrame.setVisible(true);
			}
		}
	}
	
	//	Method to export images to specified file path
	//	and delete the imported images from the project
	public void exportImages(String fileDestination, String fileName) {
		
		
		//	Clear imageList after usage
		imageList.clear();
	}
	
	public static void main (String args[]) {
		//	Create the input JFrame
		inputGUI uiWindow = new inputGUI();
		
		/*
		//	Create file to be converted to buffered image
		File imageFile = new File("/Users/keegan/Pictures/arcanine.jpg");
		
		//	Display buffered image for testing
		BufferedImage img = null;
		try {
			img = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not convert file to image.");
			e.printStackTrace();
		}
		
		//	Display image for testing
		JFrame editorFrame = new JFrame("Image Demo");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);
        */
		
	}
}
