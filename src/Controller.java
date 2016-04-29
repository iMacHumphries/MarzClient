import java.net.UnknownHostException;

import server.packets.Dictionary;


public class Controller {

	private MultiplayerManager manager;
	private MainFrame frame;
	private String username;
	
	public Controller() {
		frame = new MainFrame(this);
		frame.showView("loginView");
	}
	
	public boolean login(String user, String host) {
		username = user;
		boolean success = true;
		
		try {
			manager = new MultiplayerManager(host, this);
			manager.startClient();
			manager.localLogin(user);
			
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					manager.localDisconnect(username);
				}
			});
			
		} catch (UnknownHostException e) {
			success = false;
			e.printStackTrace();
		}
		
		if (success) {
			frame.showView("chatView");
		}
		
		return success;
	}
	
	public void sendMsg(String msg) {
		Dictionary dict = new Dictionary();
		dict.put("user", username);
		dict.put("msg", msg);
		manager.sendToAll(dict);
	}
	
	public void display(String username, String msg) {
		frame.getChatView().display(username, msg);
	}
}
