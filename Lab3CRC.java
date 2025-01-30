import java.util.Scanner;

public class Lab3CRC {
    public static String calcCRC(String data, String poly, boolean redundantbits) {
        StringBuilder sb = new StringBuilder(data); 
        
        // Append redundant bits (zero padding)
        if (redundantbits) {
            for (int i = 0; i < poly.length() - 1; i++) {
                sb.append("0");
            }
        }

        // Perform binary division (XOR process)
        for (int i = 0; i < sb.length() - (poly.length() - 1); i++) {
            if (sb.charAt(i) == '1') { // Only perform XOR when the leading bit is 1
                for (int j = 0; j < poly.length(); j++) {
                    sb.setCharAt(i + j, (sb.charAt(i + j) == poly.charAt(j)) ? '0' : '1');
                }
            }
        }

        // Extract the remainder (last poly.length - 1 bits)
        return sb.substring(sb.length() - (poly.length() - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data from user
        System.out.println("Enter the data to be sent in bits: ");
        String data = sc.next();

        System.out.println("Enter the generator polynomial in bits: "); 
        String poly = sc.next();

        // Encode the data
        String encoded = data + calcCRC(data, poly, true);
        System.out.println("The encoded data is: " + encoded);
        
        // Simulate reception
        System.out.println("Enter the data that is received in bits: ");
        String received = sc.next();

        // Check for errors
        String recString = calcCRC(received, poly, false);
        if (Integer.parseInt(recString, 2) == 0) {
            System.out.println("The received data is correct");
        } else {
            System.out.println("The received data is incorrect");
        }
        
        sc.close();
    }
}
