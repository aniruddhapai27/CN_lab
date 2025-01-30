import java.util.Random;
import java.util.Scanner;

public class Lab9RED {
        static final int QUEUE_SIZE = 50;
        static final int MAX_THRS = 40;
        static final int MIN_THRS = 10;
        static final double MAX_PROB = 0.2;

        public static double calcDropProb(int avgQSize) {
                if(avgQSize <= MIN_THRS) {
                        return 0.0;
                }
                else if(avgQSize >= MAX_THRS) {
                        return 1.0;
                }
                else {
                        return MAX_PROB * ((avgQSize - MIN_THRS) / (MAX_THRS - MIN_THRS));
                }
        }

        public static void RED(int[] incoming) {
                int qSize = 0;
                Random random = new Random();
                for(int packet: incoming) {
                        int avgQSize = (qSize + packet) / 2;
                        double dropProb = calcDropProb(avgQSize);
                        System.out.println("Packet Size: " + packet);
                        System.out.println("Average queue size: " + avgQSize);
                        System.out.println("Drop probability: " + dropProb);
                        System.out.println();
                        if(dropProb > random.nextDouble()) {
                                System.out.println("Packet dropped due to RED");
                        }
                        else {
                                qSize += packet;
                                System.out.println("Packet added to the queue");
                        }
                }
        }
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter number of packets: ");
                // int n = sc.nextInt();
                // int[] incoming = new int[n];
                // for(int i = 0; i < n; i++) {
                //         System.out.println("Enter packet " + (i + 1) + " size: ");
                //         incoming[i] = sc.nextInt();
                // }
                int[] incoming = {5, 15, 10, 20 , 30, 10, 5, 40, 25};
                RED(incoming);
        }
}