import java.util.*;
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v =new Vector();
		v.add("Krishna");
		v.add(1, "Rahul");
		v.addElement(25);
		v.add(50.4);
		v.add("deepak");
		v.add(null);
		v.add("krishna");
		v.add('k');
		v.addElement(1001);
		v.addElement('0');
		v.add(90);
		System.out.println(v);
		System.out.println(v.capacity());
		System.out.println(v);
		

	}

}
