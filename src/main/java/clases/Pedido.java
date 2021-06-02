/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;

/**
 *
 * @author alberto
 */
public class Pedido {

    private LocalDate fechaPedido;
    private String numPedido;

    public Pedido() {
        this.fechaPedido = LocalDate.now();
        this.numPedido = numPedido();
    }

    private String numPedido() {
        Random random = new Random();
        ArrayList<Integer> listaRepetida = new ArrayList<>();
        String pedido = " ";

        int numero = random.nextInt(9999);
        if (!listaRepetida.contains(numero)) {
            listaRepetida.add(numero);
            Formatter fmt = new Formatter();
            fmt.format("%04d", numero);
            pedido = String.valueOf(fmt);
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        
        pedido+= "/" + String.valueOf(cal);

        return pedido;
    }

    //getters y setters
    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

}
