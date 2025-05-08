package dao;

import model.Tipo;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoDao {
    private EntityManager em;

    public TipoDao (EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Tipo tipo) {
        this.em.persist(tipo);
    }
    public List<Tipo> buscarTodos () {
        String jpql = "SELECT t FROM Tipo t";
        return em.createQuery(jpql, Tipo.class).getResultList();
    }
    public Tipo buscarPorId(int id){
        return em.find(Tipo.class, id);
    }
    public void remover (Tipo tipo) {
        em.merge(tipo);
        em.remove(tipo);
    }
    public void alterar(Tipo tipo) {
        em.merge(tipo);
    }
}
