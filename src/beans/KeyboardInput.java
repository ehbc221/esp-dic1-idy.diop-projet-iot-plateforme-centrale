package beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput implements DataReceiver{
	private boolean ok;
	
	public KeyboardInput(){
		this.ok = false;
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		this.ok = true;
	}

	@Override
	public String readDatagram() {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("MAC ADRESS: ");
		String mac = null;
		try {
			mac = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mac.equals("quit")){
			close();
			return null;
		}
		System.out.print("DATAGRAM: ");
		String datagram = null;
		try {
			datagram = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (datagram.equals("quit")){
			close();
			return null;
		}
		
		return mac+";"+datagram;
	}

	@Override
	public boolean ready() {
		// TODO Auto-generated method stub
		return this.ok;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		this.ok = false;
	}
	
}
