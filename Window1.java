import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //(1)
public class Window1 extends JFrame {
   JTextField  textID;           //输入id
   //JTextField  textName;
   JPasswordField  textPassword ;          //View
   JButton controlRegisterButton;
   JLabel one;   
   JLabel two; 
   JLabel label;
   JButton controlLoginButton;   //控制器对象  //(2)
   HandleRegister  register; 
   HandleLogin  login; 
   Window1() {
	   
	//设置标题  
		       super("JFram设置背景图片(Cannel_2020)");  
		       //设置大小  
		       setSize(350,450);  
		       //设置位置  
		       setLocation(0, 0);  
		       //背景图片的路径。
		       String path = "A.jpg";  
		       // 背景图片  
		       ImageIcon background = new ImageIcon(path);  
		       // 把背景图片显示在一个标签里面  
		       JLabel label = new JLabel(background);  
		       // 把标签的大小位置设置为图片刚好填充整个面板  
		       label.setBounds(0, 0, this.getWidth(), this.getHeight());  
		       // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
		       JPanel imagePanel = (JPanel) this.getContentPane();  
		       imagePanel.setOpaque(false);  
		       // 把背景图片添加到分层窗格的最底层作为背景  
		       this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
		       //设置可见  
		       setVisible(true);  
		       //点关闭按钮时退出  


	  setLocation(560,130);
      setSize(250,430);
	  setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      register = new HandleRegister();
      login = new HandleLogin();
	  one = new JLabel("I D：") ;
	  two = new JLabel("密 码:") ;
      textID = new JTextField(15);         //(4)
      textPassword = new JPasswordField(15);    
      controlRegisterButton=new JButton("注册");
      controlLoginButton=new JButton("登陆");
	  
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