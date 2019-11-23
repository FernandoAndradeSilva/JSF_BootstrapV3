package br.com.gerenciador.util;

import br.com.gerenciador.dao.GenericDao;
import br.com.gerenciador.dao.MonitorDao;
import br.com.gerenciador.dao.SoftwareDao;
import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Marca;
import br.com.gerenciador.model.Monitor;
import br.com.gerenciador.model.Software;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
@ViewScoped
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;

    private Marca selectedMarca = new Marca();

    private Software softwareSelecionado;


    public List<SelectItem> selectSos() {
    	
    	
    	
        List<Marca> marcas = new ArrayList<>();        
    	
    	GenericDao<Marca> genericDao = new GenericDao<Marca>();
    	
    	Marca microsft = new Marca();    	
    	microsft.setNome("Microsoft");
    	microsft.setSoftwares(genericDao.buscarPorId(3l, microsft).getSoftwares());    	
    	marcas.add(microsft);
    	
    	genericDao = new GenericDao<Marca>();    	
    	
    	Marca canonical = new Marca();    	
    	canonical.setNome("Canonical");
    	canonical.setSoftwares(genericDao.buscarPorId(8l, microsft).getSoftwares());
    	
    	marcas.add(canonical);	


        List<SelectItem> sos = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getSoftwares().stream()
                    .map(software -> new SelectItem(software, software.getVersao()))
                    .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());

        return sos;

    }


    public List<SelectItem> selectSoServidor() {       
    	
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


        List<SelectItem> sosServidor = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getSoftwares().stream()
                    .map(software -> new SelectItem(software, software.getVersao()))
                    .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());

        return sosServidor;

    }

    public List<SelectItem> selectSoEstacao() {
    	
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


        List<SelectItem> sosEstacao = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getSoftwares().stream()
                    .map(software -> new SelectItem(software, software.getVersao()))
                    .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());

        return sosEstacao;

    }

    public List<SelectItem> selectMonitores() {
    	
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


        List<SelectItem> monitores = marcas.stream().map(marca -> {
            SelectItemGroup group = new SelectItemGroup(marca.getNome());
            group.setSelectItems(marca.getMonitores().stream()
                    .map(monitor -> new SelectItem(monitor, monitor.getTamanho() + " " + monitor.getModelo()))
                    .toArray(SelectItem[]::new));
            return group;
        }).collect(toList());

        return monitores;

    }


    public List<Marca> listMarcas() {    	
    	GenericDao<Marca> dao = new GenericDao<Marca>();    	
    	List<Marca> marcas = dao.listar(Marca.class);
    	return marcas;

    }



    public Marca getSelectedMarca() {
        return selectedMarca;
    }

    public void setSelectedMarca(Marca selectedMarca) {
        this.selectedMarca = selectedMarca;
    }

    public Software getSoftwareSelecionado() {
        return softwareSelecionado;
    }

    public void setSoftwareSelecionado(Software softwareSelecionado) {
        this.softwareSelecionado = softwareSelecionado;
    }


}
