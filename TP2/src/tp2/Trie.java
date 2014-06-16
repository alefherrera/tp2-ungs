package tp2;

import java.util.ArrayList;

public class Trie<T1,T2> {
	
	T1 [] alfabeto;
	TrieNodo<T1,T2> raiz;
	
	public Trie(T1 [] alfabeto){
		this.alfabeto = alfabeto;
	}

	public void agregar(Tupla<T1 [],T2 > clave){
		
	}
	
	public ArrayList<Tupla<T1 [],T2 >> buscar(T1 [] buscar){
		return new ArrayList<Tupla<T1 [],T2 >>();
	}
	
}
