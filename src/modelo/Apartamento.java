package modelo;

public class Apartamento extends Financiamento {

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double calcularPagamentoMensal() {
        double totalPagamento = valorImovel * (1 + (taxaJurosAnual * prazoFinanciamento));
        return totalPagamento / (prazoFinanciamento * 12);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imóvel: " + getValorImovel() + "\n");
        sb.append("Valor financiamento: " + calcularTotalPagamento() + "\n");
        sb.append("Taxa de juros: " + getTaxaJurosAnual() + "\n");
        sb.append("Prazo: " + getPrazoFinanciamento() + " anos\n");
        sb.append("Vagas na garagem: " + vagasGaragem + "\n");
        sb.append("Número do andar: " + numeroAndar + "\n");

        return sb.toString();
    }
}
