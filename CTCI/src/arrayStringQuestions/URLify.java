package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s= br.readLine();
			int trueLength=Integer.parseInt(br.readLine());
			
			char[] arr=s.toCharArray();
			char[] result= URLifyString(arr,trueLength);
			String r=String.valueOf(result);
			r=r.trim();
			System.out.print(r);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static char[] URLifyString(char[] arr,int trueLength)
	{
		int spacecount=0,index,i=0;
		for(i=0;i<trueLength;i++)
		{
			if(arr[i]==' ')
			{
				spacecount++;
			}
		}
		index = trueLength+spacecount*2;
		if(trueLength<arr.length)
		{
			arr[trueLength]='\0';
		}
		for(i=trueLength-1;i>=0;i--)
		{
			if(arr[i]==' ')
			{
				arr[index-1]='0';
				arr[index-2]='2';
				arr[index-3]='%';
				index=index-3;
			}
			else{
				arr[index-1]=arr[i];
				index--;
			}
		}
		return arr;
	}

}
