package server.packets;

public class Packet02AllData extends Packet {

	private Dictionary dictionary;
	
	public Packet02AllData(Dictionary _dictionary) {
		super(02);
		dictionary = _dictionary;
	}
	
	public Packet02AllData(byte[] data) {
		super(02);
		String[] dataArray = readData(data).split(",");
		dictionary = new Dictionary(dataArray);
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}
	
	@Override
	public byte[] getData() {
		return ("02" + dictionary.toString()).getBytes();
	}
	
	public String toString() {
		return dictionary.toString();
	}
}
