
import javax.swing.*;

public class StegoedGifImage {
	private int[][][] imagePixels;
	private final int MAXROWS;
	private final int MAXCOLS;
	private int maxStringSize = 0;
	private int[][][] stegoedImage;
	private String[] message;
	private String[] binaryString;
	private ImageBuilder i;

	public StegoedGifImage(String gifFileName, String textFileName, String gifFileStoreName, int flag) {
		// Loads the image to be stegoed into a 3D array called imagePixels
		imagePixels = ImageDeconstructor.loadImage(gifFileName);

		// Gets the height and width of the image in pixels, i.e. rows and columns
		MAXROWS = imagePixels.length; // height??
		MAXCOLS = imagePixels[0].length; // width or length of the first row??

		// maxStringSize creates an integer equal to the max string size the image can
		// hold
		// i.e. the number of pixels in the image divided by 8 for the bits in a
		// character
		if (flag == 2 || flag == 5) {
			// i.e. the number of pixels in the image divided by 4 for the bits in a
			// character
			maxStringSize = ((MAXROWS * MAXCOLS) / 4);
		} else if (flag == 3) {
			// i.e. the number of pixels in the image divided by 8 and multiplied by 3 for
			// the bits in a character
			maxStringSize = (((MAXROWS * MAXCOLS) / 8) * 3);
		} else if (flag == 4) {
			// i.e. the number of pixels in the image divided by 2 for the bits in a
			// character
			maxStringSize = ((MAXROWS * MAXCOLS) / 2);
		} else if (flag == 8) {
			// i.e. the number of pixels in the image divided by 2 for the bits in a
			// character
			maxStringSize = ((MAXROWS * MAXCOLS) / 80);
		} else {
			// i.e. the number of pixels in the image divided by 8 for the bits in a
			// character
			maxStringSize = ((MAXROWS * MAXCOLS) / 8);
		}

		message = new String[maxStringSize - 1]; // message is a string array of size maxStringSize

		// calls the method to read in the message to be stegoed from a file
		message = MessageHandler.readMessage(maxStringSize, textFileName);

		// creates binaryString which will hold the binary representation of the message
		// to be stegoed
		binaryString = new String[MAXROWS * MAXCOLS];

		// calls a method to convert the message to its binary representation
		binaryString = CharacterBinaryConverter.convertMessageToBinary(message, maxStringSize);

		if (flag == 1) {
			// calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImage1Bit(imagePixels, MAXROWS, MAXCOLS, binaryString);
		} else if (flag == 2) {
			// Calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImage2Bits(imagePixels, MAXROWS, MAXCOLS, binaryString);
		} else if (flag == 3) {
			// Calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImage3Bits(imagePixels, MAXROWS, MAXCOLS, binaryString);
		} else if (flag == 4) {
			// Calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImage4Bits(imagePixels, MAXROWS, MAXCOLS, binaryString);
		} else if (flag == 5) {
			// calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImageColorCycle(imagePixels, MAXROWS, MAXCOLS, binaryString);
		} else if (flag == 6) {
			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[MAXROWS * MAXCOLS];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG(MAXROWS * MAXCOLS);

			// calls a method to hide the binary bits in the least significant bit of the
			// blue color
			stegoedImage = stegoTheImage1BitPRNG(imagePixels, MAXROWS, MAXCOLS, binaryString, dataPositions);
		} else if (flag == 7) {
			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[MAXROWS * MAXCOLS];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG(MAXROWS * MAXCOLS);

			// calls a method to hide the binary bits using the Fridrich method
			stegoedImage = stegoTheImageFridrich(imagePixels, MAXROWS, MAXCOLS, binaryString, dataPositions);
		}

		else {

			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[(MAXROWS * MAXCOLS) / 9];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG((MAXROWS * MAXCOLS) / 9);

			// calls a method to hide the binary bits using the Fridrich method
			stegoedImage = stegoTheImageAdaptive(imagePixels, MAXROWS, MAXCOLS, binaryString, dataPositions);
		}

		// calls a method to save the stegoed image sending the method the 3D array, the
		// height and width
		ImageBuilder i = new ImageBuilder(stegoedImage, MAXROWS, MAXCOLS, gifFileStoreName); // creates a SaveImage
																								// object,
	}

	// Hides the binary bits in the least significant bit of the blue color
	public int[][][] stegoTheImage1Bit(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString) {
		int i = 0;
		int row;
		int col;
		char binaryValue;
		int blue;
		for (row = 0; row < MAXROWS; row++) {
			for (col = 0; col < MAXCOLS; col++) {
				if (binaryString[i] == null)
					return imagePixels;
				binaryValue = binaryString[i].charAt(0); // Message Bit
				blue = imagePixels[row][col][2];
				if (binaryValue == '1' && ((blue & 1) == 0)) {
					blue++;

				} else if (binaryValue == '0' && ((blue & 1) == 1)) {
					blue--;
				}
				imagePixels[row][col][2] = blue;
				i++;
				blue = 0;
			}
		}
		return imagePixels;
	}

	// loops through each row in the 3D array

	// loops through each column in the 3D array

	// extracts the characters from the array
	// representing the binary string

	// if the character equals 1

	// and the least significant bit in the
	// blue value of the current pixel of the image is 0, add 1

	// if the character equals 0
	// and the least significant bit in the
	// blue value of the current pixel of the image is 1, subtract 1

	// until all of the bits to be hidden have been hidden
	// returns the stegoed 3D array

	// Check message bit then check the LSB of the blue value
	// message bit is 1010 //LSB of blue value 1001 --> first 1 do nothing, second 0
	// do nothing, third 0 change LSB to 1, fourth change LSB to 0
	// 0=red 1=Green 2=Blue

	// Hides the binary bits in the 2 least significant bits of the blue color
	public int[][][] stegoTheImage2Bits(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString) {
		int i = 0;
		int row;
		int col;
		char binaryValue;
		int secondBit;

		// loops through each row in the 3D array

		// loops through each column in the 3D array

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1

		// and the least significant bit in the
		// blue value of the current pixel is 0, add 1

		// if the character equals 0

		// and the least significant bit in the
		// blue value of the current pixel is 1, subtract 1

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1

		// and the second least significant bit in the
		// blue value of the current pixel is 0, add 2

		// if the character equals 0
		// and the second least significant bit in the
		// blue value of the current pixel is 1, subtract 2

		// returns the stegoed 3D array

		for (row = 0; row < MAXROWS; row++)
		{
			for (col =0; col < MAXROWS; col++)
			{
				if(binaryString[i] == null)
					return imagePixels;

				binaryValue = binaryString[i].charAt(0);  //Message Bit
				if(binaryValue=='1'){
					if(imagePixels[row][col][2]%2==0)
						imagePixels[row][col][2]=imagePixels[row][col][2]+1;
				}
				else{
					if(imagePixels[row][col][2]%2==1)
						imagePixels[row][col][2]=imagePixels[row][col][2]-1;
				} 
				i++;

				if(binaryString[i]==null)
					return imagePixels;

				binaryValue = binaryString[i].charAt(0);
				secondBit = imagePixels[row][col][2]&2;
				if(binaryValue=='1') {
					if(secondBit==0) {
						imagePixels[row][col][2]=imagePixels[row][col][2]+2;
					}
				}
				else {
					if(secondBit==2) {
						imagePixels[row][col][2]=imagePixels[row][col][2]-2;
					}
				}
				i++;
			}
			//return imagePixels;
		}

		return imagePixels;		
	}
	// Hides the binary bits in the 3 least significant bits of the blue color
	public int[][][] stegoTheImage3Bits(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString) {
		int i = 0;
		int row;
		int col;
		char binaryValue;
		int secondBit;
		int thirdBit;

		// loop through each row in the 3D array
		// loop through each column in the 3D array

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the least significant bit in the
		// blue value of the current pixel is 0, add 1

		// if the character equals 0
		// and the least significant bit in the
		// blue value of the current pixel is 1, subtract 1

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the second least significant bit in the
		// blue value of the current pixel is 0, add 2

		// if the character equals 0
		// and the second least significant bit in the
		// blue value of the current pixel is 1, subtract 2

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the third least significant bit in the
		// blue value of the current pixel is 0, add 4

		// if the character equals 0
		// and the third least significant bit in the
		// blue value of the current pixel is 1, subtract 4

		// returns the stegoed 3D array
		return imagePixels;
	}

	// Hides the binary bits in the 4 least significant bits of the blue color
	public int[][][] stegoTheImage4Bits(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString) {
		int i = 0;
		int row;
		int col;
		char binaryValue;
		int secondBit;
		int thirdBit;
		int fourthBit;

		// loop through each row in the 3D array
		// loop through each column in the 3D array

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the least significant bit in the
		// blue value of the current pixel is 0, add 1

		// if the character equals 0
		// and the least significant bit in the
		// blue value of the current pixel is 1, subtract 1

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the second least significant bit in the
		// blue value of the current pixel is 0, add 2

		// if the character equals 0
		// and the second least significant bit in the
		// blue value of the current pixel is 1, subtract 2

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the third least significant bit in the
		// blue value of the current pixel is 0, add 4

		// if the character equals 0
		// and the third least significant bit in the
		// blue value of the current pixel is 1, subtract 4

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1

		// and the fourth least significant bit in the
		// blue value of the current pixel is 0, add 8

		// if the character equals 0
		// and the fourth least significant bit in the
		// blue value of the current pixel is 1, subtract 8

		// returns the stegoed 3D array
		return imagePixels;
	}

	// Hides the binary bits in the least significant bit of alternating colors
	// going from red to green to blue and back to red skipping the alpha value
	public int[][][] stegoTheImageColorCycle(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString) {
		int colorPos = 0;
		int i = 0;
		int row;
		int col;
		char binaryValue;

		// loop through each row in the 3D array
		// loop through each column in the 3D array

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1
		// and the least significant bit in the
		// chosen colour value of the current pixel is 0, add 1

		// if the character equals 0
		// and the least significant bit in the
		// chosen colour value of the current pixel is 1, subtract 1

		// increments the color position from red to green to blue to red etc.
		// data is not hidden in the alpha value

		// returns the stegoed 3D array
		return imagePixels;
	}

	// Hides the binary bits in the least significant bit of the blue color
	// of pixels whose positions coincide with the positions stored in an
	// array of pseudo randomly generated pixel positions. The array position
	// initially comprises a single value which must be reduced to a pair of
	// row and column coordinates.
	public int[][][] stegoTheImage1BitPRNG(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString,
			int[] dataPositions) {
		int i = 0;
		int tempROWS = 0;
		int tempCOLS = 0;
		char binaryValue;
		int counter;

		// for each bit in the message to be hidden
		// Loops through the dataPositions array extracting a PRNGated value
		// coresponding to
		// the position of a pixel in the image. Iteratively subtract the width of the
		// image
		// (MAXCOLS) from the array value, incrementing the row value (tempROWS) as you
		// go,
		// until the array value (dataPositions[counter]) is less than the width of the
		// image
		// which gives you the column value (tempCOLS).
		// Subtract 1 from the final column value as the image starts from 0,0 but the
		// pixel
		// position values in the array start from 1

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string

		// if the character equals 1

		// and the least significant bit in the
		// blue value of the current pixel is 0, add 1

		// if the character equals 0
		// and the least significant bit in the
		// blue value of the current pixel is 1, subtract 1

		// returns the stegoed 3D array
		return imagePixels;
	}

	// step 1 Put one occurance of each pixel in an array called imageValuesTable
	public int[][][] stegoTheImageFridrich(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString,
			int[] dataPositions) {
		int[][] imageValuesTable = new int[8][256];
		int tempRed = 256;
		int tempGreen = 256;
		int tempBlue = 256;
		int coloursFound = 0;
		double tempDistance = 3000;
		double distance = 3000;
		char foundFlag = 'n';
		int tablePosition = 0;
		int tempParity = 2;
		int currentParity;
		int row;
		int col;
		int counter;
		char parity1Flag = 'N';
		char parity0Flag = 'N';
		int testParity;
		int tableRow;
		int i = 0;
		int tempROWS = 0;
		int tempCOLS = 0;

		// for the 2D array imageValuesTable set the first four positions in column 0 to
		// the RGB and
		// parity values of pixel 0, 0 in imagePixels
		// coloursFound equals the number of different colours found to date

		// cycle through every position in imagePixels
		// loop through each row in the 3D array imagePixels
		// loop through each column in the 3D array imagePixels

		// for each pixel in imagePixels check if its RGB value are already stored in
		// the imageValuesTable array
		// counting through the values in imageValuesTable
		// if the imagePixels pixels RGB value is in the imageValuesTable array the flag
		// is changed to y
		// if the imagePixels pixels RGB value is not in the imageValuesTable array
		// insert it and its parity value into the imageValuesTable array

		// step 2 check the image is suitable for stegoing
		// checks the parity of each of the colours in imageValuesTable
		// if every parity value is the same the image is not suitable for this method
		// both flags should be changed to Y

		// step 3 check the imageValuesTable to match each colour with the closest
		// colour by distance which has a different parity

		// for each position in the imageValuesTable

		tempRed = 256;
		tempGreen = 256;
		tempBlue = 256;
		tempDistance = 3000;
		distance = 3000;
		tempParity = 4321;
		currentParity = 54321;
		// check the current position (tablePosition) against every other position in
		// the table by cycling through the table (increment tableRow)
		// calculating the distance between the positions and storing the closest other
		// colour with a
		// different parity in a set of temorary variables
		// dont compare a colour with itself
		// if the colour at tableRow is a shorter distance from the colour at
		// tablePosition
		// then any of the previous tableRow colours
		// and if it has a different parity
		// store the tableRow colour in temp variables
		// after comparing every colour against the current colour (tablePosition) we
		// should have the closest colour with a different parity in temp variables
		// by now we have an array containing every unique colour paired with the
		// closest colour to each with a different parity

		// step 4 cycle through the image and the binaryString.
		// for each pixel whose parity equals the corresponding binary value leave it
		// alone
		// for each pixel whose parity does not equal the corresponing binary value
		// replace
		// it with the closest colour which has a different parity as found in the
		// imageValuesTable
		// the pixels and binaryValues under comparison are matched using a pseudo
		// random number generator

		// for each bit in the message to be hidden

		// Loops through the dataPositions array extracting a PRNGated value
		// coresponding to
		// the position of a pixel in the image. Iteratively subtract the width of the
		// image
		// (MAXCOLS) from the array value, incrementing the row value (tempROWS) as you
		// go,
		// until the array value (dataPositions[counter]) is less than the width of the
		// image
		// which gives you the column value (tempCOLS).
		// Subtract 1 from the final column value as the image starts from 0,0 but the
		// pixel
		// position values in the array start from 1

		// until all of the bits to be hidden have been hidden
		// returns the stegoed 3D array

		// extracts the characters from the array
		// representing the binary string
		// if the character equals 1
		// if the character equals 0
		return imagePixels;
	}

	public int[][][] stegoTheImageAdaptive(int[][][] imagePixels, int MAXROWS, int MAXCOLS, String[] binaryString,
			int[] dataPositions) {
		int[][] imageValuesTable = new int[8][256];
		int tempRed = 256;
		int tempGreen = 256;
		int tempBlue = 256;
		int coloursFound = 0;
		double tempDistance = 3000;
		double distance = 3000;
		char foundFlag = 'n';
		int tablePosition = 0;
		int tempParity = 2;
		int currentParity;
		int row;
		int col;
		int counter;
		char parity1Flag = 'N';
		char parity0Flag = 'N';
		int testParity;
		int tableRow;
		int i = 0;
		int tempROWS = 0;
		int tempCOLS = 0;

		// temporary variables for testing
		int borderunsuitability = 0;
		int embedstage1 = 0;
		int embedstage2 = 0;
		int embedstage2unsuitable = 0;
		int different = 0;
		int different2 = 0;
		int unsuitable = 0;
		int unsuitablestage1 = 0;

		return imagePixels;
	}
}