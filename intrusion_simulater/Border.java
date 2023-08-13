package intrusion_simulater;

public class Border {
	final int length = 1000;
	int width;
	Sensor[][] sensors;
	
	public Border(int x, double p) {
		width = x;
		sensors = new Sensor[length][width];
		for(int i=0; i<length; i++)
		    for(int j=0; j<width; j++)
		        sensors[i][j] = new Sensor(p);
	}
	
	public void change_state() {
		for(int i=0; i<length; i++)
		    for(int j=0; j<width; j++)
		        sensors[i][j].change_state();
		return;
	}
	
}
