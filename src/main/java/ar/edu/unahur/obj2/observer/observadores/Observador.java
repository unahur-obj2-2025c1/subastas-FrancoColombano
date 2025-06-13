package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public interface Observador {
    void actualizarOferta(Oferta ultimaOfeta);
    void participar(ProductoSubastado productoSubastado);
}
