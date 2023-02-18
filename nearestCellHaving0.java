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
class NearestCellWith0 {
    int rowMoves[]=new int[]{-1,0,0,1};
    int colMoves[]=new int[]{0,-1,1,0};
    class Info{
        int row,col,dist;
        public Info(int row,int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
   public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Info> q=new LinkedList<>();
        boolean vis[][]=new boolean[m][n];
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Info(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Info cell=q.remove();
            int row=cell.row;
            int col=cell.col;
            int dist=cell.dist;
            res[row][col]=dist;
            for(int i=0;i<4;i++){
                int nrow=row+rowMoves[i];
                int ncol=col+colMoves[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && 
                !vis[nrow][ncol]){
                    q.add(new Info(nrow,ncol,dist+1));
                    vis[nrow][ncol]=true;
                }
            }
        }
        return res;
    }
}
public class nearestCellHaving0 {
    
}
