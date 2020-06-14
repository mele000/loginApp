package dto;



public class Korisnik {
	// data fields

	private String email = "";
	private String password = "";
	private String ime = "";
	private String prezime = "";

	// constructor

	public Korisnik() {
	}


	public Korisnik(String ime, String prezime,String email, String password) {
		this.email = email;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
	}

	
	public Korisnik(String email, String password) {
		this.email = email;
		this.password = password;
	}


	// getters

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}


	@Override
	public String toString() {
		return "Korisnik [email=" + email + ", password=" + password + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	

}
