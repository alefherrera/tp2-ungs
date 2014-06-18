package tp2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tupla<E1, E2> {

	private E1 e1;
	private E2 e2;

	public Tupla() {
	}

	public Tupla(E1 e1, E2 e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public E1 getE1() {
		return e1;
	}

	public void setE1(E1 e1) {
		this.e1 = e1;
	}

	public E2 getE2() {
		return e2;
	}

	public void setE2(E2 e2) {
		this.e2 = e2;
	}

	//Mejorado para el soporte de arrays
	@Override
	public String toString() {
		String ret = "";

		if (e1 != null)
		{
			if (e1.getClass().isArray())
			{
				String aux = "";
				Object[] arr = (Object[]) e1;
				for (int i = 0; i < arr.length; i++) {
					aux += arr[i].toString() ;
				}
				ret += aux + ",";
			}
			else
			ret = ret + e1.toString() + ",";
		}
		if (e2 != null)
		{
			if (e2.getClass().isArray())
			{
				String aux = "";
				Object[] arr = (Object[]) e2;
				for (int i = 0; i < arr.length; i++) {
					aux += arr[i].toString() ;
				}
				ret += aux + ",";
			}
			else
			ret = ret + e2.toString();
		}
		return ret;
	}

	//Mejorado para el soporte de arrays
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tupla other = (Tupla) obj;
		if (e1 == null) {
			if (other.e1 != null)
				return false;
		} else if (e1.getClass().isArray()) {
			if (other.e1.getClass().isArray()) {
				Object[] arr1 = (Object[]) e1;
				Object[] arr2 = (Object[]) other.e1;
				return Arrays.equals(arr1, arr2);
			}
		} else if (!e1.equals(other.e1))
			return false;
		if (e2 == null) {
			if (other.e2 != null)
				return false;
		} else if (e2.getClass().isArray()) {
			if (other.e2.getClass().isArray()) {
				Object[] arr1 = (Object[]) e2;
				Object[] arr2 = (Object[]) other.e2;
				return Arrays.equals(arr1, arr2);
			}
		} else if (!e2.equals(other.e2))
			return false;
		return true;
	}

}
