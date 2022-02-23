/*
 * import java.io.*; import java.awt.*; import java.awt.image.*; import
 * java.awt.event.*; import java.applet.*; import javax.swing.*; import
 * javax.swing.filechooser.FileFilter;
 * 
 * public class StegoImages { public static void main(String[] args) {
 * DisplayButtonsBox app = new DisplayButtonsBox();
 * 
 * app.addWindowListener(new WindowAdapter() { public void
 * windowClosing(WindowEvent e) { System.exit(0); } }); }
 * 
 * public static void knapSack(String textFileName, String saveFileName) { int
 * maxStringSize = 8000; String[] message; String[] binaryString; int[]
 * knappedNumbers = new int[11000];
 * 
 * message = new String[maxStringSize - 1]; // message is a string array of size
 * maxStringSize
 * 
 * // calls the method to read in the message to be encrypted from a file
 * message = MessageIO.readMessage(maxStringSize, textFileName);
 * 
 * // creates binaryString which will hold the binary representation of the
 * message // to be encrypted binaryString = new String[maxStringSize * 8];
 * 
 * // calls a method to convert the message to its binary representation
 * binaryString = CharacterBinaryConversion.convertMessageToBinary(message,
 * maxStringSize);
 * 
 * // calls a method to encrypt the message using knapSack knappedNumbers =
 * EncryptKnapSack.encryptKnapSack(binaryString);
 * 
 * // calls a method to save the encrypted message in a text file called //
 * saveFileName MessageIO.writeMessage(knappedNumbers, saveFileName); }
 * 
 * // Method opens encrypted text file, deencrypts the text and returns it to
 * the // calling method public static String knapSackDecrypt(String
 * textFileName) { int maxStringSize = 44000; String[] encryptedMessage; String
 * decryptedMessage;
 * 
 * encryptedMessage = new String[maxStringSize - 1]; // message is a string
 * array of size maxStringSize
 * 
 * // calls the method to read in the encrypted message to be decrypted from a
 * file encryptedMessage = MessageIO.readMessage(maxStringSize, textFileName);
 * 
 * decryptedMessage = EncryptKnapSack.decryptKnapSack(encryptedMessage,
 * maxStringSize);
 * 
 * return decryptedMessage; }
 * 
 * //////////////////////////////
 * 
 * public static void watermarkBits(String gifFileName, String
 * watermarkFileName, String gifFileStoreName) { int[][][] imagePixels; final
 * int MAXROWS; final int MAXCOLS; int[][][] watermarkedImage;
 * 
 * // Loads the image to be stegoed into a 3D array called originalImage
 * imagePixels = LoadImage.loadImage(gifFileName);
 * 
 * // Gets the height and width of the image in pixels, i.e. rows and columns
 * MAXROWS = imagePixels.length; // height?? MAXCOLS = imagePixels[0].length; //
 * width or length of the first row??
 * 
 * // calls a method to hide the watermark bits in the least significant bit of
 * the // blue color watermarkedImage =
 * WatermarkGifImage.WatermarkGifImage(gifFileName, watermarkFileName,
 * gifFileStoreName); // calls a method to save the watermarked image sending
 * the method the 3D array, // the height and width SaveImage i = new
 * SaveImage(watermarkedImage, MAXROWS, MAXCOLS, gifFileStoreName); // creates a
 * SaveImage // object, }
 * 
 * public static String unWatermarkBits(String gifFileName, String
 * gifFileStoreName) { int[][][] unWatermarkImage; int[][][] watermarkImage;
 * final int MAXROWS; final int MAXCOLS;
 * 
 * // Loads the stegoed image into a 3D array called unWatermarkImage
 * unWatermarkImage = LoadImage.loadImage(gifFileName);
 * 
 * // Gets the height and width of the stegoed image in pixels, i.e. rows and //
 * columns MAXROWS = unStegoImage.length; // height MAXCOLS =
 * unStegoImage[0].length; // width or length of the first row
 * 
 * watermarkImage = UnWatermarkGifImage.unWatermarkGifImage(gifFileName);
 * 
 * SaveImage i = new SaveImage(watermarkImage, MAXROWS, MAXCOLS,
 * gifFileStoreName); }
 * 
 * //////////////////////////////
 * 
 * public static void stegoBits(String gifFileName, String textFileName, String
 * gifFileStoreName, int flag) { int[][][] imagePixels; final int MAXROWS; final
 * int MAXCOLS; int maxStringSize = 0; int[][][] stegoedImage; String[] message;
 * String[] binaryString;
 * 
 * // Loads the image to be stegoed into a 3D array called originalImage
 * imagePixels = LoadImage.loadImage(gifFileName);
 * 
 * // Gets the height and width of the image in pixels, i.e. rows and columns
 * MAXROWS = imagePixels.length; // height?? MAXCOLS = imagePixels[0].length; //
 * width or length of the first row??
 * 
 * // maxStringSize creates an integer equal to the max string size the image
 * can // hold // i.e. the number of pixels in the image divided by 8 for the
 * bits in a // character if (flag == 2) { // i.e. the number of pixels in the
 * image divided by 4 for the bits in a // character maxStringSize = ((MAXROWS *
 * MAXCOLS) / 4); } else if (flag == 3) { // i.e. the number of pixels in the
 * image divided by 8 and multiplied by 3 for // the bits in a character
 * maxStringSize = (((MAXROWS * MAXCOLS) / 8) * 3); } else if (flag == 4) { //
 * i.e. the number of pixels in the image divided by 2 for the bits in a //
 * character maxStringSize = ((MAXROWS * MAXCOLS) / 2); } else { // i.e. the
 * number of pixels in the image divided by 8 for the bits in a // character
 * maxStringSize = ((MAXROWS * MAXCOLS) / 8); }
 * 
 * message = new String[maxStringSize - 1]; // message is a string array of size
 * maxStringSize
 * 
 * // calls the method to read in the message to be stegoed from a file message
 * = MessageIO.readMessage(maxStringSize, textFileName);
 * 
 * // creates binaryString which will hold the binary representation of the
 * message // to be stegoed binaryString = new String[MAXROWS * MAXCOLS];
 * 
 * // calls a method to convert the message to its binary representation
 * binaryString = CharacterBinaryConversion.convertMessageToBinary(message,
 * maxStringSize);
 * 
 * if (flag == 1) { // calls a method to hide the binary bits in the least
 * significant bit of the // blue color stegoedImage =
 * StegoGifImage.stegoTheImage1Bit(imagePixels, MAXROWS, MAXCOLS, binaryString);
 * } else if (flag == 2) { // Calls a method to hide the binary bits in the
 * least significant bit of the // blue color stegoedImage =
 * StegoGifImage.stegoTheImage2Bits(imagePixels, MAXROWS, MAXCOLS,
 * binaryString); } else if (flag == 3) { // Calls a method to hide the binary
 * bits in the least significant bit of the // blue color stegoedImage =
 * StegoGifImage.stegoTheImage3Bits(imagePixels, MAXROWS, MAXCOLS,
 * binaryString); } else if (flag == 4) { // Calls a method to hide the binary
 * bits in the least significant bit of the // blue color stegoedImage =
 * StegoGifImage.stegoTheImage4Bits(imagePixels, MAXROWS, MAXCOLS,
 * binaryString); } else if (flag == 5) { // calls a method to hide the binary
 * bits in the least significant bit of the // blue color stegoedImage =
 * StegoGifImage.stegoTheImageColorCycle(imagePixels, MAXROWS, MAXCOLS,
 * binaryString); } else if (flag == 6) { // creates a one dimensional array
 * representing the number of positions or // pixels in the image int[]
 * dataPositions = new int[MAXROWS * MAXCOLS];
 * 
 * // calls the Pseudo random number generator to return an array containing the
 * // positions in the image in pseudo random order dataPositions =
 * PseudoRandomNumGen.PRNG(MAXROWS * MAXCOLS);
 * 
 * // calls a method to hide the binary bits in the least significant bit of the
 * // blue color stegoedImage = StegoGifImage.stegoTheImage1BitPRNG(imagePixels,
 * MAXROWS, MAXCOLS, binaryString, dataPositions); } else { // creates a one
 * dimensional array representing the number of positions or // pixels in the
 * image int[] dataPositions = new int[MAXROWS * MAXCOLS];
 * 
 * // calls the Pseudo random number generator to return an array containing the
 * // positions in the image in pseudo random order dataPositions =
 * PseudoRandomNumGen.PRNG(MAXROWS * MAXCOLS);
 * 
 * // calls a method to hide the binary bits using the Fridrich method
 * stegoedImage = StegoGifImage.stegoTheImageFridrich(imagePixels, MAXROWS,
 * MAXCOLS, binaryString, dataPositions); }
 * 
 * // calls a method to save the stegoed image sending the method the 3D array,
 * the // height and width SaveImage i = new SaveImage(stegoedImage, MAXROWS,
 * MAXCOLS, gifFileStoreName); // creates a SaveImage object, }
 * 
 * public static String unStegoBits(String gifFileName, int flag) { int[][][]
 * unStegoImage; final int MAXROWS3; final int MAXCOLS3; String hiddenMessage =
 * "";
 * 
 * // Loads the stegoed image into a 3D array called unStegoImage unStegoImage =
 * LoadImage.loadImage(gifFileName);
 * 
 * // Gets the height and width of the stegoed image in pixels, i.e. rows and //
 * columns MAXROWS3 = unStegoImage.length; // height MAXCOLS3 =
 * unStegoImage[0].length; // width or length of the first row
 * 
 * if (flag == 1) { // calls method unStegoTheImage1Bit passing it the stegoed
 * image and returning // the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImage1Bit(unStegoImage, MAXROWS3, MAXCOLS3); } else
 * if (flag == 2) { // calls method unStegoTheImage2Bits passing it the stegoed
 * image and returning // the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImage2Bits(unStegoImage, MAXROWS3, MAXCOLS3); }
 * else if (flag == 3) { // calls method unStegoTheImage3Bits passing it the
 * stegoed image and returning // the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImage3Bits(unStegoImage, MAXROWS3, MAXCOLS3); }
 * else if (flag == 4) { // calls method unStegoTheImage4Bits passing it the
 * stegoed image and returning // the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImage4Bits(unStegoImage, MAXROWS3, MAXCOLS3); }
 * else if (flag == 5) { // calls method unStegoTheImageColorCycle passing it
 * the stegoed image and // returning the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImageColorCycle(unStegoImage, MAXROWS3, MAXCOLS3);
 * } else if (flag == 6) { // creates a one dimensional array representing the
 * number of positions or // pixels in the image int[] dataPositions = new
 * int[MAXROWS3 * MAXCOLS3];
 * 
 * // calls the Pseudo random number generator to return an array containing the
 * // positions in the image in pseudo random order dataPositions =
 * PseudoRandomNumGen.PRNG(MAXROWS3 * MAXCOLS3);
 * 
 * // calls method unStegoTheImage1BitPRNG passing it the stegoed image and //
 * returning the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImage1BitPRNG(unStegoImage, MAXROWS3, MAXCOLS3,
 * dataPositions); } else { // creates a one dimensional array representing the
 * number of positions or // pixels in the image int[] dataPositions = new
 * int[MAXROWS3 * MAXCOLS3];
 * 
 * // calls the Pseudo random number generator to return an array containing the
 * // positions in the image in pseudo random order dataPositions =
 * PseudoRandomNumGen.PRNG(MAXROWS3 * MAXCOLS3);
 * 
 * // calls method unStegoTheImageFridrich passing it the stegoed image and //
 * returning the hidden message hiddenMessage =
 * UnStegoGifImage.unStegoTheImageFridrich(unStegoImage, MAXROWS3, MAXCOLS3,
 * dataPositions); }
 * 
 * return hiddenMessage; } }
 */