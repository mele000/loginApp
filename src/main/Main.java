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

		int izbor = -1;
		
		izbor = vidiDaLiZeliKorisnikSePonovoUlogovati();

		while (izbor != 2) {

			if (izbor == 1) {

				System.out.println("Unesite email korisnika");
				String email = unos.next();

				System.out.println("Unesite password korisnika");
				String password = unos.next();

				Korisnik korisnik = obj.dobijKorisnikaPrekoEmaila(email);

				if (korisnik.getEmail().equals(email)) {

					if (korisnik.getPassword().equals(password)) {

						System.out.println(korisnik.toString());

						System.out.println(
								"Unesite " + "1 ako zelite promjeniti ime " + "2 ako zelite izaci iz programa");

						int izbor2 = unos.nextInt();

						if (izbor2 == 1) {

							System.out.println("Uneiste ime");
							String ime = unos.next();

							obj.updateStudent(korisnik, ime);

							korisnik = obj.dobijKorisnikaPrekoEmaila(email);
							System.out.println(korisnik.getIme());
							izbor = vidiDaLiZeliKorisnikSePonovoUlogovati();
							
						} else if (izbor2 == 2) {
							izbor = 0;
						}
					} else {
						System.out.println("Sifra nije tacna\n");
						System.out.println(
								"Unesite " + "1 ako zelite se ponovo ulogovati " + "2 ako zelite izaci iz programa");

						izbor = unos.nextInt();
					}
				} else {
					System.out.println("Korisnik koji ima email " + email + " ne postoji u nasoj bazi\n");
					izbor = vidiDaLiZeliKorisnikSePonovoUlogovati();
				}
			}

		}

	}

	public static int vidiDaLiZeliKorisnikSePonovoUlogovati() {
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite " + "1 ako zelite se ponovo ulogovati " + "2 ako zelite izaci iz programa");
		int izbor = unos.nextInt();
		return izbor;
	}
	

}
