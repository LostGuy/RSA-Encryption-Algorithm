import java.math.BigInteger;
import java.util.Random;
import java.io.*;


public class Main
{
	public static void main (String[] args) throws IOException 
	{
		//Create new RSA object
		RSA rsa = new RSA();
		
		//Take input
		DataInputStream in = new DataInputStream(System.in);
		
		//String to hold input
		String input ;
		
		//Prompt user
		System.out.println("Enter the plain text:");
		
		//Get the input
		input = in.readLine();
		
		System.out.println("Encrypting String: " + input);
		System.out.println("String in Bytes: " + bytesToString(input.getBytes()));
		
		//Encrypt the message
		byte[] encrypted = rsa.encrypt(input.getBytes());
		System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted));
		
		//Decrypt the message
		byte[] decrypted = rsa.decrypt(encrypted);
		
		System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted));
		System.out.println("Decrypted String: " + new String(decrypted));
	}
	
	//Convert the bytes to a string
	private static String bytesToString(byte[] encrypted) 
	{
		String test = "";
		for (byte b : encrypted) {
			test += Byte.toString(b);
		}
		return test;
	}
}
