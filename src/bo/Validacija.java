package bo;

import java.util.Scanner;

public class Validacija {	
	

	public int vidiDaLiZeliKorisnikSeUlogovati() {
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite " + "\n1 ako zelite se ulogovati" + "\n2 ako zelite napraviti nalog" + "\nbilo koji drugi broj ako zelite izaci iz programa");
		int izbor = unos.nextInt();
		return izbor;
	}
	

	
	
}
