package View;

import dao.TipoDao;
import model.Tipo;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class TipoView {
    public void cadastrarTipo() {
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);
        //digitar os atributos da classe
        String descricao = JOptionPane.showInputDialog("Digite a descrição do tipo:");
        String abreviacao = JOptionPane.showInputDialog("Digite a abreviação:");
        //instanciar a classe
        Tipo tipo = new Tipo(descricao, abreviacao);
        // cadastrar na base de dados
        em.getTransaction().begin();
        tipoDao.cadastrar(tipo);
        em.getTransaction().commit();
        em.close();
    }
    public String consultarTipo() {
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);

        List<Tipo> todosRegistros = tipoDao.buscarTodos();
        int totalRegistros = todosRegistros.size();

        String resultado = "ID - DESCRIÇÃO - ABREVIAÇÃO\n";
        for(int i=0; i <totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdTipo() + " - " +
                    todosRegistros.get(i).getDescricao() + " - " +
                    todosRegistros.get(i).getAbreviacao() + "\n";
        }
        return resultado;
    }
    public void alterarTipo(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);

        String descricao = JOptionPane.showInputDialog("Digite a descrição:");
        String abreviacao = JOptionPane.showInputDialog("Digite a abreviação:");

        Tipo tipo = tipoDao.buscarPorId(id);
        em.getTransaction().begin();
        tipoDao.alterar(tipo);
        tipo.setDescricao(descricao);
        tipo.setAbreviacao(abreviacao);
        em.getTransaction().commit();
        em.close();
    }
    public void removerTipo(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);
        Tipo tipo = tipoDao.buscarPorId(id);
        em.getTransaction().begin();
        em.remove(tipo);
        em.getTransaction().commit();
        em.close();
    }
}
