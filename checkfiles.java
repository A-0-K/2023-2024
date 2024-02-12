/*
 * checkfiles.java (check if two text files are the same)
 */
import java.util.*;
import java.io.*;

public class checkfiles {
	
	public static void main(String[] args) throws IOException {
	
		Scanner f1 = new Scanner(new File(args[0]));
		Scanner f2 = new Scanner(new File(args[1]));
	
		boolean isTheSame = true;
		int cnt = 1;
		while(true) {

			if( f1.hasNext() && f2.hasNext() ) {
				String line1 = f1.nextLine().trim();
				String line2 = f2.nextLine().trim();
			
				if( !line1.equals(line2) ) {
					isTheSame = false;
					break;
				}
			}
			else if ( f1.hasNext() && !f2.hasNext() || !f1.hasNext() && f2.hasNext() ) {
				isTheSame = false;
				break;
			}
			else //both files have finished
				break;

			cnt++;
		}

		f1.close();
		f2.close();

		System.out.printf("%-20s", args[1]);
		
		if(isTheSame)
			System.out.println("\tsame\n");
		else
			System.out.println("\tdiff at line " + cnt + "\n");
	}
}



