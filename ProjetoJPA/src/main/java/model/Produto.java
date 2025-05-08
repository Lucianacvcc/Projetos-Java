package model;

import javax.persistence.*;

@Entity
@Table (name = "produto")
public class Produto {
    // setar como ID e PK
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // auto incremente
    private int idProduto;
    private String nomeProduto;
    @Column(name="preco")
    private double valor;
    private int idTipo;

    public Produto() {
    }

    public Produto(String nomeProduto, double valor, int idTipo) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.idTipo = idTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
