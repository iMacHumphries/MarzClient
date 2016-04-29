package server.packets;

/**
 * Packet.java - 
 * @author Ben Humphries
 * @version Mar 26, 2016
 */
public abstract class Packet {
	protected byte id;
	protected PacketType type;
	
	/**
	 * Constructor init type and id
	 * @param _id
	 */
	public Packet(int _id) {
		id = (byte)_id;
		type = PacketType.getTypeForId(_id);
	}

	/**
	 * Must implement a method to convert to bytes
	 * @return byte[]
	 */
	public abstract byte[] getData();
	
	public String readData(byte[] data) {
		return new String(data).trim().substring(2);
	}
	
	public byte getID() {
		return id;
	}
	
	public PacketType getType() {
		return type;
	}
	
	public String toString() {
		return getData() + "";
	}
}
