import java.util.Scanner;

public class Lab8TokenBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bucket capacity (number of tokens): ");
        int bucketCapacity = scanner.nextInt();
        System.out.print("Enter token generation rate (tokens per second): ");
        int tokenRate = scanner.nextInt();

        System.out.print("Enter the number of packets: ");
        int numPackets = scanner.nextInt();
        int[] packetSizes = new int[numPackets];
        System.out.println("Enter the packet sizes: ");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = scanner.nextInt();
        }

        int tokens = 0;
        int sent = 0;

        System.out.println("\nPacket Size\tTokens Available\tSent\tRemaining Tokens\tStatus\n");
        for(int packetSize: packetSizes) {
            tokens = Math.min(tokens + tokenRate, bucketCapacity);

            if(packetSize <= tokens) {
                tokens -= packetSize;
                sent = packetSize;
                System.out.println(packetSize + "\t\t" + (tokens+packetSize) + "\t\t" + sent + "\t\t" + tokens + "\t\tAccepted");
            }
            else {
                sent = 0;
            System.out.println(packetSize + "\t\t" + tokens + "\t\t" + sent + "\t\t" + tokens + "\t\tDropped");
            }        
        }

    }
    
}
