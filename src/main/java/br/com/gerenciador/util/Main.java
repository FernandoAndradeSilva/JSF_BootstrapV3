package br.com.gerenciador.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.gerenciador.dao.ComputadorDao;
import br.com.gerenciador.dao.MonitorDao;
import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Monitor;



public class Main {
	
	
	@Test
	public void teste() {	
		
		ComputadorDao dao = new ComputadorDao();
		
		List<Computador> pcs = new ArrayList<Computador>();
		
		pcs = dao.buscarArq("64b" , 3);
		
		//MonitorDao sd = new MonitorDao();			
		//List<Monitor> monits = new ArrayList<Monitor>();		
		//monits = sd.listarPorTipo(1l);
		
		System.out.println(pcs);
		
		
//		GenericDao<Marca> genericDao = new GenericDao<Marca>();
//    	
//    	Marca microsft = new Marca();    	
//    	microsft.setNome("Microsoft");
//    	microsft.setSoftwares(genericDao.buscarPorId(3l, microsft).getSoftwares());    	
//    	System.out.println(microsft.getSoftwares());
//    	
//    	
//    	genericDao = new GenericDao<Marca>();
//    	Marca canonical = new Marca();    	
//    	canonical.setNome("Canonical");
//    	canonical.setSoftwares(genericDao.buscarPorId(8l, canonical).getSoftwares());    	
//    	System.out.println(canonical.getSoftwares());
//    	
    	

       
		
		//List<Marca> marcas = genericDao.g
		
		//HibernateUtil.getEntityManager();

		
	}

}
