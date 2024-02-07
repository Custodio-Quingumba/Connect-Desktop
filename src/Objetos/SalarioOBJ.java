/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author quingumba
 */
public class SalarioOBJ {

    private int id;
    private String Categoria, valor, INSS, IRT, subsidio,moeda;

    public SalarioOBJ(int id, String Categoria, String valor, String INSS, String IRT, String subsidio,String moeda) {
        this.id = id;
        this.Categoria = Categoria;
        this.valor = valor;
        this.IRT = IRT;
        this.INSS = INSS;
        this.subsidio = subsidio;
        this.moeda = moeda;
    }

    public SalarioOBJ() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getINSS() {
        return INSS;
    }

    public void setINSS(String INSS) {
        this.INSS = INSS;
    }

    public String getIRT() {
        return IRT;
    }

    public void setIRT(String IRT) {
        this.IRT = IRT;
    }

    public String getSubsidio() {
        return subsidio;
    }

    public void setSubsidio(String subsidio) {
        this.subsidio = subsidio;
    }

}
