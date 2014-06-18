package tp2;

import java.util.ArrayList;

public class Biblio {
	Trie<Character, Long> porNombre;
	Trie<Long, String> porISBN;

	public Biblio(Character[] alfabeto1, Long[] alfabeto2) {
		porNombre = new Trie<Character, Long>(alfabeto1);
		porISBN = new Trie<Long, String>(alfabeto2);
	}

	public void agregarPorNombre(String nombre, Long ISBN) {
		porNombre.agregar(new Tupla<Character[], Long>(Utils.stringToChar(nombre),
				ISBN));
		porISBN.agregar(new Tupla<Long[], String>(Utils.longToArray(ISBN), nombre));
	}

	public void agregarISBN(Long ISBN, String nombre) {
		porISBN.agregar(new Tupla<Long[], String>(Utils.longToArray(ISBN), nombre));
		porNombre.agregar(new Tupla<Character[], Long>(Utils.stringToChar(nombre),
				ISBN));
	}

	public ArrayList<Tupla<String, Long>> buscarPorNombre(String nombre) {
		ArrayList<Tupla<Character[], Long>> respuesta;
		respuesta = porNombre.buscar(Utils.stringToChar(nombre));
		ArrayList<Tupla<String, Long>> respuesta2 = new ArrayList<Tupla<String, Long>>();

		String aux = "";
		for (int i = 0; i < respuesta.size(); i++) {
			aux = Utils.charToString(respuesta.get(i).getE1());
			respuesta2.add(new Tupla<String, Long>(aux, respuesta.get(i)
					.getE2()));
		}

		return respuesta2;
	}

	public ArrayList<Tupla<String, Long>> buscarPorISBN(Long ISBN) {
		ArrayList<Tupla<Long[], String>> respuesta = porISBN
				.buscar(Utils.longToArray(ISBN));
		ArrayList<Tupla<String, Long>> respuesta2 = new ArrayList<Tupla<String, Long>>();
		Long aux;
		for (int i = 0; i < respuesta.size(); i++) {
			aux = Utils.arrayToLong(respuesta.get(i).getE1());
			respuesta2.add(new Tupla<String, Long>(respuesta.get(i).getE2(),
					aux));
		}
		return respuesta2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biblio other = (Biblio) obj;
		if (porISBN == null) {
			if (other.porISBN != null)
				return false;
		} else if (!porISBN.equals(other.porISBN))
			return false;
		if (porNombre == null) {
			if (other.porNombre != null)
				return false;
		} else if (!porNombre.equals(other.porNombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Biblio :{porNombre:[" + porNombre + "], porISBN:[" + porISBN + "]}";
	}
	
	

}
