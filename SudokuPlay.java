import javax.swing.*;
import java.io.*;
import java.util.Scanner;
public class SudokuPlay
{
 

   

   public static void main(String[] args) throws Exception

   {

      

      JFrame frame = new JFrame ("Let\'s play Sudoku");

      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      SudokuPanel sudoku = new SudokuPanel();

      frame.getContentPane().add(sudoku);      frame.pack();

      frame.setVisible(true);

   }

}