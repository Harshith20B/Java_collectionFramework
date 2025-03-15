package dataStruct3;
import java.util.*;
public class djikstra {
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
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    static void dijkstraImp(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        dist[src]=0;
        boolean[] vis = new boolean[V];
        for(int i=1;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u]+e.wt<dist[v]){
                        dist[v]=dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]){
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstraImp(graph, 0, V);
    }
}
