import java.util.Random;
import java.util.Scanner;
public class Generador {
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		random(n);
	}
	public static void random(int cantidad){
		System.out.println(cantidad);
		Random rd=new Random(System.currentTimeMillis());
		for(int i=0;i<cantidad;i++) {
		System.out.println(rd.nextInt());	
	 
		}
	}
	public static void invertido(int cantidad) {
		System.out.println(cantidad);
		for(int i=cantidad;i>0;i--)  
			System.out.println(i);
	}

}
