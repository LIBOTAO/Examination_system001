import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //(1)
import java.sql.*;
class  HandleRegister implements ActionListener {
    Connection con;
    Statement sql; 
    JTextField  textID;           //输入id
    JPasswordField textPassword ;  	//View
	int m;
    HandleRegister(){
       try{  Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//加载驱动
       }
       catch(Exception e) {
            System.out.print(e);
       }
 
    }
    public void setJTextField(JTextField ... t) {
       textID =t[0];

    }
    public void setJPasswordField(JPasswordField ... t) {
       textPassword =t[0];
     
    }
    public void actionPerformed(ActionEvent e) {
       String id = textID.getText().trim();
       String password = textPassword.getText().trim();
     
       String SQL = "insert into biao values"+
                    "('"+id+"','"+password+"')";


      try {
      con=DriverManager.getConnection  ("jdbc:derby:englishtest;create=false");
            sql=con.createStatement();
             m=sql.executeUpdate(SQL);
        
       
       }
       catch(Exception exp){
		    JOptionPane.showMessageDialog
            (null,"该学号已注册过，请重新输入学号","消息对话框", JOptionPane.WARNING_MESSAGE);
          }   
         if(m!=0){
    	    JOptionPane.showMessageDialog
            (null,"注册成功","消息对话框", JOptionPane.WARNING_MESSAGE);
         }
        else {
            JOptionPane.showMessageDialog
            (null,"注册失败","消息对话框", JOptionPane.WARNING_MESSAGE);

      
	   }
    }

}