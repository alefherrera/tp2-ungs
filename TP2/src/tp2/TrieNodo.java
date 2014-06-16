package tp2;

import java.lang.reflect.Array;

public class TrieNodo<T1, T2> {

	public TrieNodo<T1, T2>[] nodos;
	public Character letra;
	private TrieNodo<T1, T2> padre;
	public Tupla<T1[], T2> valor;

	public TrieNodo(Character l) {
		letra = l;
		nodos = (TrieNodo<T1, T2>[]) Array.newInstance(TrieNodo.class, 26);
	}

	public TrieNodo<T1, T2> buscar(T1[] s) {
		TrieNodo<T1, T2> nodo = this;
		for (int i = 0; i < s.length; i++) {
			int index = (Character)s[i] - 'a';
			TrieNodo<T1, T2> child = nodo.nodos[index];
			if (child == null) {
				child = new TrieNodo<T1, T2>((Character)s[i]);
				child.padre = this;
			}
			nodo = child;
		}
		return nodo;
	}
	
	@Override
	public String toString() {
		String r = valor == null ? "" : valor.toString();
		for (int i = 0; i < nodos.length; i++) {
			if(nodos[i] != null)
			{
				r += nodos[i].toString();
			}
		}
		return r;
	}

}