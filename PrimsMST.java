/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author HP
 */
class PrimsMST{
    static class Pair implements Comparable<Pair>{
        int source;
        int distance;
        public Pair(int source, int distance){
            this.source=source;
            this.distance=distance;
        }
        @Override
        public int compareTo(Pair that){
            return (this.distance-that.distance); 
        }
        
    }
    static class Edge{
        int dest;
        int wt;
        public Edge(int d,int w){
            this.dest=d;
            this.wt=w;
        }
//        @Override
        @Override
        public String toString(){
            return "("+dest+" "+wt+")";
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	       boolean vis[]=new boolean[V];
	       ArrayList<Edge> graph[]=new ArrayList[V];
	       for(int i=0;i<graph.length;i++)
                   graph[i]=new ArrayList<>();
//               System.out.println(edges.length);
	       for(int i=0;i<edges.length;i++){
                   int curr=edges[i][0];
                   int dest=edges[i][1];
                   int wt=edges[i][2];
                   System.out.println(curr+" "+dest+" "+wt);
	           graph[curr].add(new Edge(dest,wt));
                   graph[dest].add(new Edge(curr,wt));
//	           graph[edges[i][1]].add(new Edge(edges[i][0],edges[i][2]));
	       }
//0 1 3
//0 3 3
//0 5 10
//0 6 9
//0 4 6
//0 6 8
//0 5 6
                System.out.println(graph.length);
               for(int i=0;i<graph.length;i++){
                   System.out.println(graph[i]);
               }
	       PriorityQueue<Pair> pq=new PriorityQueue<>();
	       pq.add(new Pair(0,0));
               int cost=0;
	       while(!pq.isEmpty()){
	           Pair p=pq.remove();
	           int node=p.source;
                   System.out.println(node);
	           int distance=p.distance;
	           if(vis[node]==true)
	               continue;
	           vis[node]=true;
	           cost+=distance;
	           for(Edge e: graph[node]){
	               if(vis[e.dest]==false){
	                    pq.add(new Pair(e.dest,e.wt));
	               }
	           }
	       }
	       return cost;
	}
//        1 3 3
//1 5 10
//2 4 6
//2 6 9
//3 6 8
//4 5 6
        public static void main(String[]args){
            int[][]edges=new int[][]{
                {0,1 ,3},
                {1 ,3, 3},
                {1 ,5, 10},
                {2 ,6, 9},
                {2 ,4 ,6},
                {3, 6, 8},
                {4, 5, 6}
            };
            System.out.println(spanningTree(7,7,edges));
        }
}

