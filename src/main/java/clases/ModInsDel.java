/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void añadirProducto(Empresa o) {

        System.out.println("¿Que quiere añadir articulos o servicios?");
        String opcion = sc.nextLine();
        switch (opcion.toUpperCase()) {
            case "ARTICULO":
                Articulos nuevo = new Articulos();
                System.out.println("Introduce la cantidad de productos");
                String cant = sc.nextLine();
                nuevo.setCantidad(cant);
                System.out.println("Introduce la fecha del producto");
                String fec = sc.nextLine();
                LocalDate localDate1 = LocalDate.parse(fec.replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                nuevo.setFechaDeCreacion(localDate1);
                System.out.println("Introduce el nombre del producto");
                String nom = sc.nextLine();
                nuevo.setNombre(nom);
                System.out.println("Introduce el peso del producto");
                String peso = sc.nextLine();
                nuevo.setPeso(peso);
                System.out.println("Introduce la referencia del producto");
                String ref = sc.nextLine();
                nuevo.setReferencia(ref);
                System.out.println("Introduce el precio del producto");
                String prec = sc.nextLine();
                nuevo.setPrecio(prec);

                o.getListaProductos().add(nuevo);
                break;
            case "SERVICIO":

                Servicios nuevo2 = new Servicios();

                System.out.println("Introduce la cantidad de productos");
                String cant1 = sc.nextLine();
                nuevo2.setCantidad(cant1);
                System.out.println("Introduce la fecha de inicio del producto");
                String fec1 = sc.nextLine();
                LocalDate localDate2 = LocalDate.parse(fec1.replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                nuevo2.setFechaComienzo(localDate2);
                System.out.println("Introduce la fecha de fin del producto");
                String fec2 = sc.nextLine();
                LocalDate localDate3 = LocalDate.parse(fec2.replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                nuevo2.setFechaDeFin(localDate3);
                System.out.println("Introduce las horas d duracion del producto");
                String hora = sc.nextLine();
                nuevo2.setHoras(Double.parseDouble(hora));
                System.out.println("Introduce el nombre del producto");
                String nom1 = sc.nextLine();
                nuevo2.setNombre(nom1);
                System.out.println("Introduce el precio del producto");
                String prec1 = sc.nextLine();
                nuevo2.setPrecio(prec1);
                System.out.println("Introduce la referencia del producto");
                String ref1 = sc.nextLine();
                nuevo2.setReferencia(ref1);

                o.getListaProductos().add(nuevo2);
                break;

        }

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

    public void consultarPedidos(Empresa o) {
        for (Pedido e : o.getListaPedidos()) {
            System.out.println(o.toString());
        }
    }

    public void consultarProductos(Empresa o) {
        for (Producto e : o.getListaProductos()) {

            if (e instanceof Articulos) {
                System.out.println(((Articulos) e).toString());

            } else {
                System.out.println(((Servicios) e).toString());

            }

        }
    }

    public void consultarClientes(Empresa o) {
        for (Cliente e : o.getListaClientes()) {
            System.out.println(o.toString());
        }
    }

    public void modificarCliente(Empresa o) {
        consultarClientes(o);

        System.out.println("Introduzca el numero del cliente que quiere modificar");
        int num = sc.nextInt();

        for (Cliente e : o.getListaClientes()) {
            if (e.getNumCliente() == num) {
                System.out.println("¿Que quiere modificar?\n"
                        + "nombre\n"
                        + "direccion");
                String opcion = sc.nextLine();
                switch (opcion.toUpperCase()) {
                    case "NOMBRE":
                        System.out.println("Introduzca el nuevo nombre");
                        String nombre = sc.nextLine();
                        e.setNombre(nombre);
                        break;
                    case "DIRECCION":
                        System.out.println("Introduzca la nueva direccion");
                        String dir = sc.nextLine();
                        e.setDireccion(dir);
                        break;

                }
            }
        }
    }

    public void modificarProducto(Empresa o) {
        consultarProductos(o);
        System.out.println("Introduzca la referencia del producto");
        String ref = sc.nextLine();
        for (Producto e : o.getListaProductos()) {
            if (!ref.equalsIgnoreCase(e.getReferencia())) {
                if (e instanceof Articulos) {

                } else if (e instanceof Servicios) {

                }
            }
        }
    }

    public void modificarPedido(Empresa o) {
        consultarPedidos(o);
        System.out.println("Introduzca el numero del pedido que quiere modificar");
        String num = sc.nextLine();

        for (Pedido e : o.getListaPedidos()) {
            if (!num.equalsIgnoreCase(e.getNumPedido())) {
                System.out.println("¿Que quiere modificar?\n"
                        + "forma de pago\n" + "cambiar cliente\n" + "cambiar producto");
                String opcion = sc.nextLine();
                switch (opcion) {
                    case "FORMA DE PAGO":

                        e.setPago(formaDePago());
                        break;
                    case "CAMBIAR CLIENTE":
                        e.setCliente(meterCliente(o));
                        break;
                    case "CAMBIAR PRODUCTO":
                        e.setListaProductos(meterProductos(o));
                        break;
                }
            }
        }
    }

}
