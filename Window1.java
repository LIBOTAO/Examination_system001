import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //(1)
public class Window1 extends JFrame {
   JTextField  textID;           //����id
   //JTextField  textName;
   JPasswordField  textPassword ;          //View
   JButton controlRegisterButton;
   JLabel one;   
   JLabel two; 
   JLabel label;
   JButton controlLoginButton;   //����������  //(2)
   HandleRegister  register; 
   HandleLogin  login; 
   Window1() {
	   
	//���ñ���  
		       super("JFram���ñ���ͼƬ(Cannel_2020)");  
		       //���ô�С  
		       setSize(350,450);  
		       //����λ��  
		       setLocation(0, 0);  
		       //����ͼƬ��·����
		       String path = "A.jpg";  
		       // ����ͼƬ  
		       ImageIcon background = new ImageIcon(path);  
		       // �ѱ���ͼƬ��ʾ��һ����ǩ����  
		       JLabel label = new JLabel(background);  
		       // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
		       label.setBounds(0, 0, this.getWidth(), this.getHeight());  
		       // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
		       JPanel imagePanel = (JPanel) this.getContentPane();  
		       imagePanel.setOpaque(false);  
		       // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
		       this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
		       //���ÿɼ�  
		       setVisible(true);  
		       //��رհ�ťʱ�˳�  


	  setLocation(560,130);
      setSize(250,430);
	  setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      register = new HandleRegister();
      login = new HandleLogin();
	  one = new JLabel("I D��") ;
	  two = new JLabel("�� ��:") ;
      textID = new JTextField(15);         //(4)
      textPassword = new JPasswordField(15);    
      controlRegisterButton=new JButton("ע��");
      controlLoginButton=new JButton("��½");
	  
      //setBackground(Color.yellow);
      add(one);
      add(textID);
      add(two);
      add(textPassword); 
      add(controlRegisterButton);
      add(controlLoginButton);    	  //(4)
	  one.setBounds(20,80,40,30);
	  textID.setBounds(70,80,120,30);
	  two.setBounds(20,130,40,30);
	  textPassword.setBounds(70,130,120,30);
	  controlRegisterButton.setBounds(70,200,100,30);
	  controlLoginButton.setBounds(70,250,100,30);
	  
	  register.setJTextField(textID);
	  register.setJPasswordField(textPassword);
	  login.setJTextField(textID);
	  login.setJPasswordField(textPassword);

      controlRegisterButton.addActionListener(register);
      controlLoginButton.addActionListener(login);
   }

}