import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class HandleExmation1 implements ActionListener {    
   ExamView1  view1; 
   String [][]xuanzeRecord;         //ȫ����ѡ����
   String [][]panduanRecord;        //ȫ�����ж���
   int  typePanduanAmount,typeXuanzeAmount;     //��Ҫ��������Ŀ�ĸ���
   LinkedList<String []> panduanList; //����ж���������Ա������ȡ
   LinkedList<String []> xuanzeList;
   int tihao=1;                   //���
   int score = 0;                     //�÷�
   int error =0;                      //������Ŀ
   String answer ;                   //��ȷ��
   PreQuery query;                   //����2������2���3������3
   HandleExmation1() {
      query=new PreQuery();
      panduanList = new LinkedList<String []>();
      xuanzeList = new LinkedList<String []>();
   }
   public void setAmount(int ...a) {
      typePanduanAmount = a[0];
      typeXuanzeAmount = a[1];
   }
   public void setExamView1(ExamView1 v) {
      view1 =v;
   }
   public void actionPerformed(ActionEvent e) {
       
       if(e.getSource()==view1.radioA) {
          view1.showChoice.setText(view1.radioA.getText());  
       }
       else if(e.getSource()==view1.radioB) {
          view1.showChoice.setText(view1.radioB.getText());  
       }
       else if(e.getSource()==view1.radioC) {
          view1.showChoice.setText(view1.radioC.getText());  
       }
       else if(e.getSource()==view1.radioD) {
          view1.showChoice.setText(view1.radioD.getText());  
       }
       if(e.getSource()==view1.buttonStart) {
         score = 0;
         error = 0; 
         tihao = 1;
         answer ="";
         view1.showErrorAmount.setText("������Ŀ:"+error+"    ");
         view1.buttonStart.setEnabled(false);
         view1.nextQuesion.setEnabled(true);
         query.setDatabaseName("englishtest");
         query.setSQL("SELECT * FROM panduanT1 ");
         query.startQuery();
         String [][]panduanRecord =query.getRecord();
         for(int i=0;i<panduanRecord.length;i++) {
            panduanList.add(panduanRecord[i]);
         }
         query.setSQL("SELECT * FROM danxuanT1 ");
         query.startQuery();
         String [][]xuanzeRecord =query.getRecord();
         for(int i=0;i<xuanzeRecord.length;i++) {
            xuanzeList.add(xuanzeRecord[i]);
         }
         getOneOfPanduanTi();  
       }
       if(e.getSource()==view1.nextQuesion) {
           String userAnwer=view1.showChoice.getText();
           if(userAnwer.equalsIgnoreCase(answer)) {
               score++;
           }
           else {
               error++;
               view1.showErrorAmount.setText("������Ŀ:"+error+"    ");
           }
           if(typePanduanAmount>0)
               getOneOfPanduanTi();
           else if(typePanduanAmount==0&&typeXuanzeAmount>0)
               getOneOfXuanzeTi();
           else if(typePanduanAmount==0&&typeXuanzeAmount==0){
               view1.nextQuesion.setEnabled(false);
               JOptionPane.showMessageDialog
               (null,"����"+score,"����"+score, JOptionPane.WARNING_MESSAGE);
               view1.buttonStart.setEnabled(true);
              
           }
        }
        if(e.getSource()==view1.submitButton) { //Ӧ�ý��������š�����д�����ݿ�
           view1.nextQuesion.setEnabled(false); //��������öԻ�����ʾ�˷���
           JOptionPane.showMessageDialog
           (null,"����"+score,"����"+score, JOptionPane.WARNING_MESSAGE);
           view1.buttonStart.setEnabled(true);
        }
    }
    private void getOneOfPanduanTi(){
         view1.initOne();   //����ͼ���ֻش��ж�������
         Random  random = new Random();
         int m=random.nextInt(panduanList.size()); 
         String [] shiti = panduanList.get(m);
         view1.showQuesion.setText(tihao+"\n"+shiti[1]);
         //view1.showImage.setIcon(new ImageIcon("image/"+shiti[2]));
         view1.radioA.setText(shiti[3]); 
         view1.radioB.setText(shiti[4]);
         answer = shiti[5];
         panduanList.remove(m);
         typePanduanAmount--;
         tihao++;
    }
    private  void getOneOfXuanzeTi(){
         view1.initTwo();   //����ͼ���ֻش�ѡ��������
         Random  random = new Random();
         int m=random.nextInt(xuanzeList.size()); 
         String [] shiti = xuanzeList.get(m);
         view1.showQuesion.setText(tihao+"\n"+shiti[1]);
         //view1.showImage.setIcon(new ImageIcon("image/"+shiti[2]));
         view1.showQuesion.append("\nA."+shiti[3]);
         view1.showQuesion.append("\nB."+shiti[4]);
         view1.showQuesion.append("\nC."+shiti[5]);
         view1.showQuesion.append("\nD."+shiti[6]);
         view1.radioA.setText("A"); 
         view1.radioB.setText("B");
         view1.radioC.setText("C"); 
         view1.radioD.setText("D");
         answer = shiti[7];
         xuanzeList.remove(m);
         typeXuanzeAmount--;
         tihao++;
    }
}