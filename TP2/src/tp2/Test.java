package tp2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		test1();
		// test2();
	}

	public static void test1() {
		Character[] alfabeto = { 'a', 'b', 'c' };
		Character[] clave = { 'a', 'b' };
		Character[] clave1 = { 'a', 'b', 'c' };
		Character[] clave2 = { 'a', 'l', 'e' };
		Character[] b = { 'a' };

		Trie<Character, Integer> libros = new Trie<Character, Integer>(alfabeto);
		Tupla<Character[], Integer> tupla = new Tupla<Character[], Integer>(
				clave, 123);
		Tupla<Character[], Integer> tupla1 = new Tupla<Character[], Integer>(
				clave1, 1233);
		Tupla<Character[], Integer> tupla2 = new Tupla<Character[], Integer>(
				clave2, 1243);
		libros.agregar(tupla);
		libros.agregar(tupla1);
		libros.agregar(tupla2);

		ArrayList<Tupla<Character[], Integer>> arr = libros.buscar(b);
		if (arr != null) {
			StringBuilder sb = new StringBuilder();
			for (Tupla<Character[], Integer> t : arr) {
				sb.append(charToString(t.getE1()) + ":" + t.getE2() + "\n");
			}
			System.out.println(sb.toString());
		}

	}

	private static String charToString(Character[] valor) {
		String ret = "";

		for (int i = 0; i < valor.length; i++) {
			ret = ret + valor[i];
		}

		return ret;
	}

	public static void test2() {
		Character[] alfabetoCHR = { 'a', 'b', 'c' };
		Integer[] alfabetoINT = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Biblio biblio = new Biblio(alfabetoCHR, alfabetoINT);
		biblio.agregarPorNombre("ab", 123);
		System.out.println(biblio.buscarPorNombre("ab"));
	}

}
