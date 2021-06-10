/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Empresa {

    private Scanner sc = new Scanner(System.in);
    private String cif;
    private String nombreEmpresa;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Producto> listaProductos;

    public Empresa() {
        this.cif = "2838828ex";
        this.nombreEmpresa = "lopes S.A";
        this.listaClientes = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProducto(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cif);
        hash = 17 * hash + Objects.hashCode(this.nombreEmpresa);
        hash = 17 * hash + Objects.hashCode(this.listaClientes);
        hash = 17 * hash + Objects.hashCode(this.listaPedidos);
        hash = 17 * hash + Objects.hashCode(this.listaProductos);
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
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        if (!Objects.equals(this.nombreEmpresa, other.nombreEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.listaClientes, other.listaClientes)) {
            return false;
        }
        if (!Objects.equals(this.listaPedidos, other.listaPedidos)) {
            return false;
        }
        if (!Objects.equals(this.listaProductos, other.listaProductos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", nombreEmpresa=" + nombreEmpresa + ", listaClientes=" + listaClientes + ", listaPedidos=" + listaPedidos + ", listaProductos=" + listaProductos + '}';
    }

    public void DarDeAlta() {
        System.out.println("Nombre del cliente");
        String nombre = sc.nextLine();

        System.out.println("Direccion del cliente");
        String direccion = sc.nextLine();

        Cliente nuevo = new Cliente(nombre, direccion);

        listaClientes.add(nuevo);
    }

    public void añadirClientesCSV(String url) {

        String idFichero = url;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");

                Cliente nuevo = new Cliente();
                nuevo.setDireccion(tokens[1]);
                nuevo.setNombre(tokens[0]);
                nuevo.setNumCliente(Integer.parseInt(tokens[2]));

                listaClientes.add(nuevo);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void añadirProductosCSV(String url) {

        String idFichero = url;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");

                LocalDate localDate1 = LocalDate.parse(tokens[1].replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate localDate2 = LocalDate.parse(tokens[1].replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate localDate3 = LocalDate.parse(tokens[2].replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (tokens.length == 6) {

                    Articulos nuevo = new Articulos();

                    nuevo.setCantidad(tokens[3]);
                    nuevo.setFechaDeCreacion(localDate1);
                    nuevo.setNombre(tokens[4]);
                    nuevo.setPeso(tokens[0]);
                    nuevo.setReferencia(tokens[2]);
                    nuevo.setPrecio(tokens[5]);

                    listaProductos.add(nuevo);
                } else {
                    Servicios nuevo = new Servicios();

                    nuevo.setCantidad(tokens[4]);
                    nuevo.setFechaComienzo(localDate2);
                    nuevo.setFechaDeFin(localDate3);
                    nuevo.setHoras(Double.parseDouble(tokens[0]));
                    nuevo.setNombre(tokens[5]);
                    nuevo.setPrecio(tokens[6]);
                    nuevo.setReferencia(tokens[3]);

                    listaProductos.add(nuevo);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
}
