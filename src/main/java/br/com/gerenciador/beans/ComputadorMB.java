package br.com.gerenciador.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.dao.GenericDao;
import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Marca;
import br.com.gerenciador.model.Software;

@ViewScoped
@ManagedBean
public class ComputadorMB {

	private Computador computador = new Computador();

	private List<Computador> computadores = new ArrayList<Computador>();
	
	private Software soSelecionando;
	
	
	private String tipo;

	private Software soPesquisa = null;
	private String arquiteturaPesquisa = null;
	private Marca marcaPesquisa = null;

	
	
	public void imprimir() {
		System.out.println(soPesquisa);
	}
	
	
	public void buscarComputador() {
		if ((soPesquisa == null && arquiteturaPesquisa == "" && marcaPesquisa == null)) {

		} else if (soPesquisa != null) {

			if (arquiteturaPesquisa != "") {
				if (marcaPesquisa != null) {
					// Pesquisa os 3
				} else {
					// Pesquisa Arquitetura e SO
				}
			} else if (marcaPesquisa != null) {
				// Pesquisa por SO e Marca
			} else {
				// pesquisa só SO
			}

		}

	}

	public void buscarComputador1() {
		if ((soPesquisa == null && arquiteturaPesquisa == "" && marcaPesquisa == null)) {

		} else if (soPesquisa != null && arquiteturaPesquisa != "" && marcaPesquisa != null) {
			// pesquisa os 3{		

		} else if (soPesquisa != null) {
			
			if(arquiteturaPesquisa != "") {
				// pesquisa SO + arquitetura
			} else {
				// pesquisa SO somente
			}
			
		} else if( arquiteturaPesquisa != "") {
			
			if(marcaPesquisa != null) {
				// arquitetura + marca
			} else {
				// somente arquitetura
			}
		} else if ( marcaPesquisa != null) {
			
			if(soPesquisa != null) {
				// marca + SO
			} else {
				// somente marca
			}
		}
		
	}

	public void salvarComputador() {
		this.configuraTipo();
		GenericDao<Computador> genericDao = new GenericDao<Computador>();
		genericDao.salvar(computador);
	}

	public void configuraTipo() {
		if (this.tipo.equals("Estação")) {
			this.computador.setTipo(Computador.estacao);
		} else if (this.tipo.equals("Servidor")) {
			this.computador.setTipo(Computador.servidor);
		} else if (this.tipo.equals("Notebook")) {
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
	
	

}
