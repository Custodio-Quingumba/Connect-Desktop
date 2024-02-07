/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author quingumba
 */
public class FechoDeContasOBJ {

    private int id, ano;
    private String Mes;
    private double entrada, saida;

    public FechoDeContasOBJ(int id, int ano, String Mes, double entrada, double saida) {
        this.id = id;
        this.ano = ano;
        this.Mes = Mes;
        this.entrada = entrada;
        this.saida = saida;
    }

    public FechoDeContasOBJ() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

}
