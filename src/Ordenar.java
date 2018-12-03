public class Ordenar{

	//Metodo BubleSort
	public static void burbuja(int arreglo[]) {
		
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                
            	if (arreglo[j] < arreglo[j + 1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
    }
	
	//Metodo InserSort
	public static void insertSort(int array []){

		for(int i=1;i<array.length;i++){
			int aux=array[i];
			int j=i;
			while(j>0&&array[j-1]>aux){
				array[j]=array[j-1];
				j--;
			}
			array[j]=aux;
		}
	}
	
	
	//Metodo MergeSort
	public static void mergeSort(int []array) {
		int n = array.length;
		int p = 0;
		int q = n-1;
		int []aux=new int [array.length];	
		mergeSort(array,p,q,aux);

	}
	//Metodo QuickSort
	public static void quickSort(int array[]) {
		int n = array.length;
		int p = 0;
		int q = n-1;
		quickSort(array,p,q);
	}
	// Metodo HeapSort
    public static void heapSort(int[] v) {
        final int N = v.length;
        for(int nodo = N/2; nodo>=0; nodo--) hacerMonticulo(v, nodo, N-1);
        for(int nodo = N-1; nodo>=0; nodo--) {
            int tmp = v[0];
            v[0]    = v[nodo];
            v[nodo] = tmp;
            hacerMonticulo(v, 0, nodo-1);
        }
    }

	//Metodo MergeSort Propuesta
	public static void propuesta(int array[]) {
		//Particiono
		int n = array.length;
		int t = 0; //CANTIDAD DE PARTES
		Parte[]partes = new Parte[n];
		int inicio = 0;
		int fin;
		
		for(int i=1;i<n;i++) {
			
			if(array[i-1] > array[i]) {
				
				Parte parte = new Parte();
				parte.setInicio(inicio);
				parte.setFin(i-1);
				partes[t] = parte;
				inicio = i;
				t++;
			}
			
		}
		Parte parte = new Parte();
		parte.setInicio(inicio);
		parte.setFin(n-1);
		partes[t] = parte;
		
		int aux[] = new int[n];
		long ingreso=System.currentTimeMillis();
		mergeSortPropuesta(array,0,t,partes,aux);
		long salida=System.currentTimeMillis();
	System.out.println("TIEMPO ModificacionMergeSort: "+(salida-ingreso));
	

	}
	
	public static void mergeSortPropuesta(int []array,int p,int q,Parte partes[],int []aux){
		if(p<q){
			int r=(p+q)/2;
			mergeSortPropuesta(array,p,r,partes,aux);
			mergeSortPropuesta(array,r+1,q,partes,aux);
			mergePartePropuesta(array,partes[p], partes[r], partes[q],partes,aux);
		}
	}
	public static void mergePartePropuesta(int array[],Parte pp,Parte rr,Parte qq,Parte[]partes,int []aux){

		//int []aux=new int [array.length];		
		int p = pp.inicio;
		int q = qq.fin;
		int r = rr.fin;

		for(int i=p;i<=r;i++)
			aux[i]=array[i];
		//Invierte el contenido de la segunda Mitad
		for(int j=q;j>r;j--)
			aux[j]=array[q-j+r+1];

		int i=p;
		int j=q;
		for(int k=p;k<=q;k++){
			if(aux[i]<aux[j])
				array[k]=aux[i++];
			else array[k]=aux[j--];
		}
	}	
	
	
	//ANEXOS MERGE SORT
	public static void mergeSort(int []array,int p,int q,int []aux){
		if(p<q){
			int r=(p+q)/2;
			mergeSort(array,p,r,aux);
			mergeSort(array,r+1,q,aux);
			merge(array, p, r, q,aux);
		}
	}
	
	public static void merge(int array[],int p,int r,int q,int []aux){

		//int []aux=new int [array.length];		
		for(int i=p;i<=r;i++)
			aux[i]=array[i];
		//Invierte el contenido de la segunda Mitad
		for(int j=q;j>r;j--)
			aux[j]=array[q-j+r+1];

		int i=p;
		int j=q;
		for(int k=p;k<=q;k++){
			if(aux[i]<aux[j])
				array[k]=aux[i++];
			else array[k]=aux[j--];

		}

	}
	//ANEXOS QuickSort
	public static void quickSort(int array[],int i,int j){
		if(i<j){
			int posPiv=quick(array,i,j);  
			quickSort(array,i,posPiv-1);
			quickSort(array,posPiv+1,j);
		}
	}	
	private static void intercambiar(int array[],int x,int y){
		int aux=array[x];
		array[x]=array[y];
		array[y]=aux;
	}
	public static int quick(int []array,int i,int j){
		int x=i-1;
		int pivot=array[j];
		for(int k=i;k<j;k++)
			if(array[k]<pivot){
				x++;
				intercambiar(array,x,k);
			}
		x++;
		intercambiar(array,x,j);
		return x ;
	}
	//Anexos HeapSort
    public static void hacerMonticulo(int[] v, int nodo, int fin) {
        int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= v[izq]>v[der]?izq:der;
        if(v[nodo] < v[may]) {
            int tmp = v[nodo];
            v[nodo] = v[may];
            v[may]  = tmp;
            hacerMonticulo(v, may, fin);
        }
    }
	
	public static void print(int array[]) {
		for(int i = 0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		int array[] = {4,3,2,1,8,3,6,9,8,5,15}; 
		propuesta(array);
		print(array);
	}
}
