package tp2;

public class Test {
	
	
	public static void main(String[] args) {
		test1();
		test2();
	}
		
	public static void test1(){
		Character [] alfabeto = {'a','b','c'}; 
		Character [] clave = {'a','b'}; 
		
		Trie<Character,Integer> libros = new Trie<Character, Integer>(alfabeto);
		Tupla<Character [],Integer> tupla = new Tupla<Character [],Integer>(clave,123);  
		
		libros.agregar(tupla);
		
		if (libros.buscar(clave) != null)
			System.out.println(libros.buscar(clave).toString());
	}
	
	public static void test2(){
		Character [] alfabetoCHR = {'a','b','c'}; 
		Integer [] alfabetoINT = {0,1,2,3,4,5,6,7,8,9}; 
		Biblio biblio = new Biblio(alfabetoCHR, alfabetoINT);
		biblio.agregarPorNombre("ab", 123);
		System.out.println(biblio.buscarPorNombre("ab"));
	}

}
