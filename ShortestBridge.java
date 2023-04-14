/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author HP
 */
public class ShortestBridge {
    class Solution {
    class Pair{
        int i,j;
        int dist;
        public Pair(int i,int j,int dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    int rowM[]=new int[]{-1,0,0,1};
    int colM[]=new int[]{0,-1,1,0};
    public void dfs(int[][]grid,int i,int j, Queue<Pair> q,boolean[][]vis,int n){
        vis[i][j]=true;
        q.add(new Pair(i,j,0));
        for(int k=0;k<4;k++){
            int nRow=i+rowM[k];
            int nCol=j+colM[k];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && grid[nRow][nCol]==1 && !vis[nRow][nCol]){
                dfs(grid,nRow,nCol,q,vis,n);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        boolean vis[][]=new boolean[n][n];
        Queue<Pair> q=new LinkedList<>();
        boolean flag=false;
        for(int i=0;i<n && !flag;i++){
            for(int j=0;j<n && !flag;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    dfs(grid,i,j,q,vis,n);
                    flag=true;
                }
            }
        }
        int bridge=0;
        while(!q.isEmpty()){
            Pair p=q.remove();
            bridge=p.dist;
            for(int k=0;k<4;k++){
                int nRow=p.i+rowM[k];
                int nCol=p.j+colM[k];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && !vis[nRow][nCol] && grid[nRow][nCol]==0){
                    q.add(new Pair(nRow,nCol,p.dist+1));
                    vis[nRow][nCol]=true;    
                }
               else if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && !vis[nRow][nCol] && grid[nRow][nCol]==1)
                return bridge;
            }
        }
        return bridge;
    }
}
}
