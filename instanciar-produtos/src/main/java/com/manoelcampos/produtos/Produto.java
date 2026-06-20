package com.manoelcampos.produtos;

import com.manoelcampos.exception.CampoObrigatorioException;
import com.manoelcampos.exception.DataAtualizacaoInvalidaException;
import com.manoelcampos.exception.NumeroNegativoException;

import java.time.LocalDate;

/**
 * Produto da loja.
 * A instanciação deve ser feita exclusivamente via {@link ProdutoBuilder}.
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private final LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    private String categoria;
    private String urlFoto;

    /**
     * Construtor privado — use {@link ProdutoBuilder} para criar instâncias.
     * @param builder builder com os dados do produto.
     */
    private Produto(ProdutoBuilder builder) {
        setId(builder.id);
        setCodigoEan(builder.codigoEan);
        setDescricao(builder.descricao);
        setMarca(builder.marca);
        setModelo(builder.modelo);
        setPreco(builder.preco);
        this.dataCadastro = builder.dataCadastro;
        setDataUltimaAtualizacao(builder.dataUltimaAtualizacao);
        setEstoque(builder.estoque);
        setCategoria(builder.categoria);
        setUrlFoto(builder.urlFoto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(id <= 0) throw new CampoObrigatorioException("id");

        this.id = id;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        if(codigoEan == null) this.codigoEan = "";
        else this.codigoEan = codigoEan;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao == null || descricao.isBlank()) throw new CampoObrigatorioException("descricao");

        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if(marca == null || marca.isBlank()) throw new CampoObrigatorioException("marca");

        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if(marca == null) throw new CampoObrigatorioException("marca");

        if(modelo == null) this.modelo = "";
        else this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco <= 0) throw new CampoObrigatorioException("preco");

        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    /**
     * @param dataUltimaAtualizacao data da última atualização; não pode ser anterior à {@link #dataCadastro}.
     * @throws DataAtualizacaoInvalidaException se a data for anterior à data de cadastro.
     */
    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if(dataUltimaAtualizacao != null && dataUltimaAtualizacao.isBefore(this.dataCadastro)) throw new DataAtualizacaoInvalidaException();

        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque estoque do produto; não pode ser negativo.
     * @throws NumeroNegativoException se o estoque for negativo.
     */
    public void setEstoque(int estoque) {
        if(estoque < 0) throw new NumeroNegativoException("estoque");

        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if(categoria == null || categoria.isBlank()) throw new CampoObrigatorioException("categoria");

        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        if(urlFoto == null) this.urlFoto = "";
        else this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "\nProduto " + id +
                " => Código Ean:'" + codigoEan + '\'' +
                " | Descrição:'" + descricao + '\'' +
                " | Marca:'" + marca + '\'' +
                " | Modelo:'" + modelo + '\'' +
                " | Preço: R$" + preco +
                " | Data de Cadastro: " + dataCadastro +
                " | Data da Ultima Atualização:" + dataUltimaAtualizacao +
                " | Estoque:" + estoque +
                " | Categoria:'" + categoria + '\'' +
                " | Url da Foto:'" + urlFoto + '\'';
    }

    /**
     * Builder para instanciar {@link Produto} de forma clara e segura.
     *
     * <p>Atributos obrigatórios são exigidos no construtor.
     * Atributos opcionais são definidos via métodos fluentes antes de chamar {@link #build()}.</p>
     *
     * <p>Exemplo de uso:</p>
     * <pre>{@code
     * Produto p = new Produto.ProdutoBuilder(1, "Teclado", "KODI", 120.0, "Periféricos")
     *                 .modelo("K70")
     *                 .estoque(10)
     *                 .build();
     * }</pre>
     */
    public static class ProdutoBuilder {
        private long id;
        private String codigoEan;
        private String descricao;
        private String marca;
        private String modelo;
        private double preco;
        private final LocalDate dataCadastro;
        private LocalDate dataUltimaAtualizacao;
        private int estoque = 0;
        private String categoria;
        private String urlFoto;

        /**
         * @param id        identificador do produto (obrigatório, maior que zero).
         * @param descricao descrição do produto (obrigatório).
         * @param marca     marca do produto (obrigatório).
         * @param preco     preço do produto (obrigatório, maior que zero).
         * @param categoria categoria do produto (obrigatório).
         */
        public ProdutoBuilder(long id, String descricao, String marca, double preco, String categoria) {
            this.id = id;
            this.descricao = descricao;
            this.marca = marca;
            this.preco = preco;
            this.categoria = categoria;
            this.dataCadastro = LocalDate.now();
            this.dataUltimaAtualizacao = this.dataCadastro;
        }

        public ProdutoBuilder codigoEan(String codigoEan) {
            this.codigoEan = codigoEan;
            return this;
        }

        public ProdutoBuilder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        /**
         * @param dataUltimaAtualizacao data da última atualização; não pode ser anterior à data de cadastro.
         */
        public ProdutoBuilder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        /**
         * @param estoque estoque do produto; não pode ser negativo.
         */
        public ProdutoBuilder estoque(int estoque) {
            this.estoque = estoque;
            return this;
        }

        public ProdutoBuilder urlFoto(String urlFoto) {
            this.urlFoto = urlFoto;
            return this;
        }

        /**
         * Constrói e retorna o {@link Produto} com os dados configurados.
         * As validações são aplicadas neste momento.
         */
        public Produto build() {
            return new Produto(this);
        }
    }
}
