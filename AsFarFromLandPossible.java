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
public class AsFarFromLandPossible {
    class Solution {
    class Info{
        int row,col,time;

        public Info(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int vis[][]=new int[n][n];
        Queue<Info> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Info(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int time=0;
        int []rowMoves=new int[]{-1,0,0,1};
        int []colMoves=new int[]{0,-1,1,0};
        while(!q.isEmpty()){
            Info cell=q.remove();
            int row=cell.row;
            int col=cell.col;
            int tm=cell.time;
            time=Math.max(tm,time);
            for(int i=0;i<4;i++){
                int nRow=row+rowMoves[i];
                int nCol=col+colMoves[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && grid[nRow][nCol]==0 && vis[nRow][nCol]!=1){
                    vis[nRow][nCol]=1;
                    q.add(new Info(nRow,nCol,tm+1));
                }
            }
        }
        if(time==0)
            return -1;
        return time; 
    }
}

}
