import java.util.Scanner;

public class Buscaminas {

	private static final int DIMENSION_TABLERO = 10; 
	private static final int NUMERO_MINAS = 10; 
	
	private Tablero tablero; 
	private Scanner scanner; 
	
	public Buscaminas() { 
		tablero = new Tablero(DIMENSION_TABLERO, NUMERO_MINAS); 
		scanner = new Scanner(System.in); 
	} 
	public void jugar() { 
		while (true) { 
			tablero.imprimirTablero(); 
			System.out.println("Ingrese la fila y columna ( Empieza desde 0, separadas por un espacio): "); 
			int fila = scanner.nextInt(); 
			int columna = scanner.nextInt(); 
			try { 
				tablero.revelarCelda(fila, columna); 
			} catch (CeldaInvalidaException e) { 
				System.out.println(e.getMessage()); 
			} 
		} 
		
	} 
	
	public static void main(String[] args) { 
		Buscaminas juego = new Buscaminas(); 
		juego.jugar(); 
	}
}
