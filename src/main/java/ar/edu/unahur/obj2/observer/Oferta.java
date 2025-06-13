package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    Subastador subastador;
    Integer valorOfertado;

    public Oferta(Subastador subastador) {
        this.subastador = subastador;
        this.valorOfertado = subastador.oferta();
    }

    public Integer valor(){
        return valorOfertado;
    }

    public Subastador subastador(){
        return subastador;
    }

    public String nombreSubastador() {
        return subastador.nombreUsuario();
    }
}
