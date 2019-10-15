package selenium.testing.advance.utilityClass;
import java.util.ArrayList;
import java.util.Scanner;
public class MatchString {
	public static Scanner sc=new Scanner(System.in);
	
	public Boolean check(String find,String array) {
		char[] findArray=find.toCharArray();
		char[] inputarray=array.toCharArray();
		int sizeOfinput=find.length(),count=0,j=0;
		for(int i=0;i<inputarray.length;i++) {
			
			if(inputarray[i]==findArray[j] && sizeOfinput>j) {
			count++;
			j++;
			}
			if(count==sizeOfinput) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchString ms=new MatchString();
		System.out.println("Enter Dictionary:/n for quit enter 'N'");
		String input=sc.next();
		String print=null;
		ArrayList<String> myInput = new ArrayList<String>();
		int max=-1;
		while(!input.equalsIgnoreCase("N")) {
			myInput.add(input);
			input=sc.next();
		}
		System.out.println("Enter String to be Search");
		String array=sc.next();
		for(String in:myInput) {
			//System.out.println(in);
			if(ms.check(in, array)) {
				if(max<in.length()) {
					max=in.length();
					print=in;
				}
			}
		}
		System.out.println("String Found Longest "+print+" Max Length: "+max);
		
	}

}
