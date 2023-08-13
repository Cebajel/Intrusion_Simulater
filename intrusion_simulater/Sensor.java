package intrusion_simulater;

public class Sensor {
	boolean active;
	
	public Sensor() {
		active = true;
	}
	
	public void change_state() {
		int x = (int) Math.round(Math.random());
		if (x > 0) {
			active = !active;
		}
		return;
	}
}
