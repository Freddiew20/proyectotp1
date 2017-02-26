package piladealmacen;

import java.io.*;

public class Almacen {
	
	private Pale[] pales = new Pale[1000];
	private int posicion;
	private double totalPeso;
	private int totalCajas;
	private BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	public void menu() throws NumberFormatException, IOException{
		int opcion = 0;
		do{
		
			System.out.println("----------MENU----------");
			System.out.println("1. A�adir pale.");
			System.out.println("2. Quitar pale.");
			System.out.println("3. Mostrar pale.");
			System.out.println("4. Mostrar pales");
			System.out.println("0. Salir");
			
			opcion = Integer.parseInt(teclado.readLine());
			
			switch (opcion) {
			case 1:
				addPale();
				break;
			case 2:
				quitarPale();
				break;
			case 3:
				mostrarPale();
				break;
			case 4:
				recorrer();
				break;
			case 0:
				System.out.println("Adios!!!!!");
				break;
				
	
			default:
				System.out.println("Por favor, elija un numero de 1 al 4.");
				break;
		}
		
		}while(opcion!=0);
	}

	private void mostrarPale() throws NumberFormatException, IOException {
		System.out.println("Introduzca el codigo del pale a mostrar: ");
		Pale a = new Pale();
		int codaux = Integer.parseInt(teclado.readLine());
		
		for (int i = posicion-1; i >= 0; i--) {
			if(pales[i].getCodigo().equals(codaux)){
				System.out.println(pales[i]);
				return;
			}
			
		}
		System.out.println("El c�digo introducido no corresponde a ning�n pal�.");
	}

	private void quitarPale() {
		pales[posicion]=null;
		posicion--;
		System.out.println("Se ha quitado un pal�.");
	}

	private void addPale() throws NumberFormatException, IOException {
		System.out.println("Introduzca los datos del pal� que desea introducir:");
		Pale a = new Pale();
		a.PedirPale();
		
		for (int i = posicion-1; i >= 0; i--) {
			if(a.getCodigo().equals(pales[i])){
				System.out.println("Lo sentimos, pero el pal� que intenta introducir ya se encuentra en la pila.");
				return;
			}
			pales[posicion]=a;
			posicion++;
			
		}
	}
	
	public void recorrer(){
		for (int i = 0; i < pales.length; i++) {
			System.out.println(pales[i]);
		}
	}
	
	
}
