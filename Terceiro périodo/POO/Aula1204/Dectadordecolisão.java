import java.util.Scanner;

public class Dectadordecolisão {
    public static void main(String[] args) {
        int x0A, y0A, x1A, y1A;
        int x0B, y0B, x1B, y1B;
        Scanner teclado = new Scanner(System.in);
        
        x0A = teclado.nextInt();
        y0A = teclado.nextInt();
        x1A = teclado.nextInt();
        y1A = teclado.nextInt();
        x0B = teclado.nextInt();
        y0B = teclado.nextInt();
        x1B = teclado.nextInt();
        y1B = teclado.nextInt();

        byte saida = 1; //Assumimos que há colisão

        if(x0B > x1A || x1B < x0A || y0B > y0A || y1B < y0A) {
            saida = 0; //Não há colisão
        }

        System.out.println(saida);

        teclado.close();
    }
}
