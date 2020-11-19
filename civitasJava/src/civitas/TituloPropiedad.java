/**
 * @file TituloPropiedad.java
 * @author Yesenia González Dávila
 * @author Esther García Gallego
 * @note Grupo B.3
*/

package civitas;
public class TituloPropiedad {

    private String nombre;

    private float alquilerBase;
    private float hipotecaBase;
    private float factorRevalorizacion;
    private float factorInteresesHipoteca;
    private float precioCompra;
    private float precioEdificar;

    private boolean hipotecado;

    private int numCasas;
    private int numHoteles;

    private Jugador propietario;

    
    /** Constructor de la clase.
     * @post titulo no hipotecado, sin pripietario, casas ni hoteles
     */
    TituloPropiedad (String nombre, float ab, float fr, float hb, float pc, float pe) {
        this.nombre = nombre;
        alquilerBase = ab;
        factorRevalorizacion = fr;
        hipotecaBase = hb;
        precioCompra = pc;
        precioEdificar = pe;

        hipotecado = false;
        propietario = null;
        numCasas = 0;
        numHoteles = 0;
        factorInteresesHipoteca = 1.1f ;
    }
    
    /** Actualiza el propietario. */
    void ActualizaPropietarioPorConversion (Jugador jugador) {
        propietario = jugador;
    }
    
    /** Si la propiedad está hipotecada y el jugador es el propietario, se 
     * cancela la hipoteca. */
    boolean cancelarHipoteca (Jugador jugador) {
        boolean result = false;
        
        if (hipotecado && esEsteElPropietario(jugador)) {
                jugador.paga(getImporteCancelarHipoteca());
                hipotecado = false;
                result = true;
            }
        
        return result;
    }
    
    /** Devuelve la suma del num de casas y hoteles construidos. */
    int cantidadCasasHoteles() {
        return (numCasas + numHoteles);
    }
    
    /** Si el jugador es el propietario y n es menor al num de casas, 
     *  se decrementa el contador de casas en n unidades
     * @param n numero a decrementar del contador
     * @param jugador jugador al que aplicar el decremento de casas
     * @return @retval true si se ha realizado la operacion @retval false si no ha sido el caso
     */
    boolean derruirCasas (int n, Jugador jugador) {
        boolean correcto = true;
        
        if (n >= numCasas && esEsteElPropietario(jugador)) 
            numCasas -= n;
        else
            correcto = false;
        
        return correcto;
    }
    
    /** Comprueba si el jugador pasado como parámetro es el propietario del título. */
    private boolean esEsteElPropietario (Jugador jugador) {
        return (jugador == propietario); 
    }
    
    /** Si el titulo tiene propietario y no es el jugador pasado como parametro, 
     * este paga el alguiler correspondiente, y el propietario recibe ese mismo importe. */
    void tramitarAlquiler (Jugador jugador) {
        if (tienePropietario() && !esEsteElPropietario (jugador)) {
            jugador.pagaAlquiler (getPrecioAlquiler());
            propietario.recibe (getPrecioAlquiler());
        }
    }

    /** Si el jugador pasado como parámetro es el propietario y este no está hipotecado,
     *  entonces se da al propietario el precio de venta, se desvincula al propietario de la 
     *  propiedad y se eliminan las casas y hoteles.
     * @warning desvincular propietario !!
     */
    boolean vender (Jugador jugador) {
        boolean vendido = false;
        if (esEsteElPropietario(jugador) && !hipotecado) {
            propietario.recibe(precioCompra);
            numCasas = 0;
            numHoteles = 0;
            //desvincular propietario del jugador ?
            propietario = null;
            vendido = true;
        }
        return vendido;
    }
    
    boolean comprar (Jugador jugador) {
        boolean result = false;
        
        if (!tienePropietario()) {
            propietario = jugador;
            result = true;
            jugador.paga(getPrecioCompra());
        }
        
        return result;
    }
    
    
    boolean construirHotel (Jugador jugador) {
        boolean result = false;
        if (esEsteElPropietario(jugador)) {
            jugador.paga(precioEdificar);
            numHoteles += 1;
            result = true;
        }
        return result;
    }
    
    boolean construirCasa (Jugador jugador) {
        boolean result = false;
        if (esEsteElPropietario(jugador)) {
            jugador.paga(precioEdificar);
            numCasas += 1;
            result = true;
        }
        return result;
    }
    
    
    boolean hipotecar (Jugador jugador) {
        boolean salida = false;
        if (!hipotecado && esEsteElPropietario(jugador)) {
            jugador.recibe(getImporteHipoteca());
            hipotecado = true;
            salida = true;
        }
        
        return salida;
    }
    
    
    
    // ---------------------------------------------------------------------- //    
    // --------------------------- Consultores ------------------------------ //
    // ---------------------------------------------------------------------- //
    
    public boolean getHipotecado () {
        return hipotecado;
    }

    float getImporteCancelarHipoteca () {
        return (factorInteresesHipoteca * hipotecaBase);
    }

    float getImporteHipoteca () {
        return hipotecaBase;
    }

    String getNombre() {
        return nombre;
    }

    int getNumCasas() {
        return numCasas;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    float getPrecioAlquiler() {
        float precio;

        if (hipotecado || propietarioEncarcelado())
            precio = 0f;
        else
            precio = (float) (alquilerBase * (1 + ( (float)numCasas*0.5) + ( (float)numHoteles*2.5)));

        return precio;
    }

    float getPrecioCompra () {
        return precioCompra;
    }

    float getPrecioEdificar () {
        return precioEdificar;
    }

    float getPrecioVenta () {
        return (precioCompra + precioEdificar * (numCasas+numHoteles) * factorRevalorizacion);
    }

    Jugador getPropietario () {
        return propietario;
    }
    
    boolean tienePropietario() {
        return (propietario != null);
    }
    
    private boolean propietarioEncarcelado () {
        return (tienePropietario() && propietario.isEncarcelado());
    }
    
    @Override
    public String toString() {
        String estado =  nombre + "\n"
                        + " >> Alquiler base: " + alquilerBase + "\n"
                        + " >> Hipoteca base: " + hipotecaBase + "\n"
                        + " >> Factor de revalorizacion: " + factorRevalorizacion + "\n"
                        + " >> Factor intereses hipoteca: " + factorInteresesHipoteca + "\n"
                        + " >> Precio compra: " + precioCompra + "\n"
                        + " >> Precio edificar: " + precioEdificar + "\n"
                        + " >> Hipotecado: " + hipotecado + "\n"
                        + " >> Nº de casas: " + numCasas + "\n"
                        + " >> Nº de hoteles: " + numHoteles + "\n" ;
        
        if (propietario != null)
            estado += " >> Propietario: " + propietario.getNombre() + "\n";
        else
            estado += " >> No tiene propietario. \n";
        return estado;
    }
}