package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public abstract sealed class Pessoa permits PessoaFisica, PessoaJuridica {
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Calcula o total de impostos pagos pela pessoa, garantindo que o IR seja sempre incluído.
     * @return soma do IR com os demais impostos específicos do tipo de pessoa.
     */
    public final double calcularTotalImpostos() {
        return calcularIR() + calcularOutrosImpostos();
    }

    /**
     * Calcula o Imposto de Renda (IR) devido.
     * A fórmula varia conforme o tipo de pessoa (física ou jurídica).
     * @return valor em R$ do IR a pagar.
     */
    protected abstract double calcularIR();

    /**
     * Calcula os impostos adicionais ao IR, específicos do tipo de pessoa.
     * @return valor em R$ dos impostos adicionais.
     */
    protected abstract double calcularOutrosImpostos();
}
