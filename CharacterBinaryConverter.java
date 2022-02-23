
//import java.io.*;
//import java.awt.*;
//import java.awt.image.*;
//import java.awt.event.*;
//import java.applet.*;
//import javax.swing.*;
//import javax.swing.filechooser.FileFilter;

public class CharacterBinaryConverter

{
	//Converts the message to be stegoed, which is now an array of strings into a different array of strings
	//which contains a binary representation of that message
	public static String[] convertMessageToBinary(String [] message, int maxStringSize)
	{
		//declares a string array called binaryString which has a string position for each pixel in the 
		//image the message will be hidden in
		String [] binaryString;
		int iloop = 0;
		int mainCounter = 0;
		String text;
		char[] theLetter;
		
		//there is a character in each position in the message array
		binaryString = new String[((maxStringSize * 8) - 1)]; 
		
		do								//while there are still characters in the message to be stegoed
		{
			//problem: the message to be stegoed is in an array of strings, switch statements evaluate characters rather than strings
			text = message[iloop]; //puts the string array into a string
			theLetter = new char [1]; //creates an array of characters 1 character long
			text.getChars(0, 1, theLetter, 0); //extracts one character at a time from text and puts it into theLetter
			
			//for each character the switch statement evaluates its value and converts it into a binary string representation of that value
			//using a method called converter which appends the binary string representation of that value to a string
			//array called binaryString 
			switch (theLetter[0])
			{
				case 'A': { binaryString = converter(binaryString, mainCounter, "01000001");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'B': { binaryString = converter(binaryString, mainCounter, "01000010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'C': { binaryString = converter(binaryString, mainCounter, "01000011");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'D': { binaryString = converter(binaryString, mainCounter, "01000100");
							mainCounter = mainCounter + 8;							  
							break; 
						  }
				case 'E': { binaryString = converter(binaryString, mainCounter, "01000101");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'F': { binaryString = converter(binaryString, mainCounter, "01000110");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'G': { binaryString = converter(binaryString, mainCounter, "01000111");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'H': { binaryString = converter(binaryString, mainCounter, "01001000");
							mainCounter = mainCounter + 8;
							break; 
						  }
				
				case 'I': { binaryString = converter(binaryString, mainCounter, "01001001");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'J': { binaryString = converter(binaryString, mainCounter, "01001010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'K': { binaryString = converter(binaryString, mainCounter, "01001011");
							mainCounter = mainCounter + 8;
							break;
						  }
				case 'L': { binaryString = converter(binaryString, mainCounter, "01001100");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'M': { binaryString = converter(binaryString, mainCounter, "01001101");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'N': { binaryString = converter(binaryString, mainCounter, "01001110");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'O': { binaryString = converter(binaryString, mainCounter, "01001111");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'P': { binaryString = converter(binaryString, mainCounter, "01010000");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'Q': { binaryString = converter(binaryString, mainCounter, "01010001");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'R': { binaryString = converter(binaryString, mainCounter, "01010010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'S': { binaryString = converter(binaryString, mainCounter, "01010011");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'T': { binaryString = converter(binaryString, mainCounter, "01010100");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'U': { binaryString = converter(binaryString, mainCounter, "01010101");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'V': { binaryString = converter(binaryString, mainCounter, "01010110");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'W': { binaryString = converter(binaryString, mainCounter, "01010111");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'X': { binaryString = converter(binaryString, mainCounter, "01011000");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'Y': { binaryString = converter(binaryString, mainCounter, "01011001");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'Z': { binaryString = converter(binaryString, mainCounter, "01011010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'a': { binaryString = converter(binaryString, mainCounter, "01100001");
							mainCounter = mainCounter + 8;
							break;
					      }
				case 'b': { binaryString = converter(binaryString, mainCounter, "01100010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'c': { binaryString = converter(binaryString, mainCounter, "01100011");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'd': { binaryString = converter(binaryString, mainCounter, "01100100");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'e': { binaryString = converter(binaryString, mainCounter, "01100101");
							mainCounter = mainCounter + 8;
							break;
					      }
				case 'f': { binaryString = converter(binaryString, mainCounter, "01100110");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'g': { binaryString = converter(binaryString, mainCounter, "01100111");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'h': { binaryString = converter(binaryString, mainCounter, "01101000");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'i': { binaryString = converter(binaryString, mainCounter, "01101001");
							mainCounter = mainCounter + 8;
							break;
	  					  }
				
				case 'j': { binaryString = converter(binaryString, mainCounter, "01101010");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'k': { binaryString = converter(binaryString, mainCounter, "01101011");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'l': { binaryString = converter(binaryString, mainCounter, "01101100");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'm': { binaryString = converter(binaryString, mainCounter, "01101101");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'n': { binaryString = converter(binaryString, mainCounter, "01101110");
							mainCounter = mainCounter + 8;
							break;
					      }
				case 'o': { binaryString = converter(binaryString, mainCounter, "01101111");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'p': { binaryString = converter(binaryString, mainCounter, "01110000");
							mainCounter = mainCounter + 8;
							break; 
						  }
				case 'q': { binaryString = converter(binaryString, mainCounter, "01110001");
							mainCounter = mainCounter + 8;
							break; 
						  }
						
				case 'r': { binaryString = converter(binaryString, mainCounter, "01110010");
							mainCounter = mainCounter + 8;
							break;
					      }

				case 's': { binaryString = converter(binaryString, mainCounter, "01110011");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case 't': { binaryString = converter(binaryString, mainCounter, "01110100");
				   	      	mainCounter = mainCounter + 8;
				   	      	break;
				   	      }
				case 'u': { binaryString = converter(binaryString, mainCounter, "01110101");
				  	      	mainCounter = mainCounter + 8;
				   	      	break;
				   	      }
				case 'v': { binaryString = converter(binaryString, mainCounter, "01110110");
				  	      	mainCounter = mainCounter + 8;
				   	      	break;
				  	      }
				case 'w': { binaryString = converter(binaryString, mainCounter, "01110111");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case 'x': { binaryString = converter(binaryString, mainCounter, "01111000");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case 'y': { binaryString = converter(binaryString, mainCounter, "01111001");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case 'z': { binaryString = converter(binaryString, mainCounter, "01111010");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '.': { binaryString = converter(binaryString, mainCounter, "00101110");
					       	mainCounter = mainCounter + 8;
					      	break;
					      }
				case ',': { binaryString = converter(binaryString, mainCounter, "00101100");
					       	mainCounter = mainCounter + 8;
					      	break;
					      }
				case ' ': { binaryString = converter(binaryString, mainCounter, "00100000");
					     	mainCounter = mainCounter + 8;
					     	break;
					      }
				case '-': { binaryString = converter(binaryString, mainCounter, "00101101");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '?': { binaryString = converter(binaryString, mainCounter, "00111111");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '0': { binaryString = converter(binaryString, mainCounter, "00110000");
					        mainCounter = mainCounter + 8;
					        break;
					      }
				case '1': { binaryString = converter(binaryString, mainCounter, "00110001");
					        mainCounter = mainCounter + 8;
					        break;
					        	      }
				case '2': { binaryString = converter(binaryString, mainCounter, "00110010");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '3': { binaryString = converter(binaryString, mainCounter, "00110011");
					     	mainCounter = mainCounter + 8;
					     	break;
					      }
				case '4': { binaryString = converter(binaryString, mainCounter, "00110100");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '5': { binaryString = converter(binaryString, mainCounter, "00110101");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '6': { binaryString = converter(binaryString, mainCounter, "00110110");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '7': { binaryString = converter(binaryString, mainCounter, "00110111");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '8': { binaryString = converter(binaryString, mainCounter, "00111000");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
				case '9': { binaryString = converter(binaryString, mainCounter, "00111001");
					      	mainCounter = mainCounter + 8;
					     	break;
					      }
				default:  { //note: in the case statement unrecognised blocks of 8 bits should be inserted as an *
							binaryString = converter(binaryString, mainCounter, "00101010");
					      	mainCounter = mainCounter + 8;
					      	break;
					      }
			}	
			iloop++;
		} while (message[iloop] != null); 	
		return binaryString;
	}
	
	public static String[] converter(String [] binaryString, int mainCounter, String binaryValue)
	{
		//converter appends the binary string representation of a value to a string
		//array called binaryString and returns binaryString
		
		for	(int bitCounter = 0; bitCounter <8; bitCounter++)
		{
			binaryString[mainCounter] = binaryValue.substring(bitCounter,bitCounter+1);
			mainCounter++;
		}
		return binaryString;
	}
	
	public static String convertBinaryToMessage(String extractedBinaryMessage)
	{
		//loop through the string representing the binary bits 
		//in blocks of 8 passing the blocks to an if statement which converts them into text characters
		//and appends the character to a string representing the extracted message
		
		String extractedMessage = "";
		String theLetterBits = "";
		int position = 0;
		int exitFlag = 0;
		
		do	
		{
			//step through the string representing the binary bits 
			//in blocks of 8

			theLetterBits = extractedBinaryMessage.substring(position,position+8);	

			//evaluate the string representing a block of 8 bits and convert it to an appropriate character
			//append the character to a string representing the stegoed message
			//repeat until you find a block which does not correspond to a known character
			if (theLetterBits.compareTo("01000001") == 0) //If the block of 8 bits is the same as the value 
			{											  //sent to the method compareTo the value in brackets a 0 is returned.
				extractedMessage = extractedMessage +"A";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01000010") == 0)
			{ 
				extractedMessage = extractedMessage +"B";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01000011") == 0) 
			{ 
				extractedMessage = extractedMessage +"C";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01000100") == 0) 
			{  
				extractedMessage = extractedMessage +"D";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01000101") == 0) 
			{ 
				extractedMessage = extractedMessage +"E";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01000110") == 0) 
			{ 
				extractedMessage = extractedMessage +"F";
				position = position + 8;
		    }
			else if	(theLetterBits.compareTo("01000111") == 0) 
			{ 
				extractedMessage = extractedMessage +"G";
				position = position + 8;
			 }
			else if (theLetterBits.compareTo("01001000") == 0)
			{
				extractedMessage = extractedMessage +"H";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001001") == 0)
			{ 
				extractedMessage = extractedMessage +"I";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001010") == 0)
			{ 
				extractedMessage = extractedMessage +"J";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001011") == 0) 
			{  
				extractedMessage = extractedMessage +"K";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001100") == 0)
			{ 
				extractedMessage = extractedMessage +"L";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001101") == 0)
			{ 
				extractedMessage = extractedMessage +"M";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001110") == 0)
			{ 
				extractedMessage = extractedMessage +"N";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01001111") == 0)
			{ 
				extractedMessage = extractedMessage +"O";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010000") == 0)
			{ 
				extractedMessage = extractedMessage +"P";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010001") == 0)
			{ 
				extractedMessage = extractedMessage +"Q";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010010") == 0)
			{ 
				extractedMessage = extractedMessage +"R";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010011") == 0)
			{ 
				extractedMessage = extractedMessage +"S";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010100") == 0)
			{ 
				extractedMessage = extractedMessage +"T";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010101") == 0)
			{ 
				extractedMessage = extractedMessage +"U";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010110") == 0)
			{ 
				extractedMessage = extractedMessage +"V";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01010111") == 0)
			{ 
				extractedMessage = extractedMessage +"W";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01011000") == 0)
			{ 
				extractedMessage = extractedMessage +"X";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01011001") == 0)
			{ 
				extractedMessage = extractedMessage +"Y";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01011010") == 0)
			{ 
				extractedMessage = extractedMessage +"Z";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100001") == 0)
			{ 
				extractedMessage = extractedMessage +"a";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100010") == 0)
			{ 
				extractedMessage = extractedMessage +"b";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100011") == 0)
			{ 
				extractedMessage = extractedMessage +"c";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100100") == 0)
			{ 
				extractedMessage = extractedMessage +"d";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100101") == 0)
			{ 
				extractedMessage = extractedMessage +"e";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100110") == 0)
			{ 
				extractedMessage = extractedMessage +"f";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01100111") == 0)
			{ 
				extractedMessage = extractedMessage +"g";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101000") == 0)
			{ 
				extractedMessage = extractedMessage +"h";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101001") == 0)
			{ 
				extractedMessage = extractedMessage +"i";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101010") == 0)
			{ 
				extractedMessage = extractedMessage +"j";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101011") == 0)
			{ 
				extractedMessage = extractedMessage +"k";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101100") == 0)
			{ 
				extractedMessage = extractedMessage +"l";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101101") == 0)
			{ 
				extractedMessage = extractedMessage +"m";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101110") == 0)
			{ 
				extractedMessage = extractedMessage +"n";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01101111") == 0)
			{ 
				extractedMessage = extractedMessage +"o";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110000") == 0)
			{ 
				extractedMessage = extractedMessage +"p";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110001") == 0)
			{ 
				extractedMessage = extractedMessage +"q";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110010") == 0)
			{ 
				extractedMessage = extractedMessage +"r";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110011") == 0)
			{ 
				extractedMessage = extractedMessage +"s";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110100") == 0)
			{ 
				extractedMessage = extractedMessage +"t";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110101") == 0)
			{ 
				extractedMessage = extractedMessage +"u";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110110") == 0)
			{ 
				extractedMessage = extractedMessage +"v";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01110111") == 0)
			{ 
				extractedMessage = extractedMessage +"w";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01111000") == 0)
			{ 
				extractedMessage = extractedMessage +"x";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01111001") == 0)
			{ 
				extractedMessage = extractedMessage +"y";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("01111010") == 0)
			{ 
				extractedMessage = extractedMessage +"z";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00101110") == 0)
			{ 
				extractedMessage = extractedMessage +".";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00101100") == 0)
			{ 
				extractedMessage = extractedMessage +",";
				position = position + 8;
			}			
			else if	(theLetterBits.compareTo("00100000") == 0)
			{ 
				extractedMessage = extractedMessage +" ";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00101101") == 0)
			{ 
				extractedMessage = extractedMessage +"-";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00111111") == 0)
			{ 
				extractedMessage = extractedMessage +"?";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110000") == 0)
			{ 
				extractedMessage = extractedMessage +"0";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110001") == 0)
			{ 
				extractedMessage = extractedMessage +"1";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110010") == 0)
			{ 
				extractedMessage = extractedMessage +"2";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110011") == 0)
			{ 
				extractedMessage = extractedMessage +"3";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110100") == 0)
			{ 
				extractedMessage = extractedMessage +"4";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110101") == 0)
			{ 
				extractedMessage = extractedMessage +"5";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110110") == 0)
			{ 
				extractedMessage = extractedMessage +"6";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00110111") == 0)
			{ 
				extractedMessage = extractedMessage +"7";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00111000") == 0)
			{ 
				extractedMessage = extractedMessage +"8";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00111001") == 0)
			{ 
				extractedMessage = extractedMessage +"9";
				position = position + 8;
			}
			else if	(theLetterBits.compareTo("00101010") == 0)
			{ 
				extractedMessage = extractedMessage +"*";
				position = position + 8;
			}	
			else exitFlag = 1;

		}while (exitFlag != 1);	
			
		return extractedMessage;
	}
}
