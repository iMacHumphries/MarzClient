package server.packets;

public enum PacketType {
	INVALID(-1),
	LOGIN(00),
	DISCONNECT(01),
	ALL_DATA(02),
	ALL_OTHER_DATA(03),
	SERVER_DATA(04);
	
	
	private int packetID;
	
	private PacketType(int _id) {
		this.packetID = _id;
	}
	
	public int getID() {
		return packetID;
	}
	
	public static PacketType getTypeForId(int _id) {
		PacketType result = PacketType.INVALID;
		for (PacketType p : PacketType.values()) {
			if (p.getID() == _id) {
				result = p;
			} 
		}
		return result;
	}
	
	public static PacketType getTypeForId(String _id) {
		try {
			return getTypeForId(Integer.parseInt(_id.substring(0, 2)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PacketType.INVALID;	
	}
}