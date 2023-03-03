/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author HP
 */
class Pair{
    int dis;
    int i;
    int j;
    public Pair(int dis,int i,int j){
        this.dis=dis;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n= grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][n];
        for(int[] row : dis){
            Arrays.fill(row,(int) 1e9);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0));
        while(!q.isEmpty()){
            int distance = q.peek().dis;
            int i = q.peek().i;
            int j = q.peek().j;
            q.poll();
            if(i==n - 1 && j==m - 1) return distance+1;
            for(int row=-1;row<=1;row++){
                for(int column=-1;column<=1;column++){
                    int r = i + row;
                    int c = j + column;
                    if(r>=0 && r<n && c >=0 && c<m &&
                    grid[r][c]==0 && dis[r][c]>(distance + 1)){
                        dis[r][c]=distance + 1;
                        q.offer(new Pair(distance + 1,r,c));
                   }
                }
            }
        }
        return -1;
    }
}
