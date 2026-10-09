package modelo;

public class Terreno extends Financiamento {

    private String tipoZona;

    public Terreno (double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, String tipoZona) {
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imóvel: " + getValorImovel() + "\n");
        sb.append("Valor financiamento: " + calcularTotalPagamento() + "\n");
        sb.append("Taxa de juros: " + getTaxaJurosAnual() + "\n");
        sb.append("Prazo: " + getPrazoFinanciamento() + " anos\n");
        sb.append("Tipo de zona: " + tipoZona + "\n");

        return sb.toString();
    }
}
