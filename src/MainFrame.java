import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel cards;
	private ChatView chatView;
	private LoginView loginView;
	
	/**
	 * Create the frame.
	 */
	public MainFrame(Controller controller) {	
		setTitle("Marz Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		loginView = new LoginView(controller);
		chatView = new ChatView(controller);
		cards = new JPanel(new CardLayout());
		cards.add(loginView, "loginView");
		cards.add(chatView, "chatView");
		
		add(cards);
		setVisible(true);
	}

	public ChatView getChatView() {
		return chatView;
	}
	
	public void showView(String name) {
		((CardLayout) cards.getLayout()).show(cards, name);
	}
	
}
