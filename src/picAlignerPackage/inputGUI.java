//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class inputGUI extends JFrame {
	
	private static final long serialVersionUID = -4304475731006936106L;
	private JTextField txtEnterOutputFile;
	
	public File mainImageFile;
	public File[] imageFilesToConvert;
	public ArrayList<File> imageFileList = new ArrayList<>();
	public String outputFileName;
	public String fileOutputPath;
	boolean transform = false;
	
	public inputGUI() {
		JFrame window = new JFrame();
		window.getContentPane().setLayout(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Pic-A-Day Aligner");
		window.setSize(750, 500);
		
		JLabel lblPicadayAligner = new JLabel("Pic-A-Day Aligner");
		lblPicadayAligner.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicadayAligner.setBounds(156, 6, 438, 16);
		window.getContentPane().add(lblPicadayAligner);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(375, 34, 0, 375);
		window.getContentPane().add(separator);
		
		JButton btnSelectBaselineImage = new JButton("Select Baseline Image");
		btnSelectBaselineImage.setBounds(131, 34, 232, 29);
		window.getContentPane().add(btnSelectBaselineImage);
		
		JLabel lblMainImageConfirm = new JLabel("No Image Selected");
		lblMainImageConfirm.setBounds(387, 39, 357, 16);
		window.getContentPane().add(lblMainImageConfirm);
		
		JButton btnConversionImages = new JButton("Select Images For Conversion");
		btnConversionImages.setBounds(131, 75, 232, 29);
		window.getContentPane().add(btnConversionImages);
		
		JLabel lblNumImagesSelected = new JLabel("0 Images Selected");
		lblNumImagesSelected.setBounds(387, 80, 357, 16);
		window.getContentPane().add(lblNumImagesSelected);
		
		txtEnterOutputFile = new JTextField();
		txtEnterOutputFile.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterOutputFile.setText("Enter Output File Name");
		txtEnterOutputFile.setBounds(131, 116, 232, 26);
		window.getContentPane().add(txtEnterOutputFile);
		txtEnterOutputFile.setColumns(10);
		
		JLabel lblNameConfirm = new JLabel("No Name Entered");
		lblNameConfirm.setBounds(387, 121, 357, 16);
		window.getContentPane().add(lblNameConfirm);
		
		JButton btnFileDestination = new JButton("Select Destination Folder");
		btnFileDestination.setBounds(131, 154, 232, 29);
		window.getContentPane().add(btnFileDestination);
		
		JLabel lblDestinationConfirm = new JLabel("No Destination Selected");
		lblDestinationConfirm.setBounds(387, 159, 357, 16);
		window.getContentPane().add(lblDestinationConfirm);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(316, 210, 117, 29);
		window.getContentPane().add(btnExport);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(316, 240, 117, 29);
		window.getContentPane().add(btnQuit);
		
		JLabel lblConversionComplete = new JLabel("Conversion Complete!");
		lblConversionComplete.setVisible(false);
		lblConversionComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversionComplete.setBounds(279, 277, 191, 16);
		window.getContentPane().add(lblConversionComplete);
		
		JRadioButton rdbtnTransformImages = new JRadioButton("Transform Images To Align Faces");
		rdbtnTransformImages.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTransformImages.setBounds(239, 187, 271, 23);
		window.getContentPane().add(rdbtnTransformImages);
		
		window.setVisible(true);
		
		//	Check if button is pressed for selecting baseline image
		btnSelectBaselineImage.addActionListener(new ActionListener() {

			//	Get main image file from user in JFrame using JFileChooser
			@Override
			public void actionPerformed(ActionEvent e) {
				//	Open the file chooser if btnSelectBaselineImage is pressed and get file
				//	Create a JFileChooser for selecting mainImage
				JFileChooser imageChooser = new JFileChooser();
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("*.Images", "JPEG", "JPG", "png");
				imageChooser.setFileFilter(imageFilter);
				
				int response = imageChooser.showOpenDialog(lblMainImageConfirm);
				if (response == JFileChooser.APPROVE_OPTION) {
					mainImageFile = imageChooser.getSelectedFile();
					lblMainImageConfirm.setText(mainImageFile.toString());
				}
			}
		});
		
		//	Check if button is pressed for selecting images for conversion
		btnConversionImages.addActionListener(new ActionListener() {

			//	Get images to convert using a JFileChooser
			@Override
			public void actionPerformed(ActionEvent e) {
				//	Open the file chooser if btnConversionImages is pressed and get file
				//	Create a JFileChooser for selecting the images to be converted
				JFileChooser imageChooser = new JFileChooser();
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("*.Images", "JPEG", "JPG", "png");
				imageChooser.setFileFilter(imageFilter);
				imageChooser.setMultiSelectionEnabled(true);
				
				int response = imageChooser.showOpenDialog(lblNumImagesSelected);
				if (response == JFileChooser.APPROVE_OPTION) {
					imageFilesToConvert = imageChooser.getSelectedFiles();
					
					//	Add File array to imageFileList by looping through entire file array
					for (int i = 0; i < imageFilesToConvert.length; i++) {
						imageFileList.add(imageFilesToConvert[i]);
					}
				}
				
				//	Check if any files are currently in imageFileList
				if (imageFileList.size() > 0) {
					//	If there are more than 0 files in imageFileList change button
					//	Text to display "Select more files
					btnConversionImages.setText("Select More Images");
					
					//	Update lblNumImagesSelected to display number of images in imageFileList
					lblNumImagesSelected.setText(imageFileList.size() + " Images Selected");
				}
			}
		});
		
		//	Check Output file name is entered
		txtEnterOutputFile.addActionListener(new ActionListener() {

			//	Get main image file from user in JFrame using JFileChooser
			@Override
			public void actionPerformed(ActionEvent e) {
				//	Check if anything has been typed
				if (txtEnterOutputFile.getText().equals(""))
					lblNameConfirm.setText("No Name Entered");
				else {
					outputFileName = txtEnterOutputFile.getText();
					//	Parse through outputFileName and convert spaces to underscores
					outputFileName = outputFileName.replaceAll(" ", "_");
					lblNameConfirm.setText(outputFileName + ".mp4");
				}
			}
		});
		
		//	Check if button is pressed for selecting destination folder for converted file
		btnFileDestination.addActionListener(new ActionListener() {

			//	Get destination folder for export using JFileChooser
			@Override
			public void actionPerformed(ActionEvent e) {
				//	Open the file chooser if btnConversionImages is pressed and get file
				//	Create a JFileChooser for selecting the images to be converted
				JFileChooser imageChooser = new JFileChooser();
				imageChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				int response = imageChooser.showOpenDialog(lblDestinationConfirm);
				if (response == JFileChooser.APPROVE_OPTION) {
					fileOutputPath = imageChooser.getSelectedFile().toString();
					lblDestinationConfirm.setText(fileOutputPath);
				}
			}
		});
		
		//	Check if radio button is pressed to transform images
		rdbtnTransformImages.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transform = true;
			}
		});
		
		//	Check if button is pressed to run the conversion
		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//	Check if TransformImages radio button is selected
				if (transform) {
					//	Transform images using the baseline image as a reference
					
				}
				
				//	Export the images using the methods
				
				//	Display Message
				lblConversionComplete.setVisible(true);
			}
		});
		
		//	Check if button is pressed to quit
		btnQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
	}
}
