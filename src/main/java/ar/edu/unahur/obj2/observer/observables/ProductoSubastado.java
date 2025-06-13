package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observador;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubastado implements Observable {
    private Set<Observador> observadores = new HashSet<>();
    private List<Oferta> ofertas = new ArrayList<>();

    @Override
    public void agregarSubastador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void quitarSubastador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        observadores.forEach(o -> o.actualizarOferta(ultimaOferta()));
    }

    public Oferta ultimaOferta() {
        return ofertas.get(ofertas.size()-1);
    }

    public void agregarOferta(Oferta oferta){
        if (!esParticipante(oferta.subastador())){
            throw new OfertaSubastadorException("El subastador no participa en la subasta");
        }
        ofertas.add(oferta);
        notificar();
    }

    public Boolean esParticipante(Subastador subastador){
        return observadores.contains(subastador);
    }

    public void reiniciar(){
        observadores.clear();
        ofertas.clear();
    }

    public Integer cantidadOfertas() {
        return ofertas.size();
    }
}
