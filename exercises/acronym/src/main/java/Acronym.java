import java.io.BufferedReader;
import java.io.InputStreamReader;//Importing java.io for faster input/output
import java.io.IOException;
class Acronym
{	static String input;
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		input="  "+br.readLine().trim();
		System.out.println(getAcronym());
	}
	public static String getAcronym()       //Function to perform the main claculations
	{
		String output="";
		for(int i=0;i<input.length()-1;i++)
			if(input.charAt(i)==' ')      //If a character is a space, then add the next character in upper case to the output
				output+=Character.toString(input.charAt(i+1)).toUpperCase();
		return output.substring(1);     //Return the output without the preceding space
	}
}
