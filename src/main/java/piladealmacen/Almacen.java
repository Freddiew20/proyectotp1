package piladealmacen;

public class Almacen {
	
	private Pale[] pales = new Pale[1000];
	private int posicion;
	private double totalPeso;
	private int totalCajas;
	
	public void menu(){
		int opcion = 0;
		do{
		
			System.out.println("----------MEN�----------");
			System.out.println("1. A�adir pal�.");
			System.out.println("2. Quitar pal�.");
			System.out.println("3. Mostrar pal�.");
			System.out.println("4. Mostrar totales.");
			System.out.println("0. Salir");
			
			opcion = PedirDatos.leerEntero("Elija una opci�n");
			
			switch (opcion) {
			case 1:
				addPale();
				break;
			case 2:
				quitarPale();
				break;
			case 3:
				mostrarPales();
				break;
			case 4:
				mostrarTotales();
				break;
			case 0:
				System.out.println("Adi�s!!!!!");
				break;
				
	
			default:
				System.out.println("Por favor, elija un n�mero de 1 al 4.");
				break;
		}
		
		}while(opcion!=0);
	}
	
	
	private void mostrarTotales() {
		System.out.println("El total de cajas es: "+totalCajas+", y el peso total es de: "+totalPeso+" kilos." );
		
	}


	private void quitarPale() {
		pales[posicion] = null;
		posicion--;
		
		System.out.println("Pal� eliminado de la pila.");
	}

	private void addPale() {
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
	
	public void mostrarPales(){
		for (int i = 0; i < pales.length; i++) {
			System.out.println(pales[i]);
		}
	}
	
	
}
