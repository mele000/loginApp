package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.Korisnik;



public class StudentDAO_Implementation extends Korisnik implements StudentDAO_Interface {

	

	public StudentDAO_Implementation() {
	}	

	
	Connection connection = ConnectionManager.getInstance().getConnection();

	

	@Override
	public Korisnik dobijKorisnikaPrekoEmaila(String email) throws SQLException {

		Korisnik korisnik = new Korisnik(); 
		String query = "SELECT * FROM users WHERE email = ?";
		ResultSet rs = null;

		try (
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, email);
			rs = statement.executeQuery();

			if (rs.next()) {

				korisnik = new Korisnik(rs.getString("first_name"), rs.getString("last_name"), 
						rs.getString("email"), rs.getString("password"));

				rs.close();
			}
		}

		return korisnik;
	}


	@Override
	public void updateStudent(Korisnik korisnik,String novaVrijednost, String onoStoSeTrebaPromjeniti) throws SQLException {
		if (korisnik != null) {

			String query = "UPDATE users SET ? = ? WHERE email = ?";

			try (
					PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setString(1, onoStoSeTrebaPromjeniti);
				statement.setString(2, novaVrijednost);
				statement.setString(3, korisnik.getEmail());

				statement.executeUpdate();

				System.out.println("Student updated in the database.");
			}
		}
	}

	@Override
	public void deleteStudent(Korisnik user) throws SQLException {
		if (user != null) {
			// create an SELECT SQL query
			String query = "DELETE FROM users WHERE email = ?";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setString(1, user.getEmail());

				// execute the query
				statement.executeUpdate();

				System.out.println("User deleted from the database.");
			}
		}
	}

	@Override
	public void addStudent(String name, String lastname, String email, String password) throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO users(first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

		
		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setString(1, name);
			statement.setString(2, lastname);
			statement.setString(3, email);
			statement.setString(4, password);

			// execute the query
			statement.executeUpdate();

			System.out.println("Student added to the database.");
		}

	}
	
	
	
	@Override
	public void printStudent(Korisnik user) {
		if (user != null) {
			System.out.println("name: " + user.getIme() + ", lastname: "
					+ user.getPrezime() + ", email: " + user.getEmail() + ", sifra: " + user.getPassword());
		} else {
			System.out.println("No student to print.");
		}
	}

	




}
	
	