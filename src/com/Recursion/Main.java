package com.Recursion;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	/* maze problem, in this you have to cover all the path that
	   means you reach the last by moving left,right,up,down
	 */
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true }
        };
//        allPaths("",maze,0,0);
        int[][] mazze = new int[maze.length][maze[0].length];
        matrixPath("",maze,0,0,mazze,1);
    }
    public static void allPaths(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        // i am considering this block in my path
        maze[r][c] = false;
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
        // this line where the function will be over.
        // so before the functions get removed, also remove the changes that were made by that function.
        maze[r][c] = true;
    }
    // now printing the matrix of path.
    public static void matrixPath(String p,boolean[][] maze, int r,int c,int[][] path,int steps) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = steps;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]) {
            return;
        }
        maze[r][c] = false;
        path[r][c] = steps;
        // for down.
        if (r < maze.length - 1) {
            matrixPath(p + 'D', maze, r + 1, c, path, steps + 1);
        }
        // for right
        if (c < maze[0].length - 1) {
            matrixPath(p + 'R', maze, r, c + 1, path, steps + 1);
        }
        // for up
        if (r > 0) {
            matrixPath(p + 'U', maze, r - 1, c, path, steps + 1);
        }
        // for left
        if (c > 0) {
            matrixPath(p + 'L', maze, r, c - 1, path, steps + 1);
        }
        // now the condition of backtracking.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
