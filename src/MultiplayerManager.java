

import java.net.UnknownHostException;

import server.Client;
import server.ClientListener;
import server.packets.*;

public class MultiplayerManager implements ClientListener {

	private Client client;
	private Controller controller;

	public MultiplayerManager(String ip, Controller controller) throws UnknownHostException {
		this.controller = controller;
		client = new Client(this, ip);
	}

	public void startClient() {
		client.start();
	}

	public void localLogin(String username) {
		client.sendData(new Packet00Login(username));
	}

	public void localDisconnect(String username) {
		client.sendData(new Packet01Disconnect(username));
	}

	public void sendToAll(Dictionary dict) {
		client.sendData(new Packet02AllData(dict));
	}
	
	public void sendToServer(Dictionary dict) {
		client.sendData(new Packet03ServerData(dict));
	}

	@Override
	public void clientDidReceiveLoginPacket(Packet00Login loginPack) {
		System.out.println("Please log " + loginPack.getUsername() + " in.");
		controller.display(loginPack.getUsername(), " has joined the room.");
	}

	@Override
	public void clientDidReceiveDisconnectPacket(
			Packet01Disconnect disconnectPack) {
		System.out.println("Please disconnect " + disconnectPack.getUsername()
				+ ".");
		controller.display(disconnectPack.getUsername(), " has left the room.");
	}

	@Override
	public void clientDidReceiveAllDataPacket(Packet02AllData quickPack) {
		
		Dictionary dict = quickPack.getDictionary();
		System.out.println("Got data from server " + quickPack.toString() + " " + dict.get("user"));
		if (dict.has("msg") && dict.has("user")) {
			controller.display(dict.get("user"), dict.get("msg"));
		}
	}

	

}
