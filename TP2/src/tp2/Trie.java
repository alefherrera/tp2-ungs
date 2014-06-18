package tp2;

import java.util.ArrayList;
import java.util.Arrays;

public class Trie<T1,T2> {
	
	T1 [] alfabeto;
	TrieNodo<T1,T2> raiz;
	
	public Trie(T1 [] alfabeto){
		this.alfabeto = alfabeto;
		//Inicializo la raiz para agregar siempre a sus hijos ya que la raiz no va a poseer caracter que lo identifique
		raiz = new TrieNodo<>(null, alfabeto.length);
	}

	public void agregar(Tupla<T1 [],T2 > s) throws Exception{
		if (invariante(s.getE1()))
		raiz.agregar(s);
		else throw new Exception("Esta insertando datos iniexistentes en el alfabeto");
	}
	
	private boolean invariante(T1[] t)
	{
		int c = 0;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < alfabeto.length; j++) {
				if (t[i] == alfabeto[j])
					c++;
			}
		}
		return c == t.length;
	}
	
	@Override
	public String toString() {
		return raiz.toString();
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trie other = (Trie) obj;
		if (!Arrays.equals(alfabeto, other.alfabeto))
			return false;
		if (raiz == null) {
			if (other.raiz != null)
				return false;
		} else if (!raiz.equals(other.raiz))
			return false;
		return true;
	}

	public ArrayList<Tupla<T1 [],T2 >> buscar(T1 [] buscar){
		return raiz.buscar(buscar);
	}
	
}