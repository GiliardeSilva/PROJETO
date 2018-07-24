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
public class EntradaJpaDAO implements DAO<Entrada> {

    private static EntradaJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Entrada> consulta = null;

    public static EntradaJpaDAO getInstance() {
        if (instance == null) {
            instance = new EntradaJpaDAO();
        }

        return instance;
    }

    public void cadastrar(Entrada entrada) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entrada);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Entrada não foi cadastrada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    public void atualizar(Entrada entrada) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            entrada = this.entityManager.merge(entrada);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Entrada não foi atualizada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    public void deletar(Entrada entrada) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Entrada del = this.entityManager.find(Entrada.class, entrada.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Entrada não foi deletada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    public List<Entrada> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Entrada c", Entrada.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Entradas." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Entrada mostrarPorID(int codigo) {
        Entrada entrada = new Entrada();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            entrada = entityManager.find(Entrada.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao busca a Entrada selecionada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return entrada;
    }
}
