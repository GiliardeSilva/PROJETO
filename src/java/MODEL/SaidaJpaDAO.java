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
public class SaidaJpaDAO implements DAO<Saida> {

    private static SaidaJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Saida> consulta = null;

    public static SaidaJpaDAO getInstance() {
        if (instance == null) {
            instance = new SaidaJpaDAO();
        }

        return instance;
    }

    @Override
    public void cadastrar(Saida saida) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(saida);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Saida não foi cadastrada." + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void atualizar(Saida saida) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            saida = this.entityManager.merge(saida);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Saida não foi atualizada." + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void deletar(Saida saida) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Saida del = this.entityManager.find(Saida.class, saida.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Saida não foi deletada" + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Saida> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Saida c", Saida.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Saidas." + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Saida mostrarPorID(int codigo) {
        Saida saida = new Saida();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            saida = entityManager.find(Saida.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao busca a Saida selecionada" + ex.getMessage());

            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return saida;
    }
}
