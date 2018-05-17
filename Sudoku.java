public class Sudoku
{
   int[][] board= new int [9][9];
   int rowtotal, coltotal, gridtotal, z, grid;
   boolean ok;
 
   //Constructor
      public Sudoku()
      {
      boolean ok=true;
         for (int row=0; row<board.length; row++)
            {
            for (int col=0; col<board[row].length; col++)
               board[row][col]=0;
            }
      }

      //Sets a value to the input
      public void setValue(int i, int j, int value)
      {
      board[i][j]= value;
      }
     
     //returns a value
     public int getValue(int i, int j)
     {
     return board[i][j];
     }

     //Checks to see if it meets sudoku rules
     public boolean check ()
     {
    for (int row=0; row<board.length; row++){
        rowtotal=0;
        for (int col=0; col<board[row].length; col++){
         rowtotal+= board[row][col];
          if (rowtotal==45) 
           ok=true;
          if (rowtotal<45 || rowtotal>45)
           ok=false;
          }   
        } 
      
    for (int col=0; col<board.length; col++){
       coltotal=0;
       for (int row=0; row<board.length; row++){  
            coltotal+= board[row][col];
            if (coltotal==45) 
              ok=true;
            if (coltotal<45 || coltotal>45)
              ok=false;
       }
   }  

        z=0;
        grid=0;
        for (int row=z; row<z+3; row++){
        gridtotal=0;
           if ((grid % 3)==0 && grid != 0)
             z=z+3;
           for (int col=z; col<3; col++){
           gridtotal+= board[row][col];
           if (gridtotal==45) 
             ok=true;
           if (gridtotal<45 || gridtotal>45)
             ok=false;
           z=z-3;
           grid++;
           if ((grid % 3)== 0)
           z=z+3;
           }
        }          
      return ok;
      }

        

        

           

}