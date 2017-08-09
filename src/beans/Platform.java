package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Platform {
	private HashMap<String, Thing> mapThings;
	private ArrayList<Service> arrServices;
	
	public Platform(){
		this.mapThings = new HashMap<String, Thing>();
		this.arrServices = new ArrayList<Service>();
	}	
	public void addThing(Thing thing){
		this.mapThings.put(thing.getMacAdresse(), thing);
	}
	public void addService(Service service){
		this.arrServices.add(service);
	}
	public void run(DataReceiver dataReceiver){
		String data = "";
		Thing thing = null;
			
		while (dataReceiver.ready()){
			data = dataReceiver.readDatagram();
			if(data != null){
				thing = mapThings.get(data.substring(0, 17));
				if(thing==null){
					System.out.println("Erreur: l'adresse mac"+data.substring(0, 17)+" ne correspond a aucun des objets enregistrés sur la plateforme");
					
				}else{
					thing.setFromDatagram(data.substring(18));
					thing.update();
					thing.resetData();
				}
			}
			
		}
		
	}
	public void close(){
		 /* Parcours ArrayList avec les indices */
	    for (int i=0 ; i < this.arrServices.size() ; i++) {
	        this.arrServices.get(i).close();
	    }
	    
	}
	
}
