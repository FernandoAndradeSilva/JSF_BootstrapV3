package br.com.gerenciador.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import static java.util.Arrays.asList;

@Entity
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nome;
    
    @OneToMany(mappedBy="marca" , orphanRemoval=true, fetch = FetchType.LAZY)
    private List<Software> softwares;
    
    @OneToMany(mappedBy="marca" , orphanRemoval=true, fetch = FetchType.LAZY)
    private List<Monitor> monitores;

    public Marca() {
        super();
    }

    public Marca(String nome, Software... softwares) {
        this.nome = nome;
        this.softwares = asList(softwares);
    }

    public Marca(String nome) {
        this.nome = nome;
    }

    public Marca(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Marca(String nome, Monitor... monitores) {
        this.nome = nome;
        this.monitores = asList(monitores);
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }

    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
}
