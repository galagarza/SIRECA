/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class RegistroCarreras {

    private ArrayList<Carrera> listaCarreras;

    public RegistroCarreras() {
        listaCarreras = new ArrayList<Carrera>();
    }

    public String agregarCarrera(Carrera carrera) {
        if (carrera != null) {
            if (verificarSigla(carrera.getSigla())) {
                listaCarreras.add(carrera);
                return "La carrera se agregó correctamente!";
            } else {
                return "La carrera ya existe.";
            }
        }
        return "El objeto es null.";

    }//fin del metodo agregar
    
   
    public String deleteEstudiante(Carrera carrera) {
        for (int i = 0; i < listaCarreras.size(); i++) {
            if (listaCarreras.get(i).getSigla().equalsIgnoreCase(carrera.getSigla())) {
                listaCarreras.remove(i);
                return "La carrera fue eliminada correctamente!";
            }
        }

        return "El proceso de elminar no fue realizado correctamente";
    }

    public boolean verificarSigla(String sigla) {
        if (!sigla.equalsIgnoreCase("")) {
            if (listaCarreras.size() != 0) {
                for (int i = 0; i < listaCarreras.size(); i++) {
                    if (listaCarreras.get(i).getSigla().equalsIgnoreCase(sigla)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }//fin del metodo verificar

    public Carrera buscarCarrera(String sigla) {
        for (int i = 0; i < listaCarreras.size(); i++) {
            if (listaCarreras.get(i).getSigla().equalsIgnoreCase(sigla)) {
                return listaCarreras.get(i);
            }
        }
        return null;
    }

    public String consultarTodo() {
        String salida = "";
        for (Carrera carreraE : listaCarreras) {
            salida += carreraE.getInformacion();
        }
        return salida;
    }

    public String[][] getMatrizCarreras() {

        String matriz[][] = new String[listaCarreras.size()][Carrera.getNumeroAtributos()];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaCarreras.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }

    public String[][] getMatrizBuscar(String busca, int filtro) {
        ArrayList<Carrera> listaE = new ArrayList<Carrera>();

        for (Carrera carre : listaCarreras) {
            if (filtro == 1) {
                if (carre.getSigla().equalsIgnoreCase(busca)) {
                    listaE.add(carre);
                }
            } else if (filtro == 2) {
                if (carre.getNombre().equalsIgnoreCase(busca)) {
                    listaE.add(carre);
                }
            } else {
                if (carre.getCategoria().equalsIgnoreCase(busca)) {
                    listaE.add(carre);
                }
            }
        }//fin del ciclo

        String matriz[][] = new String[listaE.size()][Carrera.getNumeroAtributos()];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaE.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }

}//fin de la clase
