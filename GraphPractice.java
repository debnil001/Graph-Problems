/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
class Edge{
    int src;
    int dest;
    int wt;
    public Edge(int s,int d,int w){
        this.src=s;
        this.dest=d;
        this.wt=w;
    }
}
public class GraphPractice {
    public static void help(ArrayList<Edge>[] graph, int n){
        
    }
    public static void main(String[]args){
        ArrayList<Edge>[] graph=new ArrayList[5];
        int ar[]=new int[5];
        System.out.println(ar[0]);
        graph[0].size();
        help(graph,5);
        String num1="1234";
        num1=new StringBuilder(num1).reverse().toString();
        System.out.println(num1);
    }
}
