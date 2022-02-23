import javax.swing.*;


public class WatermarkGifImage
{		
	private int[][][] imagePixels;
	private int[][][] watermarkImagePixels;
	private int MAXROWS;
	private int MAXCOLS;
	private final int MAXROWSW;
	private final int MAXCOLSW;
	private int maxStringSize = 0;
	private int[][][] watermarkedImage;
	private ImageBuilder i;


	public  WatermarkGifImage(String gifFileName, String gifWatermarkFileName, String gifFileStoreName)
	{
	
		//Loads the image to be watermarked into a 3D array called imagePixels
	    imagePixels = ImageDeconstructor.loadImage(gifFileName); 
		
		//Gets the height and width of the image in pixels, i.e. rows and columns
	    MAXROWSW = imagePixels.length; 		//height
	    MAXCOLSW = imagePixels[0].length; 	//width or length of the first row

		//Loads the watermark image into a 3D array called watermarkImagePixels

		//Call watermarkTheImage and return watermarkedImage
		
		//Save watermarkedImage 
	}

	
	public static int[][][] watermarkTheImage(int[][][] imagePixels, int[][][] watermarkImagePixels, int MAXROWS, int MAXCOLS)
	{
		int i = 0;
		int row;
		int col;
	
		//loops through each row in the 3D array
		//loops through each column in the 3D array
		
		//and if the least significant bit in the 
		//blue value of the current pixel of the watermark is 0					
		//set the LSB of Blue value the image being watermarked to 0
		
		//otherwise set the LSB of Blue value the image being watermarked to 1				
		
		//returns the LSB watermarked 3D array	
		
		return imagePixels;
	}
}

