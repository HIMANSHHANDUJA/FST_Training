package activities;

public class Activity2 {
	public static void main(String[] Args) {
	int[] arr= {10, 77, 10, 54, -11, 10};
	int sum=0;int fixedSum = 30;
	for(int num:arr)
	{
		if(num==10)
		{
			sum+=num;

		}
		System.out.println(sum);
		
	}
	if (sum==fixedSum)
	{
		System.out.println("value is 30");
	}
	
	}
}
