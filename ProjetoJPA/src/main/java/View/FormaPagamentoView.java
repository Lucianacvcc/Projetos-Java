package View;

import dao.FormaPagamentoDao;
import model.FormaPagamento;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class FormaPagamentoView {
    public void cadastrarFormaPagamento () {
        // conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        String descricao = JOptionPane.showInputDialog("Digite a forma de pagamento:");
        FormaPagamento formaPagamento = new FormaPagamento(descricao);
        em.getTransaction().begin();
        formaPagamentoDao.cadastrar(formaPagamento);
        em.getTransaction().commit();
        em.close();
    }
    public String consultarFormaPagamento() {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);

        List<FormaPagamento> todosRegistros = formaPagamentoDao.buscarTodos();
        int totalRegistros = todosRegistros.size(); //quantos registros
        String resultado = "ID - DESCRICAO \n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdFormaPagamento() +
                    "-" + todosRegistros.get(i).getDescricao() + "\n";
        }
        return resultado;
    }
    public void alterarFormaPagamento(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        String descricao = JOptionPane.showInputDialog("Digite a descrição:");
        FormaPagamento formaPagamento = formaPagamentoDao.buscarporID(id);
        em.getTransaction().begin();
        formaPagamento.setDescricao(descricao);
        em.getTransaction().commit();
        em.close();
    }
    public void removerFormaPagamento(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        FormaPagamento formaPagamento = formaPagamentoDao.buscarporID(id);
        em.getTransaction().begin();
        em.remove(formaPagamento);
        em.getTransaction().commit();
        em.close();
    }

}
