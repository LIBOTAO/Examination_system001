public class RondomString { //负责随机排列单词中的字母
   String str="";
   public String getRondomString(String s) {
      StringBuffer strBuffer=new StringBuffer(s);
      int m=strBuffer.length();
      for(int k=0;k<m;k++) {
        int index=(int)(Math.random()*strBuffer.length());//Math.random()返回(0,1)之间的随机数
        char c=strBuffer.charAt(index);   
        str=str+c; 
        strBuffer=strBuffer.deleteCharAt(index);
     } 
     return str;
   }
}

