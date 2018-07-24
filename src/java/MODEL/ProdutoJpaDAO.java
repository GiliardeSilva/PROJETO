/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Giliarde
 */
public class ProdutoJpaDAO  implements ProdutoDAO {

    private static ProdutoJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Produto> consulta = null;

    public static ProdutoJpaDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoJpaDAO();
        }

        return instance;
    }

    @Override
    public void cadastrar(Produto produto) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produto);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Produto não foi cadastrada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void atualizar(Produto produto) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
           produto = this.entityManager.merge(produto);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Produto não foi atualizada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void deletar(Produto produto) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Produto del = this.entityManager.find(Produto.class, produto.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Produto não foi deletada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Produto> mostrarPorDescricao(String descricao) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query q = this.entityManager.createQuery("SELECT f FROM Produto f WHERE f.descricao = :descricao", Produto.class).setParameter("descricao", descricao);
            this.consulta = q.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro ao buscar Produto" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return consulta;
    }

    @Override
    public List<Produto> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Produto c", Produto.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Produtos." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Produto mostrarPorID(int codigo) {
        Produto produto = new Produto();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            produto = entityManager.find(Produto.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao buscar o Produto selecionado" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produto;
    }

}


