
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;

public class main{

    public static void main(String[] args) {
        ArrayList result;
        try {
            int sizeBoard;
            do {
                System.out.println("Enter N (at least 4) = ");
                Scanner input = new Scanner(System.in);
                sizeBoard = input.nextInt();
            } while ((sizeBoard < 4) || (sizeBoard > 8));
            System.out.println("Board layout");
            chessBoard layout = new chessBoard(sizeBoard);
            layout.printBoard();
            String goNext = "";
            while (!goNext.equals("n")) {
                Scanner input = new Scanner(System.in);
                System.out.println("Place first queen manually (y for yes) ?");
                String mode = input.next();
                int y=0;
                try {
                    int x = Integer.parseInt(mode);
                    y=x;
                } catch (Exception ea) {
                }
                chessBoard start = new chessBoard(sizeBoard);
                nQueen n = new nQueen(sizeBoard);
                if (mode.equals("y")) {
                    try {
                        System.out.println("Enter row of first queen = ");
                        int row = input.nextInt();
                        System.out.println("Enter col of first queen = ");
                        int col = input.nextInt();
                        start.addResult(row, col);
                        start.printBoard();
                        n.find(0, 0, true);
                        result = n.getResult();
                        chessBoard end = new chessBoard(sizeBoard);
                        boolean found = n.isFound(row, col);
                        int count = n.getCount();
                        if (!found) {
                            System.out.println("No solutions!!");
                        } else {
                            System.out.println("solution");
                            int mulSkipIndex = count / (sizeBoard + 1);
                            count = 0;
                            for (int i = (result.size() - (mulSkipIndex * (sizeBoard + 1))) - 2; count < sizeBoard; i--) {
                                end.addResult(count + 1, (int) result.get(i));
                                count++;
                            }
                            end.printBoard();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {  
                        System.out.println(e);
                        System.out.println("--------Try Again -------");
                    } catch (InputMismatchException e) {
                        System.out.println(e);
                        System.out.println("--------Try Again (input only integer !)-------");
                    }
                }        else if(mode.equals("n")){
                    System.out.println("Solution");
                    n.find(0, 0, true);
                    result = n.getResult();
                    chessBoard end = new chessBoard(sizeBoard);
                    int count = 0;
                    for (int i = result.size() - 2; count < sizeBoard; i--) {
                        end.addResult(count + 1, (int) result.get(i));
                        count++;
                    }
                    end.printBoard();
                }else if(Integer.class.isInstance(y)){
                 System.out.println("how dare you input wrong chioce?");
                 System.out.println("Plese~~~~input only (y for yes / n for no)");
                } 
                do{
                System.out.println("Continue (y for yes)");
                goNext = input.next();
                }while(!goNext.equals("y")&&!goNext.equals("n"));
            }
        } catch (NegativeArraySizeException ea) {

            System.out.println(ea);
            main(args);
        }
         catch (InputMismatchException ea) {

            System.out.println(ea);
            main(args);
        }

    }
}
