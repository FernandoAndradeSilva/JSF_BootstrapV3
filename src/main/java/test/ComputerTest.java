package test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ComputerTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String hostName;
    private String modelo;
    private String matricula;
    private String serial;
    private String processador;
    private String memoria;
    private String hd;
    private String responsavel;


    public List<ComputerTest> retorna() {

        List<ComputerTest> computadores = new ArrayList<ComputerTest>();

        ComputerTest pc01 =new ComputerTest("--" , "--" , "--" ,
                "--" , "--" , "--" , "--" , "--");

        computadores.add(pc01);

        return computadores;


    }

    public ComputerTest() {
        super();
    }

    public ComputerTest(String hostName, String modelo, String matricula, String serial, String processador, String memoria, String hd, String responsavel) {
        this.hostName = hostName;
        this.modelo = modelo;
        this.matricula = matricula;
        this.serial = serial;
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
        this.responsavel = responsavel;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
