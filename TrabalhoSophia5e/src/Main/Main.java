package Main;

import Banco.Cliente;
import Banco.Conta;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
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
        
        Cliente cliente1 = new Cliente(cpf, nome, sobrenome, agencia, conta);
        //Uma nova instancia de conta
        Conta a = new Conta(cliente1, 200);
               
        a.iniciar();

    }

}
