package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public interface EstrategiaOferta {
    void actualizarOferta (Subastador subastador, Oferta ultimaOferta);
    void participar (Subastador subastador, ProductoSubastado producto);
}
