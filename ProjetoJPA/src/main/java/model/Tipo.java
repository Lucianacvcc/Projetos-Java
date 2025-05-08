package model;

import javax.persistence.*;

@Entity
@Table (name = "tipo")
public class Tipo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idTipo;
    private String descricao, abreviacao;

    public Tipo() {
    }

    public Tipo(String descricao, String abreviacao) {
        this.descricao = descricao;
        this.abreviacao = abreviacao;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
}
