package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "v_pedido")

public class PedidoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtendimento;
    private Date dataAtendimento;
    private String nomeCliente, nomeProduto;
    private int qtde;

    public PedidoConsulta() {
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQtde() {
        return qtde;
    }
}
