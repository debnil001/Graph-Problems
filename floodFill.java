/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author HP
 */
class FloodFill {
    static int []rowMoves=new int[]{-1,0,0,1};
    static int []colMoves=new int[]{0,-1,1,0};
    public static void dfsFill(int[][]image,int sr,int sc,int sourceColor,int color){
        image[sr][sc]=color;
        for(int i=0;i<4;i++){
            int nRow=sr+rowMoves[i];
            int nCol=sc+colMoves[i];
            if(nRow>=0 && nRow<image.length && nCol>=0 &&
            nCol<image[0].length && image[nRow][nCol]==sourceColor){
                image[nRow][nCol]=color;
                dfsFill(image,nRow,nCol,sourceColor,color);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor=image[sr][sc];
        if(sourceColor==color)
            return image;
        dfsFill(image,sr,sc,sourceColor,color);

        return image;
    }
}
public class floodFill {
    public static void main(String[]args){
        Solution s=new Solution();
        int[][]image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        FloodFill.floodFill(image, 1, 1, 2);
    }
}
