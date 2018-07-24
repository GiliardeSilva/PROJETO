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
public class FornecedorJpaDAO implements FornecedorDAO {

    private static FornecedorJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Fornecedor> consulta = null;

    public static FornecedorJpaDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorJpaDAO();
        }

        return instance;
    }

    @Override
    public void cadastrar(Fornecedor fornecedor) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(fornecedor);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Fornecedor não foi cadastrada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            fornecedor = this.entityManager.merge(fornecedor);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Fornecedor não foi atualizada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void deletar(Fornecedor fornecedor) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Fornecedor del = this.entityManager.find(Fornecedor.class, fornecedor.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Fornecedor não foi deletada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Fornecedor> mostrarPorCnpj(String cnpj) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query q = this.entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj", Fornecedor.class).setParameter("cnpj", cnpj);
            this.consulta = q.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro ao buscar Fornecedor" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return consulta;
    }

    @Override
    public List<Fornecedor> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Fornecedor c", Fornecedor.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Fornecedores." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Fornecedor mostrarPorID(int codigo) {
        Fornecedor fornecedor = new Fornecedor();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            fornecedor = entityManager.find(Fornecedor.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao busca a Fornecedor selecionada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return fornecedor;
    }

}


