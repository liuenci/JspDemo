package cn.liuenci.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MutiplicationTable {
	public static void main(String[] args) {
		String filename = "D:/t1.txt";
		FileWriter fw = null;
		FileReader fr = null;
		String temp;
		try {
			fw = new FileWriter(filename);
			for(int i=1;i<=9;i++) {
				for(int j=i;i<=i;j++) {
					temp = i + "*" + j + "=" + i*j + "\t";
					fw.write(temp);
				}
				fw.write("\r\n");
			}
			fw.flush();
			fw.close();
			
			fr = new FileReader(filename);
			int c = fr.read();
			System.out.println(c);
			while(c!=-1) {
				System.out.print((char)c);
				c = fr.read();
			}
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
