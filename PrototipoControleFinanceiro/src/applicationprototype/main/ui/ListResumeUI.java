package applicationprototype.main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;

public class ListResumeUI extends JFrame {

	private JPanel contentPane;
	private JTable tableRevenue;
	private JTable tableExpense;
	private JButton btnClose;
	private JLabel lblReceitas;
	private JLabel lblDespesas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListResume frame = new ListResume();
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
	public ListResumeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tableRevenue = new JTable();
		
		lblReceitas = new JLabel("Receitas");
		lblReceitas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblDespesas = new JLabel("Despesas");
		lblDespesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tableExpense = new JTable();
		
		btnClose = new JButton("Fechar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReceitas)
						.addComponent(tableRevenue, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDespesas)
						.addComponent(tableExpense, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(335, Short.MAX_VALUE)
					.addComponent(btnClose))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblReceitas)
						.addComponent(lblDespesas))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tableRevenue, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(tableExpense, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnClose)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JTable getTableRevenue() {
		return tableRevenue;
	}

	public JTable getTableExpense() {
		return tableExpense;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

}
