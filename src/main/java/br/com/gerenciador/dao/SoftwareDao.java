package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.gerenciador.model.Software;
import br.com.gerenciador.util.HibernateUtil;

public class SoftwareDao extends GenericDao<Software>{

		private EntityManager entityManager = HibernateUtil.getEntityManager();		
	
		public List<Software> listarPorTipo (int tipo , Long marca) {
		
		EntityTransaction transaction = entityManager.getTransaction();		
		transaction.begin();		
		List<Software> lista = entityManager.createQuery("Select s from " + Software.class.getName() + " s " + " where s.uso = " + tipo +
				" and s.marca = " + marca).getResultList();		
		transaction.commit();	
		
		
		return lista;
		
		
		
	}
	
	

}
