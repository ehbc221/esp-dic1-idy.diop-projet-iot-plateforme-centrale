package beans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
	private String name;
	protected PrintWriter pw;
	
	public Service(String name){
		this.name = name;
		
		FileWriter fw = null;
		try {
			fw = new FileWriter ("log_"+this.name+".txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BufferedWriter bw = new BufferedWriter (fw);
	    this.pw = new PrintWriter (bw);
	}
	
	public void WriteData(Thing thing){
		Date now = new Date () ;
	    SimpleDateFormat formater = new SimpleDateFormat ("yyyy-MM-dd H:m:s");
	    String date = formater.format (now);
	    String data = date+";"+thing.toString();
	    pw.println(data);
	    pw.flush();
	}
	public void close(){
		pw.flush();
		pw.close();
	}
}
