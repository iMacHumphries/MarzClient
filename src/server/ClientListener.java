package server;

import server.packets.*;

public interface ClientListener {	
	
	void clientDidReceiveLoginPacket(Packet00Login loginPack);
	
	void clientDidReceiveDisconnectPacket(Packet01Disconnect disconnectPack);
	
	void clientDidReceiveAllDataPacket(Packet02AllData quickPack);
}
