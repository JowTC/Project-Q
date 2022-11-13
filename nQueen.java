
import java.util.ArrayList;


public class nQueen {
    
    private int size,count;
    private chessBoard b ;
    
    private ArrayList result = new ArrayList(); 

    public nQueen(int n){ size = n;b = new chessBoard(size);}
    
    public  boolean find(int colAdd,int rowAdd,boolean head){
        
        
        if(!b.add(rowAdd, colAdd))
            return false;
        else if (rowAdd==size)
                { return true; }

        for(int i =1;i<=size;i++){
            if(find(i,rowAdd+1,false)){
                result.add(i);
                if(head){result.add(colAdd); b.clearBoard();}
                    
                else
                    return true;
            }
        }
        if(head)
            return true;
        b.remove();
        return false;
    }
    public ArrayList getResult(){
        return result;
    
    }
    
    public boolean isFound(int row,int col){
          int found = 0;
          this.count = 0;
          for (int i = result.size() - 1; i >= 0; i--) {
                            
                if ((count % (size + 1)) != 0) {
                    if (((int) result.get(i) == col) && ((count % (size + 1)) == row)) {
                        found = 1;
                    }
                }
                count++;
                if (found == 1) {
                    return true;
                }
            }
         return false;
    }
    public int getCount(){
        return count;
    
    }
  
}
