package br.com.gerenciador.util;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.view.ViewScoped;

import br.com.gerenciador.dao.GenericDao;
import br.com.gerenciador.dao.MonitorDao;
import br.com.gerenciador.dao.SoftwareDao;
import br.com.gerenciador.model.Marca;
import br.com.gerenciador.model.Software;


@ViewScoped
@ManagedBean
public class MenuMaker implements Serializable {

    private static final long serialVersionUID = 1L;   
    
    
    
    private Product selectedProduct;
    
    
    private List<Marca> marcas;
    
    private List<SelectItem> sosEstacao;    
    private List<SelectItem> sosServidor;
    private List<SelectItem> monitores;
    private List<Marca> marcasList;

    

    
    @PostConstruct
    public void init() {    	        
    	this.carregaSosEstacao();
    	this.carregaSosServidor();
    	this.carregaMonitores();
    	this.carregaListMarcas();
    }   
    
    
    private void carregaSosEstacao() {   	    	
    	
    	List<Marca> marcas = new ArrayList<>();    	
    	SoftwareDao sd = new SoftwareDao();		
    	
    	Marca microsoft = new Marca();
    	microsoft.setNome("Microsoft");
    	microsoft.setSoftwares(sd.listarPorTipo(2 , 3l));
		
    	marcas.add(microsoft);
    	
    	sd = new SoftwareDao();		
     	
     	Marca canonical = new Marca();
     	canonical.setNome("Canonical");
     	canonical.setSoftwares(sd.listarPorTipo(2 , 8l));
    	
     	marcas.add(canonical);        

     	sosEstacao = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getSoftwares().stream()
                .map(software -> new SelectItem(software, software.getVersao()))
                .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());    
        
    }
    
    private void carregaSosServidor() {
    	
    	List<Marca> marcas = new ArrayList<>();    	
    	SoftwareDao sd = new SoftwareDao();		
    	
    	Marca microsoft = new Marca();
    	microsoft.setNome("Microsoft");
    	microsoft.setSoftwares(sd.listarPorTipo(1 , 3l));
		
    	marcas.add(microsoft);
    	
    	sd = new SoftwareDao();		
     	
     	Marca canonical = new Marca();
     	canonical.setNome("Canonical");
     	canonical.setSoftwares(sd.listarPorTipo(1 , 8l));
    	
     	marcas.add(canonical);        

     	sosServidor = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getSoftwares().stream()
                .map(software -> new SelectItem(software, software.getVersao()))
                .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());    
        
    }
    	
    public void carregaMonitores() {
    	
    	List<Marca> marcas = new ArrayList<>();    	
    	MonitorDao md = new MonitorDao();		
    	
    	Marca samsung = new Marca();
    	samsung.setNome("SAMSUNG");
    	samsung.setMonitores(md.listarPorTipo(1l));
		
    	marcas.add(samsung);
    	
    	md = new MonitorDao();		
     	
    	Marca lg = new Marca();
    	lg.setNome("LG");
    	lg.setMonitores(md.listarPorTipo(2l));
		
    	marcas.add(lg);


        monitores = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getMonitores().stream()
                    .map(monitor -> new SelectItem(monitor, monitor.getTamanho() + " " + monitor.getModelo()))
                    .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());



    }	
    
    public void carregaListMarcas() {    	
    	GenericDao<Marca> dao = new GenericDao<Marca>();    	
    	List<Marca> marcas = dao.listar(Marca.class);
    	this.marcasList = marcas;

    }
    
    
    
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }



	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}


	public List<SelectItem> getSosEstacao() {
		return sosEstacao;
	}


	public void setSosEstacao(List<SelectItem> sosEstacao) {
		this.sosEstacao = sosEstacao;
	}


	public List<SelectItem> getSosServidor() {
		return sosServidor;
	}


	public void setSosServidor(List<SelectItem> sosServidor) {
		this.sosServidor = sosServidor;
	}


	public List<SelectItem> getMonitores() {
		return monitores;
	}


	public void setMonitores(List<SelectItem> monitores) {
		this.monitores = monitores;
	}


	public List<Marca> getMarcasList() {
		return marcasList;
	}


	public void setMarcasList(List<Marca> marcasList) {
		this.marcasList = marcasList;
	}

	
	

    
    
    

}
