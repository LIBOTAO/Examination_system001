import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //(1)
import java.sql.*;
class  HandleRegister implements ActionListener {
    Connection con;
    Statement sql; 
    JTextField  textID;           //����id
    JPasswordField textPassword ;  	//View
	int m;
    HandleRegister(){
       try{  Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//��������
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
            (null,"��ѧ����ע���������������ѧ��","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
          }   
         if(m!=0){
    	    JOptionPane.showMessageDialog
            (null,"ע��ɹ�","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);
         }
        else {
            JOptionPane.showMessageDialog
            (null,"ע��ʧ��","��Ϣ�Ի���", JOptionPane.WARNING_MESSAGE);

      
	   }
    }

}