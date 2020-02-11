package jbos;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.java_cup.internal.runtime.Scanner;

public class Test {

	public static void main(String[] args) throws IOException, ParseException {

		BufferedInputStream bf = new BufferedInputStream(System.in);

		BufferedReader r = new BufferedReader(new InputStreamReader(bf, StandardCharsets.UTF_8));

		
		klijentBean kb = new klijentBean();
		OpremaBean ob = new OpremaBean();
		ZaposleniBean zb = new ZaposleniBean();
		ProjekatBean pb = new ProjekatBean();

		String exit = "N";

		while (!exit.equals("Y")) {

			System.out.println("Uneti novog klijenta.\nIme:");
			String ime = r.readLine();
			System.out.println("Prezime");
			String prezime = r.readLine();
			System.out.println("Datum rodjenja");
			DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			Date rodj = (Date) format.parse(r.readLine());
			System.out.println("JMBG");
			int JMBG = Integer.parseInt(r.readLine());
			System.out.println("Adresa");
			String adresa = r.readLine();
			System.out.println("POL");
			String POL = r.readLine();
			char pol = POL.charAt(0);
			kb.dodajKlijenta(ime, prezime, rodj, JMBG, adresa, pol);

			kb.printAll();

			System.out.println("Izbrisi klijenta sa id-em: ");
			int id = Integer.parseInt(r.readLine());
			kb.deleteKlijent(id);
			kb.printAll();

			System.out.println("Azuziraj klijenta sa id-em: ");
			int id1 = Integer.parseInt(r.readLine());

			System.out.println("Novo ime: ");
			String novoIme = r.readLine();
			System.out.println("Novo prezime: ");
			String novoPrezime = r.readLine();
			System.out.println("Nova adresa: ");
			String novaAdresa = r.readLine();
			kb.azuzrirajKlijenta(id1, novoIme, novoPrezime, novaAdresa);
			kb.printAll();

			System.out.println("Want out?(Y/N)");
			exit = r.readLine();
		}

	}
}
