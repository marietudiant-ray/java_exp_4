package pigeonnest;

import javax.swing.JOptionPane;

public class PigeonNest {
  
	 int[] nest;
	 
	 public PigeonNest()
	 {
		 nest=new int[7];
		 
		 for(int i=0;i<nest.length;i++)
		 {
			 nest[i]=(int)(Math.random()*10)%6+1;
		 }
		 String result="";
		 int i=1;
		 for(int no:nest)
		 {
			 result+="第"+i+"只鸽子飞到编号为："+no+"鸽巢\n";
			 i++;
		 }
		 JOptionPane.showMessageDialog(null, result, "鸽子在哪里", JOptionPane.INFORMATION_MESSAGE);
		
	 }
	 
	 public static void main(String[] args)
	 {
		 PigeonNest pigeonnest=new PigeonNest();
		 System.exit(0);
	 }
}
