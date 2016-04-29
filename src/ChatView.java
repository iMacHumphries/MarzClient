import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;


public class ChatView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton send;
	private JTextField msgField;
	private JTextArea chatBox;
	private Controller controller;
	
	public ChatView(Controller controller) {
		super(null);
		this.controller = controller;
		
		chatBox = new JTextArea("");
		chatBox.setEditable(false);
		chatBox.setBounds(6, 6, 317, 237);
		chatBox.setBorder(new TitledBorder("Chat"));
		add(chatBox);
		
		msgField = new JTextField();
		msgField.addActionListener(this);
		msgField.setBounds(6, 261, 317, 33);
		add(msgField);
		
		send = new JButton("Send");
		send.addActionListener(this);
		send.setBounds(327, 265, 117, 29);
		add(send);
	}

	public void display(String username, String msg) {
		chatBox.append(username + "> " + msg + "\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == send || e.getSource() == msgField) {
			controller.sendMsg(msgField.getText());
			msgField.setText("");
		}
	}
}
