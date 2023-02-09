/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class bellmanFord {
    public static int[] bellmanFordShortestPath(int V,ArrayList<ArrayList<Integer>> edges,int S){
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
            if(i!=S)
                dist[i]=(int)1e8;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> e:edges){
                int src=e.get(0);
                int dest=e.get(1);
                int cost=e.get(2);
                
                if(dist[src]!=1e8 && dist[src]+cost<dist[dest]){
                    dist[dest]=dist[src]+cost;
                }
            }
        }
        for(ArrayList<Integer> e:edges){
            int src=e.get(0);
            int dest=e.get(1);
            int cost=e.get(2);
            
            
            if(dist[src]!=1e8 && dist[src]+cost<dist[dest]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[]args){
        ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
        bellmanFordShortestPath(5,edges,0);
        //[[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
        ArrayList<Integer>al=new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(5);
        edges.add(al);
        al.removeAll(al);
        al.add(1);
        al.add(0);
        al.add(3);
        edges.add(al);
        al.removeAll(al);
        al.add(1);
        al.add(2);
        al.add(-1);
        edges.add(al);
        al.removeAll(al);
        al.add(2);
        al.add(0);
        al.add(1);
        edges.add(al);
        int dist[]=bellmanFordShortestPath(3,edges,2);
        
        for(int i:dist)
               System.out.print(i+"  ");
        
        
//        System.out.print(1e8);
    }
}
