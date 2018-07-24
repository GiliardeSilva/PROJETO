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
public class CategoriaJpaDAO implements CategoriaDAO {

    private static CategoriaJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Categoria> consulta = null;

    public static CategoriaJpaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaJpaDAO();
        }

        return instance;
    }

    @Override
    public void cadastrar(Categoria categoria) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(categoria);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Categoria não foi cadastrada." + ex.getMessage());
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void atualizar(Categoria categoria) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            categoria = this.entityManager.merge(categoria);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Categoria não foi atualizada." + ex.getMessage());
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void deletar(Categoria categoria) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Categoria del = this.entityManager.find(Categoria.class, categoria.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Categoria não foi deletada" + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Categoria> mostrarPorDescricao(String descricao) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query q = this.entityManager.createQuery("SELECT f FROM Categoria f WHERE f.descricao = :descricao", Categoria.class).setParameter("descricao", descricao);
            this.consulta = q.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro ao buscar Categoria" + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return consulta;
    }

    @Override
    public List<Categoria> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Categoria c", Categoria.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Categorias." + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Categoria mostrarPorID(int codigo) {
        Categoria categoria = new Categoria();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            categoria = entityManager.find(Categoria.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao busca a Categoria selecionada" + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return categoria;
    }

}
