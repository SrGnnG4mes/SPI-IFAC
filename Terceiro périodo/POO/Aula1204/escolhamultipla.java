import java.util.Scanner;

public class escolhamultipla {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        byte dia = -1;

        while (dia != 0) {
            System.out.println("Digite um dia da semana: ");
            dia = teclado.nextByte();
            switch (dia) {
                case 1:
                    System.out.println("Domingo");
                    break;
                case 2:
                    System.out.println("Segunda-Feira");
                    break;
                case 3:
                    System.out.println("Terça-Feira");
                    break;
                case 4:
                    System.out.println("Quarta-Feira");
                    break;
                case 5:
                    System.out.println("Quinta-Feira");
                    break;
                case 6:
                    System.out.println("Sexta-Feira");
                    break;
                case 7:
                    System.out.println("Sábado");
                    break;
                case 0:
                    System.err.println("Voçê escolheu sair do sistema.");
                    break;
                default:
                    System.out.println("Dia Inválido");
                    break;
            }
        }
        teclado.close();

    }
}
