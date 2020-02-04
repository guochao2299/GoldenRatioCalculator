import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.awt.event.InputMethodEvent;

public class frmMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputValue;
	private Boolean m_roundedValue=false;
	private double m_goldenRatio=1.618033988749;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    setBounds(100, 100, 280, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("1.618033988749");
		lblResult.setOpaque(true);
		lblResult.setBackground(new Color(192, 192, 192));
		lblResult.setFont(new Font("宋体", Font.PLAIN, 20));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(14, 13, 234, 143);
		contentPane.add(lblResult);
		
		txtInputValue = new JTextField();
		txtInputValue.getDocument().addDocumentListener(new javax.swing.event.DocumentListener()
		{
			public void UpdateTextValue()
			{
				try
				{
					double resultValue=Double.parseDouble(txtInputValue.getText());					
//					DecimalFormat df = new DecimalFormat("#.000000000000");
//					Math.round(a)
//					String str = df.format(resultValue*m_goldenRatio);
					double d2 = resultValue*m_goldenRatio;
			        BigDecimal b = new BigDecimal(d2);
			        
			        d2 = b.setScale(m_roundedValue?0:12, BigDecimal.ROUND_HALF_UP).doubleValue();			
					lblResult.setText(String.valueOf(d2));
				}
				catch(NumberFormatException ex)
				{
					lblResult.setText("输入的数字格式不正确");
				}
			}
			public void changedUpdate(DocumentEvent e)
			{
				UpdateTextValue();
			}
			public void insertUpdate(DocumentEvent e)
			{
				UpdateTextValue();
			}
			public void removeUpdate(DocumentEvent e)
			{
				UpdateTextValue();
			}
		}
		);
		txtInputValue.setFont(new Font("宋体", Font.PLAIN, 20));
		txtInputValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtInputValue.setText("1");
		txtInputValue.setBounds(14, 163, 109, 150);
		contentPane.add(txtInputValue);
		txtInputValue.setColumns(10);
		
		JButton btnNewButton = new JButton("CB:AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("1.618033988749");
				txtInputValue.setText("1");
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(124, 163, 62, 47);
		contentPane.add(btnNewButton);
		
		JButton btnInfo = new JButton("INFO");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"java swing example written by gc_2299","Infomation",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnInfo.setFont(new Font("宋体", Font.PLAIN, 12));
		btnInfo.setBounds(124, 209, 62, 47);
		contentPane.add(btnInfo);
		
		JButton btnNewButton_1 = new JButton("<html><center>\u03A6</center><br>INT</html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m_roundedValue=true;
			}
		});
		btnNewButton_1.setBounds(183, 163, 65, 93);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u03A6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_roundedValue=false;
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 30));
		btnNewButton_2.setBounds(124, 258, 124, 55);
		contentPane.add(btnNewButton_2);
	}
}
