package com.mycompany.gestionmonedas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa cada moneda y sus atributos correspondientes.
 */
class Moneda {
    private static int contadorId = 1;
    private int id;
    private String pais;
    private String denominacion;
    private int anoEmision;

    /**
     * Constructor para crear una nueva moneda.
     * @param pais El país de origen de la moneda.
     * @param denominacion La denominación o valor de la moneda.
     * @param anoEmision El año en que se emitió la moneda.
     */
    public Moneda(String pais, String denominacion, int anoEmision) {
        this.id = contadorId++;
        this.pais = pais;
        this.denominacion = denominacion;
        this.anoEmision = anoEmision;
    }

    /**
     * Obtiene el ID único de la moneda.
     * @return Devuelve ese valor.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el país de origen de la moneda.
     * @return Devuelve ese valor.
     */
    
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene la denominación de la moneda.
     * @return Devuelve ese valor.
     */
    public String getDenominacion() {
        return denominacion;
    }

    /**
     * Obtiene el año de emisión de la moneda.
     * @return Devuelve ese valor.
     */
    public int getAnoEmision() {
        return anoEmision;
    }

    /**
     * @return Devuelve toda la información relevante de la moneda.
     */
    @Override
    public String toString() {
        return String.format("ID: %d, País: %s, Denominación: %s, Año de emisión: %d", id, pais, denominacion, anoEmision);
    }
}

/**
 * Clase principal que gestiona una colección de monedas.
 */
public class GestionMonedas {
    private ArrayList<Moneda> monedas;
    private Scanner scanner;

    /**
     * Constructor que inicializa la lista de monedas.
     */
    public GestionMonedas() {
        monedas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Agrega una nueva moneda a la colección.
     * @param pais El país de la moneda.
     * @param denominacion La denominación de la moneda.
     * @param anoEmision El año de emisión de la moneda.
     */
    public void agregarMoneda(String pais, String denominacion, int anoEmision) {
        Moneda nuevaMoneda = new Moneda(Pais(pais), Denominacion(denominacion), anoEmision);
        monedas.add(nuevaMoneda);
        System.out.println("Moneda agregada: " + nuevaMoneda);
    }

    /**
    * Formatea y capitaliza el nombre de un país.
    * 
    * @param pais El nombre del país a formatear.
    * @return El nombre del país con la primera letra en mayúscula y el resto en minúsculas.
    * @throws UnsupportedOperationException Si ocurre un error durante el proceso de formateo.
    */
    public String Pais(String pais) {
        return pais.trim().substring(0, 1).toUpperCase() + pais.trim().substring(1).toLowerCase();
    }

    /**
    * Formatea y capitaliza el nombre de la denominacion.
    * 
    * @param denominacion 
    * @return El nombre del país con la primera letra en mayúscula y el resto en minúsculas.
    * @throws UnsupportedOperationException Si ocurre un error durante el proceso de formateo.
    */
    public String Denominacion(String denominacion) {
        return denominacion.trim().substring(0, 1).toUpperCase() + denominacion.trim().substring(1).toLowerCase();
    }

    /**
     * Muestra todas las monedas añadidas hasta ese momento.
     */
    public void mostrarMonedas() {
        if (monedas.isEmpty()) {
            System.out.println("La lista de monedas está vacía.");
        } else {
            System.out.println("Lista de monedas:");
            for (Moneda moneda : monedas) {
                System.out.println(moneda);
            }
        }
    }

    /**
     * Elimina una moneda de la colección basándose en el ID.
     * @param id El ID de la moneda a eliminar.
     */
    public void eliminarMoneda(int id) {
        boolean encontrado = false;
        for (Moneda moneda : monedas) {
            if (moneda.getId() == id) {
                monedas.remove(moneda);
                System.out.println("Moneda eliminada: " + moneda);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Moneda no encontrada.");
        }
    }

    /**
     * Método  que lleva a cabo la ejecución del programa además de la interfaz de usuario.
     */
    public void ejecutar() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar moneda");
            System.out.println("2. Mostrar monedas");
            System.out.println("3. Eliminar moneda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el país de la moneda: ");
                    String pais = scanner.nextLine();
                    System.out.print("Ingrese la denominación de la moneda: ");
                    String denominacion = scanner.nextLine();
                    System.out.print("Ingrese el año de emisión de la moneda: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    agregarMoneda(pais, denominacion, ano);
                    break;
                case "2":
                    mostrarMonedas();
                    break;
                case "3":
                    System.out.print("Ingrese el ID de la moneda a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    eliminarMoneda(idEliminar);
                    break;
                case "4":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Método principal que inicia la ejecución del programa
     */
    public static void main(String[] args) {
        new GestionMonedas().ejecutar();
    }
}
