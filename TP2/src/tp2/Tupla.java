package tp2;

public class Tupla<E1,E2> {

	private E1 e1;
	private E2 e2;
	
	public Tupla() {}
	
	public Tupla(E1 e1, E2 e2){
		this.e1= e1;
		this.e2 = e2;
	}
	
	public E1 getE1() {		return e1;	}
	
	public void setE1(E1 e1) {		this.e1 = e1;	}
	
	public E2 getE2() {		return e2;	}
	
	public void setE2(E2 e2) {		this.e2 = e2;	}
		

	@Override
	public String toString(){
		String ret = "";
		
		if (e1 != null) ret = ret + e1.toString() +",";
		if (e2 != null) ret = ret + e2.toString();
		
		return ret;
	}
	
}

