import java.awt.*;
import javax.swing.*;
public class ExamView1 extends JPanel {
    JButton buttonStart;      //�����ð�ť��ʼѵ��
    JButton  nextQuesion;      //�����ð�ť�����һ��Ŀ
    JButton submitButton;     //����ť
    JButton radioA,radioB,radioC,radioD;//��Ŀ��ѡ��
    JLabel  showChoice;          //��ʾ�û���ѡ����Ϣ
    JLabel  showErrorAmount;    //��ʾ�û�����������Ŀ
    JTextArea  showQuesion;    //������ʾ��ѡ����ʾ��
    //JButton showImage ;          //�����ͼ��ʾ��ͼ
    JPanel panel ;             //���ø����û���������Ҫ�����
    HandleExmation1 handle;
    ExamView1() {
      buttonStart = new JButton("��ʼѵ��");
      nextQuesion = new JButton("��һ��Ŀ");
      submitButton = new JButton("����");
      showChoice = new JLabel();
      showErrorAmount=new JLabel("������Ŀ��");
      radioA = new JButton(); 
      radioB = new JButton();
      radioC = new JButton(); 
      radioD = new JButton();
      showQuesion = new JTextArea("�ж���");
      showQuesion.setFont(new Font("����",Font.BOLD,17));
      showQuesion.setWrapStyleWord(true);
      showQuesion.setLineWrap(true);  //�Զ�����
     // showImage = new JButton(new ImageIcon("image/wait.gif"));
      JScrollPane pane=new JScrollPane();
      JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,showQuesion,pane);
      split.setDividerLocation(1000);  
      add(buttonStart,BorderLayout.NORTH);
      add(split,BorderLayout.CENTER); 
      panel = new JPanel();
      panel.setLayout(new GridLayout(2,1));
      add(panel,BorderLayout.SOUTH);   
      handle = new  HandleExmation1();  //���ݵĴ�����
      handle.setExamView1(this);       //�����ͼ������
      handle.setAmount(3,0) ;              //�����������������Ŀ
      nextQuesion.setEnabled(false);
      buttonStart.addActionListener(handle);
      nextQuesion.addActionListener(handle);
      submitButton.addActionListener(handle);
      radioA.addActionListener(handle);
      radioB.addActionListener(handle);
      radioC.addActionListener(handle);
      radioD.addActionListener(handle);
      setSize(1000,500);
      setVisible(true);
      //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   public void initOne() {
      panel.removeAll();
      JPanel pOne = new JPanel();
      pOne.setLayout(new GridLayout(1,5));
      pOne.setBackground(Color.green);
      pOne.add(showErrorAmount);
      pOne.add(showChoice);
      JLabel tishi=new  JLabel("��ѡ��:");
      pOne.add(tishi);
      pOne.add(radioA);
      pOne.add(radioB);
      JPanel pTwo = new JPanel(); 
      pTwo.setLayout(new GridLayout(1,2));
      pTwo.setBackground(Color.blue);
      pTwo.add(nextQuesion);
      pTwo.add(submitButton);
      panel.add(pOne);
      panel.add(pTwo);
      panel.repaint();
      validate();
   }
   public void initTwo() {
      panel.removeAll();
      JPanel pOne = new JPanel();
      pOne.setLayout(new GridLayout(1,7));
      pOne.setBackground(Color.pink);
      pOne.add(showErrorAmount);
      pOne.add(showChoice);
      JLabel tishi=new  JLabel("��ѡ��:");
      pOne.add(tishi);
      pOne.add(radioA);
      pOne.add(radioB);
      pOne.add(radioC);
      pOne.add(radioD);
      JPanel pTwo = new JPanel(); 
      pTwo.setBackground(Color.cyan);
      pTwo.setLayout(new GridLayout(1,2));
      pTwo.add(nextQuesion);
      pTwo.add(submitButton);
      panel.add(pOne);
      panel.add(pTwo);
      panel.repaint();
      validate();
   }
}