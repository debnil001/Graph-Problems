/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
class FindEventualSafeState {
    public boolean dfsFindCycle(int node,int[][]graph,boolean[]vis,boolean[]pathVisit,boolean[]checkSafe){
        vis[node]=true;
        pathVisit[node]=true;
        for(int neigh:graph[node]){
            if(!vis[neigh]){
                if(dfsFindCycle(neigh,graph,vis,pathVisit,checkSafe))
                    return true;
            }
            else if(pathVisit[neigh]){
                return true;
            }
        }
        checkSafe[node]=true;
        pathVisit[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        boolean vis[]=new boolean[V];
        boolean pathVisit[]=new boolean[V];
        boolean checkSafe[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfsFindCycle(i,graph,vis,pathVisit,checkSafe);
            }
        }
        ArrayList<Integer> safeNode=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(checkSafe[i]==true)
                safeNode.add(i);
        }
        return safeNode;
    }
}
