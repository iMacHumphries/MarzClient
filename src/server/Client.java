package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import server.packets.*;

public class Client extends Thread {
	private InetAddress hostIPAddress;
	private DatagramSocket socket;

	private ClientListener delegate;

	public Client(ClientListener delegate, String ip) throws UnknownHostException {
		System.out.println("Starting client ...");
		this.delegate = delegate;
		try {
			hostIPAddress = InetAddress.getByName(ip);
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			byte[] data = new byte[Constants.MAX_BYTES];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			parsePacket(packet);
		}
	}

	private void parsePacket(DatagramPacket pack) {
		byte[] data = pack.getData();
		String message = new String(pack.getData());
		String id = message.substring(0, 2);
		
		PacketType type = PacketType.getTypeForId(id);
		switch (type) {
		
		case INVALID:
			System.out.println("Invalid packet type from server.");
			break;
			
		case LOGIN:
			delegate.clientDidReceiveLoginPacket(new Packet00Login(data));
			break;
			
		case DISCONNECT:
			delegate.clientDidReceiveDisconnectPacket(new Packet01Disconnect(data));
			break;
			
		case ALL_DATA:
			delegate.clientDidReceiveAllDataPacket(new Packet02AllData(data));
			break;
			
		case SERVER_DATA:
			System.out.println("Should not get a server_data packet");
			break;
			
		default:
			System.out.println("Unkown packet type from server.");
			break;
		}
	}

	public void sendData(Packet pack) {
		sendData(pack.getData());
	}
	
	public void sendData(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length,
				hostIPAddress, Constants.PORT_NUMBER);
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("error sending data to client");
			e.printStackTrace();
		}
	}
}
