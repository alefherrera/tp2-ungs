package tp2;

import java.util.ArrayList;

public class Biblio {
	Trie<Character, Integer> porNombre;
	Trie<Integer, Character> porISBN;

	// pasar astring
	public Biblio(Character[] alfabeto1, Integer[] alfabeto2) {
		porNombre = new Trie<Character, Integer>(alfabeto1);
		porISBN = new Trie<Integer, Character>(alfabeto2);
	}

	public void agregarPorNombre(String nombre, Integer ISBN) {

		porNombre.agregar(new Tupla<Character[], Integer>(stringToChar(nombre),
				ISBN));
	}

	public void agregarISBN(Integer ISBN, String nombre) {
	}

	public ArrayList<Tupla<String, Integer>> buscarPorNombre(String nombre) {
		ArrayList<Tupla<Character[], Integer>> respuesta;
		respuesta = porNombre.buscar(stringToChar(nombre)); // ArrayList<Tupla<Chacaracter
															// [],Integer >>

		ArrayList<Tupla<String, Integer>> respuesta2 = new ArrayList<Tupla<String, Integer>>();

		String aux = "";
		for (int i = 0; i < respuesta.size(); i++) {
			aux = charToString(respuesta.get(i).getE1());
			// genero las Tuplas <Tupla<String,Integer >>
			respuesta2.add(new Tupla<String, Integer>(aux, respuesta.get(i)
					.getE2()));
		}

		return respuesta2;
	}

	private String charToString(Character[] valor) {
		String ret = "";

		for (int i = 0; i < valor.length; i++) {
			ret = ret + valor[i];
		}

		return ret;
	}

	private Character[] stringToChar(String valor) {
		char[] aux = valor.toCharArray();
		Character[] clave = new Character[aux.length];

		for (int i = 0; i < aux.length; i++) {
			clave[i] = aux[i];
		}

		return clave;

	}

}
