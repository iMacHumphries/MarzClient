package server.packets;

public class Packet01Disconnect extends Packet {

	private String username;
	
	public Packet01Disconnect(String _username) {
		super(01);
		username = _username;
	}
	
	public Packet01Disconnect(byte[] data) {
		super(01);
		String[] dataArray = readData(data).split(",");
		this.username = dataArray[0];
	}

	public String getUsername() {
		return username;
	}

	@Override
	public byte[] getData() {
		return ("01" + username).getBytes();
	}

}
