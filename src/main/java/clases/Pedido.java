/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Pedido {

    private Scanner sc = new Scanner(System.in);
    private LocalDate fechaPedido;
    private String numPedido;
    private FormaPago pago;
    private Cliente cliente;
    private ArrayList<Producto> listaProductos;

    public Pedido(LocalDate fechaPedido, FormaPago pago, Cliente cliente, ArrayList<Producto> listaProductos) {
        this.fechaPedido = fechaPedido;
        this.numPedido = numPedido();
        this.pago = pago;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
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

        pedido += "/" + String.valueOf(cal);

        return pedido;
    }

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

    public FormaPago getPago() {
        return pago;
    }

    public void setPago(FormaPago pago) {
        this.pago = pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.fechaPedido);
        hash = 67 * hash + Objects.hashCode(this.numPedido);
        hash = 67 * hash + Objects.hashCode(this.pago);
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.listaProductos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.numPedido, other.numPedido)) {
            return false;
        }
        if (!Objects.equals(this.fechaPedido, other.fechaPedido)) {
            return false;
        }
        if (this.pago != other.pago) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.listaProductos, other.listaProductos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "fechaPedido=" + fechaPedido + ", numPedido=" + numPedido + ", pago=" + pago + ", codcliente=" + cliente.getNumCliente() + ", listaProductos=" + textolistaProductos() + '}';
    }

    private String textolistaProductos(){
        String texto="";
        for(Producto o: listaProductos){
            texto+=o.getReferencia() + "," + o.getCantidad() +",";
        }
        
        return texto;
    }

    public Pedido realizarPedido(Empresa o) {

        Pedido nuevo = new Pedido(LocalDate.now(), formaDePago(), meterCliente(o), meterProductos(o));
        o.getListaPedidos().add(nuevo);
        return nuevo;
    }

    private FormaPago formaDePago() {
        System.out.println("¿Como quiere pagarlo?\n" + "tarjeta o transferencia");
        String pago = sc.nextLine();

        switch (pago.toUpperCase()) {
            case "TARJETA":
                return FormaPago.TARJETA;

            case "TRANSFERENCIA":
                return FormaPago.TRANSFERENCIA;

        }
        return null;

    }

    private Cliente meterCliente(Empresa o) {
        System.out.println(o.getListaClientes().toString());
        System.out.println("¿Que cliente quiere meter en el pedido?");
        int num = sc.nextInt();

        for (Cliente e : o.getListaClientes()) {
            if (e.getNumCliente()==num) {
                return e;
            }
        }

        return null;
    }

    private ArrayList<Producto> meterProductos(Empresa o) {
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto e : o.getListaProductos()) {
            System.out.println(e.toString());
        }

        System.out.println("¿Cuantos productos diferente tiene el pedido?");
        int num = sc.nextInt();

        int contador = 0;
        do {
            System.out.println("Introduzca la referencia del producto");
            String ref = sc.nextLine();
            System.out.println("Introduzca la cantidad del producto");
            String cant = sc.nextLine();
            for (Producto u : o.getListaProductos()) {
                if (u.getReferencia().contains(ref)) {
                    u.setCantidad(cant);
                    lista.add(u);
                }
            }

        } while (contador != num);
        return lista;
    }

    public void imprimirPedido(Pedido o, String idFichero) {

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.write("Fecha: " + String.valueOf(LocalDate.now()) + "\n"
                    + "Cliente: " + o.getCliente().getNombre() + "\t" + "nº" + o.getNumPedido() + "\n"
                    + "Direccion: " + o.getCliente().getDireccion() + "\n"
                    + "Producto\t" + "Cantidad\t" + "Precio\t" + "Total");

            for (Producto e : o.getListaProductos()) {
                int total= Integer.parseInt(e.getPrecio()) * Integer.parseInt(e.getCantidad());
                String total1= String.valueOf(total);
                flujo.write(e.getNombre()+"\t" + e.getCantidad()+"\t" + e.getPrecio()+"\t" + total1);

            }
            
            flujo.write("Forma de pago" + o.getPago());
            // Metodo newLine() añade salto de línea después de cada fila
            flujo.newLine();

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Pedido " + idFichero + " impreso correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
