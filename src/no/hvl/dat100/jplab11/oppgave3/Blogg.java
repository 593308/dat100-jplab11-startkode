package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nestledige;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nestledige = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nestledige = 0;
	}

	public int getAntall() {
		
		return nestledige;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;

		while (pos < nestledige && !funnet) {
			if (innleggtabell[pos].erLik(innlegg))
				funnet = true;
			else
				pos++;
		}

		if (funnet)
			return pos;
		else
			return -1;
//		for (int i = 0; i < innleggtabell.length; i++) 
//			if (innleggtabell[i].erLik(innlegg))
//				return i;
//			return -1;

	}

	public boolean finnes(Innlegg innlegg) {
//		boolean funnet = false;
//		int pos = 0;
//
//		while (pos < nestledige && !funnet) {
//			if (innleggtabell[pos].erLik(innlegg))
//				return true;
//			else
//				pos++;
//		}
//
//		return false;
		for (int i = 0; i < nestledige; i++) 
			if (innleggtabell[i].erLik(innlegg))
				return true;
			return false;
	}

	public boolean ledigPlass() {
		if (nestledige < innleggtabell.length)
			return true;
		else
			return false;

	}

	public boolean leggTil(Innlegg innlegg) {

//		boolean ny = (ledigPlass() && !(finnes(innlegg)));
//
//		if (ny) {
//			innleggtabell[nestledige] = innlegg;
//			nestledige++;
//			return true;
//		} else
//			return false;

		if (ledigPlass() && !(finnes(innlegg))) {
			innleggtabell[nestledige] = innlegg;
			nestledige++;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
//		String test = "test";
		String toString = nestledige + "\n";
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null)
			toString += innleggtabell[i].toString();
		}
		return toString;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] utvidet = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nestledige; i++) {
			utvidet[i] = innleggtabell[i];	
		}
		
		innleggtabell = new Innlegg[utvidet.length];
		for (int i = 0; i < innleggtabell.length; i++) {
			innleggtabell[i] = utvidet[i];
		}
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}