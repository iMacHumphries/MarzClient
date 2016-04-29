package server.packets;

public class Packet00Login extends Packet {

	private String username;
	
	public Packet00Login(String _username) {
		super(00);
		username = _username;
	}

	public Packet00Login(byte[] data) {
		super(00);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public byte[] getData() {
		return ("00" + username).getBytes();
	}

}
