import java.util.Scanner;
public class Elephant {

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the coordinate of Elephant friend's house: ");
			int x=sc.nextInt(); 		
			int n;		
			if (x<=5) {
				System.out.println("1");
			}
			else {
				if(x%5==0) {
					n=x/5;
					System.out.println("The minimum no of steps: "+n);
				}
				else {
					n=x/5+1;
					System.out.println("The minimum no of steps: "+n);
				}
			}
		}
	}
