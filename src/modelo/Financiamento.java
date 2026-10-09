package modelo;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    //construtor
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnual;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //Metodos
    public double calcularPagamentoMensal() {
        return (this.valorImovel/ (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println("O valor do seu financiamento total ficou: " + calcularTotalPagamento() + " e o valor do seu imovel ficou: " + valorImovel);
    }

} 

