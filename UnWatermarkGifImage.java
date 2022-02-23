import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class UnWatermarkGifImage
{
	private	final int MAXROWS;
	private	final int MAXCOLS;
	private  int[][][] watermarkedImage;

	public UnWatermarkGifImage(String gifFileName, String gifFileStoreName)
	{
		int[][][] watermark;

		//Loads the image to be watermarked into a 3D array called imagePixels
	    watermarkedImage = ImageDeconstructor.loadImage(gifFileName); 
		
		//Gets the height and width of the image in pixels, i.e. rows and columns
	    MAXROWS = watermarkedImage.length; 		//height
	    MAXCOLS = watermarkedImage[0].length; 	//width or length of the first row
	
		//Loads the watermark image into a 3D array called watermark

		//Save watermark
	}

	public static int[][][] extractWatermark(int[][][] watermarkedImage, int MAXROWS, int MAXCOLS)
	{
		int row;
		int col;
		
		//loops through each row in the 3D array
		//loops through each column in the 3D array
		
		//extract the last bit of the blue value and 
		//if its equal to 0 set the RGB values for that					
		//pixel in the watermarked image to 0
		
		//otherwise set the RGB values for that pixel			
		//in the watermarked image to 255	
		
		//returns the 3D array containing the watermark
		
		
		return watermarkedImage;	
	}
}
	

