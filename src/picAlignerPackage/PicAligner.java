//	Pic-A-Day-Aligner
//	Author:	Kochis, Keegan
//	Date: 	Jan 31, 2019
//	Email: 	keeganjkochis@gmail.com
package picAlignerPackage;
import java.awt.Image;
import java.awt.image.*;
import java.util.ArrayList;

public class PicAligner {
	
	//	Array List to store all of the images
	ArrayList<Image> imageList = new ArrayList<Image>();
	
	//	Image to base the rest of the images translations off
	public Image baseImage;
	
	//	Constructor for PicAligner
	public PicAligner(Image base) {
		baseImage = base;
	}
	
	//	Method to import images to add to imageList
	public void importImages(String folderPath) {
		
	}
	
	//	Method to export images to specified file path
	//	and delete the imported images from the project
	public void exportImages(String fileDestination) {
		
	}
	
	public static void main (String args[]) {
		
	}
}
