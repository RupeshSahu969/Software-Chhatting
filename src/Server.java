import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.*;

public class Server extends JFrame implements ActionListener{

	private static final int Image_SCALE_DEFAULT = 0;
	private static final int Font = 0;
	private static final Color ColorWHITE = null;
	JPanel p1;
	JTextField t1;
	JButton b1;
	
	static JTextArea a1;
	
	
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	
	
	
	Server(){
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		add(p1);
		
		
		
		
		
		addMouseListener (new MouseAdapter(){
		public void mouseClicked(MouseEvent ae) {
			System.exit(0);
		}
			
		});
		
		
				

		//ImageIcon i7= new ImageI con(ClassLoader.getSystemResource("/Chatting Application/icon/rrr.png.jpg"));
		//Image i8=i7.getImage().getScaledInstance(30, 30, Image_SCALE_DEFAULT);
		//ImageIcon i9=new ImageIcon(i10);
		//JLabel l5=new JLabel(i9);
		//l5.setBounds(200,20,30,30);
		//p1.add(l5);	
		
		//ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("/Chatting Application/icon/rrr.png.jpg"));
		//Image i12=i11.getImage().getScaledInstance(35, 30, Image_SCALE_DEFAULT);
		//ImageIcon i13=new ImageIcon(i12);
		//JLabel l6=new JLabel(i13);
		//l6.setBounds(350,20,35,30);
		//p1.add(l6);	
		
		
		//ImageIcon i14= new ImageIcon(ClassLoader.getSystemResource("/Chatting Application/icon/rrr.png.jpg"));
		//Image i15=i14.getImage().getScaledInstance(12, 25, Image_SCALE_DEFAULT);
		//ImageIcon i16=new ImageIcon(i15);
		//JLabel l7=new JLabel(i16);
		//l7.setBounds(420,20,15,30);
		//p1.add(l7);	
		
		JLabel l3=new JLabel("Rupesh");
		l3.setFont(new Font("SAN_SERIE",Font,18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110,15,100,20);
		p1.add(l3);
		
		JLabel l4=new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIE",Font,12));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110,38,100,20);
		p1.add(l4);
		
		
		
		
		
		a1=new JTextArea();
		a1.setBounds(5,75,440,550);
		//a1.setBackground(Color.PINK);
		//a1.setFont(new Font("SAN_SERIF", Font.PLAIN,16))
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		
		t1=new JTextField();
		t1.setBounds(5,655,310,40);
	
		add(t1);
		
		b1=new JButton("Send");
		b1.setBounds(320,655,125,40);
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		//b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(b1);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(450,740);
		setLocation(200,200);
		//setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		try {
			
				String out=t1.getText();
				a1.setText(a1.getText()+"\n\t\t\t"+out);
				dout.writeUTF(out);
				t1.setText("");
			
			
			}
			catch(Exception e) {
			
			}
		
		
		
		
	}
	
	
	
	public static void main (String[] args) {
		new Server().setVisible(true);
		
		
		String msginput="";
		
		try {
			
			skt=new ServerSocket(8002);
			s=skt.accept();
			
			din=new DataInputStream(s.getInputStream()); 
			dout=new DataOutputStream(s.getOutputStream());
			
			msginput=din.readUTF();
			a1.setText(a1.getText()+"\n"+msginput);
			
			skt.close();
			s.close();
		}
		catch(Exception e) {
			
			
			
		}
		
		
		
		
		
	}
	
	
	
}
