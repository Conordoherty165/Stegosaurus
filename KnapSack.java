
public class KnapSack
{
	public static void knapSack(String textFileName, String saveFileName)
	{
		int maxStringSize = 8000;  	//8000 Characters can produce 64000 bits which can
		String[] message;			//produce just under 11000 integer values using 6
		String[] binaryString;		//bit chunks to produce an encrypted number.
		int [] knappedNumbers = new int[11000];	//The highest integer produced will be three digits
												//long and each integer will be seperated by a ','
												//resulting in a maximum of 44000 individual 
												//character values 0 to 9 and a comma
		
		message = new String[maxStringSize - 1]; //message is a string array of size maxStringSize
		
		//calls the method to read in the message to be encrypted from a file
		message = MessageHandler.readMessage(maxStringSize, textFileName);
		
		//creates binaryString which will hold the binary representation of the message to be encrypted				
		binaryString = new String[maxStringSize*8];
		
		//calls a method to convert the message to its binary representation
		binaryString = CharacterBinaryConverter.convertMessageToBinary(message, maxStringSize);
						
		//calls a method to encrypt the message using knapSack
		knappedNumbers=encryptKnapSack(binaryString);
		
		//calls a method to save the encrypted message in a text file called saveFileName
		MessageHandler.writeMessage(knappedNumbers, saveFileName);	
	}
	
	//Method opens encrypted text file, deencrypts the text and returns it to the calling method
	public static String knapSackDecrypt(String textFileName)
	{
		int maxStringSize =44000;
		String[] encryptedMessage;
		String decryptedTextMessage;
		
		encryptedMessage = new String[maxStringSize - 1]; //message is a string array of size maxStringSize
		
		//calls the method to read in the encrypted message to be decrypted from a file
		encryptedMessage = MessageHandler.readMessage(maxStringSize, textFileName);
		
		decryptedTextMessage = decryptKnapSack(encryptedMessage, maxStringSize);

		return decryptedTextMessage;
	}
	
	//takes a message represented as a binary string and returns an encrypted version of that message
	//which is represented as a series of knapped numbers stored in an array
	public static int [] encryptKnapSack (String[] binaryString)
	{
		int counter = 0;
		int kNCounter=0;
		int total = 0;
		char binaryValue;
		
		//creates an array to hold the knapped numbers and initialises its values to -1
		int [] knappedNumbers = new int[11000];
		
		for(int initializer = 0; initializer < 11000; initializer++)
		{
			knappedNumbers[initializer] = -1;
		}
		
		//examine the array of binary bits in blocks of 6
		//if a bit is equal to 1 it is assigned a number from the public key
		//the number it is assigned depends on its position in the block
		//if the bit is a 0 it is ignored
		//a total is derived by adding the numbers corresponding to the binary ones
		//this total represents the knapped number for that block of 6 bits
		//the total is stored in the next position in the knappedNumbers array
		do
		{
			total = 0;
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 62;
			}
			counter++;
			
			if (binaryString[counter] == null)
			{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 93;
			}
			counter++;
			if (binaryString[counter] == null)
				{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 81;
			}
			counter++;
			if (binaryString[counter] == null)
				{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 88;
			}
			counter++;
			if (binaryString[counter] == null)
				{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 102;
			}
			counter++;
			if (binaryString[counter] == null)
				{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			binaryValue = binaryString[counter].charAt(0);
			
			if (binaryValue =='1')
			{
				total = total + 37;
			}
			counter++;
			if (binaryString[counter] == null)
				{
				knappedNumbers[kNCounter] = total;
				return knappedNumbers;
			}
			
			knappedNumbers[kNCounter] = total;
			kNCounter++;
		
		}while (binaryString != null); //repeats this process while there are bits remaining in the string
		
		return knappedNumbers;
	}
	
	public static String decryptKnapSack (String[] encryptedMessage, int maxStringSize)
	{
		String eachNumber = "";
		int [] arrayedKnappedNumbers = new int[maxStringSize/4]; 
		int counter = 0;
		int counter2 = 0;
		int reverseKnap = 0;
		String decryptedBinaryMessage ="";
		String subString = "";
		String decryptedTextMessage;
		int i; 
		
		do
		{
			//search the encryptedMessage array building each distinct number by utilising
			//the fact that each distinct number e.g. 125 is separated by a comma
			//each distinct number is stored in an array called arrayedKnappedNumbers 
			do
			{
				if (encryptedMessage[counter].charAt(0)!=',')
				{
					eachNumber = eachNumber + encryptedMessage[counter].charAt(0);
				}
				counter++;
				
			}while(encryptedMessage[counter].charAt(0)!=',');
			
			arrayedKnappedNumbers[counter2] = Integer.parseInt(eachNumber);
			eachNumber = "";
			counter2++;
			counter++;
			
		}while (encryptedMessage[counter]!= null);
		
		//carry out a reverse knap calculation on each number in arrayedKnappedNumbers compare the 
		//result with a superincreasing series of numbers representing the private key. When our number 
		//is greater than a given private key number add a 1 to the binary string and subtract that 
		//private key number form our number otherwise add a 0 to the binary string. Eventually this will 
		//yield a binary string equivalent to the original message
		for(i =0; i<counter2; i++)
		{
			reverseKnap = ((arrayedKnappedNumbers[i]*61)%105);
			if (reverseKnap < 52)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 52;
			}
			if (reverseKnap < 27)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 27;
			}
			if (reverseKnap < 13)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 13;
			}
			if (reverseKnap < 6)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 6;
			}
			if (reverseKnap < 3)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 3;
			}
			if (reverseKnap < 2)
				subString = "0" + subString;
			else
			{
				subString = "1" + subString;
				reverseKnap = reverseKnap - 2;
			}
			
			decryptedBinaryMessage =decryptedBinaryMessage + subString;	
			subString = "";	
		}
		
		//append an unfamiliar binary value to the decrypyted binary message so that the convertBinaryToMessage
		//method in the CharacterBinaryConversion class will recognise the end of the message
		decryptedBinaryMessage = decryptedBinaryMessage + "01000000";
		
		decryptedTextMessage = CharacterBinaryConverter.convertBinaryToMessage(decryptedBinaryMessage);
		
		return decryptedTextMessage ;
	}
}