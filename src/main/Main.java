package main;

import java.sql.SQLException;
import java.util.Scanner;

import bo.Validacija;
import dao.StudentDAO_Implementation;
import dto.Korisnik;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner unos = new Scanner(System.in);
		StudentDAO_Implementation obj = new StudentDAO_Implementation();
		Validacija val = new Validacija();

		int izbor = 0;

		izbor = val.vidiDaLiZeliKorisnikSeUlogovati();

		while (izbor == 1 || izbor == 2) {

			if (izbor == 1) {

				System.out.println("Unesite email korisnika");
				String email = unos.next();

				System.out.println("Unesite password korisnika");
				String password = unos.next();

				Korisnik korisnik = obj.dobijKorisnikaPrekoEmaila(email);

				if (korisnik.getEmail().equals(email)) {

					if (korisnik.getPassword().equals(password)) {
						
						obj.printStudent(korisnik);
						
						System.out.println("Unesite " + "\n1 ako zelite promjeniti vase podatke"
								+ "\n2 ako zelite izbrisati nalog");

						int izbor2 = unos.nextInt();

						if (izbor2 == 1) {

							System.out.println("Unesite " + "\n1 ako zelite promjeniti ime "
									+ "\n2 ako zelite pormjeniti prezime " + "\n3 ako zelite promjeniti email "
									+ "\n4 ako zelite promjeniti sifru "
									+ "\nbilo koji drugi broj ako zelite izaci iz programa");

							int izbor3 = unos.nextInt();

							String info = "";

							if (izbor3 == 1) {
								info = "first_name";				
							} else if (izbor3 == 2) {
								info = "last_name";

							} else if (izbor3 == 3) {
								info = "email";

							} else if (izbor3 == 4) {
								info = "password";

							}

							else
								break;

							
							System.out.println("Uneiste novu vrijednost " + info + "-a");
							String novaVrijednost = unos.next();

							obj.updateStudent(korisnik, novaVrijednost, info);

							korisnik = obj.dobijKorisnikaPrekoEmaila(email);
							obj.printStudent(korisnik);
							izbor = val.vidiDaLiZeliKorisnikSeUlogovati();
						} else if (izbor2 == 2) {

							obj.deleteStudent(korisnik);
							izbor = val.vidiDaLiZeliKorisnikSeUlogovati();
							
						}

					} else {
						System.out.println("Sifra nije tacna\n");
						izbor = val.vidiDaLiZeliKorisnikSeUlogovati();
					}
				} else {
					System.out.println("Korisnik koji ima email " + email + " ne postoji u nasoj bazi\n");
					izbor = val.vidiDaLiZeliKorisnikSeUlogovati();
				}
			} else if (izbor == 2) {
				System.out.print("Unesite ime: ");
				String name = unos.next();

				System.out.print("Unesite prezime: ");
				String lastname = unos.next();

				System.out.print("Unesite email: ");
				String email = unos.next();

				System.out.print("Unesite sifru: ");
				String password = unos.next();

				Korisnik korisnik_provjera = obj.dobijKorisnikaPrekoEmaila(email);

				if (korisnik_provjera.getEmail().equals(email)) {
					System.out.println("Postoji vec takav jedan korisnik");
				} else {
					obj.addStudent(name, lastname, email, password);
					Korisnik korisnik = obj.dobijKorisnikaPrekoEmaila(email);
					obj.printStudent(korisnik);
				}
				izbor = val.vidiDaLiZeliKorisnikSeUlogovati();

			}

		}

	}

}
