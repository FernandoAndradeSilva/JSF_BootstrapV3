package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.gerenciador.model.Monitor;
import br.com.gerenciador.model.Software;
import br.com.gerenciador.util.HibernateUtil;

public class MonitorDao extends GenericDao<Monitor>{

		private EntityManager entityManager = HibernateUtil.getEntityManager();		
	
		public List<Monitor> listarPorTipo (Long marca) {
		
		EntityTransaction transaction = entityManager.getTransaction();		
		transaction.begin();		
		List<Monitor> lista = entityManager.createQuery("Select m from " + Monitor.class.getName() + " m " + " where m.marca = " + marca).getResultList();		
		transaction.commit();	
		
		
		return lista;
		
		
		
	}
	
	

}
