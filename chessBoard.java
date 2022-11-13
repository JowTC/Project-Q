public class chessBoard {
    private int col[];
    private int row[];
    private int realTimeSize = 0;
    private int sizeInput;
    private int board[][];
    public chessBoard(int n){
        col = new int[n+1];
        row = new int[n+1];
        board = new int[n][n];
        sizeInput = n;
        for(int i =0;i<n+1;i++){
            col[i] = -10;
            row[i] = -10;
        }
            
    }
    
    public void remove(){
        col[realTimeSize-1] = -10;
        row[--realTimeSize] = -10;
    }
    
    public boolean add(int rrow,int ccol){
        
        if(isSameCol(ccol))
            {
                return false;
             
            }
        if(isSameDiagonal(rrow,ccol))
             {
                return false;
             
            }
        col[realTimeSize] = ccol;
        row[realTimeSize++] = rrow;
        return true ;
    
    }
    
    public boolean isSameCol(int ccol){
         for(int i =0;i<col.length;i++){
            if(col[i]==ccol)
                return true;
        }
         return false;
    }
    
    public boolean isSameDiagonal(int rrow,int ccol){
        int tempRow = rrow;
        int tempCol = ccol;
        while((tempRow>1) && (tempCol>1)){
            tempRow--;
            tempCol--;
            for(int i =0;i<col.length;i++){
                if(  (col[i]==tempCol)&&(row[i]==tempRow) )
                    return true;
            }
        }
        
        tempRow = rrow;
        tempCol = ccol;
         
          while( (tempRow>1) && (tempCol<sizeInput)){
           tempRow--;
           tempCol++;
           for(int i =0;i<col.length;i++){
               if( (col[i]==tempCol)&& (row[i]==tempRow) )
               {
                   return true;}
           }
        }
          
          tempRow = rrow;
        tempCol = ccol;
         
          while( (tempRow<sizeInput) && (tempCol>1) ){
           tempRow++;
           tempCol--;
           for(int i =0;i<col.length;i++){
               if(  (col[i]==tempCol)&& (row[i]==tempRow) )
                   return true;
           }
        }
          
          tempRow = rrow;
        tempCol = ccol;
         
          while( (tempRow<sizeInput) && (tempCol<sizeInput) ){
           tempRow++;
           tempCol++;
           for(int i =0;i<col.length;i++){
               if(  (col[i]==tempCol)&&(row[i]==tempRow) )
               {
                   return true;}
           }
        }
        return false;
        
    
    }
    
    public void clearBoard(){
        for(int i=1;i<col.length;i++){
            col[i] = -10;
            row[i] = -10;
            realTimeSize = 1;
        }
    
    }
    
    public void printBoard(){
        System.out.printf("     ");
        for(int i =0;i<sizeInput;i++)
            System.out.printf("%2d   ",i+1);
        System.out.println();
                
        for(int i =0;i<sizeInput;i++){
            System.out.printf("%2d    ",i+1);
            for(int j = 0;j<sizeInput;j++){
                if(board[i][j]==1)
                    System.out.printf("Q    ");
                else
                    System.out.printf("=    ");
            
            }
            System.out.println();
        }
    
    }
    
    public void addResult(int row,int col){
        board[row-1][col-1] = 1;
    }
}
