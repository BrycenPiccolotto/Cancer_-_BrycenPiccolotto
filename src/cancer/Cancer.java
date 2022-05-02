/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cancer;
import java.lang.Math;
import java.util.Scanner;
/**
 *
 * @author BrPic4370
 */
public class Cancer {
    public static int p;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What are the odds of cancer?");
        System.out.println("The first number is the range of the randomization");
        int x = scan.nextInt();
        while(x<=0){
            System.out.println("Ivalid Input. Pleaes try again");
            x = scan.nextInt();
        }
        System.out.println("The second input is the chance of positive cells within that range");
        int y = scan.nextInt();
        while(y>x||y<=0){
            System.out.println("Ivalid Input. Pleaes try again");
            y = scan.nextInt();
        }
        System.out.println();
        System.out.println("Here is the patient's file");
        System.out.println();
        String [][] grid = new String [15][15];
        for(int i = 0; i<grid.length;i++){
            grid [i][0] = "▓";
            grid [i][14] = "▓";
            for(int j = 0; j<grid[0].length; j++){
                grid [0][j] = "▓";
                grid [14][j] = "▓";
            }
        }
        int r = 0;
        for(int j = 1; j<grid.length&&j<14;j++){
           for(int i = 1; i<grid[i].length-1&&i<=14;i++){
               r = (int)((Math.random()*x)+1);
               if(r<=y){
                   grid[j][i] = "▓";
               }else{
                   grid[j][i] = "▒";
               }
           }
        }
        int a = 0;
        int b = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j].equals("▒")){
                    b++;
                }else{
                    a++;
                }
            }
        }
        a=a-56;
        System.out.println("There are " + a + " ammount of ▓'s");
        System.out.println("There are " + b + " ammount of ▒'s");
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("");
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == "▒"){
                    floodFill(grid,i,j);
                    p++;
                }
            }
        }
        System.out.println("There are " + p + " cancer spots in the file");
        System.out.println();
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static void floodFill(String [][] grid,int row, int col) {
        
        if (grid[row][col].equals("▒")){
            
            grid[row][col] = "░";
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
