package 餐厅点餐系统;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Land {
	private JFrame jf;
	
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JPanel jp4;
	
	private JTextField jtf1;
	private JPasswordField jpf1;
	
	private JLabel jl1;
	private JLabel jl2;
	
	private JButton jb1;
	private JButton jb2;
	
	public void init() {
	jf = new JFrame("登陆");
	
	jp1 = new JPanel();
	jp2 = new JPanel();
	jp3 = new JPanel();
	jp4 = new JPanel();
	
	jtf1 = new JTextField(15);
	jpf1 = new JPasswordField (15);
	jpf1.setEchoChar('*');
	
	jl1 = new JLabel("用户");
	jl2 = new JLabel("密码");
	
	jb1 = new JButton("登陆");
	jb2 = new JButton("重置");
	
	jf.setLayout(new GridLayout(3,1));
	jf.add(jp2);
	jf.add(jp3);
	jf.add(jp4);
	
	jp2.add(jl1);
	jp2.add(jtf1);
	
	jp3.add(jl2);
	jp3.add(jpf1);
	
	jp4.add(jb1);
	jp4.add(jb2);
	
	jb1.addActionListener(new ButtonListener());
	jb2.addActionListener(new ButtonListener());
	
	jf.pack();
	jf.setLocation(400, 300);
	jf.setLocationRelativeTo(null);
	jf.setVisible(true);
	jf.setAlwaysOnTop(false);
	
}
	
private class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	String command = event.getActionCommand();
		if("登陆".equals(command) && jtf1.getText().equals("123") && jpf1.getText().equals("123")) {
				new System1().init(jtf1.getText());
				jf.setVisible(false);
			}
		else if("登陆".equals(command) && jtf1.getText().equals("") && jpf1.getText().equals("")) {				
				JOptionPane.showMessageDialog(null,"请输入用户名和密码","提示",1);				
			}
		else if("重置".equals(command)) {
				jtf1.setText("");
				jpf1.setText("");
			}
		else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误！","错误 ",0);
				jtf1.setText("");
				jpf1.setText("");
			}
		}
	}
 
public static void showMessageDialog(Component parentComponent,Object message,String title,int messageType,Icon icon) {	
 
}
 
public static void main(String[] args) {
		new Land().init();
	}
}