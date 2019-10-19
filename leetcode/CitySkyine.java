package leetcode;
/*
 * Max Increase to Keep City Skyline - leetcode problem 807
 * Author : Komal Soham Wadekar
 */
public class CitySkyine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
       
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int row_max[] = new int[rows]; //left-right skyline view
        int col_max[] = new int[cols]; // top - bottom skyline view
        int newGrid[][]  = new int[rows][cols];
        
        for(int i=0; i<rows; i++){
        	int max = 0;
        	for(int j=0; j<cols; j++){
        		if(grid[i][j] >max){
        			max = grid[i][j]; 
        			row_max[i] = max;
        		}        		
        	}
        }
        
        for(int j=0; j<cols;j++){
        	int max = 0;
        	for(int i=0; i<rows;i++){
        		if(grid[i][j] >max){
        			max = grid[i][j]; 
        			col_max[j] = max;
        		} 	
        	}
        }
        int sum = 0;
        int diff=0;
        for(int i=0; i<rows; i++){
        	for(int j=0;j<cols;j++){
        		if(grid[i][j]!=row_max[i] && grid[i][j]!=col_max[j]){
        			diff = Math.min(row_max[i], col_max[j]) - grid[i][j];
        			newGrid[i][j] = grid[i][j]+diff;
        			sum = sum +diff;
        		}
        	}
        }
		return sum;
    }
    
    public static void main(String args[]){
    	CitySkyine city = new CitySkyine();
    	int grid[][] = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    	int sum = city.maxIncreaseKeepingSkyline(grid);
    	System.out.println("maximum total sum that the height of the buildings can be increased is: "+sum);
    }
}
