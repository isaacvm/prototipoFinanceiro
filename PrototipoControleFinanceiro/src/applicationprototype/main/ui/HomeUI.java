package applicationprototype.main.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeUI extends JFrame {

	private JPanel contentPane;
	JButton btnCreate;
	JButton btnList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
/*		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnCreate = new JButton("Cadastrar");
		
		panel.add(btnCreate);
		
		btnList = new JButton("Listar resumo");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnList);
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public JButton getBtnExpenseList() {
		return btnList;
	}
	
	


}
