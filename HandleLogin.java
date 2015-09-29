import java.awt.*;
import java.awt.event.*;
import javax.swing.*; //(1)
import java.sql.*;
class  HandleLogin implements ActionListener {
    Connection con;
    Statement sql; 
    ResultSet rs;
    JTextField  textID;           //输入id
    JPasswordField  textPassword ;       //View
    PreQuery query;
	HandleLogin(){
		  query=new PreQuery();
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
       try { 
					query.setDatabaseName("englishtest");
		             String SQL=
		            "select * from  biao "
		            + "where id='"+id+"'and password='"+password+"'";
		             
		             query.setSQL(SQL);
		             query.startQuery();
		             String ziduan[] =query.getColumnName();
		             String [][]record=query.getRecord();
		             if(password.equals(record[0][1])){
		            	 YWindow win = new YWindow();
		             }
		             else{
		            	 JOptionPane.showMessageDialog
		 		           (null,"请输入正确的密码","消息对话框", JOptionPane.WARNING_MESSAGE);
		             }		   		             
		       }
		       catch(Exception exp) { 
		         JOptionPane.showMessageDialog
		         (null," "+exp,"消息对话框", JOptionPane.WARNING_MESSAGE);
		     		       		       		 
	   }
    }

}