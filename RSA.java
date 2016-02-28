import java.math.BigInteger;
import java.util.Random;


/**
 * This Class sets the values that are needed to use the RSA Encryption algorithm.
 * It also contains the methods needed to encrypt and decrypt a message
 * @author Jesse.West
 *
 */
public class RSA 
{
	//Choose 2 large primes
	private BigInteger p;
	private BigInteger q;
	
	//Used to compute n = p*q
	private BigInteger N;
	
	//Used to compute z = (p-1)*(q-1)
	private BigInteger phi;
	
	//Used to compute e = e*d == 1 % z
	private BigInteger e;
	
	//Prime to z
	private BigInteger d;
	
	//Bit length
	private int bitlength = 1024;
	
	//Block size in bytes
	private int blocksize = 256;

	//Random generator
	private Random r;
	
	//Default constructor
	public RSA() 
	{
		//Get a random number
		r = new Random();
		
		//Set the values
		p = BigInteger.probablePrime(bitlength, r);
		q = BigInteger.probablePrime(bitlength, r);
		N = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(bitlength/2, r);
		while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(phi);
	}
	
	//Encrypt message
	public byte[] encrypt(byte[] message)
	{
		return (new BigInteger(message)).modPow(e, N).toByteArray();
	}
	
	//Decrypt message
	public byte[] decrypt(byte[] message) 
	{
		return (new BigInteger(message)).modPow(d, N).toByteArray();
	}
}