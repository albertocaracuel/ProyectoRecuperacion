/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class PresentacionMenu {

    private static Scanner sc = new Scanner(System.in);

    public static void menuPrincipal(Empresa o) throws IOException {
        ModInsDel med = new ModInsDel();

        System.out.println("Bienvenido a la aplicacion de la empresa");
        String salir2 = "";
        do {
            System.out.println("¿Que quiere hacer?\n"
                    + "Consultar/modificar/insertar/borrar clientes\n"
                    + "Consultar/modificar/insertar/borrar productos\n"
                    + "Consultar/modificar/insertar/borrar pedidos.\n"
                    + "Imprimir pedido\n"
                    + "Generar copia de seguridad\n"
                    + "Restaurar copia de seguridad");
            String opcion = sc.nextLine();

            switch (opcion.toUpperCase()) {
                case "CLIENTES":

                    menuClientes(o, med);

                    break;
                case "PRODUCTOS":

                    menuProductos(o, med);

                    break;
                case "PEDIDOS":

                    menuPedidos(o, med);

                    break;
                case "IMPRIMIR":
                    med.consultarPedidos(o);
                    System.out.println("Introduzca el numero del pedido que quiere imprimir");
                    String num = sc.nextLine();
                    for (Pedido e : o.getListaPedidos()) {
                        if (e.getNumPedido().equals(num)) {
                            e.imprimirPedido(e, num);
                        }
                    }

                    break;
                case "GENERAR":
                    o.crearCopiaDeSeguridad(o);
                    break;
                case "RESTAURAR":
                    o.restaurarCopiaDeSeguridad();
                    break;

            }
            System.out.println("¿Quiere salir?");
            salir2 = sc.nextLine();

        } while (!salir2.equals("si"));

    }

    private static void menuPedidos(Empresa o, ModInsDel e) {
        System.out.println("¿Que quiere hacer?\n"
                + "Consultar/modificar/insertar/borrar");
        String opcion = sc.nextLine();

        switch (opcion.toUpperCase()) {
            case "CONSULTAR":
                e.consultarPedidos(o);
                break;
            case "MODIFICAR":
                e.modificarPedido(o);
                break;
            case "INSERTAR":
                e.añadirPedido(o);
                break;
            case "BORRAR":
                e.borrarPedido(o);
                break;
        }
    }

    private static void menuProductos(Empresa o, ModInsDel e) {
        System.out.println("¿Que quiere hacer?\n"
                + "Consultar/modificar/insertar/borrar");
        String opcion = sc.nextLine();

        switch (opcion.toUpperCase()) {
            case "CONSULTAR":
                e.consultarProductos(o);
                break;
            case "MODIFICAR":
                e.modificarProducto(o);
                break;
            case "INSERTAR":
                e.añadirProducto(o);
                break;
            case "BORRAR":
                e.borrarProducto(o);
                break;
        }
    }

    private static void menuClientes(Empresa o, ModInsDel e) {
        System.out.println("¿Que quiere hacer?\n"
                + "Consultar/modificar/insertar/borrar");
        String opcion = sc.nextLine();

        switch (opcion.toUpperCase()) {
            case "CONSULTAR":
                e.consultarClientes(o);
                break;
            case "MODIFICAR":
                e.modificarCliente(o);
                break;
            case "INSERTAR":
                e.añadirCliente(o);
                break;
            case "BORRAR":
                e.borrarCliente(o);
                break;
        }
    }
}
