/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author HP
 */
class Solution {
    int rowMoves[]=new int[]{-1,0,0,1};
    int colMoves[]=new int[]{0,-1,1,0};
    public void dfs(char[][]board,int row,int col,boolean vis[][],int m,int n){
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow=row+rowMoves[i];
            int ncol=col+colMoves[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol]=='O' && !vis[nrow][ncol]){
                dfs(board,nrow,ncol,vis,m,n);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'&&!vis[i][0]){
                dfs(board,i,0,vis,m,n);
            }
            if(board[i][n-1]=='O'&&!vis[i][n-1]){
                dfs(board,i,n-1,vis,m,n);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' &&!vis[0][j]){
                dfs(board,0,j,vis,m,n);
            }
            if(board[m-1][j]=='O' &&!vis[m-1][j]){
                dfs(board,m-1,j,vis,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
}
public class surroundedRegions {
    
}
