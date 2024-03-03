import java.util.*;
public class ArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Array Size: ");
		int n=s.nextInt();
		int[] a= new int[n];
		System.out.println("Enter "+n+" element of array");
		for (int i=0;i<a.length;i++)
		{
			a[i]= s.nextInt();
		}
		int sum=0;
		System.out.println(Arrays.toString(a));
		for (int i=0;i<n;i++)
		{
			sum=sum+a[i];
		}
		System.out.println(sum);
	}

}
