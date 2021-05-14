package com.company;

import java.util.Scanner;
import java.io.*;

public class WordSearch
{

    //Instance Variables
    private int rows;
    private int cols;
    private int words;
    private char[][] wordSearchchar;
    private String[] wordSearchstring;

    //Constructor
    public WordSearch()
    {
        //initialized
    }

    //x change
    public int addX(int x, int ax)
    {
        x = x + ax;
        if(x < 0) x = rows - 1;
        if(x >= rows) x = 0;
        return x;
    }

    //y change
    public int addY(int y, int ay)
    {
        y = y + ay;
        if(y < 0) y = cols - 1;
        if(y >= cols) y = 0;
        return y;
    }

    //Function checking directions
    public boolean testdirect(int x, int y, int d,String word, int ax, int ay)
    {
        if(d == word.length()) return true;
        if(wordSearchchar[x][y] == word.charAt(d))
        {
            return testdirect(addX(x, ax), addY(y, ay), d+1, word, ax, ay);
        }
        return false;
    }

    //Methods
//Takes in the matrix of words and checks if the code is in the scrambled words.
    public void wordFind()
    {
        for(int d = 0; d < words; d++)
        {
            String word = wordSearchstring[d];
            boolean foundWord = false;
            for(int i = 0; i < rows; i++)
            {
                if(foundWord == true)
                {
                    break;
                }
                for(int j = 0; j < cols; j++)
                {
                    if(wordSearchchar[i][j] == word.charAt(0))
                    {
                        if(testdirect(i, j, 0, word, 1, 0) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, -1, 0) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, 0, 1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, 0, -1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, 1, 1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, -1, -1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, -1, 1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                        else if(testdirect(i, j, 0, word, 1, -1) == true)
                        {
                            System.out.println(i + " " + j);
                            foundWord = true;
                        }
                    }
                }
            }

            if(foundWord == false)
            {
                System.out.println("NOT FOUND");
            }

        }
    }

    //Reads in the WordSearch File
    public void readWordSearch()
    {
        String inputLine;

        Scanner fileInput;
        File inFile = new File("C:/Users/abdul/IdeaProjects/1-ecu_game/src/com/company/input.txt");

        try
        {
            fileInput = new Scanner(inFile);

            //Pulls the data from the top to make the maze
            //Sets the start and end row for a win
            rows = fileInput.nextInt();
            cols = fileInput.nextInt();
            wordSearchchar = new char[rows][cols];

            fileInput.nextLine();

            for(int i = 0; i < rows; i++)
            {
                inputLine = fileInput.nextLine();
                for(int j = 0; j < cols; j++)
                {
                    wordSearchchar[i][j] = inputLine.charAt(j);
                }
            }

            words = fileInput.nextInt();
            wordSearchstring = new String[words];


            fileInput.nextLine();
            for(int i = 0; i < words; i++)
            {
                wordSearchstring[i] = fileInput.nextLine();
            }


            fileInput.close();

        } // end try

        catch (FileNotFoundException e)
        {
            System.out.println(e);
            System.exit(1);		// IO error; exit program
        } // end catch
    }


    //Displays the solved array
    public void printWordSearch()
    {


        //Print its contents
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(wordSearchchar[i][j]);
            }
            System.out.println();
        }

        for(int i = 0;i < words; i++)
        {
            System.out.print(wordSearchstring[i]);
            System.out.println();
        }
    }
}
