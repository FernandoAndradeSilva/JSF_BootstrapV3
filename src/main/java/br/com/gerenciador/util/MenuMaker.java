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
    
    
    

    
    @PostConstruct
    public void init() {    	        
    	this.carregaSosEstacao();
    	this.carregaSosServidor();
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


	

    
    
    

}
