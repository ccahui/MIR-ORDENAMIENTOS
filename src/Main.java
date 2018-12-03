import java.util.Scanner;

public class Main {
	
	public static int array[];
	
	public static void main(String[] args) {
	

		recibirEntrada();
		
		tiempoBubleSort();
		tiempoInsertSort();
		tiempoQuickSort();
		tiempoHeapSort();
		
		tiempoPropuesta();
		tiempoMergeSort();
	
	}
	//Donde el Primer digito es el TAM  DEL ARRAY seguido del Arreglo Completo
	public static void recibirEntrada() {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		array = new int [n];
		for(int i=0;i<n;i++)
			array[i]=scan.nextInt();
		
	}
	public static int [] copiarArray() {

		int n = array.length;
		int [] arrayCopia = new int [n]; 
		System.arraycopy(array,0,arrayCopia,0,n);
		
		return arrayCopia;
	}
	
	public static void tiempoInsertSort() {
		
		int [] arrayCopia = copiarArray();
		
		long ingreso=System.currentTimeMillis();
			Ordenar.insertSort(arrayCopia);
		long salida=System.currentTimeMillis();
		
		System.out.println("TIEMPO InsertSort: "+(salida-ingreso));
		
	}
	
	public static void tiempoBubleSort() {
		
		int [] arrayCopia = copiarArray();
		
		long ingreso=System.currentTimeMillis();
			Ordenar.burbuja(arrayCopia);
		long salida=System.currentTimeMillis();
		
		System.out.println("TIEMPO BubleSort: "+(salida-ingreso));
		
	}
	
	public static void tiempoMergeSort() {

		int [] arrayCopia = copiarArray();
		
		long ingreso=System.currentTimeMillis();
		Ordenar.mergeSort(arrayCopia);
		long salida=System.currentTimeMillis();
		System.out.println("TIEMPO MergeSort: "+(salida-ingreso));
		
	}
	
	public static void tiempoQuickSort() {

		int [] arrayCopia = copiarArray();

		long ingreso=System.currentTimeMillis();
		Ordenar.quickSort(arrayCopia);
		long salida=System.currentTimeMillis();
		System.out.println("TIEMPO QuickSort: "+(salida-ingreso));
	
	}
	
	public static void tiempoHeapSort() {

		int [] arrayCopia = copiarArray();

		long ingreso=System.currentTimeMillis();
		Ordenar.heapSort(arrayCopia);
		long salida=System.currentTimeMillis();
		System.out.println("TIEMPO HeapSort: "+(salida-ingreso));
	
	}
	//MODIFICACION MERGE SORT
	public static void tiempoPropuesta() {

		int [] arrayCopia = copiarArray();
			Ordenar.propuesta(arrayCopia);
		//System.out.println(validar(arrayCopia));
	}
	
	public static void print(int array[]) {
		for(int i = 0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	
	public static boolean validar(int array[]) {
		int n = array.length;
		for(int i=1;i<n;i++)
			if(array[i]<array[i-1])
				return false;
		return true;
			
	}
	
}
