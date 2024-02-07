/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Custódio Quingumba
 */
public class ClientesOBJ {

    private String nome, informação, email, endereço, serviço, nacionalidade, telefone, whatsapp, BI, GPON,vlan;
    private int id, diaPagamento, pacote;

    public ClientesOBJ(int id, String nome, String nacionalidade,String BI, String telefone, String whatsapp, String endereço, String email, String informação, String serviço, int pacote, String GPON,String vlan,int dia) {
        this.nome = nome;
        this.informação = informação;
        this.email = email;
        this.endereço = endereço;
        this.serviço = serviço;
        this.pacote = pacote;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.id = id;
        this.BI = BI;
        this.whatsapp = whatsapp;
        this.GPON = GPON;
        this.vlan = vlan;
        this.diaPagamento = dia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getServiço() {
        return serviço;
    }

    public void setServiço(String serviço) {
        this.serviço = serviço;
    }

    public int getPacote() {
        return pacote;
    }

    public void setPacote(int pacote) {
        this.pacote = pacote;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
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

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getGPON() {
        return GPON;
    }

    public void setGPON(String GPON) {
        this.GPON = GPON;
    }
    
    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    
}
