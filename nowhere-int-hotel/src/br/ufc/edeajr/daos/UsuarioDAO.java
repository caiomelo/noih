package br.ufc.edeajr.daos;

import javax.management.Query;

import br.ufc.edeajr.model.Usuario;

@Component
public class UsuarioDAO extends JPAGenericDao<Usuario, Long> implements IJPAGenericDao<Usuario, Long>{

	public UsuarioDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public boolean existeEmail(String email) {
		try {
			Query query = em.createQuery("SELECT u.email FROM Usuario u where u.email = :email", Usuario.class);
			query.setParameter("email", email);
			query.getSingleResult(); // Executa a jpql e se não encontrar nada throws exception
		} catch(NoResultException e) {
			return false;
		}
		return true;
	}
	
	public boolean existeLogin(String login) {
		try {
			Query query = em.createQuery("SELECT u.login FROM Usuario u where u.login = :login", Usuario.class);
			query.setParameter("login", login);
			query.getSingleResult(); // Executa a jpql e se não encontrar nada throws NoResultException
		} catch(NoResultException e) {
			return false; 
		}
		return true;
	}
	
	 public Usuario login(String login, String senha) {
		 Usuario usuario = null;
		 try {
			 Query query = em.createQuery("SELECT u FROM Usuario u where u.login = :login AND u.senha = :senha", Usuario.class);
			 query.setParameter("login", login);
			 query.setParameter("senha", senha);
			 usuario = (Usuario) query.getSingleResult();
		 } catch (NoResultException e){
			 return null;
		 }
		 return usuario;
	}

}