package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextFileUtilities {
	
	// There is a chance of multiple text Files with test data in our project 
	//Access existing text File or csv File, which consists of test data
	public static String[] getValueOfLine(String filePath , int linenumber )throws Exception
	{
		File f = new File(filePath);// locate file in HDD
		FileReader fr = new FileReader(f);// take READ permission
		BufferedReader br = new BufferedReader(fr);//Shift to rpm
		try {
			//move to line which is before the target line 
			for(int i=1; i<linenumber;i++) {
				br.readLine();
			}
			//get target line 2 split into values by separate with ","
			String temp = br.readLine();
			String output[] = temp.split(",");
			br.close();
			fr.close();
			return(output);
		}
		catch(Exception ex) {
			return(null);
		}
	}

}
