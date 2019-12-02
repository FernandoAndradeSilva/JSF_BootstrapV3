package br.com.gerenciador.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Computador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    public static final int estacao = 2;
    public static final int servidor = 1;
    public static final int notebook = 3;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String matricula;
	private String serial;
	private String modelo;
	private String processador;
	private String memoria;
	private String hd;
	private String arquitetura;
	private String observacoes;
	private String tamanhoTela;
	private String ip;
	
	
	private int tipo;
	
	@ManyToOne
	@JoinColumn(name="marca",  nullable= true)	
	private Marca marca = new Marca();
	
	@ManyToOne
	@JoinColumn(name="monitor",  nullable= true)	
	private Monitor monitor = new Monitor();
	
	@ManyToOne
	@JoinColumn(name="sistemaoperacional",  nullable= true)	
	private Software sistemaOperacional = new Software();	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario",  nullable= true)	
	private Usuario usuario = new Usuario();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String getTamanhoTela() {
		return tamanhoTela;
	}

	public void setTamanhoTela(String tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
	
	
	
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}



	public Software getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(Software sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	
	public String getProcessador() {
		return processador;
	}
	
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	
	public String getMemoria() {
		return memoria;
	}
	
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	
	public String getHd() {
		return hd;
	}
	
	public void setHd(String hd) {
		this.hd = hd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computador other = (Computador) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computador [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", serial=" + serial
				+ ", modelo=" + modelo + ", processador=" + processador + ", memoria=" + memoria + ", hd=" + hd
				+ ", arquitetura=" + arquitetura + ", observacoes=" + observacoes + ", tamanhoTela=" + tamanhoTela
				+ ", ip=" + ip + ", tipo=" + tipo + ", marca=" + marca + ", monitor=" + monitor
				+ ", sistemaOperacional=" + sistemaOperacional + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	

    
}
