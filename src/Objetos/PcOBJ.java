/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Custódio Quingumba
 */
public class PcOBJ {
    private String Cliente, CTO;
    private int pon;

    public PcOBJ(String Cliente, String CTO, int pon) {
        this.Cliente = Cliente;
        this.CTO = CTO;
        this.pon = pon;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getCTO() {
        return CTO;
    }

    public void setCTO(String CTO) {
        this.CTO = CTO;
    }

    public int getPon() {
        return pon;
    }

    public void setPon(int pon) {
        this.pon = pon;
    }
    
    
}
