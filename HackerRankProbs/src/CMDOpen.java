import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDOpen {

	public static void main(String[] args) {
	
		try 
		{ 
		ProcessBuilder pb=new ProcessBuilder("cmd","/c","gauti.bat");	
		File dir=new File("F:\\JavaPrograms\\HackerRankProbs");
				pb.directory(dir);
				pb.start();

		} 
		catch(IOException e1) {} 

		System.out.println("Done"); 
		}

	}


