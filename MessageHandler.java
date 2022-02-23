import java.io.*;
import javax.swing.*;


public class MessageHandler 
{
	//Reads in the message to be stegoed from a file. The message can be up to maxStringSize in size
	public static String[] readMessage(int maxStringSize, String textFileName)
	{
		int EOF_flag = 0;

		String[] message = new String[maxStringSize - 1]; //creates a string array to hold the message 
		String fileMessage = "";
		String lineFromFile = "";
		String fileName = textFileName; //the name of the file in which the message is stored
		int textLength;
		int i;
		
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader inFile = new BufferedReader(fr);//reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines
			do						//reads the message to be stegoed from its file a line at a time until EOF
			{
				fileMessage = fileMessage + lineFromFile;
				lineFromFile = inFile.readLine();
			}while (lineFromFile != null);
			
			inFile.close();
		}
		catch(EOFException exception)
		{
			EOF_flag = 1;
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
		//converts the string called message into a string array called fileMessage
		//fileMessage cannot be larger than the maxStringSize
		
		textLength = fileMessage.length(); //get the length of the message from the file
		
		
		if (maxStringSize >= textLength)		//if the message from the file is smaller than maxStringSize
		{										//copies the message from the file into the message array 
			for (i=0; i<textLength; i++)
			{
				message[i] = fileMessage.substring(i,i+1); //puts a character into each position in the message array
			}
		}
		else
		{
			//if the message from the file is larger than maxStringSize
			//copies as much as possible of the message from the file into the message array		
			JOptionPane.showMessageDialog(null, "Your message is too long, it will be truncated.", "Message", 
			JOptionPane.PLAIN_MESSAGE);		
					
			for (i=0; i<maxStringSize - 2; i++)
			{
				message[i] = fileMessage.substring(i,i+1);
			}
			
			message[i] = null;
		}
		return message; //returns the message to be stegoed
	}
	
	//used to save messages which have been encrypted, it takes in an array of knapped numbers
	//representing the encrypted message and the name of the file to store them in
	public static void writeMessage(int [] knappedNumbers, String saveFileName)
	{	
		int counter =0;
		try
		{
			//creates a FileWriter, a BufferedWriter and a PrintWriter
			FileWriter fw = new FileWriter(saveFileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);
			 
			do						
			{
				//writes knapped numbers out to a file separateing each with a comma to facilitate later retrieval
				outFile.print(knappedNumbers[counter] + ",");	
				
				counter++;
			}while (knappedNumbers[counter] != -1);
			//after all of the knapped numbers have been written to the file closes the file
			outFile.close();
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
	}
}