package es.curso.springboot1.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.curso.springboot1.negocio.Socio;

@Repository
public class SocioRepositoryMemoria {

    List<Socio> socios = new ArrayList<Socio>();

    public SocioRepositoryMemoria() {

        socios.add(new Socio("pepe", "perez", 10));
        socios.add(new Socio("pepe2", "perez", 10));
        socios.add(new Socio("pepe3", "perez", 10));
        socios.add(new Socio("pepe4", "perez", 10));

    }

    public void borrarSocio(String nombre) {
        Socio s = new Socio(nombre);
        socios.remove(s);
    }

    public void insertarsocio(Socio socio) {
        socios.add(socio);

    }

    public List<Socio> buscarTodos() {
        return socios;
    }

    public Optional<Socio> buscarUno(String nombre) {
        return socios.stream().filter((s) -> s.getNombre().equals(nombre)).findFirst();

    }

    public List<Socio> buscarTodosOrdenados(String orden) {
        List<Socio> listaOrdenada = new ArrayList<>();
        if (orden.equals("nombre")) {

            listaOrdenada = (List<Socio>) socios.stream().sorted(Comparator.comparing(Socio::getNombre)).toList();

        } else if (orden.equals("Apellidos")) {
            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getApellidos)).toList();

        } else {
            listaOrdenada = socios.stream().sorted(Comparator.comparing(Socio::getEdad)).toList();

        }

        return listaOrdenada;

    }

}
