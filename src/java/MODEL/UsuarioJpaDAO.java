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
public class UsuarioJpaDAO implements UsuarioDAO {

    private static UsuarioJpaDAO instance = null;
    private EntityManager entityManager = null;
    private List<Usuario> consulta = null;

    public static UsuarioJpaDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioJpaDAO();
        }

        return instance;
    }

    @Override
    public void cadastrar(Usuario usuario) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(usuario);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Usuario não foi cadastrada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            usuario = this.entityManager.merge(usuario);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Usuario não foi atualizada." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void deletar(Usuario usuario) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            Usuario del = this.entityManager.find(Usuario.class, usuario.getCodigo());
            this.entityManager.remove(del);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("A Usuario não foi deletada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Usuario> mostrarPorCpf(String cpf) {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query q = this.entityManager.createQuery("SELECT f FROM Usuario f WHERE f.cpf = :cpf", Usuario.class).setParameter("cpf", cpf);
            this.consulta = q.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro ao buscar Usuario" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return consulta;
    }

    @Override
    public List<Usuario> mostrarTodos() {
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select c from Usuario c", Usuario.class);
            this.consulta = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("ocorreu um erro ao listar as Usuarios." + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.consulta;
    }

    @Override
    public Usuario mostrarPorID(int codigo) {
        Usuario usuario = new Usuario();
        this.entityManager = EntityFactory.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            usuario = entityManager.find(Usuario.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("erro ao busca a Usuario selecionada" + ex.getMessage());
            
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return usuario;
    }

}
