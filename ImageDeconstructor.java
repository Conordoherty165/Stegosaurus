
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class ImageDeconstructor
{
	public static int[][][] loadImage (String gifFileName) 		//static loadImage method returns a 3D array representing the image
	{
        Image img;
		Button b;
		MediaTracker tracker;
		IObserver observer;
		int width;
		int height;
		int[][][] imagePixels;
		
		img = (Image)null;  				//create a null Image
		
		try{
            while (img == null)					//while the Image img is null
			{
				//gifFileName is the gif image to be loaded
	    		img = Toolkit.getDefaultToolkit().getImage(gifFileName); //returns an object of type Toolkit
				//which contains information about the environment in which the application is running 
				//including the screen size in pixels

	   			b = new Button();  							//Creates a button to use as a parameter which is sent
	                              							//to the constructor for MediaTracker.
				tracker = new MediaTracker(b); 				//tracks the status of media objects including images
				tracker.addImage(img,0);  					//addImage adds the image and the ID which here is 0  
															//it is called for each image to be tracked		
				tracker.waitForID(0);						//Starts loading all images tracked by this media tracker														//with the specified identifier.
			}
		}
		catch(InterruptedException e) 
		{
            JOptionPane.showMessageDialog(null, e, "Message", 
					JOptionPane.ERROR_MESSAGE);
	    	System.exit(1);
		}
				
		//Creates "observer", an object that allows us to
		//use getWidth and getHeight of the image above
		observer = new IObserver();
		
		width = img.getWidth(observer);
		height = img.getHeight(observer);
		
		//Converts the img Image into a 3D array called "imagePixels" by calling the method getImagePixels.
        //The three dimensions are imagePixels[row][col][values for RGB and A] 
		imagePixels = getImagePixels(img, width, height);
        return imagePixels;
	}
		
	public static int[][][] getImagePixels(Image img, int width, int height) 
	{
		int[] rawPixels;
		int[][] rgbPixels;
		int[][][] imagePixels;
		int index=0;
		int j;
		int row;
		int col;
		int rgbo;
		
		//Gets the raw pixel data as a series of 32 bit values stored in a one dimensional array called rawPixels
		rawPixels = getPixels(img,width,height);

		//creates a 2D array containing the number of pixels in the image and 4 values representing RGB and O for each pixel
		rgbPixels = new int[rawPixels.length][4];
		
		//Each pixel is represented by 32 bit values in rawPixels.  Separate each of the 32 bit values in rawPixels into
		//four 8-bit values (red, green, blue, offset) and store the RGB and O values in the rgbPixels array 
		for(j=0; j<rawPixels.length; j++) 
		{
		    rgbPixels[j][0] = ((rawPixels[j]>>16)&0xff);
		    rgbPixels[j][1] = ((rawPixels[j]>>8)&0xff);
		    rgbPixels[j][2] = (rawPixels[j]&0xff);
		    rgbPixels[j][3] = ((rawPixels[j]>>24)&0xff);
		}

		//rgbPixels still represents the image as a one dimensional series of 
		//positions each of which is divided into an RGBA sub array which gives it 2 dimensions
		
		//Arranges the data by rows and columns turning it into a 3D array creates a 3D array
		//called imagePixels which is the width of the original image wide, the height of the original image
		//high and 4 positions deep to represent the rgb and o values at the corresponding pixel coordinate
		imagePixels = new int[height][width][4];
		
		//for each row 
		for(row=0; row<imagePixels.length; row++) 
		{
			//for each column in that row
	    	for(col=0; col<imagePixels[0].length; col++) 
			{
				//read the rgb and o values from the 2D rgbPixels array and put them into the corresponding rgbo positions
				//in the appropriate row column position in the 3D imagePixels array
				for(rgbo=0; rgbo<4; rgbo++) 
				{
		    		imagePixels[row][col][rgbo]=rgbPixels[index][rgbo];
				} // for rgbo
				
				index++; //go to the next position in rgbPixels
	    	} // for col
		}  // for row
		return imagePixels; //return the 3D representation of the image
    }

	//returns a one dimensional array containing the rawPixels data which is a series of 32 bit values 
	//representing rgb and o for each pixel in the image.
	public static  int[] getPixels(Image img, int width, int height) 
	{
		int[] rawPixels; 
		PixelGrabber pg;
		
		//rawPixels gets its size by multiplying the width and height of the image it will be storing
		rawPixels = new int [width * height];
		
		//Creates a PixelGrabber object to grab the (x, y, w, h) rectangular section of pixels from the specified 
		//image into the given array, in this case rawPixels. 
		pg = new PixelGrabber (img, 0, 0, width, height, rawPixels, 0, width);
		
		try 
		{
	    	pg.grabPixels ();
		}
		catch (InterruptedException e) 
		{
	    	e.printStackTrace ();
		}
		
		//return the array with the raw pixel values
		return rawPixels;
    }	
}

class IObserver implements ImageObserver 					//An interface for receiving notifications
{					 										//about Image information as the Image is constructed.														
    public boolean imageUpdate (Image img, int infoflags, int x, int y, int width, int height) 
	{														// incrementally draws an image on the component 
		return true;			 							//as more of the bits of the image are available.
	}
}