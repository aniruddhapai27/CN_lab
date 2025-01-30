import java.util.*;



public class Lab2Sort {
    public static class Frame {
        int sequence;
        int data;
        
        Frame(int sequence, int data) {
            this.sequence = sequence;
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of frames: ");
        int n = sc.nextInt();
        Frame[] frames = new Frame[n];
        for(int i=0; i<n; i++) {
            Random random = new Random();
            int seq = random.nextInt(1000) + 1;
            System.out.print("Enter data of " + (i+1) + "th frame: ");
            int data = sc.nextInt();
            frames[i] = new Frame(seq, data);
        }   

        System.out.println("Before sorting: ");
        for(Frame frame: frames) {
            System.out.println(frame.sequence + " " + frame.data);
        }
        System.out.println();
        
        // for(int i=0; i<n-1; i++) {
        //     for(int j=0; j<n-i-1; j++) {
        //         if(frames[j].sequence > frames[j+1].sequence) {
        //             Frame temp  = frames[j];
        //             frames[j] = frames[j+1];
        //             frames[j+1] = temp;
        //         }
        //     }
        // }

        Arrays.sort(frames, (a, b) -> a.sequence - b.sequence);
        
        System.out.println("After sorting: ");
        for(Frame frame: frames) {
            System.out.println(frame.sequence + "  " + frame.data);
        }
    }
}