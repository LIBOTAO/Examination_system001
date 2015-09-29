import java.awt.*;
import javax.swing.*;
public class YWindow extends JFrame{
    JTabbedPane firstLayer;        //��һ�㴰��
    JTabbedPane secondLayerOne;   //��ӵ���һ���еĵ�2�㴰��
    JTabbedPane secondLayerTwo;   //��ӵ���һ���еĵ�2�㴰��
    JTabbedPane secondLayerThree;  
  
    //AddPanduanShitiView  addPanduanShitiView;
    //AddXuanzeShitiView   addXuanzeShitiView;
    ExamView  examView;
    ExamView1  examView1;
    SpellingWordFrame spellingWordFrame;

    public YWindow(){
        setBounds(100,20,900,560);
        setVisible(true);
        firstLayer=new JTabbedPane();
        secondLayerOne = new JTabbedPane(JTabbedPane.LEFT);
        secondLayerTwo = new JTabbedPane(JTabbedPane.LEFT);
        secondLayerThree = new JTabbedPane(JTabbedPane.LEFT);

        examView  = new ExamView();
        examView1  = new ExamView1();
        spellingWordFrame = new SpellingWordFrame();
        //addPanduanShitiView = new AddPanduanShitiView();
        //addXuanzeShitiView  =new AddXuanzeShitiView();

        secondLayerOne.add("������",spellingWordFrame); 
        secondLayerOne.add("������ϰ",examView);

        secondLayerTwo.add("����ѵ��",new JButton("�Ժ�����")); 
        secondLayerTwo.add("����ѡ��",new JButton("�Ժ�����"));
        secondLayerTwo .add("�ж�����",examView1); 

        secondLayerThree .add("����ѵ��",new JButton("�ȶ�ʱ������"));
	secondLayerThree .add("�Ķ����",new JButton("�ȶ�ʱ������"));
	secondLayerThree .add("���㷶��",new JButton("�ȶ�ʱ������"));
   
        firstLayer.add("��ͯ",secondLayerOne);
        firstLayer.add("��ѧ��",secondLayerTwo);
        firstLayer.add("CET",secondLayerThree);
        add(firstLayer,BorderLayout.CENTER); 
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}