/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: Create a utility class that manipulates a two-dimensional 
 * 				ragged array of doubles. This utility class will be used to create a 
 * 				Sales Report for Retail District #5. 
 * 
 * 			-	Create a utility class that will calculate holiday bonuses given a ragged 
 * 				array of doubles which represent the sales for each store in each category.
 * Due: 11/27/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Naol Gobena
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TwoDimRaggedArrayUtility {
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data - the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/number of elements)
	 */
	static double getAverage(double[][] data)
	{
		double avg =0;
		double sum = 0;
		int element = 0;
		
		for(int row =0; row < data.length; row++)
		{
			for (int col =0; col < data[row].length; col++)
			{
				sum+= data[row][col];
				element++;
			}
		}
		avg = sum/element;
			
		return avg;
	}
	
	
	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, 
	 * it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	static double getColumnTotal(double[][] data, int col)
	{
		double sum =0;
		
		for(int row =0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				sum+= data[row][col];
			}
			else
			{
				sum+= 0;
			}
		}
		
		return sum;
	}
	
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data  - the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	static double getHighestInArray(double[][] data)
	{
		double highest =0;
		
		for(int row =0; row < data.length; row++)
		{
			for (int col =0; col < data[row].length; col++)
			{
				if(highest < data[row][col])
				highest = data[row][col];
			}
		}
		
		return highest;
	}
	
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, 
	 * it doesn't participate in this method.
	 * @param data  - the two dimensional array
	 * @param col - the selected column
	 * @return the largest element of the selected column
	 */
	static double getHighestInColumn(double[][] data, int col)
	{
		double highest =0;
		
		for(int row =0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(highest < data[row][col])
					highest = data[row][col];
			}
		}
			
		
		return highest;
	}
	
	
	/**
	 * Returns index of the largest element of the selected column in the two dimensional array index 0 
	 * refers to the first column. If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data  - the two dimensional array
	 * @param col - the selected column
	 * @return the index of the largest element of the column
	 */
	static int getHighestInColumnIndex(double[][] data, int col)
	{
		int index = 0;
		double highest =0;
		
		for(int row =0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(highest < data[row][col])
				{
					highest = data[row][col];
					index = row;
				}
			}
			
		}
		
		return index;

	}
	
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data  - the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	static double getHighestInRow(double[][] data, int row)
	{
		double highest =0;
		
		for(int col =0; col < data[row].length; col++)
		{
			if(highest < data[row][col])
				highest = data[row][col];
		}
		
		return highest;
	}
	
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data  - the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	static int getHighestInRowIndex(double[][] data, int row)
	{
		int index = 0;
		double highest =0;
		
		for(int col =0; col < data[row].length; col++)
		{
			if(highest < data[row][col])
				index = col;
		}
		
		return index;
	}
	
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	static double getLowestInArray(double[][] data)
	{
		double lowest =getHighestInArray(data);
		
		for(int row =0; row < data.length; row++)
		{
			for (int col =0; col < data[row].length; col++)
			{
				if(lowest > data[row][col])
					lowest = data[row][col];
			}
		}
		
		return lowest;
	}
	
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the 
	 * first column. If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	static double getLowestInColumn(double[][] data, int col)
	{
		double lowest =getHighestInArray(data);
		
		for(int row =0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(lowest > data[row][col])
				lowest = data[row][col];
			}
		}
			
		return lowest;
	}
	
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to 
	 * the first column. If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	static int getLowestInColumnIndex(double[][] data, int col)
	{
		int index = 0;
		double lowest =getHighestInArray(data);
		
		for(int row =0; row < data.length; row++)
		{
			if(col < data[row].length)
			{
				if(lowest > data[row][col])
				{
					lowest = data[row][col];
					index = row;				
				}	
			}
		}
		
		return index;
	}
	
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data  - the two dimensional array
	 * @param row - the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	static double getLowestInRow(double[][] data, int row)
	{
		double lowest =getHighestInArray(data);
		
		for(int col =0; col < data[row].length; col++)
		{
			if(lowest > data[row][col])
				lowest = data[row][col];
		}
		
		return lowest;
	}
	
	
	/**
	 * Returns the index of the smallest element of the selected row in the two 
	 * dimensional array index 0 refers to the first row.
	 * @param data  - the two dimensional array
	 * @param row  - the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	static int getLowestInRowIndex(double[][] data, int row)
	{
		int index = 0;
		double lowest =0;
		
		for(int col =0; col < data[row].length; col++)
		{
			if(lowest > data[row][col])
				index = col;
		}
		
		return index;
	}
	
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	static double getRowTotal(double[][] data, int row)
	{
		double sum =0;
		
		for(int col =0; col < data[row].length; col++)
		{
			sum+= data[row][col];
		}
		
		return sum;
	}
	
	
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data - the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */
	static double getTotal(double[][] data)
	{
		double sum = 0;
		
		for(int row =0; row < data.length; row++)
		{
			for (int col =0; col < data[row].length; col++)
			{
				sum+= data[row][col];
				
			}
		}
			
		return sum;
	}
 
	
	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for 
	 * each row is 10 Each row in the file is separated by a new line Each element in the row is separated by a space 
	 * Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array.
	 * 1. Read the doubles from the file into a temporary array [MAX_ROW][MAX_COLUMN] of Strings which was initialized 
	 * to nulls.
	 * 2. Find out how many rows there are (any row that has the first element != null is a valid row) 
	 * 3. Create the array based on the number of rows, i.e. double[][]array = new double[#rows][] 
	 * 4. Determine the number of columns for the first row (any element != null is a valid element)
	 * 5. Create the first row, i.e. array[0] = new double[#columns] 
	 * 6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles) 
	 * 7. Repeat for all rows
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, 
	 * returns a null if file is empty
	 * @throws FileNotFoundException
	 */
	static double[][] readFile(File file) throws FileNotFoundException
	{
		Scanner scan = new Scanner(file);
		int row = 0;
		
		while (scan.hasNextLine()) {
	        scan.nextLine();
	        row++;
	    }
			
		double [][] data = new double[row][];
		scan = new Scanner(file);
		
		while (scan.hasNextLine())
		{
			 for (int i = 0; i < data.length; i++) 
			 {
	             String[] line = scan.nextLine().trim().split(" ");
	             
	             data[i] = new double [line.length];
	             for (int j = 0; j < line.length; j++) 
	             {
	                 data[i][j] = Double.parseDouble(line[j]);
	             }
	         }
		}		
		return data;
		
	}
	
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double 
	 * is separated by a space.
	 * @param data  - two dimensional ragged array of doubles
	 * @param outputFile  - the file to write to
	 * @throws IOException  - if outputFile is not valid
	 */
	static void writeToFile(double[][] data, File outputFile) throws IOException
	{
		BufferedWriter writer = new BufferedWriter (new FileWriter(outputFile));
	
		for (int row = 0; row < data.length; row++) 
		 {
           
            for (int col = 0; col < data[row].length; col++) 
            {
            	 writer.write(data[row][col] + " ");
            }
            writer.write("\n");
        }
		
		writer.close();
	}
	

	
}