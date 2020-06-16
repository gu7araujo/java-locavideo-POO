/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locavideo.Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Database implements Serializable {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();    
    private ArrayList<Fita> fitas = new ArrayList<>();


    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public ArrayList<Fita> getFitas() {
        return fitas;
    }
    public void setFitas(ArrayList<Fita> fitas) {
        this.fitas = fitas;
    }
}
