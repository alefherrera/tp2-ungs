package tp2;

public class Test {
	
	
	public static void main(String[] args) throws Exception {
		test1();
		test2();
	}
		
	public static void test1() throws Exception{
		Character [] alfabeto = {'a','b','c'}; 
		Character [] clave = {'a','b'}; 
		
		Trie<Character,Integer> libros = new Trie<Character, Integer>(alfabeto);
		Tupla<Character [],Integer> tupla = new Tupla<Character [],Integer>(clave,123);  
		
		libros.agregar(tupla);
		
		if (libros.buscar(clave) != null)
			System.out.println(libros.buscar(clave).toString());
	}
	
	public static void test2() throws Exception{
		Character [] alfabetoCHR = {'a','b','c'}; 
		Long[] alfabetoINT = { 0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L };
		Biblio biblio = new Biblio(alfabetoCHR, alfabetoINT);
		biblio.agregarPorNombre("ab", 123L);
		System.out.println(biblio.buscarPorNombre("ab"));
	}

}
