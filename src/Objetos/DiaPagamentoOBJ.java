/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Custódio Quingumba
 */
public class DiaPagamentoOBJ {
    private String nome, telefone, informação;
    private int id,dia;

    public DiaPagamentoOBJ( int id, String nome, String telefone, String informação, int dia) {
        this.nome = nome;
        this.telefone = telefone;
        this.informação = informação;
        this.id = id;
        this.dia = dia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInformação() {
        return informação;
    }

    public void setInformação(String informação) {
        this.informação = informação;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    
}
