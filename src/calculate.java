
public class calculate{
	Mark mfenshu=new Mark();
	int chess=0;
	int[][] cal=new int[19][19];
	
	void setChess(int a){
		chess=a;
	}
	
	void nextMove(int a,int b){
		cal[a][b]=chess;
		chess=chess*(-1);
	}
	
	void clean(){
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				cal[i][j]=0;
				mfenshu.clean();
			}
		}
	}
	
	void copy(int a,int b,int c){
		cal[a][b]=c;
	}
	
	void unknow(){
		for(int i=0;i<19;i++){
			   for(int j=0;j<19;j++){
				   mfenshu.copy(i, j, cal[i][j]);
			   }
		   }
		mfenshu.setChess(chess);
		mfenshu.add();
		cal[mfenshu.getX()][mfenshu.getY()]=chess;
		chess=chess*(-1);
	}
}
