package br.com.gerenciador.model;

import java.io.Serializable;

public class Impressora implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String matricula;
	private String serial;
	private String modelo;	
	private String tipo;
	private String suprimentos;	
	private String impressao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSuprimentos() {
		return suprimentos;
	}
	public void setSuprimentos(String suprimentos) {
		this.suprimentos = suprimentos;
	}
	public String getImpressao() {
		return impressao;
	}
	public void setImpressao(String impressao) {
		this.impressao = impressao;
	}
	
	
	

}
