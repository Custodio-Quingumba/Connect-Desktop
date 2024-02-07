/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Quingumba
 */
public class HistoricoOBJ {

    private int id;
    private String cliente, funcionario, dataPedido, ação, nota, tecnico, dataFecho;

    public HistoricoOBJ(int id, String cliente, String funcionario, String dataPedido, String ação, String nota, String tecnico, String dataFecho) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataPedido = dataPedido;
        this.ação = ação;
        this.nota = nota;
        this.tecnico = tecnico;
        this.dataFecho = dataFecho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getAção() {
        return ação;
    }

    public void setAção(String ação) {
        this.ação = ação;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getDataFecho() {
        return dataFecho;
    }

    public void setDataFecho(String dataFecho) {
        this.dataFecho = dataFecho;
    }
    
    

}
