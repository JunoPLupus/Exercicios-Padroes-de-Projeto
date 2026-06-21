package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public non-sealed class PessoaFisica extends Pessoa {

    private static final double ALIQUOTA_IRPF = 0.11;
    private static final double ALIQUOTA_INSS = 0.11;

    private double salarioBruto;
    private double deducaoDependentes;
    private double gastosEducacao;
    private double gastosSaude;

    public PessoaFisica(long id, String nome, double salarioBruto) {
        super(id, nome);
        this.salarioBruto = salarioBruto;
    }

    public double getSalarioBruto() {
        return this.salarioBruto;
    }
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getDeducaoDependentes() {
        return this.deducaoDependentes;
    }
    public void setDeducaoDependentes(double deducaoDependentes) {
        this.deducaoDependentes = deducaoDependentes;
    }

    public double getGastosEducacao() {
        return this.gastosEducacao;
    }
    public void setGastosEducacao(double gastosEducacao) {
        this.gastosEducacao = gastosEducacao;
    }

    public double getGastosSaude() {
        return this.gastosSaude;
    }
    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    /**
     * {@inheritDoc}
     * Para Pessoa Física:
     * ```
     * INSS = salarioBruto * 11%
     * IR Parcial = (salarioBruto - deducaoDependentes - INSS) * 11%
     * IR PF = IR Parcial - (gastosEducacao + gastosSaude)
     * ```
     * @return valor em R$ do IR da Pessoa Física.
     */
    @Override
    protected double calcularIR() {
        double inss = salarioBruto * ALIQUOTA_INSS;
        double irParcial = (salarioBruto - deducaoDependentes - inss) * ALIQUOTA_IRPF;
        return irParcial - (gastosEducacao + gastosSaude);
    }

    /**
     * {@inheritDoc}
     * Para Pessoa Física:
     * ```
     * INSS = salarioBruto * 11%
     * ```
     * @return valor em R$ do INSS.
     */
    @Override
    protected double calcularOutrosImpostos() {
        return salarioBruto * ALIQUOTA_INSS;
    }
}
