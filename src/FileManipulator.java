import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManipulator {

	public static void main(String[] args) {
		StringBuilder line = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\sharedFolder\\h1bfinal.csv"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] stringArray = sCurrentLine.split(",");
				StringBuilder lineBuilder = new StringBuilder(stringArray[0]);
				for(int i=1;i<stringArray.length;i++){
					lineBuilder.append("\t").append(i+":"+stringArray[i]);
				}
				line=line.append("\n").append(lineBuilder.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//We are writing the file here..
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			String content = line.toString();

			fw = new FileWriter("C:\\sharedFolder\\h1bfinal_feature.txt");
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
