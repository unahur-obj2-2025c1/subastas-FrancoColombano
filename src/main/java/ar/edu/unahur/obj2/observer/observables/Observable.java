package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.observadores.Observador;

public interface Observable {
    void agregarSubastador(Observador observador);
    void quitarSubastador(Observador observador);
    void notificar();
}
