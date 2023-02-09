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
public class findAllPaths {
    public static void findPaths(ArrayList<Integer>[]graph,List<List<Integer>> res,List<Integer> ans,int source,int dest){
        ans.add(source);
        if(source==dest){
            res.add(new ArrayList(ans));
            return;
        }
        for(int i=0;i<graph[source].size();i++){
            findPaths(graph,res,ans,graph[source].get(i),dest);
            ans.remove(ans.size()-1);
        }
    }
    public static void allPaths(int graph[][]){
        ArrayList<Integer> []adj=new ArrayList[graph.length];
        for(int i=0;i<graph.length;i++)
            adj[i]=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                 adj[i].add(graph[i][j]);
            }
        }
        int source=0,dest=graph.length-1;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        findPaths(adj,res,ans,source,dest);
        System.out.println(res);
    }
    public static void main(String[]args){
        int graph[][]=new int[][]{
            {1,2},
            {3},
            {3},
            {}
        };
//        for(int a[]:graph){
//                System.out.print(a[0]+" ");
//           System.out.println();
//        }
//        System.out.println(graph);

        allPaths(graph);
    }
}
