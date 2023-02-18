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
class numOfIsland {
    static class Pair{
        int row,col;
        public Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public static void checkArea(char[][]grid,int r,int c,boolean[][]vis,int m,int n){
        Queue<Pair> q=new LinkedList<>();
        vis[r][c]=true;
        q.add(new Pair(r,c));
        int []rowMoves=new int[]{-1,0,0,1};
        int []colMoves=new int[]{0,-1,1,0};
        while(!q.isEmpty()){
            Pair p=q.remove();
            int row=p.row;
            int col=p.col;
            //visit all 8 directions
            for(int i=0;i<4;i++){
                    int neighRow=row+rowMoves[i];
                    int neighCol=col+colMoves[i];
                    if(neighRow>=0&&neighRow<m&&neighCol>=0&&neighCol<n&&grid[neighRow][neighCol]=='1'&&vis[neighRow][neighCol]==false){ 
                        vis[neighRow][neighCol]=true;
                        q.add(new Pair(neighRow,neighCol));
                    }
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int countIsland=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    countIsland++;
                    checkArea(grid,i,j,visited,m,n);
                }
            }
        }
        return countIsland;
    }
}
