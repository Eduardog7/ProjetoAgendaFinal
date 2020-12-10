/**
 * 
 */
package br.com.acme.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.utils.JPAUtil;
import br.com.acme.agenda.model.Usuario;
//import br.com.acme.agenda.service.ServiceLogin;

/**
 * @author TERCEIRA CAMADA
 *
 */
public class ContatoDaoImpl implements ContatoDao {

	@Override
	public void salvar(Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(contato);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Contato> listarContatos() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Query consulta = entityManager.createQuery("SELECT c FROM Contato c");
		List<Contato> listaDeContatosDoBancoDeDados = consulta.getResultList();
		entityManager.close();
		return listaDeContatosDoBancoDeDados;
	}

	@Override
	public void remover(Long idContato) {
		try {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			Contato contato = entityManager.find(Contato.class, idContato);
			entityManager.remove(contato);
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch(NoResultException e){
			e.getMessage();
			
		}
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contato = entityManager.find(Contato.class, idContato);
		entityManager.getTransaction().commit();
		entityManager.close();
		return contato;
	}

	@Override
	public void editarContato(Long idContato, Contato contato) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contatoQueTavaNoBanco = entityManager.find(Contato.class, idContato);
		contatoQueTavaNoBanco.setAtivo(contato.isAtivo());
		contatoQueTavaNoBanco.setEmail(contato.getEmail());
		contatoQueTavaNoBanco.setTelefone(contato.getTelefone());
		contatoQueTavaNoBanco.setNome(contato.getNome());
		
		entityManager.merge(contatoQueTavaNoBanco);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public Contato buscaContatoPorEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			return entityManager.createNamedQuery("Contato.buscaContatoPorEmail", Contato.class)
					.setParameter("email", email)
					.getSingleResult();
		}catch(NoResultException e){
			e.getMessage();
		}
		return null;
	}

	@Override
	public void ativarDesativarContato(Long id) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Contato contatoQueTavaNoBanco = entityManager.find(Contato.class, id);
		if(contatoQueTavaNoBanco != null) {
			if (contatoQueTavaNoBanco.isAtivo()) {
				contatoQueTavaNoBanco.setAtivo(false);
				entityManager.merge(contatoQueTavaNoBanco);
				entityManager.getTransaction().commit();
				entityManager.close();
			} else {
				contatoQueTavaNoBanco.setAtivo(true);
				entityManager.merge(contatoQueTavaNoBanco);
				entityManager.getTransaction().commit();
				entityManager.close();
			}
			
		}

	}
	
}










