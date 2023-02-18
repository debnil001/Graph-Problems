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
// } Driver Code Ends

class Bipartite
{
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int[]col,int node){
        for(Integer i:adj.get(node)){
            if(col[i]==-1){
                col[i]=(col[node]==1)?2:1;
                if(dfs(adj,col,i)==false)
                    return false;
            }
            else{
                if(col[i]==col[node])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<V;i++)
            color[i]=-1;
        for(int i=0;i<color.length ;i++){
            if(color[i]==-1){
                color[i]=1;
                if(dfs(adj,color,i)==false)
                    return  false;
                // System.out.println(color[i]);
            }
        }
        return true;
    }
}
public class bipartiteGraph {
    
}
