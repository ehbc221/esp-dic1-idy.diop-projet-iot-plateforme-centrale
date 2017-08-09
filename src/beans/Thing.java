package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Thing {
	private String userId;
	private String macAdresse;
	private HashMap<String, String> mapData;
	ArrayList<Service> arrServices; 
	
	public Thing(String mac, String id){
		this.userId = id;
		this.macAdresse = mac;
		this.mapData = new HashMap<String, String>();
		this.arrServices = new ArrayList<Service>();
	}
	public String getMacAdresse(){
		return macAdresse;
	}
	public String getUserId(){
		return userId;
	}
	public void putData(String key, String data){
		mapData.put(key, data);
	}
	public String getData(String key){
		return mapData.get(key);
	}
	
	public void setFromDatagram(String datagram){
		String[] tabData = datagram.split(";");
		for(int i=0; i<tabData.length; i++){
			putData(tabData[i].substring(0, 3), tabData[i].substring(4));
		}
	}
	public boolean existData(String key){
		return mapData.containsKey(key);
	}
	public void resetData(){
		mapData.clear();
	}
	public void subscribe(Service service){
		arrServices.add(service);
	}
	public String toString(){
		String str = macAdresse+";"+userId;
		Iterator it = this.mapData.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry couple = (Map.Entry)it.next() ;
	        String dat = (String)couple.getValue() ;
	        str = str+";"+dat;
	    }

	    return str;
	}
	public void update(){
		/* Parcours ArrayList avec les indices */
	    for (int i=0 ; i < this.arrServices.size() ; i++) {
	        Service service = this.arrServices.get(i);
	        service.WriteData(this);
	    }
	}
	
	
}
