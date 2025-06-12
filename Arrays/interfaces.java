public class interfaces {
    public static void main(String[] args) {
        Queen q = new Queen();
        Rook r = new Rook();
        King k = new King();

        q.move();
        r.move();
        k.move();
    }

    interface ChessPlayer{

        void move();
    }

   static class Queen implements ChessPlayer {
    public void move(){
        System.out.println("up, down , left ,right , diagonal(in all 4 drins) ");
    }
   }

   static class Rook implements ChessPlayer {
    public void move(){
        System.out.println("up, down , left ,right");
    }
   }

   static class King implements ChessPlayer {
    public void move(){
        System.out.println("up, down , left ,right, diagonal(by 1 step)");
    }
   }

}
