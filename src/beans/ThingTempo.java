package beans;

import java.util.Date;

public class ThingTempo extends Thing{
	private static long delay;
	private long lastUpdate;
	public ThingTempo(String mac, String id) {
		super(mac, id);
		// TODO Auto-generated constructor stub
		this.lastUpdate = 0;
	}
	public static void setDelay(long time){
		delay = time;
	}
	public static long getDelay(){
		return delay;
	}
	public void update(){
		Date now = new Date() ;
	    long time = now.getTime() ;
	    System.out.println("chrono = "+(time-lastUpdate)+" and delay="+delay);
	    if((time-lastUpdate)>delay){
	    	super.update();
	    	lastUpdate = time;
	    }
	}

}
