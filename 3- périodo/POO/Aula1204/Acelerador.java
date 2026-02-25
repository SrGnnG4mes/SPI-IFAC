import java.util.Scanner;

public class Acelerador {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int d = teclado.nextInt();
        d -= 3;
        d %= 8;
        int sensor;

        
        if (d==3) {
            sensor = 1;
        }else if(d==4){
            sensor = 2;
        } else {
            sensor = 3;
        }
        System.out.println(sensor);

        teclado.close();

        

        System.out.println(d-2);

        teclado.close();
    }
}