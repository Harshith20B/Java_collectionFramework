package dataStruct3;
import java.util.*;
//shortest distance from source to all vertices unlike djikstra works for -ve edges, but more time complexity then djikstra
//dynamic programming
// time complexity - O(VE)
// does not work for -ve weight cycles
public class bellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }
    static void bellman(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int k=0;k<V-1;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    // in java adding a small number to max value makes it negative which will always be less than dist[v]
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
                        dist[v] = dist[u]+e.wt;
                    }
                }
            }
        }
        // to detect -ve weight cycle
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                // in java adding a small number to max value makes it negative which will always be less than dist[v]
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
                    System.out.println("negative weight cycle");
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println("Distance from "+src+" to "+i+" is "+dist[i]);
        }
    }
    public static void main(String args[]){
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellman(graph, 0, V);
    }
}
