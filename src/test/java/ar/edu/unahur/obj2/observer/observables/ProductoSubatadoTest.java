package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
    static ProductoSubastado producto;
    static Subastador gonzager;
    static Subastador diazdan;
    static Subastador martomau;

    @BeforeAll
        static void setUp(){
            producto = new ProductoSubastado();
            gonzager = new Subastador("gonzager");
            diazdan = new Subastador("diazdan");
            martomau = new Subastador("martomau");
        }
    
    @BeforeEach
        void setUpReseto(){
            producto.reiniciar();
            gonzager.reiniciar();
            diazdan.reiniciar();
            martomau.reiniciar();
        }

    void prepararEscenario1(){
        producto.agregarSubastador(gonzager);
        producto.agregarSubastador(martomau);
        martomau.realizarOferta(producto);  
        gonzager.realizarOferta(producto);  
        martomau.realizarOferta(producto); 
    }

    @Test
        void testSubastadoresRecibenUltimaOfertaCorrectamente(){
            producto.agregarSubastador(gonzager);
            producto.agregarSubastador(martomau);

            martomau.realizarOferta(producto);  
            assertEquals(martomau.ultimaOferta(), gonzager.ultimaOferta());

            gonzager.realizarOferta(producto);  
            assertEquals(martomau.ultimaOferta(), gonzager.ultimaOferta());

            martomau.realizarOferta(producto);  
            assertEquals(martomau.ultimaOferta(), gonzager.ultimaOferta());
        }

    @Test
        void testUltimaOfertaPerteneceASubastadorMartomau(){
            prepararEscenario1();
            assertEquals(martomau.ultimaOferta(), producto.ultimaOferta());
        }
    
    @Test 
        void testValorUltimaOfertaEs30(){
        producto.agregarSubastador(gonzager);
        producto.agregarSubastador(martomau);

        martomau.realizarOferta(producto);  
        assertEquals(producto.ultimaOferta().valor(),10);
        gonzager.realizarOferta(producto);  
        assertEquals(producto.ultimaOferta().valor(),20);
        martomau.realizarOferta(producto); 
        assertEquals(producto.ultimaOferta().valor(),30);
    }

    @Test 
        void testCantidadDeOfertasRegistradasEs3(){
            prepararEscenario1();
            assertEquals(3, producto.cantidadOfertas());
        }

    @Test
        void testAgregarOfertaSubastadorNoParticipanteLanzaExcepcion(){
            prepararEscenario1();
            assertThrows(OfertaSubastadorException.class, () -> {
                diazdan.realizarOferta(producto);
            });
        }
}
