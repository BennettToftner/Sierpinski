public class SierpinskiLong {

	//Sierpinski's Triangle
	public static void main(String[] args) {
		int size = 64;
		long[][] pascal = new long[size][];
		for (int i = 1; i <= size; i++)
		{
			pascal[i - 1] = new long[i];
		}
		fillPascal(pascal);
		arrPrint(pascal);
		for (int i = 0; i < size; i += 2)
		{
			for (int s = (int)((size - i) / 2); s > 0; s--)
			{
				System.out.print(" ");
			}
			for (int j = 0; j < pascal[i].length; j++)
			{
				if (pascal[i][j] % 2 == 1)
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
	
	public static void fillPascal(long[][] arr)
	{
		arr[0][0] = 1;
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				long firstNum = 0;
				if (j - 1 != -1)
				{
					firstNum = arr[i - 1][j - 1];
				}
				long secondNum = 0;
				if (j < arr[i - 1].length)
				{
					secondNum = arr[i - 1][j];
				}
				arr[i][j] = firstNum + secondNum;
			}
		}
	}
	
	public static void arrPrint(long[][] arr)
	{
		for (long[] innerArr: arr)
		{
			for (long n: innerArr)
			{
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}
