/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author HP
 *///{ Driver Code Starts
import java.util.*;
import java.io.*;

// } Driver Code Ends


class CycleBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(adj,vis,i,-1))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[]vis,int curr,int par){
        vis[curr]=true;
        for(Integer node:adj.get(curr)){
            if(vis[node]==false){
                if(dfs(adj,vis,node,curr)){
                    return true;
                }
            }
            else if(vis[node]==true && node!=par){  
                return true;
            }
        }
        return false;
    }
}

