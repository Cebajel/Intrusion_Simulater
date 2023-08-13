package intrusion_simulator;

public class Clock {
	int time;
	
	public Clock() {
		time = 0;
	}
	
	public void increment_time() {
		time++;
		return;
	}
	
	public void reset_time() {
		time = 0;
		return;
	}
}
