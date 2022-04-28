/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cancer;
import java.lang.Math;
/**
 *
 * @author BrPic4370
 */
public class Cancer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [][] grid = new String [15][15];
        for(int i = 0; i<grid.length;i++){
            grid [i][0] = "+";
            grid [i][14] = "+";
            for(int j = 0; j<grid[0].length; j++){
                grid [0][j] = "+";
                grid [14][j] = "+";
            }
        }
        int r = 0;
        for(int j = 1; j<grid.length&&j<14;j++){
           for(int i = 1; i<grid[i].length-1&&i<=14;i++){
               r = (int)((Math.random()*2)+1);
               if(r==1){
                   grid[j][i] = "-";
               }else{
                   grid[j][i] = "+";
               }
           }
        }
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("");
        
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j]=="-"){
                    grid[i][j] = " ";
                }
            }
        }
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static void floodFill(String [][] grid,int row, int col) {
        if (grid[row][col].equals("-")){
            grid[row][col] = " ";
            floodFill(grid, row - 1, col - 1);   
            floodFill(grid, row - 1, col);
            floodFill(grid, row - 1, col + 1);
            floodFill(grid, row, col - 1);
            floodFill(grid, row, col + 1);
            floodFill(grid, row + 1, col - 1);
            floodFill(grid, row + 1, col);
            floodFill(grid, row + 1, col + 1);
        }
    }
}
