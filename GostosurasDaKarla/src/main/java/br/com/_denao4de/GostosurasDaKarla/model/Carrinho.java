package br.com._denao4de.GostosurasDaKarla.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Carrinho {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    private Produto produto;

    @NotNull 
    private int quantidade;
    
    @NotNull 
    private Double precoUni;

    @NotNull 
    private int subTotal;

    public Carrinho() {
    }

    public Carrinho(@NotBlank Produto produto, @NotNull int quantidade, @NotNull Double precoUni,
            @NotNull int subTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUni = precoUni;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUni() {
        return precoUni;
    }

    public void setPrecoUni(Double precoUni) {
        this.precoUni = precoUni;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    
    
    

    
    
}
