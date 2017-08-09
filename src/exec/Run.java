package exec;

import java.io.IOException;
import java.util.*;

import beans.*;

public class Run {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome on Internet Of Thing platform.");
		
		int choix=-1;
		
		// creation des objets
		Thing t1 = new Thing("f0:de:f1:39:7f:17","1");
		Thing t2 = new Thing("f0:de:f1:39:7f:18","2");
		ThingTempo thTempo = new ThingTempo("f0:de:f1:39:7f:18","3");
		
		//creation des services
		Service s1 = new Service("mon_service1");
		Service s2 = new Service("mon_service2");
		SmartHome sh = new SmartHome("myKWHome");
		QuantifiedSelf qs = new QuantifiedSelf("RUNstats");
		
		//souscription des objets au service
		t1.subscribe(s1);
		t1.subscribe(s2);
		t2.subscribe(s1);
		

		//creation des dataReceiver
		KeyboardInput k = new KeyboardInput();
		FileReader f = new FileReader("simu.txt");
		k.open();
		f.open();
		
		//initialisation du plateforme
		Platform p = new Platform();
		p.addService(s1);
		p.addService(s2);
		p.addThing(t1);
		p.addThing(t2);
		
		
		while(choix == -1){
			System.out.println("1:Saisir les information du datagramme au clavier");
			System.out.println("2:Tester les comportements des services SmartHome et QuantifiedSelf en chargeant les datagramme du fichier simu.txt");
			System.out.println("3:Tester les comportements de l'objet ThingTempo");
			choix = sc.nextInt();
			switch(choix){
				case 1:
					p.run(k);
					break;
					
				case 2:
					t1.subscribe(sh);
					t1.subscribe(qs);
					
					t2.subscribe(sh);
					t2.subscribe(qs);
					
					p.addService(sh);
					p.addService(qs);
					
					p.run(f);
					break;
					
				case 3:
					System.out.println("Entrez le quantum de temps en (s)");
					ThingTempo.setDelay(sc.nextLong()*1000);
					System.out.println(ThingTempo.getDelay());
					thTempo.subscribe(s1);
					thTempo.subscribe(s2);
					
					p.addThing(thTempo);
					p.run(k);
					break;
					
				default:
					System.err.print("Choix non disponible");
					choix = -1;
					break;
			}
		}
		
		System.out.println("Bye.");
	}

}
