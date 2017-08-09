package beans;

import java.util.Date;

public class QuantifiedSelf extends Service{

	public QuantifiedSelf(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void WriteData(Thing thing){
		if (thing.getData("geo")!=null){
			Date now = new Date() ;
		    long time = now.getTime() ;
		    String data = String.valueOf(time)+";"+thing.toString();
		    pw.println(data);
		    pw.flush();
		}else{
			System.err.println("le datagramme doit contenir un attribut de type geo");
		}
	}

}
