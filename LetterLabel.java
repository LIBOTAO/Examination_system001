import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LetterLabel extends JTextField implements FocusListener {
   LetterLabel() {
      setEditable(false);
      addFocusListener(this);//������1�� //����ǰ����ע��Ϊ����Ľ�������
      setBackground(Color.white);
      setFont(new Font("Arial",Font.PLAIN,30));
   }  
   public static  LetterLabel[] getLetterLabel(int n) {
      LetterLabel a[]=new LetterLabel[n];
      for(int k=0;k<a.length;k++)
         a[k]=new LetterLabel();
      return a;
   }
   public void focusGained(FocusEvent e) {
      setBackground(Color.cyan);
   }
   public void focusLost(FocusEvent e) {
      setBackground(Color.white);
   }
   public void setText(char c) {
      setText(""+c);
   }
}
