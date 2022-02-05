package com.Recursion;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	/* maze problem, in this you have to cover all the path that
	   means you reach the last by moving left,right,up,down
	 */
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true }
        };
        allPaths("",maze,0,0);
    }
    public static void allPaths(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        // for down
        if(r<maze.length-1){
            allPaths(p+"D",maze,r+1,c);
        }
        // for right
        if(c< maze[0].length-1){
            allPaths(p+"R",maze,r,c+1);
        }
        // for up
        if(r>0){
           allPaths(p+'U',maze,r-1,c);
        }
        // for left
        if(c>0){
            allPaths(p+'L',maze,r,c-1);
        }
    }
}
