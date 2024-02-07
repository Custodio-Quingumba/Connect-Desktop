/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Custódio Quingumba
 */
public class LoginOBJ {

    private int id;
    private String nome, email, senha, previlegio, categoria;

    public LoginOBJ(int id, String nome, String email, String senha, String previlegio, String categoria) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.previlegio = previlegio;
        this.email = email;
        this.categoria = categoria;
    }

    public LoginOBJ() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrevilegio() {
        return previlegio;
    }

    public void setPrevilegio(String previlegio) {
        this.previlegio = previlegio;
    }

}
