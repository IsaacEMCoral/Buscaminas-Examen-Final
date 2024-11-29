import java.util.Random;

public class Tablero {
	private static final char MINA = '*';
	private static final char VACIO = '.';
	private static final char REVELADO = '$';
	
	private int dimension; 
	private int numeroMinas; 
	private char[][] tablero; 
	private boolean[][] revelado;
	
	public Tablero(int tamano, int numeroMinas) { 
		this.dimension = tamano; 
		this.numeroMinas = numeroMinas; 
		tablero = new char[tamano][tamano]; 
		revelado = new boolean[tamano][tamano]; 
		inicializarTablero(); 
		colocarMinas(); 
	}
	private void inicializarTablero() { 
		for (int i = 0; i < dimension; i++) { 
			for (int j = 0; j < dimension; j++) { 
				tablero[i][j] = VACIO; 
				revelado[i][j] = false; 
			} 
		} 
	}
	private void colocarMinas() { 
		Random random = new Random(); 
		int minasColocadas = 0; 
		while (minasColocadas < numeroMinas) { 
			int fila = random.nextInt(dimension); 
			int columna = random.nextInt(dimension); 
			if (tablero[fila][columna] != MINA) { 
				tablero[fila][columna] = MINA; 
				minasColocadas++; 
			} 
		} 
	}
	public void imprimirTablero() { 
		for (int i = 0; i < dimension; i++) { 
			for (int j = 0; j < dimension; j++) { 
				if (revelado[i][j]) { 
					System.out.print(tablero[i][j] + " "); 
					} else { 
						System.out.print(VACIO + " "); 
					} 
				} 
			System.out.println(); 
		} 
	}
	public void revelarCelda(int fila, int columna) throws CeldaInvalidaException { 
		if (fila < 0 || fila >= dimension || columna < 0 || columna >= dimension) { 
			throw new CeldaInvalidaException("Coordenadas fuera del tablero."); 
		} 
		if (revelado[fila][columna]) { 
			throw new CeldaInvalidaException("Celda ya revelada."); 
		} 
		revelado[fila][columna] = true; 
		if (tablero[fila][columna] == MINA) { 
			System.out.println("¡Boom! Has encontrado una mina. Fin del juego."); 
			System.exit(0); 
		} else {
			tablero[fila][columna] = REVELADO;
		}
	} 
}
