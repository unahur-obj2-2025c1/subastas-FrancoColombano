package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class SubastadorConLimite extends Subastador{
    Integer umbral;

    public SubastadorConLimite(String nombreUsuario, Integer umbral) {
        super(nombreUsuario);
        this.umbral = umbral;
    }

    @Override
    public void realizarOferta(ProductoSubastado productoSubastado) {
        if (umbral<ultimaOferta.valor()) {
            super.realizarOferta(productoSubastado);
        }
    }
}
