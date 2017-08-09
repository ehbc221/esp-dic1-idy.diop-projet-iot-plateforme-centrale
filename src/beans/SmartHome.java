package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartHome extends Service{

	public SmartHome(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void WriteData(Thing thing){
		if (thing.getData("sta")!=null){
			Date now = new Date () ;
		    SimpleDateFormat formater = new SimpleDateFormat ("yyyy-MM-dd H:m:s");
		    String date = formater.format (now);
		    String data = date+";"+thing.toString();
		    pw.println(data);
		    pw.flush();
		}else{
			System.err.println("le datagramme doit contenir un attribut de type sta");
		}
	}

}
