package main;

import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main {
     public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<Financiamento>();

        double taxaJuros = interfaceUsuario.pedirTaxaJuros();
        int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
        double valorImovel = interfaceUsuario.pedirValorImovel();

        Casa casaUsuario = new Casa(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, 200, 400);

        double pagamentoMensal = casaUsuario.calcularPagamentoMensal();
        double totalPagamento = casaUsuario.calcularTotalPagamento();

        System.out.println("Pagamento mensal: " + pagamentoMensal);
        System.out.println("Total do financiamento: " + totalPagamento);

        casaUsuario.mostrarDadosFinanciamento();

        listaDeFinanciamento.add(casaUsuario);
        listaDeFinanciamento.add(new modelo.Casa (500000, 22, 0.12, 500, 1000));
        listaDeFinanciamento.add(new modelo.Apartamento( 47189, 14, 0.08, 5, 4));
        listaDeFinanciamento.add(new modelo.Apartamento( 87452, 26, 0.07, 10, 1));
        listaDeFinanciamento.add(new modelo.Terreno(24367, 17, 0.06, "Residencial"));


        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        int i;

        for (i = 0; i < listaDeFinanciamento.size(); i++) {

            Financiamento financiamento = listaDeFinanciamento.get((int) i);
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalPagamento();

            System.out.println("Financiamento " + (i + 1) + " - valor do imóvel: R$ " + financiamento.getValorImovel() + ", valor do financiamento: R$ " + financiamento.calcularTotalPagamento());
        }
        System.out.println("Total dos imóveis: " + totalImoveis);
        System.out.println("Total dos financiamentos: " + totalFinanciamentos);

         try {
             FileWriter escritor = new FileWriter("financiamentos.txt");
             for (Financiamento financiamento : listaDeFinanciamento) {
                 escritor.write(financiamento.toString());
                 escritor.write("\n");

             }
             escritor.flush();
             escritor.close();
             System.out.println("Arquivo salvo com sucesso!");

         } catch (Exception e) {
             System.out.println("Erro ao salvar arquivo: " + e.getMessage());

         }

         try {
             BufferedReader leitor = new BufferedReader(new FileReader("financiamentos.txt"));
             String linha;

             while ((linha = leitor.readLine()) != null) {
                 System.out.println(linha);

             }
             leitor.close();

         } catch (Exception e) {
             System.out.println("Erro ao ler arquivo: " + e.getMessage());
         }


         try {
             ObjectOutputStream escritor =
                     new ObjectOutputStream(new FileOutputStream("financiamentos.ser"));

             escritor.writeObject(listaDeFinanciamento);
             escritor.close();
             System.out.println("Arquivo serializado salvo!");

         } catch (Exception e) {
             System.out.println("Erro na serialização: " + e.getMessage());

         }


         try {

             ObjectInputStream leitor =
                     new ObjectInputStream(new FileInputStream("financiamentos.ser"));

             ArrayList<Financiamento> listaLida =
                     (ArrayList<Financiamento>) leitor.readObject();

             leitor.close();

             for (Financiamento financiamento : listaLida) {
                 System.out.println(financiamento);

             }
         } catch (Exception e) {
             System.out.println("Erro ao ler serialização: " + e.getMessage());
         }
    }
}
