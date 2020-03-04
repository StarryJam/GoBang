import java.awt.Color;
import java.awt.Cursor; 
import java.awt.Graphics; 
import java.awt.Image;
import java.io.File; 
import java.io.IOException; 
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessBoardPanel extends JPanel implements ActionListener {
	int[][]arr=new int[19][19];
	int[][] reg=new int[19][19];
	int[][] biaoji=new int[19][19];
	Mark fenshu=new Mark();
	int step=0;;
	boolean start=false;
	boolean PVP=true;
	int chess=1;
    JButton k=new JButton("��ʼ");	
    JButton h=new JButton("����");
    JButton r=new JButton("����");
    JButton q=new JButton("����");
    JButton t=new JButton("�˳�");
	
//���찴ť
    public ChessBoardPanel() { 
	 
	k.addActionListener (this);
	h.addActionListener (this);
	r.addActionListener (this);
	q.addActionListener (this);
	t.addActionListener (this);
    this.addMouseListener(ma); 
    this.setLayout(null);
	this.add(k);
	this.add(h);
	this.add(r);
	this.add(q);
	this.add(t);
	k.setBounds(660,50,100,60);
	h.setBounds(660,170,100,60);
	r.setBounds(660,290,100,60);
	q.setBounds(660,410,100,60);
	t.setBounds(660,530,100,60);
	} 
		
			 
		//����
public void paint(Graphics g ) { 
			    	   //�������
					super.paint(g);
					g.drawLine(660, 170,760,170); 
			        g.drawLine(660, 230, 760, 230); 
			        g.drawLine(660, 170, 660, 230); 
			        g.drawLine(760, 170, 760, 230); 
					//����Ϸ��ʼ��� 
			         
					g.drawLine(660, 50, 760, 50); 
			        g.drawLine(660, 110, 760, 110); 
			        g.drawLine(660, 50, 660, 110); 
			        g.drawLine(760, 50, 760, 110); 
			        //��������� 
			   
			        g.drawLine(660, 290,760,290); 
			        g.drawLine(660, 350, 760, 350); 
			        g.drawLine(660, 290, 660, 350); 
			        g.drawLine(760, 290, 760, 350); 
			        //���������
			        g.drawLine(660, 410, 760, 410); 
			       g.drawLine(660, 470, 760, 470); 
			       g.drawLine(660, 410, 660, 470); 
			       g.drawLine(760, 410, 760, 470); 
			        //���˳���� 
			        g.drawLine(660, 530, 760, 530); 
			        g.drawLine(660, 590, 760, 590); 
			        g.drawLine(660, 530, 660, 590); 
			        g.drawLine(760, 530, 760, 590); 
			        //����¼��������� 
			      /*  g.drawString("��Ϸ��ʼ", 680, 80); 
			        g.drawString("����", 680, 310); 
			        g.drawString("����", 680, 440); 
			        g.drawString("�˳�", 680, 550); 
                    g.drawString("����",680,200);*/
                    
			        //���Բ���
                   /* g.drawString(String.valueOf(max), 10, 10);
                    g.drawString(String.valueOf(msum1), 10, 25);
                    g.drawString(String.valueOf(thousand1), 10, 40); 
                    g.drawString(String.valueOf(thouthousand2), 10, 55);
                    g.drawString(String.valueOf(thousand2), 10, 70);
                    g.drawString(String.valueOf(thouthousand2), 10, 85);
                    for (int i = 0; i <19; i++) {
 					   for (int j = 0; j <19; j++) {
 					   	g.drawString(String.valueOf(fenshu.mark[i][j]), 38 + i * 30, 38 + j * 30);}}*/
					// �������� 
					  // ���� 
					  for (int i = 0; i <19;  i++) { 
						 //������ÿ�μ�30����  
					   g.drawLine(50, 50 + i * 30, 590, 50 + i * 30); 
					  } 
					  // ���� 
					  for (int i = 0; i < 19; i++) { 
						   g.drawLine(50 + i * 30, 50, 50 + i * 30, 590); 
					  } 
					  g.fillOval(315, 315, 10, 10);
					 
					  for (int i = 0; i <19; i++) {
					   for (int j = 0; j <19; j++) {
						
					    if (arr[i][j] != 0) {
					     if (arr[i][j] == 1)
                        { 
                         g.setColor(Color.BLACK); 
					   //���������ɫ������������Բ��
					     g.fillOval(38 + i * 30, 38 + j * 30,24, 24); 
					   //�����ӱ߽�
					     g.drawOval(38 + i * 30, 38 + j * 30, 24, 24); 
					     } 
					     else { 
					     g.setColor(Color.WHITE); 
					     g.fillOval(38 + i * 30, 38 + j * 30, 24, 24); 
					     g.setColor(Color.BLACK); 
					     g.drawOval(38 + i * 30, 38 + j * 30, 24, 24);
					    //������һ����
					    
					    
					     } 
					     if (biaoji[i][j] == 1){
					    	g.setColor(Color.RED);
					    	g.fillOval(47 + i * 30, 47 + j * 30,6, 6);
					    }
					    } 
					   } 
					     } 
                        // �ô����ػ� ��Ȼ����ͼ�η����仯�󲻻�������ʾ
				     this.repaint(); 
				        } 
			 
			 			 
			//��������������ж�
MouseAdapter ma = new MouseAdapter() { 
	 
	//����¼�			 
	public void mouseClicked(MouseEvent e) { 
			   int x = e.getX(); 
			   int y = e.getY(); 
			  //�ж��Ƿ�����
			   if (start == true)
{
				  

			    if (x >= 50 && x <= 620 && y >= 50 && y <= 620)
	{        
			     //����������Ӧ
			    int i1 = (x - 50) / 30; 
			     int j1 = (y - 50) / 30; 
			   //������ӷ�Χ
			     if ((x - 50) % 30 > 15) 
			      {   i1 = i1 + 1;  }
			        
			        if ((y - 50) % 30 > 15) 
			        {  j1 = j1 + 1;  }
			        
			        if (arr[i1][j1] == 0)  
			        {
			        	for(int i=0;i<19;i++){
			        		for(int j=0;j<19;j++){
			        			biaoji[i][j]=0;
			        		}
			        	}
			        	
			        arr[i1][j1] = chess; 
			        biaoji[i1][j1]=1;
			        // �ж���Ӯ 
			        if (isWin(chess) == true) {
			         if (chess == 1) { 
			         //��������
			          JOptionPane.showMessageDialog(null, "�����ʤ  "); 
			         }  
			         else { 
			          JOptionPane.showMessageDialog(null, "�����ʤ  "); 
			         } 
	                start = false; 
	
	} 
			        // ��������ɫ
			       chess = chess * (-1); 
			        step++;
			        reg[i1][j1]=step;


			        
		
			      //�˻�
 if(PVP==false){
	    calculate moni=new calculate();
	    
	    Mark monifenshu=new Mark();
		int thousand1=0;
		int thouthousand1=0;
		int thousand2=0;
		int thouthousand2=0;

             fenshu.clean();
					   for(int i=0;i<19;i++){
						   for(int j=0;j<19;j++){
							   biaoji[i][j]=0;
							   fenshu.copy(i, j, arr[i][j]);
						   }
					   }
					   fenshu.setChess(chess);
					   fenshu.add();
						
					   //ģ��һ���ж����������ġ�����
					   for(int i=0;i<19;i++){
						   for(int j=0;j<19;j++){
							   moni.copy(i, j, arr[i][j]);
						   }
					   }
							
					  
					   monifenshu.clean();
					   moni.setChess(chess);
					   for(int i=0;i<19;i++){
						   for(int j=0;j<19;j++){
							   monifenshu.copy(i, j, moni.cal[i][j]);
							   }
						   }
					   int ex;
						for(int i=0;i<19;i++){
							for(int j=0;j<19;j++){
								for(int l=0;l<=1;l++){
								
								if(arr[i][j]==0){
									ex=0;
									thousand1=0;
									thouthousand1=0;
									thousand2=0;
									thouthousand2=0;
									
									moni.nextMove(i,j);
									monifenshu.copy(i, j, moni.cal[i][j]);
									monifenshu.setChess(moni.chess);
									monifenshu.add();
									for(int i3=0;i3<19;i3++){
										for(int j3=0;j3<19;j3++){
											if(fenshu.mark[i3][j3]>=1000&&fenshu.mark[i3][j3]<=10000){
												thousand1++;
												}
											if(fenshu.mark[i3][j3]>=1000000&&fenshu.mark[i3][j3]<=10000000){
												thouthousand1++;
												}
											if(monifenshu.mark[i3][j3]>=1000&&monifenshu.mark[i3][j3]<=10000){
												thousand2++;
												}
											if(monifenshu.mark[i3][j3]>=1000000&&monifenshu.mark[i3][j3]<=10000000){
												thouthousand2++;
												}
											}
										}
									
									if(thouthousand2-thouthousand1>=2){
										ex=200000;
										}
									if(thouthousand2-thouthousand1>=1&&thousand2-thousand1>=1){
										ex=20000;
										}
									if(thousand2-thousand1>=3){
										ex=400;
										}
									if(moni.chess==chess){
										ex=ex/2;
										}
									fenshu.mark[i][j]+=ex;
									if (fenshu.mark[i][j]>fenshu.max){
										fenshu.max=fenshu.mark[i][j];
										fenshu.x=i;
										fenshu.y=j;
										}
									moni.cal[i][j]=0;
									monifenshu.arr[i][j]=0;
									}
								}
							}
						}
			        if(start==true){
			        	arr[fenshu.getX()][fenshu.getY()]=chess;
			        	biaoji[fenshu.getX()][fenshu.getY()]=1;
			        }
			        
			       // �ж���Ӯ 
			        if (isWin(chess) == true) { 
			         if (chess == 1) { 
			         //��������
			          JOptionPane.showMessageDialog(null, "�����ʤ  "); 
			         }  
			         else { 
			          JOptionPane.showMessageDialog(null, "�����ʤ  "); 
			         } 
	                start = false; 
	
	} 
			        chess=chess*(-1);
			        step++;
			        reg[fenshu.getX()][fenshu.getY()]=step;
 }  			 
		
			        }
			        }



			       
			     
                   
                   
             
			       } 


			    		     } 
			    		    }; 
	
//�ж���Ӯ 
// ���� 
public boolean isH(int chess) 
	
{for (int i = 0; i < 19; i++)  
{for (int j = 2; j < 17; j++)  
 {if (arr[i][j - 2] == chess && arr[i][j - 1] == chess 
   && arr[i][j] == chess && arr[i][j + 1] == chess 
   && arr[i][j + 2] == chess) 
  { return true; }
 } 
} 

return false; 
} 
// ���� 
public boolean isV(int chess)  
	 { for (int i = 2; i < 17; i++)  
	 { for (int j = 0; j < 19; j++) 
	  {  if (arr[i - 2][j] == chess && arr[i - 1][j] == chess 
	   && arr[i][j] == chess && arr[i + 1][j] == chess 
	   && arr[i + 2][j] == chess)  
	    { return true; } 
	   } 
	  } 
	      return false; 
	  } 
// ���� 
public boolean isES(int chess) { 
		    for (int i = 2; i < 17; i++) { 
		     for (int j = 2; j < 17; j++) { 
		      if (arr[i - 2][j - 2] == chess && arr[i - 1][j - 1] == chess 
		        && arr[i][j] == chess && arr[i + 1][j + 1] == chess 
		        && arr[i + 2][j + 2] == chess) { 
		       return true; 
		      } 
		     } 
		    } 
		    return false; 
		   } 
//���� 
public boolean isEN(int chess) { 
for (int i = 2; i < 17; i++) { 
 for (int j = 2; j < 17; j++) { 
  if (arr[i - 2][j + 2] == chess && arr[i - 1][j + 1] == chess 
    && arr[i][j] == chess && arr[i + 1][j - 1] == chess 
    && arr[i + 2][j - 2] == chess) { 
   return true; 
  } 
 } 
} 
return false; 
} 

public boolean isWin(int chess) { 
if ((isH(chess) == true) || (isV(chess) == true) 
  || (isES(chess) == true) || (isEN(chess) == true)) 
{ 
 return true; 
} 
return false; 
}

//��ť�¼�
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getActionCommand()=="��ʼ"){
		if(start==false){
		chess=1;
	       // ���� 
	       for (int i = 0; i < 19; i++) { 
	        for (int j = 0; j < 19; j++) { 
	         arr[i][j] = 0; 
	        } 
	       } 
	       start = true; 
	       JOptionPane.showMessageDialog(null, "��Ϸ��ʼ��"); 
		}
	        
	}
	//����
	if(step>0){
	  if (e.getActionCommand()=="����"){
		  if(start==true){
    	 outterLoop: for (int i=0;i<19;i++){
    		  for (int j = 0; j < 19; j++) {
    			  if (reg[i][j]==step){
    				  arr[i][j]=0;
    				  reg[i][j]=0;
    				  step--;
    				  for (int i1=0;i1<19;i1++){
    					  for (int j1 = 0; j1 < 19; j1++) {
    						  if (reg[i1][j1]==step){
    							  biaoji[i1][j1]=1;
    						  }
    					  }
    				  }
    				  chess=chess*(-1);
    				  break outterLoop;
    			  }
    		    }
    		  }
		 if(PVP==false){
 	     outterLoop: for (int i=0;i<=19;i++){
		       for (int j = 0; j < 19; j++) {
			       if (reg[i][j]==step){
				      arr[i][j]=0;
				      reg[i][j]=0;
				      step--;
				      for (int i1=0;i1<19;i1++){
    					  for (int j1 = 0; j1 < 19; j1++) {
    						  if (reg[i1][j1]==step){
    							  biaoji[i1][j1]=1;
    						  }
    					  }
    				  }
				      chess=chess*(-1);
				      break outterLoop;
				      }
			       }
		       }
		 }
		 }
		  }
	  }
	//����
	if (e.getActionCommand()=="����") { 
	       int option = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ ������", 
	         "ȷ�Ͽ�", JOptionPane.YES_NO_OPTION); 
	       if (option == 0) { 
	    	   
	    	   if (chess == 1) { 
	    		      JOptionPane.showMessageDialog(null, "�������䪫����ʤ"); 
	    		     } else { 
	    		      JOptionPane.showMessageDialog(null, "�������䪫����ʤ"); 
	    		      } 
	    		     start = false; 
	    		       } 
 		         } 
	 // ���� 
	  if (e.getActionCommand()=="����") 
    
	     { 
		   int option = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ����", 
	    		      "�Ի���", JOptionPane.YES_NO_OPTION); 
		   if (option == 0) {
			   start=false;
		   for (int i = 0; i < 19; i++) { 
	       {   for (int j = 0; j < 19; j++)
	         arr[i][j] = 0; 
	        }  }}
        } 
	  if (e.getActionCommand()=="�˳�") { 
		    int option = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���", 
		      "�Ի���", JOptionPane.YES_NO_OPTION); 
		    if (option == 0) { 
		        System.exit(0); 
		       } 
		      } 

}
}


