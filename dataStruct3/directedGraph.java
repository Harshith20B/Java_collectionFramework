package dataStruct3;
import java.util.*;
public class directedGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }
    static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String args[]){
        int V=4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        createGraph(graph);
        for(int i=0;i<vis.length;i++){
            if(isCycleDirected(graph, vis, i, rec)){
                System.out.print("cycle detected");
                break;
            }
        }
    }
}
