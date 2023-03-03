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
// } Driver Code Ends


/*Complete the function below*/

class DetectCycle {
    public boolean dfsCycle(int node,ArrayList<ArrayList<Integer>> adj,boolean[]vis,boolean[]pathVisit){
        vis[node]=true;
        pathVisit[node]=true;
        for(int neigh: adj.get(node)){
            if(!vis[neigh]){
                if(dfsCycle(neigh,adj,vis,pathVisit))
                return true;
            }
            else if(pathVisit[neigh]==true)
                return true;
        }
        pathVisit[node]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean[V];
        boolean pathVisit[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfsCycle(i,adj,vis,pathVisit))
                    return true;
            }
        }
        return false;
    }
}
