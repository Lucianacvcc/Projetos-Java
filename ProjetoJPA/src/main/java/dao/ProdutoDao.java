package dao;

import model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    //gerenciamento da entidade
    private EntityManager em;

    public ProdutoDao (EntityManager em) {
        this.em = em;
    }
    // metodo para cadastrar produto
    public void cadastrar (Produto produto) {
        // cria o registro no banco
        this.em.persist(produto);
    }
    //metodo para consultar o produto
    public List<Produto> buscarTodos () {
        String jpql = "Select p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
        // buscar apenas um registro
        public Produto buscarPorId (int id){
            return em.find(Produto.class,id);
        }
        // deletar registro
        public void removerProduto (Produto produto) {
            //carregar no JPA
            em.merge(produto);
            // remover produto
            em.remove(produto);
        }
        public void alterarProduto (Produto produto) {
            em.merge(produto);
    }
}
