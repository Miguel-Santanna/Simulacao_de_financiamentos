package util;
import java.util.InputMismatchException;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        double valor;

        while (true) {

            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = scanner.nextDouble();

                if (valor <= 0) {
                    System.out.println("Erro! O valor digitado tem que ser positivo.");
                    continue;
                }
                return valor;

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");
                scanner.nextLine();

            }
        }
    }


    public int pedirPrazoFinanciamento() {
        int prazo;

        while (true) {

            try {
                System.out.print("Digite o prazo do financiamento em anos: ");
                prazo = scanner.nextInt();

                if (prazo <= 0) {
                    System.out.println("Erro! O valor digitado tem que ser positivo.");
                    continue;
                }
                return prazo;

            } catch (InputMismatchException e) {

                System.out.println("Digite um número inteiro.");
                scanner.nextLine();

            }
        }
    }

    public double pedirTaxaJuros() {
        double taxa;
        while (true) {

            try {
                System.out.print("Digite a taxa de juros anual: ");
                taxa = scanner.nextDouble();

                if (taxa <= 0) {
                    System.out.println("Erro! O valor digitado tem que ser positivo.");
                    continue;
                }
                return taxa;

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");
                scanner.nextLine();

            }
        }
    }
}