package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class SubastadorArriesgado implements EstrategiaOferta{
    ProductoSubastado productoSubastado;

    @Override
    public void actualizarOferta(Subastador subastador, Oferta ultimaOferta) {
        subastador.actualizarOferta(ultimaOferta);
        subastador.realizarOferta(productoSubastado);
    }

    @Override
    public void participar(Subastador subastador, ProductoSubastado producto) {
        subastador.productoSubastado = producto;
        subastador.realizarOferta(producto);
    }

    /* 
    public SubastadorArriesgado(String nombreUsuario) {
        super(nombreUsuario);
    }

    @Override
    public void actualizarOferta(Oferta ultimaOferta) {
        super.actualizarOferta(ultimaOferta);
        realizarOferta(productoSubastado);
    }

    @Override
    public void participar(ProductoSubastado productoSubastado) {
        this.productoSubastado = productoSubastado;
        realizarOferta(productoSubastado);
    }

    @Override
    public void reiniciar() {
        super.reiniciar();
        productoSubastado = null;
    }*/
}
