package beans;

public interface DataReceiver {
	public void open();
	public String readDatagram();
	public boolean ready();
	public void close();
}
