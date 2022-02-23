import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;


//Creates and displays the main menu for the Steganographic system
//The menu takes the form of a series of buttons to stego and unstego 
//images using various techniques and some related options

public class MenuBox extends JFrame
{
	private JButton button1, button2, button3, button4, button5, button6, button7,
	button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, buttonExit, buttonHelp;
	private JLabel label1;
	private Container c;
	private FlowLayout layout;	
	private File file1, file2;
	private JPanel buttonPanel;
	private ButtonHandler handler;
	private JFileChooser fileChooser;
	private File file;
	private int result;
	
	public MenuBox()
	{
		super("Main Menu for Steganographic System");
		
		layout = new FlowLayout();
		c = getContentPane();
		
		buttonPanel = new JPanel();	//creates a panel for the main menu
		
		label1 = new JLabel("Please choose the method you wish to use                   ");//creates a label for the main menu
		buttonPanel.add(label1);
		
		//creates the buttons for the main menu 
		button15 = new JButton("   Watermark Image  "); 
		layout. setAlignment(FlowLayout.LEFT);
		button15.setActionCommand("button15");
		buttonPanel.add(button15);
		
		button16 = new JButton("  Extract Watermark  ");
		layout. setAlignment(FlowLayout.LEFT);
		button16.setActionCommand("button16");
		buttonPanel.add(button16);
		
		button1 = new JButton("        Stego One Bit          ");
		layout. setAlignment(FlowLayout.LEFT);
		button1.setActionCommand("button1");
		buttonPanel.add(button1);
		
		button7 = new JButton("      UnStego One Bit       ");
		layout. setAlignment(FlowLayout.RIGHT);
		button7.setActionCommand("button7");
		buttonPanel.add(button7);
		
		button2 = new JButton("       Stego Two Bits        ");
		layout. setAlignment(FlowLayout.LEFT);
		button2.setActionCommand("button2");
		buttonPanel.add(button2);
		
		button8 = new JButton("     UnStego Two Bits      ");
		layout. setAlignment(FlowLayout.RIGHT);
		button8.setActionCommand("button8");
		buttonPanel.add(button8);
		
		button3 = new JButton("      Stego Three Bits      ");
		layout. setAlignment(FlowLayout.LEFT);
		button3.setActionCommand("button3");
		buttonPanel.add(button3);
		
		button9 = new JButton("    UnStego Three Bits    ");
		layout. setAlignment(FlowLayout.RIGHT);
		button9.setActionCommand("button9");
		buttonPanel.add(button9);
		 
		button4 = new JButton("       Stego Four Bits        ");
		layout. setAlignment(FlowLayout.LEFT);
		button4.setActionCommand("button4");
		buttonPanel.add(button4);
		
		button10 = new JButton("    UnStego Four Bits      ");
		layout. setAlignment(FlowLayout.RIGHT);
		button10.setActionCommand("button10");
		buttonPanel.add(button10);
		
		button5 = new JButton("    Stego Color Cycle      ");
		layout. setAlignment(FlowLayout.LEFT);
		button5.setActionCommand("button5");
		buttonPanel.add(button5);
		
		button11 = new JButton("  UnStego Color Cycle   ");
		layout. setAlignment(FlowLayout.RIGHT);
		button11.setActionCommand("button11");
		buttonPanel.add(button11);
		
		button6 = new JButton("   Stego One Bit PRNG   ");
		layout. setAlignment(FlowLayout.LEFT);
		button6.setActionCommand("button6");
		buttonPanel.add(button6);
		
		button12 = new JButton(" UnStego One Bit PRNG ");
		layout. setAlignment(FlowLayout.RIGHT);
		button12.setActionCommand("button12");
		buttonPanel.add(button12);
		
		button13 = new JButton("        Stego Fridrich         ");
		layout. setAlignment(FlowLayout.LEFT);
		button13.setActionCommand("button13");
		buttonPanel.add(button13);
		
		button14 = new JButton("      UnStego Fridrich       ");
		layout. setAlignment(FlowLayout.RIGHT);
		button14.setActionCommand("button14");
		buttonPanel.add(button14);
		
		button17 = new JButton("        Stego Adaptive        ");
		layout. setAlignment(FlowLayout.LEFT);
		button17.setActionCommand("button17");
		buttonPanel.add(button17);
		
		button18 = new JButton("      UnStego Adaptive      ");
		layout. setAlignment(FlowLayout.RIGHT);
		button18.setActionCommand("button18");
		buttonPanel.add(button18);
		
		button19 = new JButton("      Detect LSB      ");
		layout. setAlignment(FlowLayout.RIGHT);
		button19.setActionCommand("button19");
		buttonPanel.add(button19);
		
		button20 = new JButton("      Detect Parity      ");
		layout. setAlignment(FlowLayout.RIGHT);
		button20.setActionCommand("button20");
		buttonPanel.add(button20);
		
		buttonExit = new JButton("Exit");
		layout. setAlignment(FlowLayout.LEFT);
		buttonExit.setActionCommand("Exit");
		buttonPanel.add(buttonExit);
		
		buttonHelp = new JButton("Help");
		layout. setAlignment(FlowLayout.RIGHT);
		buttonHelp.setActionCommand("Help");
		buttonPanel.add(buttonHelp);
		
		c.add(buttonPanel, BorderLayout.CENTER); //adds the panel to the container
		layout.setHgap(35);
		
		handler = new ButtonHandler();  //creates new ButtonHandler object called handler
		
		//adds an ActionListener to each button
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
		button4.addActionListener(handler);
		button5.addActionListener(handler);
		button6.addActionListener(handler);
		button7.addActionListener(handler);
		button8.addActionListener(handler);
		button9.addActionListener(handler);
		button10.addActionListener(handler);
		button11.addActionListener(handler);
		button12.addActionListener(handler);
		button13.addActionListener(handler);
		button14.addActionListener(handler);
		button15.addActionListener(handler);
		button16.addActionListener(handler);
		button17.addActionListener(handler);
		button18.addActionListener(handler);
		button19.addActionListener(handler);
		button20.addActionListener(handler);
		buttonExit.addActionListener(handler);
		buttonHelp.addActionListener(handler);
		
		setSize(400, 450);
		show();
	}
	
	//creates a DisplyButtonsBox object and adds a WindowListener to it
	public static void main(String[] args) 
	{
		MenuBox app = new MenuBox();
		
		app.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
			);
	}
	
	//depending on which button is clicked a different action from the main menu is carried out
	//the user is walked through the process of choosing images and text files as required for carrying out a given action
	private class ButtonHandler implements ActionListener
	{
		private String gifFileName;
		private String gifWatermarkFileName; 
		private String textFileName; 
		private String gifFileStoreName;
		private String message;
		private String textFileStoreName;
		private int value;
		private StegoedGifImage stegoBits;
		private WatermarkGifImage watermarkBits;
		private UnWatermarkGifImage unWatermarkBits;
	   private StegoedImageViewer storedImage128;
		private StegoedImageViewer storedImage64;
		private StegoedImageViewer storedImage32;
		private StegoedImageViewer storedImage16;
		private StegoedImageViewer storedImageCC;
		private StegoedImageViewer storedImagePRNG;
		private StegoedImageViewer storedImageFrid;
		private StegoedImageViewer storedImageAdapt;
		private StegoedImageViewer storedImagePairs;
		private ImageViewer watermarkedImage128;
		private ImageViewer stegoedImage128;
		private ImageViewer stegoedImage64;
		private ImageViewer stegoedImage32;
		private ImageViewer stegoedImage16;
		private ImageViewer stegoedImageCC;
		private ImageViewer stegoedImagePRNG;
		private ImageViewer stegoedImageFrid;
		private ImageViewer stegoedImageAdapt;
		private ImageViewer imagePairs;
		private UnStegoedGifImage image;
		private MessageBox encryptedMessage;
		private StegoDetect detect1, detect2;
		private HelpBox help;
		
		public void actionPerformed(ActionEvent e)
		{
////////////////////////////////////////////////////////////////////////////////////////////////
		
			//Embeds the watermark in the LSB of the blue value
			if (e.getActionCommand().equals("button15"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 128 color GIF image to embed the watermark in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer image128 = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select the watermark image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				gifWatermarkFileName = openGIFFile();
				
				if (gifWatermarkFileName == "exit")
				{
					return;
				}
				
				ImageViewer watermarkImage = new ImageViewer(gifWatermarkFileName);
			
				JOptionPane.showMessageDialog(null, "You have chosen watermark image: " + gifWatermarkFileName + " and the image: " + gifFileName  + " to watermark.\nNext you must select a gif file in which to store the watermarked image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
		
				gifFileStoreName = saveWatermarkGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		

				watermarkBits = new WatermarkGifImage (gifFileName, gifWatermarkFileName, gifFileStoreName);
				storedImage128 = new StegoedImageViewer(gifFileStoreName);		

			}
////////////////////////////////////////////////////////////////////////////////////////////////
		
			//stegos one bit per pixel in the LSB of the blue value
			if (e.getActionCommand().equals("button1"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 128 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				//gifFileName = openGIFFile(); easy of access
				gifFileName = "C:\\Users\\jedib\\Downloads\\OneDrive_2022-02-22\\StegoSystem with watermark 2019 edited- Student Copy\\Sample Images\\parrots_128.gif";
				if (gifFileName.equals("exit"))
				{
					return;
				}
				
				ImageViewer image128 = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				//textFileName = openTextFile(); easy of access
				textFileName ="C:\\Users\\jedib\\Downloads\\OneDrive_2022-02-22\\StegoSystem with watermark 2019 edited- Student Copy\\message.txt";
				
				if (textFileName.equals("exit"))
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
		
				//gifFileStoreName = saveStegoGifFile();
				gifFileStoreName="C:\\Users\\jedib\\Desktop\\output.gif";
				if (gifFileStoreName.equals( "exit"))
				{
					return;
				}		

				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 1);
				storedImage128 = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//stegos 2 bits per pixel in the 2 LSBs of the blue value
			if (e.getActionCommand().equals("button2"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 64 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer image64 = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
				
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		

				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 2);
				storedImage64 = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//stegos 3 bits per pixel in the 3 LSBs of the blue value
			if (e.getActionCommand().equals("button3"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 32 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer image32 = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
				
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		

				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 3);
				storedImage32 = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//stegos 4 bits per pixel in the 4 LSBs of the blue value
			if (e.getActionCommand().equals("button4"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 16 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer image16 = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
				
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		

				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 4);
				storedImage16 = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//stegos 1 bit per pixel in the LSB of each colour in turn (Color Cycle)
			if (e.getActionCommand().equals("button5"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 64 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer imageCC = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
				
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		

				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 5);
				storedImageCC = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//stegos 1 bit per pixel in the LSB of the blue value of a pseudo randomly selected sequence of pixels 
			if (e.getActionCommand().equals("button6"))
			{
				JOptionPane.showMessageDialog(null, "You must select a 128 color GIF image to hide the message in", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer imagePRNG = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
			
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		
				
				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 6);
				storedImagePRNG = new StegoedImageViewer(gifFileStoreName);	
			}
			
			//stegos the parity bit of a pseudo randomly selected sequence of pixels using the Fridrich method
			if (e.getActionCommand().equals("button13"))
			{
				JOptionPane.showMessageDialog(null, "You must select a GIF image to hide the message in.\nIt can have up to 256 colours.", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer imageFrid = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
			
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		
				
				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 7);
				storedImageFrid = new StegoedImageViewer(gifFileStoreName);
			}
			
			//stegos the parity bit of a pseudo randomly selected sequence of pixels using the Adaptive method
			if (e.getActionCommand().equals("button17"))
			{
				JOptionPane.showMessageDialog(null, "You must select a GIF image to hide the message in.\nIt can have up to 256 colours.", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer imageAdapt = new ImageViewer(gifFileName);
			
				JOptionPane.showMessageDialog(null, "Next you must select a text file containing the message you want to hide", 
				"Message", JOptionPane.PLAIN_MESSAGE);
	
				textFileName = openTextFile();
				
				if (textFileName == "exit")
				{
					return;
				}
			
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " and the message file: " + textFileName  + " to stego.\nNext you must select a gif file in which to store the stegoed image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
			
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		
				
				stegoBits = new StegoedGifImage (gifFileName, textFileName, gifFileStoreName, 8);
				storedImageAdapt = new StegoedImageViewer(gifFileStoreName);
			}
			
////////////////////////////////////////////////////////////////////////////////////////////////

			//Removes watermark one bit per pixel from the LSB of the blue value
			if (e.getActionCommand().equals("button16"))
			{
				JOptionPane.showMessageDialog(null, "You must select a watermarked GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				watermarkedImage128 = new ImageViewer(gifFileName);
		
				JOptionPane.showMessageDialog(null, "You have chosen watermarked image: " + gifFileName + "Next you must select a gif file in which to store the watermarked image", 
				"Message", JOptionPane.PLAIN_MESSAGE);
		
				gifFileStoreName = saveWatermarkGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		
		
		
				unWatermarkBits = new UnWatermarkGifImage (gifFileName, gifFileStoreName);	

				storedImage128 = new StegoedImageViewer(gifFileStoreName);
					
			}

////////////////////////////////////////////////////////////////////////////////////////////////


			//unstegos one bit per pixel from the LSB of the blue value
			if (e.getActionCommand().equals("button7"))
			{
				JOptionPane.showMessageDialog(null, "You must select a stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				//gifFileName = openGIFFile();
				gifFileName="C:\\Users\\jedib\\Desktop\\output.gif";
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImage128 = new ImageViewer(gifFileName);
		
				UnStegoedGifImage image = new UnStegoedGifImage (gifFileName, 1);			
			}
			
			//unstegos two bits per pixel from the 2 LSBs of the blue value
			if (e.getActionCommand().equals("button8"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImage64 = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 2);			
			}
			
			//unstegos three bits per pixel from the 3 LSBs of the blue value
			if (e.getActionCommand().equals("button9"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImage32 = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 3);			
			}
			
			//unstegos four bits per pixel from the 4 LSBs of the blue value
			if (e.getActionCommand().equals("button10"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImage16 = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 4);			
			}
			
			//unstegos one bit per pixel from the LSB of each colour in turn (Color Cycle)
			if (e.getActionCommand().equals("button11"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImageCC = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 5);			
			}
			
			//unstegos 1 bit per pixel from the LSB of the blue value of a pseudo randomly selected sequence of pixels 
			if (e.getActionCommand().equals("button12"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImagePRNG = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 6);			
			}
			
			//unstegos the parity bit of a pseudo randomly selected sequence of pixels following the Fridrich method
			if (e.getActionCommand().equals("button14"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImageFrid = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 7);		
			}
			
			//unstegos the parity bit of a pseudo randomly selected sequence of pixels following the Adaptive method
			if (e.getActionCommand().equals("button18"))
			{
				JOptionPane.showMessageDialog(null, "You must select the stegoed GIF image to decode", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				stegoedImageAdapt = new ImageViewer(gifFileName);
				image = new UnStegoedGifImage (gifFileName, 8);		
			}
			
			if (e.getActionCommand().equals("button19"))
			{
				JOptionPane.showMessageDialog(null, "You must select the GIF image to detect", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				
				detect1 = new StegoDetect (gifFileName);		
			}
			
			if (e.getActionCommand().equals("button20"))
			{
				JOptionPane.showMessageDialog(null, "You must select the GIF image to detect", "Message", 
				JOptionPane.PLAIN_MESSAGE);
			
				gifFileName = openGIFFile();
				
				if (gifFileName == "exit")
				{
					return;
				}
				
				ImageViewer imagePairs = new ImageViewer(gifFileName);
				
				
				JOptionPane.showMessageDialog(null, "You have chosen image: " + gifFileName + " to stegoDetect.\nNext you must select a gif file in which to store the image pairs", 
				"Message", JOptionPane.PLAIN_MESSAGE);
			
				gifFileStoreName = saveStegoGifFile();
				
				if (gifFileStoreName == "exit")
				{
					return;
				}		
				
				detect2 = new StegoDetect (gifFileName,gifFileStoreName);
			
				storedImagePairs = new StegoedImageViewer(gifFileStoreName);		
			}
			
			//encrypts a message to be stegoed using the Knapsack method
			//if (e.getActionCommand().equals("button15"))
			//{
			//	JOptionPane.showMessageDialog(null, "You must select a file containing the message to encrypt", "Message", 
			//	JOptionPane.PLAIN_MESSAGE);
			
			//	textFileName = openTextFile();
				
			//	if (textFileName == "exit")
			//	{
			//		return;
			//	}
				
			//	JOptionPane.showMessageDialog(null, "You have chosen the message file: " + textFileName  + " to encrypt.\nNext you must select a text file in which to store the encrypted message", 
			//	"Message", JOptionPane.PLAIN_MESSAGE);
			
			//	textFileStoreName = saveEncryptedFile();
				
			//	if (textFileStoreName == "exit")
			//	{
			//		return;
			//	}		
				
			//	KnapSack.knapSack(textFileName, textFileStoreName);			
			//}
			
			//decrypts a message using the Knapsack method
			//if (e.getActionCommand().equals("button16"))
			//{
			//	JOptionPane.showMessageDialog(null, "You must select the file containing the message to decrypt", "Message", 
			//	JOptionPane.PLAIN_MESSAGE);
			
			//	textFileName = openTextFile();
				
			//	if (textFileName == "exit")
			//	{
			//		return;
			//	}
				
			//	JOptionPane.showMessageDialog(null, "You have chosen the message file: " + textFileName  + " to decrypt.", 
			//	"Message", JOptionPane.PLAIN_MESSAGE);
				
				
			//	message = KnapSack.knapSackDecrypt(textFileName);

			//	if (message.length()==0)
			//	{
			//		JOptionPane.showMessageDialog(null, "No message was found in the file.\nPlease check that you have chosen a file containing an encrypted message.", "Message", 
			//		JOptionPane.PLAIN_MESSAGE);
			//	}
			//	else
			//	{
			//		encryptedMessage = new MessageBox(message);
			//	}				
			//}
			
			//Displays the contents of a help file containing an explanation of the menu options
			if (e.getActionCommand().equals("Help"))
			{
				String fileMessage = "";
				String lineFromFile = "";
				String fileName = "C:\\StegoSystem\\HelpText.hlp"; //the name of the file in which the message is stored

				try
				{
					FileReader fr = new FileReader(fileName);
					BufferedReader inFile = new BufferedReader(fr);	//reads text from a character-input stream, buffering characters so as to provide for the efficient reading of 
					do												//characters, arrays, and lines reads the message to be stegoed from its file a line at a time until EOF
					{
						fileMessage = fileMessage + lineFromFile;
						fileMessage = fileMessage + "\n";
						lineFromFile = inFile.readLine();
					}while (lineFromFile != null);
			
					inFile.close();
				}
				catch(EOFException exception)
				{
					int EOF_flag = 1;
				}
				catch(FileNotFoundException exception)
				{
					JOptionPane.showMessageDialog(null, "The file could not be found", "Message", 
					JOptionPane.ERROR_MESSAGE);
				}
				catch(IOException exception)
				{
					JOptionPane.showMessageDialog(null, exception, "Message", 
					JOptionPane.ERROR_MESSAGE);
				}
				help = new HelpBox(fileMessage);
			}
			
			//Allows the user to exit after prompting for confirmation
			if (e.getActionCommand().equals("Exit"))
			{
				value = JOptionPane.showConfirmDialog(null, "Are you sure you wish to exit?", "Exit Check", 
				JOptionPane.YES_NO_OPTION);
				
				if (value==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				else if (value==JOptionPane.NO_OPTION)
				{ 
					return;
				}
			}
		}
	}
	
	//displays a JFileChooser to choose a Gif file containing an image to be stegoed 
	private String openGIFFile()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		ExtensionFilter gifFilter = new ExtensionFilter(".gif", "Gif Files(*.gif)");
		File file = new File("C:\\Karen\\Thesis Pictures\\A_Temp\\images for analysis");
		fileChooser.setCurrentDirectory(file);
		fileChooser.addChoosableFileFilter(gifFilter);
		fileChooser.setFileFilter(gifFilter);
		
		result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)	
			return "exit";		
		else
			return (fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName());  
	}
	
	//displays a JFileChooser to choose a text file to store in the image or be encrypted
	private String openTextFile()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		ExtensionFilter textFilter = new ExtensionFilter(".txt", "Text Files(*.txt)");
		File file = new File("C:\\StegoSystem");
		fileChooser.setCurrentDirectory(file);
		fileChooser.addChoosableFileFilter(textFilter);
		fileChooser.setFileFilter(textFilter);
		
		result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)	
			return "exit";	
		else
			return (fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName());  
	}
	
	
	//displays a JFileChooser to choose a Gif file in which to store the stegoed image 
	private String saveStegoGifFile()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		ExtensionFilter gifFilter = new ExtensionFilter(".gif", "Gif Files(*.gif)");
		file = new File("C:\\Karen\\Thesis Pictures\\A_Temp\\images for analysis");
		fileChooser.setCurrentDirectory(file);
		fileChooser.addChoosableFileFilter(gifFilter);
		fileChooser.setFileFilter(gifFilter);
		
		result = fileChooser.showSaveDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION)	
			return "exit";	
		else
			return (fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName());  		
	}
	
	//displays a JFileChooser to choose a Gif file in which to store the watermarked image 
	private String saveWatermarkGifFile()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		ExtensionFilter gifFilter = new ExtensionFilter(".gif", "Gif Files(*.gif)");
		file = new File("C:\\Karen\\Thesis Pictures\\A_Temp\\images for analysis");
		fileChooser.setCurrentDirectory(file);
		fileChooser.addChoosableFileFilter(gifFilter);
		fileChooser.setFileFilter(gifFilter);
		
		result = fileChooser.showSaveDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION)	
			return "exit";	
		else
			return (fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName());  		
	}

	
	//displays a JFileChooser to choose a text file in which to store the encrypted message 
	private String saveEncryptedFile()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		ExtensionFilter textFilter = new ExtensionFilter(".txt", "Text Files(*.txt)");
		file = new File("C:\\StegoSystem");
		fileChooser.setCurrentDirectory(file);
		fileChooser.addChoosableFileFilter(textFilter);
		fileChooser.setFileFilter(textFilter);
		
		result = fileChooser.showSaveDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)	
			return "exit";	
		else
			return (fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName());  	
	}			
}	

//creates the filters for the JFileChoosers		
class ExtensionFilter extends FileFilter
{
	private String extension;
	private String description;
	
	public ExtensionFilter (String ext, String descr)
	{
		extension = ext.toLowerCase();
		description = descr;
	}
	
	public boolean accept(File file)
	{
		return (file.isDirectory()|| file.getName().toLowerCase().endsWith(extension));
	}
	
	public String getDescription()
	{
		return description;
	}
}

//creates a JFrame in which to display the image to be stegoed
class ImageViewer extends JFrame
{
	private Icon logo;
	private JLabel label;
	private Container c;
	private FlowLayout layout;
	
	public ImageViewer (String gifFileName)
	{
		super("Your chosen Image");
		layout = new FlowLayout();
		c = getContentPane();
		c.setLayout(layout);
		logo = new ImageIcon(gifFileName);
		label = new JLabel(); 
		label.setText("This is the image you have chosen" + gifFileName);
		label.setIcon(logo);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);                 
		c.add(label);
		setSize(500, 500);
		setEnabled(true); 
		setLocation(0, 400);
		show();
	}		
}

//creates a JFrame in which to display the image which has been stegoed
class StegoedImageViewer extends JFrame
{
	private Icon icon;
	private JLabel label;
	private Container c;
	private FlowLayout layout;
	
	public StegoedImageViewer (String gifFileStoreName)
	{
		super("Your Modified Image");
		layout = new FlowLayout();
		c = getContentPane();
		c.setLayout(layout);
		icon = new ImageIcon(gifFileStoreName);
		label = new JLabel(); 
		label.setText("This is your modified image" + gifFileStoreName);
		label.setIcon(icon);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);                 
		c.add(label);
		setSize(500, 500);
		setLocation(400, 400);
		show();
	}			
}

//creates a JFrame in which to display the image which has been stegoed
//class WatermarkImageViewer extends JFrame
//{
//	private Icon icon;
//	private JLabel label;
//	private Container c;
//	private FlowLayout layout;
	
//	public WatermarkImageViewer (String gifFileStoreName)
//	{
//		super("Your Watermarked Image");
//		layout = new FlowLayout();
//		c = getContentPane();
//		c.setLayout(layout);
//		icon = new ImageIcon(gifFileStoreName);
//		label = new JLabel(); 
//		label.setText("This is your watermarked image" + gifFileStoreName);
//		label.setIcon(icon);
//		label.setHorizontalTextPosition(SwingConstants.CENTER);
//		label.setVerticalTextPosition(SwingConstants.BOTTOM);                 
//		c.add(label);
//		setSize(500, 500);
//		setLocation(400, 400);
//		show();
//	}			
//}

//creates a JFrame in which to display the message unstegoed from the image		
class MessageBox extends JFrame
{
	private JTextArea text;
	private Container c;
	private Box b;
	private JScrollPane pane;
	
	public MessageBox (String message)
	{
		super("Your Message");
		b = Box.createHorizontalBox();
		
		text = new JTextArea(400, 400);
		text.setText(message + "Message Decoded");
		JScrollPane pane = new JScrollPane(text);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b.add(pane);
		c = getContentPane();
		c.add(b);
		setSize(400, 400);
		//setLocation(0, 0);
		show();
	}
}

//creates a JFrame in which to display the contents of a file containing an explanation of the menu options
class HelpBox extends JFrame
{
	private JTextArea text;
	private Container c;
	private Box b;
	private JScrollPane pane;
	
	public HelpBox (String fileMessage)
	{
		super("Help");
		b = Box.createHorizontalBox();
		text = new JTextArea(400, 400);
		text.setText(fileMessage);
		JScrollPane pane = new JScrollPane(text);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b.add(pane);
		c = getContentPane();
		c.add(b);
		setSize(400, 400);
		//setLocation(0, 0);
		show();
	}
}

