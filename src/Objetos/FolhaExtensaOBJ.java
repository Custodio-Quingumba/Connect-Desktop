/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author quingumba
 */
public class FolhaExtensaOBJ {
    String funcionario,categoria,mes,salario, IRT,INSS, subsidio;

    public FolhaExtensaOBJ(String funcionario, String categoria, String mes, String salario, String IRT, String INSS, String subsidio) {
        this.funcionario = funcionario;
        this.categoria = categoria;
        this.mes = mes;
        this.salario = salario;
        this.IRT = IRT;
        this.INSS = INSS;
        this.subsidio = subsidio;
    }

    
    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getIRT() {
        return IRT;
    }

    public void setIRT(String IRT) {
        this.IRT = IRT;
    }

    public String getINSS() {
        return INSS;
    }

    public void setINSS(String INSS) {
        this.INSS = INSS;
    }

    public String getSubsidio() {
        return subsidio;
    }

    public void setSubsidio(String subsidio) {
        this.subsidio = subsidio;
    }
    
    
}
