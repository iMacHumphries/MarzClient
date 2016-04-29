import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import server.Constants;


public class LoginView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField userField;
	private JTextField hostField;
	private JButton join;
	private Controller controller;
	
	public LoginView(Controller controller) {
		super(null);
		this.controller = controller;
		userField = new JTextField();
		hostField = new JTextField(Constants.HOST_IP);
		build();
	}

	private void build() {
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(77, 37, 123, 16);
		add(lblUsername);
		
		userField.setBounds(77, 69, 123, 28);
		add(userField);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setHorizontalAlignment(SwingConstants.CENTER);
		lblHost.setBounds(77, 109, 123, 16);
		add(lblHost);
		
		hostField.setBounds(77, 137, 123, 28);
		add(hostField);
		
		join = new JButton("Join");
		join.addActionListener(this);
		
		join.setBounds(77, 204, 123, 29);
		add(join);
	
		setSize(300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == join) {
			controller.login(userField.getText(), hostField.getText());
		}
	}
	
	
}
