import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Child{

	public static void main(String[] args){
		Date aDate= new Date();
		try{
			aDate=new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
			Calendar aCalendar= Calendar.getInstance();
			aCalendar.setTime(aDate);
			System.out.println(aCalendar.get(aCalendar.DAY_OF_MONTH)+","+aCalendar.get(aCalendar.MONTH));
		}catch(ParseException ex){
			System.out.println(ex);
		}
	}

}
	
	
	

	

