
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class UnStegoedGifImage {
	private int[][][] unStegoImage;
	private final int MAXROWS;
	private final int MAXCOLS;
	private String hiddenMessage = "";
	private MessageBox stegoMessage;

	public UnStegoedGifImage(String gifFileName, int flag)
	// public static String unStegoBits(String gifFileName, int flag)
	{
		// Loads the stegoed image into a 3D array called unStegoImage
		unStegoImage = ImageDeconstructor.loadImage(gifFileName);

		// Gets the height and width of the stegoed image in pixels, i.e. rows and
		// columns
		MAXROWS = unStegoImage.length; // height
		MAXCOLS = unStegoImage[0].length; // width or length of the first row

		if (flag == 1) {
			// calls method unStegoTheImage1Bit passing it the stegoed image and returning
			// the hidden message
			hiddenMessage = unStegoTheImage1Bit(unStegoImage, MAXROWS, MAXCOLS);
		} else if (flag == 2) {
			// calls method unStegoTheImage2Bits passing it the stegoed image and returning
			// the hidden message
			hiddenMessage = unStegoTheImage2Bits(unStegoImage, MAXROWS, MAXCOLS);
		} else if (flag == 3) {
			// calls method unStegoTheImage3Bits passing it the stegoed image and returning
			// the hidden message
			hiddenMessage = unStegoTheImage3Bits(unStegoImage, MAXROWS, MAXCOLS);
		} else if (flag == 4) {
			// calls method unStegoTheImage4Bits passing it the stegoed image and returning
			// the hidden message
			hiddenMessage = unStegoTheImage4Bits(unStegoImage, MAXROWS, MAXCOLS);
		} else if (flag == 5) {
			// calls method unStegoTheImageColorCycle passing it the stegoed image and
			// returning the hidden message
			hiddenMessage = unStegoTheImageColorCycle(unStegoImage, MAXROWS, MAXCOLS);
		} else if (flag == 6) {
			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[MAXROWS * MAXCOLS];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG(MAXROWS * MAXCOLS);

			// calls method unStegoTheImage1BitPRNG passing it the stegoed image and
			// returning the hidden message
			hiddenMessage = unStegoTheImage1BitPRNG(unStegoImage, MAXROWS, MAXCOLS, dataPositions);
		}

		else if (flag == 7) {
			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[MAXROWS * MAXCOLS];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG(MAXROWS * MAXCOLS);

			// calls method unStegoTheImageAdaptive passing it the stegoed image and
			// returning the hidden message
			hiddenMessage = unStegoTheImageFridrich(unStegoImage, MAXROWS, MAXCOLS, dataPositions);
		} else if (flag == 8) {
			// creates a one dimensional array representing the number of positions or
			// pixels in the image
			int[] dataPositions = new int[(MAXROWS * MAXCOLS) / 9];

			// calls the Pseudo random number generator to return an array containing the
			// positions in the image in pseudo random order
			dataPositions = PRNGenerator.PRNG((MAXROWS * MAXCOLS) / 9);

			// calls method unStegoTheImageAdaptive passing it the stegoed image and
			// returning the hidden message
			hiddenMessage = unStegoTheImageAdaptive(unStegoImage, MAXROWS, MAXCOLS, dataPositions);
		}

		// display hiddenMessage;
		if (hiddenMessage.length() == 0) {
			JOptionPane.showMessageDialog(null,
					"No message was found in the chosen image.\nPlease check that you have chosen a stegoed image and the correct unStego method.",
					"Message", JOptionPane.PLAIN_MESSAGE);
		} else {
			MessageBox stegoMessage = new MessageBox(hiddenMessage);
		}
	}

	public static String unStegoTheImage1Bit(int[][][] unStegoImage, int MAXROWS, int MAXCOLS) {
		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int row;
		int col;

		// Takes in the 3D array representing the stegoed image. It then loops through
		// the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		// loop through the rows

		// loop through the columns

		// extract the last bit of the blue value and append the
		// bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		for (row = 0; row < MAXROWS; row++) {
			for (col = 0; col < MAXCOLS; col++) {
				if (unStegoImage[row][col][2] % 2 == 0)
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "0";
				else
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "1";
			}
			extractedBinaryMessage = extractedBinaryMessage + lineOfExtractedBinaryMessage;
			lineOfExtractedBinaryMessage = "";
		}
		extractedMessage = CharacterBinaryConverter.convertBinaryToMessage(extractedBinaryMessage);
		return extractedMessage;
	}

	public static String unStegoTheImage2Bits(int[][][] unStegoImage, int MAXROWS, int MAXCOLS) {
		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int row;
		int col;
		int secondBit;

		// takes in the 3D array representing the stegoed image
		// it then loops through the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the second last bit of the blue value in each pixel using
		// the bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		// loop through the rows
		// loop through the columns

		// extract the last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the second last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		for (row = 0; row < MAXROWS; row++) {
			for (col = 0; col < MAXCOLS; col++) {
				if (unStegoImage[row][col][2] % 2 == 0)
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "0";
				else
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "1";

				secondBit = unStegoImage[row][col][2] & 2;

				if (secondBit == 0)
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "0";
				else
					lineOfExtractedBinaryMessage = lineOfExtractedBinaryMessage + "1";
			}
			extractedBinaryMessage = extractedBinaryMessage + lineOfExtractedBinaryMessage;
			lineOfExtractedBinaryMessage = "";
		}
		extractedMessage = CharacterBinaryConverter.convertBinaryToMessage(extractedBinaryMessage);
		return extractedMessage;
	}

	public static String unStegoTheImage3Bits(int[][][] unStegoImage, int MAXROWS, int MAXCOLS) {
		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int row;
		int col;
		int secondBit;
		int thirdBit;

		// takes in the 3D array representing the stegoed image
		// it then loops through the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the second last bit of the blue value in each pixel using
		// the bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the third last bit of the blue value in each pixel using the
		// bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		// loop through the rows
		// loop through the columns

		// extract the last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the second last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the third last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		return extractedMessage;
	}

	public static String unStegoTheImage4Bits(int[][][] unStegoImage, int MAXROWS, int MAXCOLS) {
		// takes in the 3D array representing the stegoed image
		// it then loops through the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the second last bit of the blue value in each pixel using
		// the bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the third last bit of the blue value in each pixel using the
		// bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage
		// it then extracts the fourth last bit of the blue value in each pixel using
		// the bitwise and function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int row;
		int col;
		int secondBit;
		int thirdBit;
		int fourthBit;

		// loop through the rows
		// loop through the columns

		// extract the last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the second last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the third last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// extract the fourth last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		return extractedMessage;
	}

	public static String unStegoTheImageColorCycle(int[][][] unStegoImage, int MAXROWS, int MAXCOLS) {
		// takes in the 3D array representing the stegoed image
		// it then loops through the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int row;
		int col;
		int colorPos = 0;

		// loop through the rows
		// loop through the columns

		// extract the last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		return extractedMessage;
	}

	public static String unStegoTheImage1BitPRNG(int[][][] unStegoImage, int MAXROWS, int MAXCOLS,
			int[] dataPositions) {
		// takes in the 3D array representing the stegoed image
		// it then loops through the image
		// extracting the last bit of the blue value in each pixel using a modula
		// function
		// it appends that bit to a string representing the bits called
		// extractedBinaryMessage

		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int counter;
		int tempROWS = 0;
		int tempCOLS = 0;
		int tempSize = (MAXROWS * MAXCOLS);

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

		// extract the last bit of the blue value
		// append the bit to a string represnting the bits for that column

		// add the string representing the bits in the column to the overall string
		// representing the bits
		// this process of reading a row at a time improves performance significantly

		// calls a method to convert the string representing the binary least
		// significant bits of the blue values
		// to a text message

		return extractedMessage;
	}

	public static String unStegoTheImageFridrich(int[][][] unStegoImage, int MAXROWS, int MAXCOLS,
			int[] dataPositions) {
		// Locate the tempROW and tempCOL values from the dataPositions array ( the
		// random position as before)
		// Measure the parity of the pixel value. Add the parity bit to the array of
		// message bits.
		// Convert it to a message as before

		int count = 0;
		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int tempROWS = 0;
		int tempCOLS = 0;
		int tempSize;
		int counter;

		return extractedMessage;
	}

	public static String unStegoTheImageAdaptive(int[][][] unStegoImage, int MAXROWS, int MAXCOLS,
			int[] dataPositions) {
		int count = 0;
		String extractedBinaryMessage = "";
		String lineOfExtractedBinaryMessage = "";
		String extractedMessage = "";
		int tempROWS = 0;
		int tempCOLS = 0;
		int tempSize;
		int counter;
		int unsuitable = 0;
		int borderunsuitability = 0;
		int unsuitablestage1 = 0;
		int embedstage1 = 0;
		int different = 0;

		return extractedMessage;
	} // method
} // class