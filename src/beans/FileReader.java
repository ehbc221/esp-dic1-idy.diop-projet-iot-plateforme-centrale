package beans;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader implements DataReceiver{
	private String filename;
	private BufferedReader br;
	private boolean ok;
	private int nbLines = 0;
	
	public FileReader(String filename){
		this.filename = filename;
		this.ok = false;
		
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub
		InputStream ips = null;
		try {
			ips = new FileInputStream(this.filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    InputStreamReader ipsr = new InputStreamReader(ips);
	    this.br = new BufferedReader(ipsr);
	    this.ok = true;
	}

	@Override
	public String readDatagram() {
		// TODO Auto-generated method stub
		String data = null;
		try {
			data = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(data == null || data.equals("")){
			System.err.println(nbLines+" Ligne(s) lue(s)");
			this.ok = false;
			return null;
		}
		this.nbLines++;
		return data	;
	}

	@Override
	public boolean ready() {
		// TODO Auto-generated method stub
		return this.ok;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ok = false;
		
	}

}
