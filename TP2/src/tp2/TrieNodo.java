package tp2;

public class TrieNodo<T1,T2> {

	public TrieNodo<T1,T2>[] nodos;
	public Tupla<T1, T2> valor;
	/*
	public TrieNodo<T1,T2> getNodo(String s) {
		TrieNodo<T1,T2> nodo = this;
		for (int i = 0; i < s.length(); i++) {
			int index = LOWERCASE.getIndex(s.charAt(i));
			TrieNodo<T1,T2> child = nodo.nodos[index];
			if (child == null) {
				// There is no such word
				return null;
			}
			nodo = child;
		}
		return nodo;
	}*/
	
}
