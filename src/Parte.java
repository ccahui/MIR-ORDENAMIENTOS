
public class Parte {

	int inicio;
	int fin;
	
	public Parte() {
		this(0,0);
	}
	public Parte(int inic,int fin) {
		this.inicio = inic;
		this.fin = fin;
	}
	
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	public String toString() {
		return inicio+"-"+fin;
	}
}