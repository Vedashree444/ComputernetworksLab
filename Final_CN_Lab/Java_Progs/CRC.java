import java.util.*;
public class CRC {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int m,g[],n,d[],z[],r[],msb,i,j,k;
		System.out.println("Enter no. of bits in Dataword(d) : ");
		n=sc.nextInt();
		System.out.println("Enter no. of generator bits : ");
		 m=sc.nextInt();
		d=new int[n+m];
		g=new int[m];
		System.out.println("Enter Dataword bits(one bit per line):");
		for(i=0;i<n;i++)
			d[i]=sc.nextInt();
		System.out.println("Enter generator bits(one bit per line):");
		for(j=0;j<m;j++)
			g[j]=sc.nextInt();
		for(i=0;i<m-1;i++)
			d[n+i]=0;
		r=new int[m+n];
		for(i=0;i<m;i++)
			r[i]=d[i];
		z=new int[m];
		for(i=0;i<m;i++)
			z[i]=0;
		for(i=0;i<n;i++)
		{
			k=0;
			msb=r[i];
			for(j=i;j<m+i;j++)
			{
				if(msb==0)
					r[j]=xor(r[j],z[k]);
				else
					r[j]=xor(r[j],g[k]);
				k++;
			}
			r[m+i]=d[m+i];
		}
		System.out.println("The redundant(r) bits added are : ");
		for(i=n;i<n+m-1;i++)
		{
			d[i]=r[i];
			System.out.println(d[i]);
		}System.out.println();
		System.out.println("The codeword(c=d+r) is :");
		for(i=0;i<n+m-1;i++)
		{
			System.out.println(d[i]);
		}
		int c[]=new int[n+m];
		System.out.println();
		System.out.println("Enter the data bits recieived(one bit per line)");
		for(i=0;i<n+(m-1);i++)
			c[i]=sc.nextInt();
		int count=0;
		for(i=0;i<n+m-1;i++)
		{	if(c[i]==d[i])
			count++;
		else
			break;
		}
		
		if(count==n+m-1)
			System.out.println("No error");
		else{
			System.out.println("Error present");
			System.out.println("Error occurs at "+(count+1));
		}	}
	public static int xor(int x,int y)
	{
		if(x==y)
			return(0);
		else
			return(1);
	}
}

