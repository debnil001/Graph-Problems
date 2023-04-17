/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author HP
 */
public class ShortestPathInDAG {
    class Solution {
    class Edge{
        int source;
        int dest;
        int cost;
        public Edge(int s,int d,int c){
            this.source=s;
            this.dest=d;
            this.cost=c;
        }
    }
    public void dfs(ArrayList<Edge> []graph,int node,boolean[]vis,Stack<Integer> st){
        vis[node]=true;
        for(Edge e: graph[node]){
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis,st);
            }
        }
        
        st.push(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<Edge> []graph=new ArrayList[N];
		for(int i=0;i<N;i++){
		    graph[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++){
		    int source=edges[i][0];
		    int dest=edges[i][1];
		    int cost=edges[i][2];
		    graph[source].add(new Edge(source,dest,cost));
		}
		
		Stack<Integer> st=new Stack<>();
		boolean vis[]=new boolean[N];
		
		for(int i=0;i<N;i++){
		    if(!vis[i]){
		        dfs(graph,i,vis,st);
		    }
		}
		int dist[]=new int[N];
		Arrays.fill(dist,(int)1e9);
		dist[0]=0;
		while(!st.isEmpty()){
		    int node=st.pop();
		    for(Edge e: graph[node]){
		        int dest=e.dest;
		        int cost=e.cost;
		        if(dist[node]+cost<dist[dest]){
		            dist[dest]=dist[node]+cost;
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(dist[i]==(int)1e9)
		        dist[i]=-1;
		}
		return dist;
	}
}
}
