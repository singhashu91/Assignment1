import java.util.*;
class ByteLand
{
	public static long MOD = 1000000007;
	public static void power(long P[][], long n)
	{
		if( n == 0 || n == 1)
    		return;
		long M[][] = {{1,1},{1,0}};
 		power(P, n/2);
		toAdd(P, P);
		if (n%2 != 0)
    	toAdd(P, M);
	}
	public static void toAdd(long P[][], long M[][])
	{
		long x =  ((P[0][0]*M[0][0])% MOD + (P[0][1]*M[1][0])%MOD)%MOD;
		long y =  ((P[0][0]*M[0][1])%MOD + (P[0][1]*M[1][1])%MOD)%MOD;
		long z =  ((P[1][0]*M[0][0])%MOD + (P[1][1]*M[1][0])%MOD)%MOD;
		long w =  ((P[1][0]*M[0][1])%MOD + (P[1][1]*M[1][1])%MOD)%MOD;
 
		P[0][0] = x;
		P[0][1] = y;
		P[1][0] = z;
		P[1][1] = w;
	}
	public static long counter(long n)
	{
		long P[][] = {{1,1},{1,0}};
		if (n == 0)
			return 0;
		if (n == 1)
			return 2;
		if (n == 2)
			return 3;
		power(P, n-2);
		return (P[0][0]*3+P[0][1]*2)%MOD;
	}
	

	public static void main(String[] args)
	{
		Scanner scr=new Scanner(System.in);
		long t=scr.nextLong();
		for(long i =0 ; i< t ; i++)
		{
			long n=scr.nextLong();

			System.out.println("Output : " + counter(n) );
		}
	}
}