import javax.swing.*;

public class StegoDetect
{		
	private int[][][] imagePixels;
	private final int MAXROWS;
	private final int MAXCOLS;
	private ImageBuilder i;
	private int result;
	int shortestdistancepairs=0;
	int[][][] imagePairs;
		
	public  StegoDetect(String gifFileName)
	{
		//Loads the image to be stegoed into a 3D array called imagePixels
	    imagePixels = ImageDeconstructor.loadImage(gifFileName); 
		
		//Gets the height and width of the image in pixels, i.e. rows and columns
	    MAXROWS = imagePixels.length; 		//height??
	    MAXCOLS = imagePixels[0].length; 	//width or length of the first row??

	
	}
	
	public  StegoDetect(String gifFileName, String gifFileStoreName)
	{
		//Loads the image to be stegoed into a 3D array called imagePixels
	    imagePixels = ImageDeconstructor.loadImage(gifFileName); 
		
		//Gets the height and width of the image in pixels, i.e. rows and columns
	    MAXROWS = imagePixels.length; 		//height??
	    MAXCOLS = imagePixels[0].length; 	//width or length of the first row??

	}
		
	
	public int detectLSB(int[][][] imagePixels, int MAXROWS, int MAXCOLS)
	{		
	
		return 5;
	}

	public int [][][] detectParity(int[][][] imagePixels, int MAXROWS, int MAXCOLS)
	{
	
		return imagePairs;
	}
}
