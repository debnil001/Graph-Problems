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
class RottingOranges {
   static  class Info{
        int row,col,time;

        public Info(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public static void print(int[][]vis){
        for(int[] v:vis){
            for(int i:v)
                System.out.print(i+" ");
            System.out.println();
        }
    }
    public static int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        Queue<Info> q=new LinkedList<>();
        int rottenCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Info(i,j,0));
                    vis[i][j]=2;
                    rottenCount++;
                }
            }
        }
        int time=0;
        int cnt=0;
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
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && grid[nRow][nCol]==1 && vis[nRow][nCol]!=2){
                    vis[nRow][nCol]=2;
                    q.add(new Info(nRow,nCol,tm+1));
                    cnt++;
                }
            }
        }
        // print(vis);
        // System.out.println(cnt);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=2 && grid[i][j]==1)
                    return -1;
            }
        }
        // if(cnt!=rottenCount)
        //     return -1;
        return time; 
    }
}
//You are given an m x n grid where each cell can have one of three values:

//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
public class rottenOranges {
    public static void main(String[]args){
        int[][]grid=new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int time=RottingOranges.orangesRotting(grid);
    }
}
