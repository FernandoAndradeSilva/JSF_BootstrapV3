package br.com.gerenciador.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gerenciador.dao.ComputadorDao;
import br.com.gerenciador.dao.GenericDao;
import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Marca;
import br.com.gerenciador.model.Software;
import br.com.gerenciador.model.Usuario;

@ViewScoped
@ManagedBean
public class ComputadorMB {	
	
	private Usuario usuarioResponsavel = new Usuario();
	
	private Computador computador = new Computador();
	
	private GenericDao<Computador> dao = new GenericDao<Computador>(); 

	private List<Computador> computadores = new ArrayList<Computador>();
	
	private Software soSelecionando = new Software();
	
	private Long idItem;
	
	private String tipo;

	private Software soPesquisa = new Software();
	private String arquiteturaPesquisa = null;
	private Marca marcaPesquisa = new Marca();
	
	
	
	
	
	public String retornaNomeTipo() {
		
		if(tipo.equals("1")) {
			return "SERVIDORES";
		} else if(tipo.equals("2")) {
			return "ESTAÇÕES";
		} else
			return "NOTEBOOKS";
	}
	
	public void printTest() {
		
		Computador pc = new Computador();		
		pc = dao.buscarPorId(idItem, pc);		
		this.computador = pc;
		
		
		if(pc.getTipo() == 1) {
			this.tipo = "servidor";
		} else if(pc.getTipo() == 2) {
			this.tipo = "estacao";
		} else {
			this.tipo = "notebook";
		}
		
		
	}
	
	public String remover(Long id) {
		GenericDao<Computador> dao = new GenericDao<Computador>();
		
		Computador pc = new Computador();
		
		pc.setId(id);
		
		dao.buscar(pc);
		
		System.out.println(pc);
		
		dao = new GenericDao<Computador>();
		
		dao.deletarPorId(pc);

		FacesContext.getCurrentInstance().addMessage(
		        null, new FacesMessage("Computador Excluído com sucesso"));
		FacesContext.getCurrentInstance()
	    .getExternalContext()
	    .getFlash().setKeepMessages(true);
		
		
		return "listProdutos?tipo=2&faces-redirect=true";
		
		
		
	}
	
	public void buscarUsuarioResponsavel(Long idUsuario) {
		
		GenericDao<Usuario> dao = new GenericDao<Usuario>();
		
		Usuario user = new Usuario();		
		usuarioResponsavel = dao.buscarPorId(idUsuario, user);
		
		
		
	}


	public void buscarComputador1() {		
		int tipo = Integer.parseInt(this.tipo);		
		
		ComputadorDao computadorDao = new ComputadorDao();	
		
		
		if ((soPesquisa == null && arquiteturaPesquisa == "" && marcaPesquisa == null)) {

		} else if (soPesquisa != null && arquiteturaPesquisa != "" && marcaPesquisa != null) {
			// pesquisa os 3
			
			

		} else if (soPesquisa != null) {			
			if(arquiteturaPesquisa != "" ) {
				// pesquisa SO + arquitetura
				computadores = computadorDao.buscarSoArq(soPesquisa.getId(), arquiteturaPesquisa , tipo);			
			} else {
				
				if(marcaPesquisa == null) {
					// somente SO
					computadores = computadorDao.buscarSo(soPesquisa.getId() , tipo);
				} else 				
					// pesquisa SO e Marca
					computadores = computadorDao.buscarMarSo(marcaPesquisa.getId(), soPesquisa.getId() , tipo);

				
			}
			
		} else if( arquiteturaPesquisa != "") {			
			if(marcaPesquisa != null) {				
				// arquitetura + marca
				computadores = computadorDao.buscarArqMar(arquiteturaPesquisa, marcaPesquisa.getId() , tipo);
				
			} else {
				
				if(soPesquisa == null) {
					// someente arquitetura
					computadores = computadorDao.buscarArq(arquiteturaPesquisa, tipo);
				} else 				
				// pesquisa arquitetura + so
				computadores = computadorDao.buscarSoArq(soPesquisa.getId(), arquiteturaPesquisa, tipo);
			}
			
			
		} else if ( marcaPesquisa != null) {
			
			if(soPesquisa != null) {
				// marca + SO
				computadores = computadorDao.buscarMarSo(marcaPesquisa.getId(), soPesquisa.getId() , tipo);

			} else {
				
				if(soPesquisa == null) {
					// somente marca
					computadores = computadorDao.buscarMar(marcaPesquisa.getId(), tipo);
				}			
				// marca + arquitetura
				computadores = computadorDao.buscarArqMar(arquiteturaPesquisa, marcaPesquisa.getId(), tipo);
			}
		}
		
	}

	public String salvarComputador() throws IOException {
		
		
		GenericDao<Computador> genericDao = new GenericDao<Computador>();
		
		String mensagem;
		
		if(idItem != null) {
			genericDao.updateMerge(computador);
			mensagem = "Informações atualizadas";
			
		} else {
			this.configuraTipo();
			genericDao.salvar(computador);
			mensagem = "Computador cadastrado";
		}		
		
		
		computador = new Computador();		
		
		FacesContext.getCurrentInstance().addMessage(
		        null, new FacesMessage(mensagem));
		FacesContext.getCurrentInstance()
	    .getExternalContext()
	    .getFlash().setKeepMessages(true);

		
		return "index?faces-redirect=true";

		 
		
	}

	public void configuraTipo() {
		if (this.tipo.equals("estacao")) {
			this.computador.setTipo(Computador.estacao);
		} else if (this.tipo.equals("servidor")) {
			this.computador.setTipo(Computador.servidor);
		} else if (this.tipo.equals("notebook")) {
			this.computador.setTipo(Computador.notebook);
		}

	}

	public boolean verificaEstacao(String tipo) {

		if (tipo.equals("ESTACAO")) {
			return true;
		} else
			return false;
	}

	public Computador getComputador() {
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Software getSoPesquisa() {
		return soPesquisa;
	}

	public void setSoPesquisa(Software soPesquisa) {
		this.soPesquisa = soPesquisa;
	}

	public String getArquiteturaPesquisa() {
		return arquiteturaPesquisa;
	}

	public void setArquiteturaPesquisa(String arquiteturaPesquisa) {
		this.arquiteturaPesquisa = arquiteturaPesquisa;
	}

	public Marca getMarcaPesquisa() {
		return marcaPesquisa;
	}

	public void setMarcaPesquisa(Marca marcaPesquisa) {
		this.marcaPesquisa = marcaPesquisa;
	}


	public Software getSoSelecionando() {
		return soSelecionando;
	}


	public void setSoSelecionando(Software soSelecionando) {
		this.soSelecionando = soSelecionando;
	}

	public List<Computador> getComputadores() {
		return computadores;
	}

	public void setComputadores(List<Computador> computadores) {
		this.computadores = computadores;
	}




	public Long getIdItem() {
		return idItem;
	}
	
	



	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}


	
	


	
	

}
