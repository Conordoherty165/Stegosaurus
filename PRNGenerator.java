import javax.swing.JOptionPane;

//this class produces a pseudo random non repeating sequence of numbers using a key 
//the PRNG stego and unstego processes and the Fridrich stego and unstego processes
//will later turn these into a series of 2D image positions
public class PRNGenerator 
{
	public static int[] PRNG(int pictureSize) 
	{
		//i is a non factor of pictureSize
		//pictureSize divided by i = the step size
		//the pseudo random numbers are stored in the dataPositions array
		int i = findNonFactors(pictureSize); 
		int stepSize = pictureSize / i;
		int flag = 0;
		int [] dataPositions = new int[pictureSize]; //initialise the dataPositions array
		int dpPos = 0;
		int key=0;
		int counter;
		String keyValue;
		int pos;
		
		//set the dataPositions array values to 0		
		for (counter = 0; counter < pictureSize; counter++)
			dataPositions [counter] = 0;
		
		//check if picture size and stepsize have no factors in common
		do
		{
			flag = findFactors(stepSize, pictureSize);
			if (flag == 1)
			{
				stepSize++;
			}
		} while (flag == 1);
		
		//reads in a positive integer key value other than 0 which will be used to generate the pseudo random numbers
		do
		{
			try
			{
				keyValue = JOptionPane.showInputDialog("Please enter a positive integer key value other than 0: ");
		
				key = Integer.parseInt(keyValue);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "This stegonography process cannot continue without a valid key value", 
				"Message", JOptionPane.PLAIN_MESSAGE);
			}
		} while (key == 0);
		
		for (counter = 0; counter < pictureSize; counter++)
		{
			pos = key + (stepSize * counter);

			if (pos > pictureSize)
			{
				pos = (pos % pictureSize);//if pos is greater than pictureSize get its Modulus which becomes pos
				dataPositions[dpPos] = pos + 1; //place pos in dataPositions adding 1 to it in case pos has a value of 0
				dpPos++;	
			}
			else
			{
				dataPositions[dpPos] = pos + 1;//place pos in dataPositions adding 1 to it in case pos has a value of 0
				dpPos++;
			}	
		}
		return dataPositions;
	}
	
	//given the size of the picture finds and returns a non factor of pictureSize
	public static int findNonFactors(int pictureSize)
	{
		int counter;
		
		for (counter = 2; counter <= pictureSize; counter++)
		{
			if (pictureSize % counter != 0)
			{
				return counter;
			}
		}
		return counter;
	}
	
	//checks if stepSize and pictureSize have any factors in common
	//if they have factors in common this method returns a 1 else it returns a 0
	public static int findFactors(int stepSize, int pictureSize)
	{
		//creates an array called stepSizeFactors and initialises its values to 0
		int [] stepSizeFactors = new int[stepSize];
		int arrayPos = 0;
		int counter;
		int flag = 0;
		
		for (counter = 0; counter < stepSize; counter++)
			stepSizeFactors [counter] = 0;
		
		//finds the factors of stepSize other than 1 and stores them in stepSizeFactors	
		for (counter = 2; counter <= stepSize; counter++)
		{
			if (stepSize % counter == 0)
			{
				stepSizeFactors [arrayPos] = counter;
				arrayPos++;
			}
		}		
	
		flag = 0;
		
		//checks if factors of stepSize (stored in stepSizeFactors) are factors of pictureSize
		//if they are set flag to 1, otherwise flag remains equal to 0
		for (counter = 0; counter < arrayPos; counter++)
		{
			if (pictureSize % stepSizeFactors [counter] == 0)
				flag = 1;
		}
		return flag;
	}	
}