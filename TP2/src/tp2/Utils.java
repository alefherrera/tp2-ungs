package tp2;

public class Utils {

	//Metodo para obtener el indice dependiendo el tipo. 
	//Hardcodeado para los tipos usados ya que seria mas complejo enviar un alfabeto junto con su metodo para obtener lo indices
	public static<T> int getIndex(T c)
	{
		if (c instanceof Character){
			Character ch = (Character)c;
			if (ch == ' ') return 26;
			return ch - 'a';
		}
		if (c instanceof Integer)
			return (Integer)c;
		if (c instanceof Long)
			return ((Long) c).intValue();
		return 0;
	}
	
	public static String charToString(Character[] valor) {
		String ret = "";
		for (int i = 0; i < valor.length; i++) {
			ret = ret + valor[i];
		}
		return ret;
	}

	public static Character[] stringToChar(String valor) {
		char[] aux = valor.toCharArray();
		Character[] clave = new Character[aux.length];
		for (int i = 0; i < aux.length; i++) {
			clave[i] = aux[i];
		}
		return clave;
	}

	public static Long[] longToArray(Long valor) {
		char[] aux = valor.toString().toCharArray();
		Long[] r = new Long[aux.length];
		for (int i = 0; i < aux.length; i++) {
			r[i] = (long) Character.getNumericValue(aux[i]);
		}
		return r;
	}

	public static Long arrayToLong(Long[] l) {
		String s = "";
		for (int i = 0; i < l.length; i++) {
			s += l[i].toString();
		}
		return Long.parseLong(s);
	}
	
}
