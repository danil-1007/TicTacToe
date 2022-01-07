import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Field {
   static int [] canvas = {0,0,0,
            0,0,0,
            0,0,0
   };

    public static void Game() throws IOException{
        boolean breakloop ;
        boolean isX = false;

        do {
            isX = !isX;
            drawCanvas();
            System.out.println("mark " + (isX ? "X" : "O"));
            int n = getNumber();
            canvas[n] = isX ? 1 : 2;
            breakloop = !isGameOver(n);
        } while (breakloop);
        drawCanvas();


        System.out.println("The winner is " + (isX ? "X" : "O") + "!");
    }


    private static boolean isGameOver(int n) {
        int column = n % 3;
        if (canvas[column] == canvas[column + 3])
            if (canvas[column] == canvas[column + 6]) return true;

        int row = n - n % 3;
        if (canvas[row] == canvas[row + 1] && canvas[row] == canvas[row + 2]) {
            return true;
        }

        if (n % 2 != 0) return false;

        if (n % 4 == 0) {

            if (canvas[0] == canvas[4] &&
                    canvas[0] == canvas[8]) return true;
            if (n != 4) return false;
        }
        return canvas[2] == canvas[4] &&
                canvas[2] == canvas[6];
    }

    private static void drawCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            if (i != 0) {
                if (i % 3 == 0) {
                    System.out.println();
                } else
                    System.out.print("|");
            }

            if (canvas[i] == 0) System.out.print("  " +i+  "  ");
            if (canvas[i] == 1) System.out.print("  X  ");
            if (canvas[i] == 2) System.out.print("  O  ");
        }
        System.out.println();

    }

    static int getNumber() throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         while (true) {
             try {
                 int n = Integer.parseInt(reader.readLine());
                 if (n >= 0 && n < canvas.length && canvas[n] == 0) {
                     return n;
                 }
                 System.out.println("Choose free cell and enter its number");
             } catch (NumberFormatException e) {
                 System.out.println("Please enter the number");
             } catch (IOException e) {
             }
         }



     }
}
