/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;


/**
 *
 * @author Custódio Quingumba
 */
public class TemaOBJ {

    private int id;
    private String nome, padrão, texto, botão;

    public TemaOBJ(int id, String nome, String padrão, String texto, String botão) {
        this.id = id;
        this.nome = nome;
        this.padrão = padrão;
        this.texto = texto;
        this.botão = botão;
    }

    public TemaOBJ() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPadrão() {
        return padrão;
    }

    public void setPadrão(String padrão) {
        this.padrão = padrão;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getBotão() {
        return botão;
    }

    public void setBotão(String botão) {
        this.botão = botão;
    }

}
