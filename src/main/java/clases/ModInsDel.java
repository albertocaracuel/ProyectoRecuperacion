/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class ModInsDel {

    private Scanner sc = new Scanner(System.in);

    public void borrarCliente(Empresa o) {
        o.getListaClientes().forEach(e -> {
            System.out.println(e);
        });

        System.out.println("Introduzca El nombre del cliente que quiere borrar");
        String nombre = sc.nextLine();

        o.getListaClientes().stream().filter(e -> (e.getNombre().equals(nombre))).map(e -> {
            o.getListaClientes().remove(e);
            return e;
        }).forEachOrdered(_item -> {
            System.out.println("Cliente borrado");
        });
    }

    public void borrarProducto(Empresa o) {
        o.getListaProductos().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("Introduzca el nombre del producto que quiere borrar");
        String nombre = sc.nextLine();

        o.getListaProductos().stream().filter(e -> (e.getNombre().equals(nombre))).map(e -> {
            o.getListaProductos().remove(e);
            return e;
        }).forEachOrdered(_item -> {
            System.out.println("Producto borrado");
        });
    }

    public void borrarPedido(Empresa o) {
        o.getListaPedidos().forEach(e -> {
            System.out.println(e);
        });

        System.out.println("Introduzca el numero del pedido que quiere borrar");
        String num = sc.nextLine();

        o.getListaPedidos().stream().filter(e -> (e.getNumPedido().equals(num))).map(e -> {
            o.getListaPedidos().remove(e);
            return e;
        }).forEachOrdered(_item -> {
            System.out.println("Pedido borrado");
        });
    }

    public void añadirCliente(Empresa o) {
        System.out.println("Nombre del cliente");
        String nombre = sc.nextLine();

        System.out.println("Direccion del cliente");
        String direccion = sc.nextLine();

        Cliente nuevo = new Cliente(nombre, direccion);

        o.getListaClientes().add(nuevo);
    }

    public void añadirProducto() {

    }

    public void añadirPedido(Empresa o) {

        Pedido nuevo = new Pedido(LocalDate.now(), formaDePago(), meterCliente(o), meterProductos(o));
        o.getListaPedidos().add(nuevo);
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
            if (e.equals(num)) {
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
}
