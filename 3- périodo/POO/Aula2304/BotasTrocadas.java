package Aula2304;

import java.util.Scanner;

public class BotasTrocadas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        byte[] esquerdo = new byte[61];
        byte[] direito = new byte[61];
        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            byte tamanho = teclado.nextByte();
            char pe = teclado.next().charAt(0);
            if (pe == 'E') {
                esquerdo[tamanho]++;
            } else {
                direito[tamanho]++;
            }

        }

        int quantidade = 0;
        for (int i = 30; i <= 60; i++) {
            quantidade = quantidade + Math.min(esquerdo[i], direito[i]);
        }
        System.out.println(quantidade);
        teclado.close();
    }

}
