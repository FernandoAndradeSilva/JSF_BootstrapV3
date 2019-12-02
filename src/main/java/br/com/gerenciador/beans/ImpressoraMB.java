package br.com.gerenciador.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.dao.ComputadorDao;
import br.com.gerenciador.dao.GenericDao;
import br.com.gerenciador.model.Computador;
import br.com.gerenciador.model.Impressora;
import br.com.gerenciador.model.Marca;
import br.com.gerenciador.model.Software;

@ViewScoped
@ManagedBean
public class ImpressoraMB {

	private Impressora impressora = new Impressora();

	private List<Impressora> impressoras = new ArrayList<Impressora>();
	
	private Long idItem;
	
	
	private String tipo;

	private Software soPesquisa = new Software();
	private String arquiteturaPesquisa = null;
	private Marca marcaPesquisa = null;

	public String retornaNomeTipo() {

		if (tipo.equals("1")) {
			return "SERVIDORES";
		} else if (tipo.equals("2")) {
			return "ESTAÇÕES";
		} else
			return "NOTEBOOKS";
	}

	public boolean verificaEstacao(String tipo) {

		if (tipo.equals("ESTACAO")) {
			return true;
		} else
			return false;
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

	public Impressora getImpressora() {
		return impressora;
	}

	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	
	

}
