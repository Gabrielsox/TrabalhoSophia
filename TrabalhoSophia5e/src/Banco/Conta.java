package Banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Conta {
    
    public String getTipoConta() {
        
        if(tipoConta == 1){
            return "Corrente";
        }
        else{
            return "Poupança";
        }
    }
    

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    private Cliente dono;

    private double saldo;
    private int tipoConta; //1- corrente 2-poupanca
    private Conta b;

    private Scanner entrada = new Scanner(System.in);

    Extrato<String> e;

    List<Extrato> listaExtrato = new ArrayList<Extrato>();

    private void extrato() {

        for (Extrato extrato : listaExtrato) {

            System.out.println("data - " + extrato.getData());
            System.out.println("tipo - " + extrato.getTipo());
            System.out.println("valor - " + extrato.getValor());
            System.out.println("\n---------------------");

        }

    }

    public Conta(Cliente dono, double saldo) {
        this.dono = dono;
        this.saldo = saldo;

    }

    private void depositar(double valor) {
        saldo += valor;
        e = new Extrato<>();
        e.setTipo("Deposito");
        e.setData(new Date());
        e.setValor(valor);

        listaExtrato.add(e);
    }

    private void sacar(double valor) {
        double novoSaldo = saldo - valor;
        saldo = novoSaldo;

        e = new Extrato<>();
        e.setTipo("Saque");
        e.setData(new Date());
        e.setValor(valor);

        listaExtrato.add(e);
    }

    private Double consultarSaldo() {
        return saldo;
    }

    public void transferir(Conta destino, double valor) {
        saldo -= valor;
        e = new Extrato<>();
        e.setTipo("Transferência de sua conta para \n"
                + b.dono.getNome().toString()
                + "\nAgencia: " + b.dono.getAgencia()
                + "\nConta: " + b.dono.getConta()
                + "\nTipo Conta: " + b.getTipoConta());
        e.setData(new Date());
        e.setValor(valor);

        listaExtrato.add(e);

    }

    public void iniciar() {
        int opcao;

        do {
            exibeMenu();
            opcao = entrada.nextInt();
            Opcoes(opcao);
        } while (opcao != 6);
    }

    private void exibeMenu() {

        System.out.println("\t Escolha a opção desejada");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Extrato");
        System.out.println("4 - Saldo");
        System.out.println("5 - Traferência");
        System.out.println("6 - Sair \n");
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

                System.out.println("O saldo atual é: R$" + consultarSaldo() + "\n\n");
                break;
            case 5:
                Clear();

                System.out.println("================");
                System.out.println("= TRANFERÊNCIA =");
                System.out.println("================");
                System.out.println("Preencha os dados da conta de transferência: ");

                Conta c = transferirAB();

                System.out.println("Valor de transferência: ");

                double transf = entrada.nextDouble();

                transferir(c, transf);

            case 6:
                Clear();

                System.out.println("OBRIGADO POR UTILIZAR O SISTEMA.");
                break;

            default:
                Clear();
                System.out.println("Opção inválida ");
        }

    }

    public Conta transferirAB() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digiete os dados da sua conta: ");
        System.out.println("===============================\n");

        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Sobrenome: ");
        String sobrenome = sc.next();

        System.out.println("Agencia: ");
        int agencia = sc.nextInt();
        System.out.println("Conta: ");
        int conta = sc.nextInt();
        System.out.println("------------------\n1-Corrente\n2-Poupança\nTipo Conta: ");
        int tipoConta = sc.nextInt();

        Cliente cliente2 = new Cliente(cpf, nome, sobrenome, agencia, conta);
        //Uma nova instancia de conta
        b = new Conta(cliente2, 300);

        return b;
    }
}
