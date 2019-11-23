package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Software;
import br.com.gerenciador.util.HibernateUtil;

public class ComputadorDao extends GenericDao<Computador>{

		private EntityManager entityManager = HibernateUtil.getEntityManager();		
		
		public List<Computador> buscarSo(Long so) {			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.sistemaoperacional = " + so).getResultList();		
			transaction.commit();	
			return lista;	
			
		}
		
		public List<Computador> buscarArq(String arquitetura) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.arquitetura = " + arquitetura).getResultList();		
			transaction.commit();	
			return lista;	
			
			
		}
		
		public List<Computador> buscarMar(Long marca) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.marca = " + marca).getResultList();		
			transaction.commit();	
			return lista;	
			
		}
		
		
		public List<Computador> buscarSoArq (Long so , String arquitetura) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.sistemaoperacional = " + so +
					" and c.arquitetura = " + arquitetura).getResultList();		
			transaction.commit();	
			return lista;				
		}			
		
		public List<Computador> buscarSoMar (Long so , Long marca) {
		
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.sistemaoperacional = " + so +
					" and c.marca = " + marca).getResultList();		
			transaction.commit();	
			return lista;				
		
	}		
		
		public List<Computador> buscarArqMar (String arq , Long marca) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.arquitetura = " + arq +
					" and c.marca = " + marca).getResultList();		
			transaction.commit();	
			return lista;	
		
	}
		
		public List<Computador> buscarMarSo(Long marca ,  Long so) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.marca = " + marca +
					" and c.so = " + so).getResultList();		
			transaction.commit();	
			return lista;	
		
	}
		
	
	

}
