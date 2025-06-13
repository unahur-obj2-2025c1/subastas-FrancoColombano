package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observador {
    protected Oferta ultimaOferta;
    protected String nombreUsuario;
    protected ProductoSubastado productoSubastado;
    private EstrategiaOferta estrategia;
    
    public Subastador (String nombreUsuario, EstrategiaOferta estrategia){
        this.nombreUsuario = nombreUsuario;
        this.estrategia = estrategia;
    }
    
    @Override
    public void actualizarOferta(Oferta ultimaOferta) {
        estrategia.actualizarOferta(this, ultimaOferta);
    }
    
    @Override
    public void participar(ProductoSubastado productoSubastado) {
        estrategia.participar(this, productoSubastado);
    }

    public void realizarOferta(ProductoSubastado productoSubastado){
        productoSubastado.agregarOferta(new Oferta(this));
    }
    
    public void reiniciar(){
        ultimaOferta = null;
        productoSubastado = null;
    }

    public Integer oferta(){
        if (ultimaOferta == null)
        return 10;
        return ultimaOferta.valor() + 10;
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
