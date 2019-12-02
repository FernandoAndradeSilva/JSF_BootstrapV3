package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Software;
import br.com.gerenciador.util.HibernateUtil;

public class ComputadorDao extends GenericDao<Computador>{

		private EntityManager entityManager = HibernateUtil.getEntityManager();		
		
		public List<Computador> buscarSo(Long so, int tipo) {	
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c "  + " where c.sistemaOperacional  = " + so + " and c.tipo = " + tipo).getResultList();		
			transaction.commit();				

			return lista;	
			
			
		}
		
		public List<Computador> buscarMar(Long marca, int tipo) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.marca = " + marca + " and c.tipo = " + tipo).getResultList();		
			transaction.commit();	
			return lista;	
			
		}
		
		
		public List<Computador> buscarArq(String arquitetura, int tipo) {
			
			System.out.println(arquitetura);
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.arquitetura = :param and c.tipo = " + tipo + " and c.tipo = " + tipo).setParameter("param", arquitetura).getResultList();		
			transaction.commit();	
			return lista;	
			
			
		}
		

		
		public List<Computador> buscarSoArq (Long so , String arquitetura, int tipo) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.sistemaOperacional = " + so +
					" and c.arquitetura = :param and c.tipo = " + tipo).setParameter("param", arquitetura).getResultList();		
			transaction.commit();	
			return lista;				
		}			
		
		public List<Computador> buscarSoMar (Long marca , Long so, int tipo) {
		
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.sistemaOperacional = " + so +
					" and c.marca = " + marca + " and c.tipo = " + tipo).getResultList();		
			transaction.commit();	
			return lista;				
		
	}		
		
		public List<Computador> buscarArqMar (String arq , Long marca, int tipo) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.arquitetura = :param and c.marca = " + marca + " and c.tipo = " + tipo).setParameter("param", arq).getResultList();		
			transaction.commit();	
			return lista;	
		
	}
		
		public List<Computador> buscarMarSo(Long marca ,  Long so, int tipo) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.marca = " + marca +
					" and c.sistemaOperacional = " + so + " and c.tipo = " + tipo).getResultList();		
			transaction.commit();	
			return lista;	
		
	}
		
		public List<Computador> buscarMarSoArquitetura(Long marca ,  Long so, String arquitetura, int tipo) {
			
			EntityTransaction transaction = entityManager.getTransaction();		
			transaction.begin();		
			List<Computador> lista = entityManager.createQuery("Select c from " + Computador.class.getName() 
					+ " c " + " where c.marca = " + marca +
					" and c.sistemaOperacional = " + so + " and c.tipo = " + tipo + " and c.arquitetura = :param").setParameter("param", arquitetura).getResultList();		
			transaction.commit();	
			return lista;	
		
	}
		
	
	

}
