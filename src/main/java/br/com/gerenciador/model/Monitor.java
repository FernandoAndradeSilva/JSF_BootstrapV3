package br.com.gerenciador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Monitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tamanho;
    private String modelo;
    
    @ManyToOne
	@JoinColumn(name="marca",  nullable= true)	
	private Marca marca = new Marca();


    public Monitor() {
    }

    public Monitor(Marca marca , String tamanho, String modelo) {
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.marca = marca;
    }
    
    public Monitor(String tamanho, String modelo) {
        this.tamanho = tamanho;
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

	@Override
	public String toString() {
		return "Monitor [id=" + id + ", tamanho=" + tamanho + ", modelo=" + modelo + ", marca=" + marca + "]";
	}
    
    
    
}
