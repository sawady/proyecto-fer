package persistence.test;

public class Cronometro {
	
	private long time;
	
	public void start(){
		time = System.currentTimeMillis();
	}

	public long stop(){
		time = Math.abs(time - System.currentTimeMillis());
		return time;
	}
	
	public void print(){
		System.out.println("Demora: " + time + " mils");
	}
}
