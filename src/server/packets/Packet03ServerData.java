package server.packets;


public class Packet03ServerData extends Packet {

	private Dictionary dictionary;
	
	public Packet03ServerData(Dictionary _dictionary) {
		super(03);
		this.dictionary = _dictionary;
	}
	
	public Packet03ServerData(byte[] data) {
		super(03);
		String[] dataArray = readData(data).split(",");
		dictionary = new Dictionary(dataArray);
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}
	
	@Override
	public byte[] getData() {
		return ("03" + dictionary.toString()).getBytes();
	}

}
