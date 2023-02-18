/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author HP
 */
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class Pair implements Comparable<Pair>{
        int N;
        int cost;
        public Pair(int N,int cost){
            this.N=N;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair that){
            return this.cost-that.cost;
        }
        
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dist[]=new int[V];
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(i!=S){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            Pair node=pq.remove();
            ArrayList<ArrayList<Integer>> info=adj.get(node.N);
            for(ArrayList<Integer> i:info){
                    int neighbour=i.get(0);
                    int cost=i.get(1);
                        if(dist[node.N]+cost<dist[neighbour]){
                            dist[neighbour]=dist[node.N]+cost;
                            pq.add(new Pair(neighbour,dist[neighbour]));
                        }
            }
        }
    return dist;
    }
}


public class DijsktraShortestPath {
    
}
