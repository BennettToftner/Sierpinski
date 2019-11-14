import java.math.BigInteger;

public class SierpinskiBigInteger {

	//Sierpinski's Triangle
	public static void main(String[] args) {
		int size = 256;
		BigInteger[][] pascal = new BigInteger[size][];
		for (int i = 1; i <= size; i++)
		{
			pascal[i - 1] = new BigInteger[i];
		}
		fillPascal(pascal);
		for (int i = 0; i < size; i += 2)
		{
			for (int s = (int)((size - i) / 2); s > 0; s--)
			{
				System.out.print(" ");
			}
			for (int j = 0; j < pascal[i].length; j++)
			{
				if (pascal[i][j].mod(new BigInteger("2")).equals(BigInteger.ONE))
				{
					System.out.print("▲");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void fillPascal(BigInteger[][] arr)
	{
		arr[0][0] = BigInteger.ONE;
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				BigInteger firstNum = BigInteger.ZERO;
				if (j - 1 != -1)
				{
					firstNum = arr[i - 1][j - 1];
				}
				BigInteger secondNum = BigInteger.ZERO;
				if (j < arr[i - 1].length)
				{
					secondNum = arr[i - 1][j];
				}
				arr[i][j] = firstNum.add(secondNum);
			}
		}
	}
}
