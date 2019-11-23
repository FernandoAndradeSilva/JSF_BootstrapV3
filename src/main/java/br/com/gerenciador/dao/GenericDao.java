package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.gerenciador.model.Software;
import br.com.gerenciador.util.HibernateUtil;

public class GenericDao<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}

	public E buscar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}

	public E buscarPorId(Long id, E entidade) {
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}

	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		return entidadeSalva;
	}

	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager
				.createNativeQuery(
						"delele from " + entidade.getClass().getSimpleName().toLowerCase() + "where id =" + id)
				.executeUpdate();

		transaction.commit();
	}

	public List<E> listar(Class<E> entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();	
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();

		return lista;

	}

	public List<E> listarPorTipo(Class<E> entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		List<E> lista = entityManager.createQuery("Select s from " + entidade.getName() + " s ")
				.getResultList();
		transaction.commit();

		return lista;

	}



}
