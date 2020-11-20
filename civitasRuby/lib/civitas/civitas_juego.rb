=begin
Authors: Esther García Gallego
         Yesenia González Dávila
         Grupo B3
=end

require_relative 'Jugador'
require_relative 'Dado'
require_relative 'Tablero'
require_relative 'MazoSorpresas'
require_relative 'TituloPropiedad'


module Civitas
  class CivitasJuego
    
    NumJugadores = 2  # Todo lo que empiece con mayúsculas se considera constante
    CasillaCarcel = 3 # Preguntar de todas formas
    NumCasillas = 11
    
    def initialize(nombres)
      jugadores = []
      
      for i in 0..@@NumJugadores
        jugadores.insert(i,jugador.new(nombres[i])) # Crea el jugador
      end
      
      @gestorEstados = GestorEstados.new()
      @estado = @gestorEstados.estadoInicial()
      
      @indiceJugadorActual = Dado.instance().quienEmpieza(NumJugadores)
      
      inicializaMazoSorpresas(@tablero)
      inicializaTablero(@mazo)
      
    end
    
    def inicializaTablero(mazo)
      @tablero = Tablero.new(@@CasillaCarcel)
      
      # Creamos calles
      i = 1
      alquiler = 100
      hipotecaBase = 50
      precioCompra = 120
      precioEdificar = 200
      factorRev = 1.2
      nombre = "Calle "
     
      #t1 = TituloPropiedad.new(nombre + i, alquiler*i, factorRev, hipotecaBase*i, precioCompra*i, precioEdificar*i++)
      #t2 = TituloPropiedad.new(nombre + i, alquiler*i, factorRev, hipotecaBase*i, precioCompra*i, precioEdificar*i++)
      #t3 = TituloPropiedad.new(nombre + i, alquiler*i, factorRev, hipotecaBase*i, precioCompra*i, precioEdificar*i++)
      
      # Casillas
      c1 = Casilla.new(t1)
      c2 = Casilla.new(t2)
      
      s1 = Casilla.new(@mazo, "Sorpresa 1")
      
      Cantidad_impuesto 50
      impuesto = Casilla.new(Cantidad_impuesto, "Impuesto")
      
      for i in 1..NumCasillas
        case i
        
        when 1
          @tablero.añadeCasilla(c1)
        when 2
          @tablero.añadeCasilla(s1)
        when
          @tablero.añadeCasilla(impuesto)
        when
          @tablero.añadeCasilla(c2)
        when 6
          @tablero.añadeJuez
        end
        
      end
      
    end
    
    def inicializarMazoSorpresas(tablero)
      valor = 100
      ir_a_casilla = 6
      num_sorpresas = 6
      
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.IRCARCEL, tablero));
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.IRCASILLA, tablero, ir_a_casilla, " Ir a casilla 6 (JUEZ)"));
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.SALIRCARCEL, mazo));
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.PORJUGADOR, valor, " POR JUGADOR"));
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.PORCASAHOTEL, valor, " POR CASA HOTEL"));
      @mazo.alMazo(Sorpresa.new(TipoSorpresa.PAGARCOBRAR, valor, " PAGARCOBRAR"));
    end
    
    def avanzaJugador
      
      # Declaramos al jugador actual y su posicion
      jugadorActual = getJugadorActual();
      posicionActual = jugadorActual.getNumCasillaActual();
      jugadorActual.moverACasilla(posicionActual);
      
      # Calculamos su nueva posicion tirando el dado  
      tirada = Dado.Instance.tirar()
      posicionNueva = @tablero.nuevaPosicion(posicionActual, tirada)
      
      # Declaramos la casilla en la que está la nueva posición  
      casilla = @tablero.getPorSalida(posicionNueva)
      
      # Comprobamos si ha pasado por salida para que el jugador reciba el dinero en tal caso
      contabilizarPasosPorSalida(jugadorActual)
      
      # Movemos al jugador a la nueva posición
      jugadorActual.moverACasilla(posicionNueva)
      
      # Actualizamos la casilla y volvemos a comprobar si ha pasado por salida
      @casilla.recibeJugador(jugadorActual)
      contabilizarPorSalida(jugadorActual)
    end
    
    def getJugadorActual
      @jugadores.at(@indiceJugadorActual)
    end
    
    def getCasillaActual
      @tablero.getCasilla(getJugadorActual().getNumCasillaActual())
    end
    
    def contabilizarPasosPorSalida(jugadorActual)
      while @tablero.getPorSalida > 0
        jugadorActual.pasarPorSalida
      end
    end
    
    def pasarTurno
      indiceJugadorActual = (indiceJugadorActual+1) % NumJugadores
    end    
    
    def siguientePaso
      jugadorActual = @jugadores.at(@indiceJugadorActual)
      operacion = @gestorEstados.operacionesPermitidas(jugadorActual)
      
      if operacion == Civitas::OperacionesJuego::PASAR_TURNO
        pasarTurno()
        siguientePasoCompletado(operacion)
      elsif operacion == Civitas::OperacionesJuego::AVANZAR
        avanzarJugador()
        siguientePasoCompletado(operacion)
      end
    end
    
    def siguientePasoCompletado(operacion)
      @estado = @gestionEstados.siguienteEstado(getJugadorActual(), @estado, operacion)
    end
    
    def construirCasa(ip)
      getJugadorActual().construirCasa(ip)
    end
    
    def construirHotel(ip)
      getJugadorActual().construirHotel(ip)
    end
    
    def vender(ip)
      getJugadorActual().vender(ip)
    end
    
    def comprar
      jugadorActual = @jugadores.at(@indiceJugadorActual)
      casilla =@tablero.getCasilla(jugadorActual.getNumCasillaActual())
      titulo = casilla.getTituloPropiedad()
      jugadorActual.comprar(titulo)
    end
    
    def hipotecar(ip)
      getJugadorActual().hipotecar(ip)
    end
    
    def cancelarHipoteca(ip)
      getJugadorActual().cancelarHipoteca(ip)
    end
    
    def salirCarcelPagando
      getJugadorActual().salirCarcelPagando()
    end
    
    def salirCarcelTirando
      getJugadorActual().salirCarcelTirando()
    end
    
    def finalDelJuego
      finaljuego = false
      
      for i in 0..NumJugadores and !finaljuego
        finaljuego = @jugadores.at(i).enBancarrota()
      end
      
      finaljuego
    end
    
    def compareTo(jugador)
      # completar
    end
    
    def ranking
      playersrank = []
      
      jugadores_aux = @jugadores  # no sé cómo copiar un array
      
      for i in 0..NumJugadores
        max = jugadores_aux.at(0)
        pos = 0
        
        for j in 1..jugadores_aux.size
          if max.compareTo(jugadores_aux.at(j) < 0)
            max = jugadores_aux.at(j)
            pos = j
          end
        end
          
        playersrank.push(max)
        jugadores_aux.delete_at(pos)
        
      end
      
      return playersrank # Se puede poner return pa que quede más claro, no es un error
    end
    
    
  end
end
