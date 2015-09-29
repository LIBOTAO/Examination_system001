import java.awt.*;
import javax.swing.*;
public class YWindow extends JFrame{
    JTabbedPane firstLayer;        //第一层窗格
    JTabbedPane secondLayerOne;   //添加到第一层中的第2层窗格
    JTabbedPane secondLayerTwo;   //添加到第一层中的第2层窗格
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

        secondLayerOne.add("背单词",spellingWordFrame); 
        secondLayerOne.add("基础练习",examView);

        secondLayerTwo.add("听力训练",new JButton("以后再做")); 
        secondLayerTwo.add("单项选择",new JButton("以后再做"));
        secondLayerTwo .add("判断正误",examView1); 

        secondLayerThree .add("听力训练",new JButton("等段时间再做"));
	secondLayerThree .add("阅读理解",new JButton("等段时间再做"));
	secondLayerThree .add("优秀范文",new JButton("等段时间再做"));
   
        firstLayer.add("儿童",secondLayerOne);
        firstLayer.add("中学生",secondLayerTwo);
        firstLayer.add("CET",secondLayerThree);
        add(firstLayer,BorderLayout.CENTER); 
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}