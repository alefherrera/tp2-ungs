package tp2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrieNodo<T1, T2> {

	public TrieNodo<T1, T2>[] hijos;
	public T1 letra;
	public Tupla<T1[], T2> valor;

	public TrieNodo(T1 l, int len) {
		letra = l;
		hijos = (TrieNodo<T1, T2>[]) Array.newInstance(TrieNodo.class, len);
	}

	public void agregar(Tupla<T1[], T2> s) {
		TrieNodo<T1, T2> nodo = this;
		for (int i = 0; i < s.getE1().length; i++) {
			int index = Utils.getIndex(s.getE1()[i]);
			if (nodo.hijos[index] == null) {
				nodo.hijos[index] = new TrieNodo<T1, T2>(
						 s.getE1()[i], hijos.length);
			}
			nodo = nodo.hijos[index];
		}
		nodo.valor = s;
	}

	public ArrayList<Tupla<T1[], T2>> buscar(T1[] s) {
		TrieNodo<T1, T2> nodo = this;
		int c = 0;
		for (int i = 0; i < s.length; i++) {
			int index = Utils.getIndex(s[i]);
			if (nodo.hijos[index] != null) {
				c++;
				nodo = nodo.hijos[index];
			}
		}
		if (c == s.length)
			return resultados(nodo);
		else
			return new ArrayList<>();
	}

	private ArrayList<Tupla<T1[], T2>> resultados(TrieNodo<T1, T2> n) {
		ArrayList<Tupla<T1[], T2>> r = new ArrayList<>();
		if (n == null)
			return r;
		if (n.valor != null)
			r.add(n.valor);
		for (int i = 0; i < n.hijos.length; i++) {
			if (n.hijos[i] != null)
				r.addAll(resultados(n.hijos[i]));
		}
		return r;
	}

	@Override
	public String toString() {
		String r = valor == null ? "" : valor.toString();
		for (int i = 0; i < hijos.length; i++) {
			if (hijos[i] != null) {
				r += hijos[i].toString();
			}
		}
		return r;
	}

}