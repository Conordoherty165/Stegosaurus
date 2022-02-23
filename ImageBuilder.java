import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import javax.swing.*;


public class ImageBuilder extends Applet
{
	private Image finalImage;
	private int pix[];
	private int index;
	private int row;
	private int col;
	private int red;
	private int green;
	private int blue;
	private int alpha;
	private int RGBA;
	
	
	public ImageBuilder(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String saveImageName)
	{
		//takes the 3D array representing the image to be saved and creates a one dimensional array 
		//which will hold the reassembled 32 bit raw pixel values from the 3D array		
		int pix[] = new int[MAXCOLS * MAXROWS];
		index = 0;		
		
		//loops through each row
		for(row = 0; row < MAXROWS; row++)
		{
			//loops through each column
			for(col = 0; col < MAXCOLS; col++)
			{
				//combine the RGBO value back together
				red   = imagePixels[row][col][0];
				green = imagePixels[row][col][1];
				blue  = imagePixels[row][col][2];
				alpha = imagePixels[row][col][3];
				
				RGBA  = ((alpha << 24) | (red << 16) | (green << 8) | blue);
				
				pix[index++] = RGBA;
			}
		}
		//creates an image object called finalImage from the 1D array of 32 bit raw pixel values
		finalImage = createImage(new MemoryImageSource(MAXCOLS, MAXROWS, pix, 0, MAXCOLS));
			
		//calls the saveFile method passing it finalImage
		saveFile(finalImage, saveImageName);
	}
	
	public void saveFile(Image img, String saveImageName) 
	{
		//takes the image to be saved and writes it to a gif image file using the GIFEncoder provided
		try 
		{
			FileOutputStream out = new FileOutputStream(saveImageName);
			
			//Begins use of GIFEncoder 
			GIFEncoder encode = new GIFEncoder(img);
			OutputStream output = new BufferedOutputStream(out);
			encode.Write(output);
			//Ends use of GIFEncoder 
			
			output.close();
			out.close();
		}
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "The file " + saveImageName + " was not found.", "Message", 
					JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "The following error occured when trying to write the " + saveImageName + " file: " + e, "Message", 
					JOptionPane.ERROR_MESSAGE);
		}
	}	
}

