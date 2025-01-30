import java.math.BigInteger;
import java.util.*;

class RSAalgorithm {
        BigInteger pubKey, priKey, mod;

        void getKeys(int bitLen) {
                Random r = new Random();
                BigInteger p = BigInteger.probablePrime(bitLen, r);
                BigInteger q = BigInteger.probablePrime(bitLen, r);

                mod = p.multiply(q); // n = p*q

                BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
                pubKey = BigInteger.probablePrime(bitLen/2, r);

                while(!phi.gcd(pubKey).equals(BigInteger.ONE) || pubKey.compareTo(phi) >= 0) {
                    pubKey = BigInteger.probablePrime(bitLen/2, r);
                }

                priKey = pubKey.modInverse(phi);
        }

        BigInteger encrypt(BigInteger m) {
            return m.modPow(pubKey, mod);  // c = m^e mod n
        }

        BigInteger decrypt(BigInteger c) {
            return c.modPow(priKey, mod); // m = c^d mod n
        }
}

public class Lab7RSA {
        public static void main(String[] args) {
                RSAalgorithm rsa = new RSAalgorithm();
                rsa.getKeys(512);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the message to be encrypted: ");
                BigInteger m = new BigInteger(sc.nextLine().getBytes());
                BigInteger c = rsa.encrypt(m);
                System.out.println("Encrypted message: " + c);
                BigInteger d = rsa.decrypt(c);
                System.out.println("Decrypted message: " + new String(d.toByteArray()));
        }
}