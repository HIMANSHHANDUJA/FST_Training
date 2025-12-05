package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		File file=new File("src/main/resources/newfile.txt");// TODO Auto-generated method stub
		boolean fStatus=file.createNewFile();
		if(fStatus)
		{
			System.out.println("file created");
			File inputFile = null;
			FileUtils.writeStringToFile(inputFile, "Write here:",Charset.defaultCharset());
			
		}
		else
		{
			System.out.println("File existed or something wrong!");
		}
		// Read File
		System.out.println("Data in File"+ FileUtils.readFileToString(file,"UTF8"));
		
	}

}
