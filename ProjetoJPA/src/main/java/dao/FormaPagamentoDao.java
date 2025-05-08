package dao;

import model.FormaPagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoDao {
    private EntityManager em;

    public FormaPagamentoDao (EntityManager em) {
        this.em = em;
    }
    public void cadastrar (FormaPagamento formaPagamento) {
        em.persist(formaPagamento);
    }
    public List<FormaPagamento> buscarTodos (){
        String jpql = "Select f FROM FormaPagamento f";
        return em.createQuery(jpql, FormaPagamento.class).getResultList();
    }
    public FormaPagamento buscarporID (int id) {
        return em.find(FormaPagamento.class,id);
    }
    public void remover(FormaPagamento formaPagamento) {
        em.merge(formaPagamento);
        em.remove(formaPagamento);
    }
    public void alterar (FormaPagamento formaPagamento) {
        em.merge(formaPagamento);
    }
}
