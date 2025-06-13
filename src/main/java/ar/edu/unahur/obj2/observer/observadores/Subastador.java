package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observador {
    private Oferta ultimaOferta;
    private String nombreUsuario;

    public Subastador (String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public void actualizarOferta(Oferta ultimaOferta) {
        this.ultimaOferta = ultimaOferta;
    }

    public void realizarOferta(ProductoSubastado productoSubastado){
        productoSubastado.agregarOferta(new Oferta(this));
    }

    public Integer oferta(){
        if (ultimaOferta == null)
            return 10;
        return ultimaOferta.valor() + 10;
    }

    public void reiniciar(){
        ultimaOferta = null;
    }

    public Oferta ultimaOferta(){
        return ultimaOferta;
    }
    
    public Integer valorUltimaOferta(){
        if (ultimaOferta == null)
            throw new OfertaSubastadorException("Todavía no hay ofertas");
        return ultimaOferta.valor();
    }

    public String subastadorUltimaOferta(){
        if (ultimaOferta == null)
            throw new OfertaSubastadorException("Todavía no hay ofertas");
        return ultimaOferta.nombreSubastador();
    }

    public String nombreUsuario(){
        return nombreUsuario;
    }
}
