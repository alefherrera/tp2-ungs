package tp2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// test1();
		test2();
	}

	public static void test1() {
		Character[] alfabeto = { 'a', 'b', 'c' };
		Character[] clave = { 'a', 'b' };
		Character[] clave1 = { 'a', 'b', 'c' };
		Character[] clave2 = { 'a', 'c', 'b' };
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
		Character[] alfabetoCHR = { 'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z' };
		Long[] alfabetoINT = { 0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L };
		Biblio biblio = new Biblio(alfabetoCHR, alfabetoINT);
		biblio.agregarPorNombre("ab", 123L);
		biblio.agregarPorNombre("ab", 125L);
		biblio.agregarISBN(122L, "acc");
		System.out.println(biblio.buscarPorNombre("ab"));
		System.out.println(biblio.buscarPorNombre("acc"));
		System.out.println(biblio.buscarPorISBN(125L));
	}

}
