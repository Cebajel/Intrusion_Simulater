package intrusion_simulator;

public class Infiltrator {
	public int x1, y1, x2, y2;
	private Clock my_clock;
	public boolean caught, succeeded, moving, choice;
	
	public Infiltrator(boolean my_choice) {
		my_clock = new Clock();
		caught = false;
		succeeded = false;
		moving = false;
		choice = my_choice;
		x1 = -1;
		y1 = -1;
		x2 = -1;
		y2 = -1;
	}
	
	private void analyze(Border border) {
		if(my_clock.time != 0) {
			return;
		}
		
		if((x1 == -1) && (y1 == -1)) {
			for(int i=0;i<border.length;i++) {
				if(!border.sensors[i][0].active) {
					x2 = i;
					y2 = 0;
					return;
				}
			}
			return;
		}
		
		if (choice) {
			if(border.sensors[x1][y1].active) {
				x2 = x1;
				y2 = y1;
				return;
			}
		}
		
//		y1+1
		if((y1+1) == border.width) {
			y2 = y1+1;
			x2 = x1;
			return;
		}
		
		if(!border.sensors[x1][y1+1].active) {
			y2 = y1+1;
			x2 = x1;
			return;
		}
		
		if((x1+1) < border.length) {
			if(!border.sensors[x1+1][y1+1].active) {
				y2 = y1+1;
				x2 = x1+1;
				return;
			}
		}
		
		if(x1 > 0) {
			if(!border.sensors[x1-1][y1+1].active) {
				y2 = y1+1;
				x2 = x1-1;
				return;
			}
		}
		
//		y1
		if((x1+1) < border.length) {
			if(!border.sensors[x1+1][y1].active) {
				y2 = y1;
				x2 = x1+1;
				return;
			}
		}
		
		if(x1 > 0) {
			if(!border.sensors[x1-1][y1].active) {
				y2 = y1;
				x2 = x1-1;
				return;
			}
		}
		
//		y1-1
		if(y1 > 0) {
			if(!border.sensors[x1][y1-1].active) {
				y2 = y1-1;
				x2 = x1;
				return;
			}
			
			if((x1+1) < border.length) {
				if(!border.sensors[x1+1][y1-1].active) {
					y2 = y1-1;
					x2 = x1+1;
					return;
				}
			}
			
			if(x1 > 0) {
				if(!border.sensors[x1-1][y1-1].active) {
					y2 = y1-1;
					x2 = x1-1;
					return;
				}
			}
		}
		
		x2 = x1;
		y2 = y1;
		return;
		
	}
	
	private void move(Border border) {
		if(my_clock.time != 1) {
			return;
		}
		
		if((x1 != x2) || (y1 != y2)) {
			moving = true;
			return;
		}
		
		return;
	}
		
	public void work(Border border) {
		if (my_clock.time == 0) {
			analyze(border);
			my_clock.increment_time();
			return;
		}
		
		if (my_clock.time == 1) {
			move(border);
			if(moving) {
				my_clock.increment_time();
			}
			else {
				my_clock.reset_time();
			}
			return;
		}
		
		my_clock.increment_time();
		
		if (my_clock.time == 10) {
			moving = false;
			x1 = x2;
			y1 = y2;
			my_clock.reset_time();
			
			if(y1 == border.width) {
				succeeded = true;
			}
			return;
		}
		return;
		
	}
	
	public void check(Border border) {
		if(!moving) {
			return;
		}
		
		if((x1 > -1) && (y1 > -1)) {
			if(border.sensors[x1][y1].active) {
				caught = true;
				return;
			}
		}
		
		if((y2) == border.width) {
			return;
		}
		
		if(border.sensors[x2][y2].active) {
			caught = true;
			return;
		}
		
		return;
	}
	
}
