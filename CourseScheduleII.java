/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author HP
 */
class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[]=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        int[]indegree=new int[numCourses];
        for (ArrayList<Integer> adj1 : adj) {
            for (int node : adj1) {
                indegree[node]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            res.add(node);
            for(int i:adj[node]){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }           
        }
        if(res.size()<numCourses)
            return new int[]{};
        int[]finalRes=new int[res.size()];
        for(int i=0;i<res.size();i++){
            finalRes[i]=res.get(i);
        }
        return finalRes;
    }
}
