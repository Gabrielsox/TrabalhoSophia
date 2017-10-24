package Banco;

import java.util.Scanner;

public class Conta {

    private int numero;
    private Cliente dono;
    private double saldo;
    private Scanner entrada = new Scanner(System.in);

    public Conta(Cliente dono, double saldo, int numero) {
        this.dono = dono;
        this.saldo = saldo;
        this.numero = numero;
    }

    private void depositar(double valor) {
        saldo += valor;
    }

    private void sacar(double valor) {
        double novoSaldo = saldo - valor;
        saldo = novoSaldo;
    }

    private void extrato() {

    }

    private double consultarSaldo() {
        return saldo;
    }

    public void iniciar() {
        int opcao;

        do {
            exibeMenu();
            opcao = entrada.nextInt();
            Opcoes(opcao);
        } while (opcao != 5);
    }

    private void exibeMenu() {

        System.out.println("\t Escolha a opção desejada");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Estrato");
        System.out.println("4 - Saldo");
        System.out.println("5 - Sair \n");
        System.out.print("Opção: ");

    }

    private void Clear() {

        for (int i = 0; i < 200; i++) {
            System.out.print("\r\n");
        }

    }

    private void Opcoes(int opcao) {
        double valor;

        switch (opcao) {
            case 1:
                Clear();

                System.out.println("=============");
                System.out.println("= DEPOSITAR =");
                System.out.println("=============");

                System.out.println("Digite o valor do Deposito");
                valor = entrada.nextDouble();

                if (valor > 0) {
                    depositar(valor);
                    System.out.println("valor atual:R$" + consultarSaldo());
                } else {
                    System.out.println("O valor a depositar não pode ser igual ou menor que zero");

                }
                break;

            case 2:
                Clear();

                System.out.println("=========");
                System.out.println("= SACAR =");
                System.out.println("=========");

                System.out.println("Digite o valor do Saque");
                valor = entrada.nextDouble();

                if (consultarSaldo() > valor) {
                    sacar(valor);
                    System.out.println("valor atual:R$" + consultarSaldo());
                } else {
                    System.out.println("Saldo insuficiente \n");
                }

                break;

            case 3:
                Clear();

                System.out.println("===========");
                System.out.println("= EXTRATO =");
                System.out.println("===========");

                extrato();
                break;

            case 4:
                Clear();

                System.out.println("=========");
                System.out.println("= SALDO =");
                System.out.println("=========");

                System.out.println("O saldo atual é: R$" + consultarSaldo());
                break;
            case 5:
                Clear();

                System.out.println("OBRIGADO POR UTILIZAR O SISTEMA.");
                break;

            default:
                Clear();
                System.out.println("Opção inválida ");
        }
    }

}
