package Main;

import Banco.Cliente;
import Banco.Conta;
import Banco.Extrato;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("10790319608", "Igor", "Araujo");

        Conta c = new Conta(cliente1, 0, 0);
        c.iniciar();

    }

}
