package no.hvl.dat100.jplab11.oppgave4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		File file = new File(mappe + filnavn);
		
		
	
		
		try {
			
			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println(samling.toString());
			
			pw.flush();
			return true;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fant ingen fil");
			return false;
			
		} catch (IOException e) {
			System.out.println("en eller annen feil");
			e.printStackTrace();
			return false;
			
		}
	}
}
