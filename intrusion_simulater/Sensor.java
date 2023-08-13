package intrusion_simulater;

public class Sensor {
	boolean active;
	double p;
	
	public Sensor(double my_p) {
		active = true;
		p = my_p;
	}
	
	public void change_state() {
		double x = Math.random();
		if (x <= p) {
			active = !active;
		}
		return;
	}
}
