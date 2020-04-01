/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

/**
 *
 * @author vasco
 */
public class Produtos {
    
    private int id;
    private String descricao;
    private double preco;
    private int qntd;
    private Fornecedores fornecedor;
    private Long codigobarras;
    private int estoquemin;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
    
    public int getEstoquemin() {
        return estoquemin;
    }

    public void setEstoquemin(int estoquemin) {
        this.estoquemin = estoquemin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public Long getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(Long codigobarras) {
        this.codigobarras = codigobarras;
    }

   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
    
    
}
