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

    private void Clear(){
        
        for (int i = 0; i < 200; i++) {
            System.out.print("\r\n");
        }
        
    }
    
    

}
