public class Backtracking_Queens {
    public static boolean isSafe(char board[][] , int row , int coloumn){
        //vertical
        for(int i = row - 1; i>=0; i--){
            if(board[i][coloumn]== 'Q'){
                return false;
            }
        }
        //diag left up
        for(int i = row-1,  j = coloumn-1; i>= 0 && j>=0 ; i--, j--){
            if(board[i][j]== 'Q'){
                return false;
            }
        }
        //diag right up
        for(int i = row-1,  j = coloumn+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]== 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        //base
        if(row == board.length){
            Print(board);
            count++;
            return;
        }
        //coloumn_loop
        for(int j = 0; j < board.length; j++){
            if(isSafe(board,row,j)){
            board[row][j]= 'Q';
            nQueens(board, row+1);//functions_call
            board[row][j] = 'X';//Backtracking_steps
            }
        }
    }
    public static void Print(char board[][]){
        System.out.println("----Chess Board----");
        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board.length ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        //initialize
        for(int i = 0; i<n; i++){
            for(int j = 0; j< n; j++){
                board[i][j] = 'X';
            }
        }
        nQueens(board,0);
       System.out.println("Total ways to solve nQueens : "+count);
    }
}
