package intrusion_simulater;
import java.util.Scanner;

public class Simulater {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter Border Width :");
	    int width = myObj.nextInt();
	    
	    if(width == 0) {
	    	System.out.println("\t THE END");
			System.out.println("Infiltrator Succeeded");
			return;
	    }
	    
	    System.out.println("Do you want the Intruder to "
	    		+ "analyze cell benath him while deciding for his next move? :");
	    boolean choice = myObj.nextBoolean();
	    
		Border my_border = new Border(width);
		Infiltrator my_infiltrator = new Infiltrator(choice);
		Clock my_clock = new Clock();
		
//		System.out.println(my_border.sensors[0][0].active);
		while((!my_infiltrator.succeeded) && (!my_infiltrator.caught)) {
			
			if (my_clock.time % 10 == 0) {
				my_border.change_state();
			}
			
			
			my_infiltrator.work(my_border);
			my_infiltrator.check(my_border);
			my_clock.increment_time();
			System.out.print("X1: " + my_infiltrator.x1);
			System.out.println(" Y1: " + my_infiltrator.y1);
			System.out.print("X2: " + my_infiltrator.x2);
			System.out.println(" Y2: " + my_infiltrator.y2);
			try {
				System.out.println("Is Present Cell Active? " + my_border.sensors[my_infiltrator.x1][my_infiltrator.y1].active);
			}
			catch(Exception e) {
				
			}
			try {
				System.out.println("Is Future Cell Active? " + my_border.sensors[my_infiltrator.x2][my_infiltrator.y2].active);
			}
			catch(Exception e) {
				if(my_infiltrator.y1 == width) {
					System.out.println("Passed the Border!");
				}
				else {
					System.out.println("ON THE LAST ROW!");
				}
			}
//			System.out.println("Time " + my_clock.time);
			System.out.println();
		}
		System.out.println("\t THE END");
		
		if(my_infiltrator.succeeded) {
			System.out.println("Infiltrator Succeeded");
		}
		else {
			System.out.println("Infiltrator Got Caught");
		}
		return;
	}
}
