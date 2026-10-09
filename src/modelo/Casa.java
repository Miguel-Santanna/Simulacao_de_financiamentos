package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnual, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, prazoFinanciamentoAnual, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    private void verificadorExcecao(double valorJuros, double valorAcrescimo) throws AcrescimoMaiorDoQueJurosException {
        if (valorAcrescimo > (valorJuros / 2)) {
            throw new AcrescimoMaiorDoQueJurosException("Cuidado! O acréscimo é maior do que a metade dos juros da mensalidade.");
        }
    }


    public double calcularPagamentoMensal() {
        double parcela = super.calcularPagamentoMensal();

        double valorSemJuros = valorImovel / (prazoFinanciamento * 12);
        double valorJuros = parcela - valorSemJuros;

        try {
            verificadorExcecao(valorJuros, 80);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
        }

        return parcela + 80;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imóvel: " + getValorImovel() + "\n");
        sb.append("Valor financiamento: " + calcularTotalPagamento() + "\n");
        sb.append("Taxa de juros: " + getTaxaJurosAnual() + "\n");
        sb.append("Prazo: " + getPrazoFinanciamento() + " anos\n");
        sb.append("Area construida: " + areaConstruida + "\n");
        sb.append("Area do terreno: " + areaTerreno + "\n");

        return sb.toString();
    }

}
