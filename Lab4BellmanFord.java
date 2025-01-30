import java.util.Arrays;
import java.util.Scanner;

public class Lab4BellmanFord {

    public static void bellmanFord(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i=0; i<n-1; i++) {
            for(int u=0; u<n; u++) {
                for(int v=0; v<n; v++) {
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        for(int u=0; u<n; u++) {
            for(int v=0; v<n; v++) {
                if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][v]<dist[v]) {
                    System.out.println("Graph contains negative edges");
                    return;
                }
            }
        }
        
        System.out.println("\nVertex\t\tDistance from source\n");
        for(int i=0; i<n; i++) {
            System.out.println((i+1) + "\t\t" + (dist[i]!=Integer.MAX_VALUE?dist[i]:"INF"));
        }   

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex: (1-based index) ");
        int source = sc.nextInt();

        bellmanFord(graph, source-1);

    }

}
