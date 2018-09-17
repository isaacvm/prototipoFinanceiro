package applicationprototype.main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class CreateUI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField fieldDate;
	private JTextField fieldValue;
	private JRadioButton radioRevenue;
	private JLabel lblRegistro;
	private JRadioButton radioExpense;
	private JLabel lblTipo;
	private JLabel lblClassificao;
	private JLabel lblDataddmmyyyy;
	private JLabel lblValor;
	private JLabel lblObservao;
	private JEditorPane paneObservation;
	private JButton btnSave;
	private JButton btnCancel;
	private GroupLayout gl_contentPane;
	private JComboBox comboType;
	private JComboBox comboClassification;
	
	

	public JTextField getFieldDate() {
		return fieldDate;
	}

	public JTextField getFieldValue() {
		return fieldValue;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JRadioButton getRadioRevenue() {
		return radioRevenue;
	}

	public JRadioButton getRadioExpense() {
		return radioExpense;
	}

	public JEditorPane getPaneObservation() {
		return paneObservation;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JComboBox getComboType() {
		return comboType;
	}

	public JComboBox getComboClassification() {
		return comboClassification;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
/*		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUI frame = new CreateUI();
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
	public CreateUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblRegistro = new JLabel("Registro:");
		
		radioRevenue = new JRadioButton("Receita");
		buttonGroup.add(radioRevenue);
		
		radioExpense = new JRadioButton("Despesa");
		buttonGroup.add(radioExpense);
		
		lblTipo = new JLabel("Tipo:");
		
		comboType = new JComboBox();
		
		lblClassificao = new JLabel("Classifica\u00E7\u00E3o:");
		
		comboClassification = new JComboBox();
		
		lblDataddmmyyyy = new JLabel("Data (dd/mm/yyyy):");
		
		fieldDate = new JTextField();
		fieldDate.setColumns(10);
		
		lblValor = new JLabel("Valor (e.g. 92845,43):");
		
		fieldValue = new JTextField();
		fieldValue.setColumns(10);
		
		lblObservao = new JLabel("Observa\u00E7\u00E3o");
		
		paneObservation = new JEditorPane();
		
		btnSave = new JButton("Salvar");
		
		btnCancel = new JButton("Cancelar");
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataddmmyyyy)
						.addComponent(lblValor)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRegistro)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radioRevenue)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioExpense))
								.addComponent(lblTipo)
								.addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblClassificao)
								.addComponent(comboClassification, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancel)
								.addComponent(btnSave)
								.addComponent(paneObservation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblObservao))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegistro)
						.addComponent(radioRevenue)
						.addComponent(radioExpense)
						.addComponent(lblObservao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTipo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblClassificao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboClassification, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(paneObservation))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDataddmmyyyy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
