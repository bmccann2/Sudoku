import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.Scanner; 
   import java.io.*;
   public class SudokuPanel extends JPanel 
   {


      //instance data

      private JTextField[][] gameBoard;

      private Sudoku puzzle = new Sudoku();

      public SudokuPanel() throws Exception 

      {

         //sets file

         File myFile = new File ("Sudoku.inp");

         Scanner fileScan = new Scanner (myFile);

         int value; 

         

         //set a few values

         puzzle.setValue(0,0,1);

         puzzle.setValue(0,1,2);

         puzzle.setValue(0,2,3);

                       

          //Reads from file  

          for (int row=0; row<9; row++)

          {

             for (int col=0; col<9; col++)

             {

             value= fileScan.nextInt();

             puzzle.setValue(row,col,value);

             }

               

          }

         //set up primary panel

         setBackground (Color.green);

         setPreferredSize( new Dimension(400,350) );

         // gameBoard panel

         JPanel gamePanel = new JPanel();

         gamePanel.setLayout (new GridLayout (3, 3));

         //set up subpanels - one for each of the 9 grids

         JPanel[] smallgrid = new JPanel[9];

         for (int index = 0; index < 9; index++)

         {

           smallgrid[index] = new JPanel();

            smallgrid[index].setBackground(new 

Color((int)(256*Math.random()), (int) (256*Math.random()),(int) 

(256*Math.random())));

            smallgrid[index].setPreferredSize( new Dimension( 

110, 100) );

         }

         //set up game text fields to allow for user input

         gameBoard = new JTextField[9][9];

         for (int i = 0; i<9; i++)

            for (int j=0; j<9; j++)

            {

               if( puzzle.getValue(i,j) == 0 ) //no given value for this puzzle

                  //provide user ability to enter a value

                  gameBoard[i][j] = new JTextField(2);

               else

               {

                  //display the puzzle value and prevent user from changing

                  gameBoard[i][j] = new JTextField(" " + 

puzzle.getValue(i,j), 2);

                  gameBoard[i][j].setEditable( false );

               }

               //add the JTextField to the appropriate grid panel

               smallgrid[ (i/3)*3 + j/3 ].add(gameBoard[i][j]);

            }

         //add each of the grids to the panel

         for( int index=0; index < 9; index++)

            gamePanel.add( smallgrid[index] );

         //add the gamePanel to the primary panel

         this.add(gamePanel);

         // add button to allow user to check puzzle

         JButton check = new JButton("Check");

         check.addActionListener(new CheckListener());

         this.add(check);

      }

      

       public class CheckListener implements ActionListener 

      {

      

     

         public void actionPerformed(ActionEvent event) 

         {

            //read data from gameBoard to Sudoku

            String input;

                        

            

            for (int i=0; i<9; i++)

               for (int j=0; j<9; j++)

               {

                  input = gameBoard[i][j].getText().trim();

                  if( input.length() == 0 )

                     puzzle.setValue(i,j,0);

                 else

                     puzzle.setValue(i,j, 

Integer.parseInt(input));

               }

            //check the Sudoku puzzle and inform user of results

            if( puzzle.check() )

               JOptionPane.showMessageDialog(null, "You Win!");

            else

               JOptionPane.showMessageDialog(null, "You're not done just yet!");

         }

      }

   }