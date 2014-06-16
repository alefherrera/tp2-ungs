package tp2;

import java.util.ArrayList;

public class Trie<T1,T2> {
	
	T1 [] alfabeto;
	TrieNodo<T1,T2> raiz;
	
	public Trie(T1 [] alfabeto){
		this.alfabeto = alfabeto;
		raiz = new TrieNodo<>('a');
	}

	public void agregar(Tupla<T1 [],T2 > clave){
		raiz.buscar(clave.getE1()).valor = clave;		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return raiz.toString();
	}
	
	public ArrayList<Tupla<T1 [],T2 >> buscar(T1 [] buscar){
		return new ArrayList<Tupla<T1 [],T2 >>();
	}
	
}