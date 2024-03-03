import java.util.*;
public class ArraySumDivideBy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n= s.nextInt();
		int[] a= new int[n];
		System.out.println("Enter "+n+" Element of Arrays: ");
		for (int i=0;i<a.length;i++)
		{
			a[i]= s.nextInt();
		}
		System.out.println(Arrays.toString(a));
		int sum=0;
		for (int i=0;i<n;i++)
		{
			if (a[i]%3==0)
			{
				sum=sum+a[i];
			}
		}
		System.out.println(sum);

	}

}
