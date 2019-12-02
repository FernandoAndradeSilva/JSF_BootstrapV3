package br.com.gerenciador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Software implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	

    public static final int sistemaOperacional = 1;
    public static final int aplicacao = 2;
    public static final int office = 3;

    public static final int servidor = 1;
    public static final int estacao = 2;


    String versao;
    String arquitetura;
    Integer tipo;
    Integer uso;
    
	@ManyToOne
	@JoinColumn(name="marca",  nullable= true)	
	private Marca marca = new Marca();

    public Software() {

    }

    public Software(String versao) {
        this.versao = versao;
    }

    public Software(String versao, String arquitetura) {
        this.versao = versao;
        this.arquitetura = arquitetura;

    }

    public Software(String versao, String arquitetura, Integer tipo, Integer uso , Marca marca , Long id) {
        this.versao = versao;
        this.arquitetura = arquitetura;
        this.tipo = tipo;
        this.uso = uso;
        this.marca = marca;
        this.id = id;
    }
    
    public Software(Marca marca , String versao, String arquitetura, Integer tipo, Integer uso) {
        this.versao = versao;
        this.arquitetura = arquitetura;
        this.tipo = tipo;
        this.uso = uso;
        this.marca = marca;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getUso() {
        return uso;
    }

    public void setUso(Integer uso) {
        this.uso = uso;
    }

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Software other = (Software) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Software [id=" + id + ", versao=" + versao + ", arquitetura=" + arquitetura + ", tipo=" + tipo
				+ ", uso=" + uso + ", marca=" + marca + "]";
	}



	
	
    
}
