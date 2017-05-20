import java.util.Scanner;

public class BowlingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int a[][] = new int[50][2];
		int m = 0,n = 0,flag = 0;
		for(int i = 0; i < str.length(); i++)
		{
			
			if(str.charAt(i)=='X')
			{
				
				if(flag == 0)
				{	
					a[m][n] = 10;
					m++;
					n = 0;
				}
				else
				{
					a[m][n] = 10;
					
					n++;
				}
				
			}
			else if(str.charAt(i)=='-')
			{
				a[m][n] = 0;
				if(str.charAt(i+1)=='|')
				{
					m++;
					n = 0;
				}
				else
					n++;
				
			}
			else if(str.charAt(i)=='/')
			{
				a[m][n] = 10 - (str.charAt(i-1)-'0');
				m++;
				n = 0;
			}
			else if(str.charAt(i)=='|'&&str.charAt(i+1)=='|')
			{
				i = i + 1;
				flag = 1;
				n = 0;	
			}
			else if(str.charAt(i)=='|')
			{
				continue;
			}
			else
			{
				if(flag == 0)
				{
					a[m][n] = str.charAt(i)-'0';
					if(str.charAt(i+1)=='|')
					{
						m++;
						n = 0;
					}
					else
						n++;
				}
				else
				{
					a[m][n] = str.charAt(i)-'0';
					n++;
				}
			}
				
		}
		int sum = 0;
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				if(j==0&&a[i][j]==10)
				{
					
					int t = a[i+1][1];
					if(a[i+1][1] == 0)
					{
						t = a[i+2][0];
					}
					sum = sum + 10 + a[i+1][0] + t;
				}
				else if(j==0&&(a[i][j]+a[i][j+1]==10))
				{
					sum = sum + 10 + a[i+1][0];
					
				}
				else if(j==0&&(a[i][j]+a[i][j+1]<10))
				{
					sum = sum + a[i][j]+a[i][j+1];
				}
			}
			//System.out.println(sum);
		}
		System.out.println(sum);
		
	}

}
