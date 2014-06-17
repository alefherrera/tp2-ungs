package tp2;

public class Utils {

	public static<T> int getIndex(T c)
	{
		if (c instanceof Character)
			return (Character)c - 'a';
		if (c instanceof Integer)
			return (Integer)c;
		if (c instanceof Long)
			return ((Long) c).intValue();
		return 0;
	}	
}
