package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File fil = null;
		Scanner leser = null;

		try {
			fil = new File(mappe + filnavn);
			leser = new Scanner(fil);

			int linjeNr = 1;
			String linje;
			int tabStr = 0;
			while (leser.hasNextLine() && linjeNr == 1) {
				linje = leser.nextLine();
				tabStr = Integer.parseInt(linje);
				System.out.println(Integer.parseInt(linje));
				linjeNr++;
			}

			Blogg samling = new Blogg(tabStr);

			while (leser.hasNextLine()) {
				linje = leser.nextLine();

				if (linje.equals(TEKST)) {
					System.out.println("yes");
					int id = 0;
					String bruker = "";
					String dato = "";
					int likes = 0;
					String tekst = "";
					for (int i = 1; i < 6; i++) {

						if (i == 1) {
							linje = leser.nextLine();
							id = (Integer.parseInt(linje));
						} else if (i == 2) {
							linje = leser.nextLine();
							bruker = linje;
						} else if (i == 3) {
							linje = leser.nextLine();
							dato = linje;
						} else if (i == 4) {
							linje = leser.nextLine();
							likes = (Integer.parseInt(linje));
						} else if (i == 5) {
							linje = leser.nextLine();
							tekst = linje;
						}

					}

					Tekst text = new Tekst(id, bruker, dato, likes, tekst);
					samling.leggTil(text);

				} else if (linje.equals(BILDE)) {
					int id = 0;
					String bruker = "";
					String dato = "";
					int likes = 0;
					String tekst = "";
					String url = "";

					for (int i = 1; i < 7; i++) {
						if (i == 1) {
							linje = leser.nextLine();
							id = (Integer.parseInt(linje));
						} else if (i == 2) {
							linje = leser.nextLine();
							bruker = linje;
						} else if (i == 3) {
							linje = leser.nextLine();
							dato = linje;
						} else if (i == 4) {
							linje = leser.nextLine();
							likes = (Integer.parseInt(linje));
						} else if (i == 5) {
							linje = leser.nextLine();
							tekst = linje;
						} else if (i == 6) {
							linje = leser.nextLine();
							url = linje;
						}
					}

					Bilde bilde = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(bilde);
				}
				linjeNr++;

			}
			System.out.println("Tabell opprettet");
			leser.close();
			return samling;

		} catch (FileNotFoundException e) {
			System.out.println("filen finnes ikke");
			Blogg samling = new Blogg();
			return samling;
		}

	}
}
