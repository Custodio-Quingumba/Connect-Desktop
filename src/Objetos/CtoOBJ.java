/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Custódio Quingumba
 */
public class CtoOBJ {

    private int id,idCeo, capacidade, pon,entrada;
    private String nome,spliter;

    public CtoOBJ() {
    }

    
    public CtoOBJ(int id,int idCeo, String nome, int capacidade, int pon,int entrada, String spliter) {
        this.id = id;
        this.idCeo = idCeo;
        this.capacidade = capacidade;
        this.nome = nome;
        this.pon = pon;
        this.entrada = entrada;
        this.spliter = spliter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPon() {
        return pon;
    }

    public void setPon(int pon) {
        this.pon = pon;
    }

    public int getIdCeo() {
        return idCeo;
    }

    public void setIdCeo(int idCeo) {
        this.idCeo = idCeo;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public String getSpliter() {
        return spliter;
    }

    public void setSpliter(String spliter) {
        this.spliter = spliter;
    }
    
}
