/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aaron
 */
public class Carrera {

    private String sigla;
    private String nombre;
    private String categoria;
    private static String[] etiquetas = {"Sigas", "Nombre", "Categoria"};

    public Carrera(String sigla, String nombre, String categoria) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public static String[] getEtiquetas() {
        return etiquetas;
    }

    public static int getNumeroAtributos() {
        return etiquetas.length;
    }

    public String getAtributo(int colum) {
        switch (colum) {
            case 0:
                return sigla;
            case 1:
                return nombre;
            case 2:
                return categoria;
            default:
                return null;
        }
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInformacion() {
        return this.getSigla() + "\t" + this.getNombre() + "\t" + this.getCategoria() + "\n";
    }

}
