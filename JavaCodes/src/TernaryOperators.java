
public class TernaryOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double number =-5.5d;
		String result;
		if(number>0)
		{
		    System.out.println("Number is positive");	
		}
		else
		{
			System.out.println("Number is negative");	
		}
		
		result = number>0?"Number is positive":"Number is negative";
		System.out.println(result);
		
	}

}
