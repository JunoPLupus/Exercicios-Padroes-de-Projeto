package com.manoelcampos.impostorenda;

/**
 * @author Juno Piazza Lopes
 */
public non-sealed class PessoaJuridica extends Pessoa {

    private static final double ALIQUOTA_IRPJ = 0.15;
    private static final double ALIQUOTA_IRPJ_ADICIONAL = 0.10;
    private static final double LIMITE_COBRANCA_IR = 20_000;
    private static final double ALIQUOTA_CSLL = 0.09;
    private static final double ALIQUOTA_ICMS = 0.05;

    private double lucro;
    private double valorProdutos;

    public PessoaJuridica(long id, String nome, double lucro, double valorProdutos) {
        super(id, nome);
        this.lucro = lucro;
        this.valorProdutos = valorProdutos;
    }

    public double getLucro() {
        return this.lucro;
    }
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getValorProdutos() {
        return this.valorProdutos;
    }
    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    /**
     * {@inheritDoc}
     * Para Pessoa Jurídica (regime Lucro Real):
     * ```
     * IR Parcial = lucro * 15%
     * IR Excedente = IR Parcial - R$20.000 (se positivo, paga 10% sobre o excedente)
     * IR PJ = IR Parcial + (IR Excedente > 0 ? IR Excedente * 10% : 0)
     * ```
     * @return valor em R$ do IR da Pessoa Jurídica.
     */
    @Override
    protected double calcularIR() {
        double irParcial = lucro * ALIQUOTA_IRPJ;
        double irExcedente = irParcial - LIMITE_COBRANCA_IR;
        return irParcial + (irExcedente > 0 ? irExcedente * ALIQUOTA_IRPJ_ADICIONAL : 0);
    }

    /**
     * {@inheritDoc}
     * Para Pessoa Jurídica:
     * ```
     * CSLL = lucro * 9% e ICMS = valorProdutos * 5%
     * ```
     * @return valor em R$ da soma de CSLL + ICMS.
     */
    @Override
    protected double calcularOutrosImpostos() {
        double csll = lucro * ALIQUOTA_CSLL;
        double icms = valorProdutos * ALIQUOTA_ICMS;
        return csll + icms;
    }
}
