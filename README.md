# MarzClient

##### Example Usage
```
try {
		manager = new MultiplayerManager(hostIp, this);
		manager.startClient();
		manager.localLogin(username);
			
		// Gets called on end of program
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
```

##### Sending a message
```
Dictionary dict = new Dictionary();
dict.put("user", username);
dict.put("msg", msg);
manager.sendToAll(dict);
```
