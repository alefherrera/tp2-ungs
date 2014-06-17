package tp2;

import java.util.ArrayList;

public class Biblio {
	Trie<Character, Long> porNombre;
	Trie<Long, String> porISBN;

	// pasar astring
	public Biblio(Character[] alfabeto1, Long[] alfabeto2) {
		porNombre = new Trie<Character, Long>(alfabeto1);
		porISBN = new Trie<Long, String>(alfabeto2);
	}

	public void agregarPorNombre(String nombre, Long ISBN) {
		porNombre.agregar(new Tupla<Character[], Long>(stringToChar(nombre),
				ISBN));
		porISBN.agregar(new Tupla<Long[], String>(longToArray(ISBN), nombre));
	}

	public void agregarISBN(Long ISBN, String nombre) {
		porISBN.agregar(new Tupla<Long[], String>(longToArray(ISBN), nombre));
		porNombre.agregar(new Tupla<Character[], Long>(stringToChar(nombre),
				ISBN));
	}

	public ArrayList<Tupla<String, Long>> buscarPorNombre(String nombre) {
		ArrayList<Tupla<Character[], Long>> respuesta;
		respuesta = porNombre.buscar(stringToChar(nombre)); // ArrayList<Tupla<Chacaracter
															// [],Integer >>

		ArrayList<Tupla<String, Long>> respuesta2 = new ArrayList<Tupla<String, Long>>();

		String aux = "";
		for (int i = 0; i < respuesta.size(); i++) {
			aux = charToString(respuesta.get(i).getE1());
			// genero las Tuplas <Tupla<String,Integer >>
			respuesta2.add(new Tupla<String, Long>(aux, respuesta.get(i)
					.getE2()));
		}

		return respuesta2;
	}
	
	public ArrayList<Tupla<String,Long>> buscarPorISBN(Long ISBN){
		ArrayList<Tupla<Long[], String>> respuesta = porISBN.buscar(longToArray(ISBN));
		ArrayList<Tupla<String, Long>> respuesta2 = new ArrayList<Tupla<String, Long>>();
		Long aux;
		for (int i = 0; i < respuesta.size(); i++) {
			aux = arrayToLong(respuesta.get(i).getE1());
			// genero las Tuplas <Tupla<String,Integer >>
			respuesta2.add(new Tupla<String, Long>( respuesta.get(i)
					.getE2(),aux));
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
	
	private Long[] longToArray(Long valor){
		char[] aux = valor.toString().toCharArray();
		Long[] r = new Long[aux.length];
		for (int i = 0; i < aux.length; i++) {		
			r[i] = (long)Character.getNumericValue(aux[i]);
		}
		return r;
	}
	
	private Long arrayToLong(Long[] l){
		String s = "";
		for (int i = 0; i < l.length; i++) {
			s += l[i].toString();
		}
		return Long.parseLong(s);
	}
	

}
