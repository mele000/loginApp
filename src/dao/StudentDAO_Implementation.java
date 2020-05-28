package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.Korisnik;

/**
 * proof of concept implementation almost zero sanity checking.
 * 
 * demonstration purposes only - use at your own risk
 */

public class StudentDAO_Implementation extends Korisnik implements StudentDAO_Interface {

	

	public StudentDAO_Implementation() {
	}	

	Connection connection = ConnectionManager.getInstance().getConnection();

	

	@Override
	public Korisnik dobijKorisnikaPrekoEmaila(String email) throws SQLException {

		Korisnik korisnik = new Korisnik(); 
		String query = "SELECT * FROM info WHERE email = ?";
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
	public void updateStudent(Korisnik korisnik,String name) throws SQLException {
		if (korisnik != null) {

			String query = "UPDATE info SET first_name = ? WHERE email = ?";

			try (
					PreparedStatement statement = connection.prepareStatement(query);) {

				statement.setString(1, name);
				statement.setString(2, korisnik.getEmail());

				statement.executeUpdate();

				System.out.println("Student updated in the database.");
			}
		}
	}
/*
	@Override
	public void deleteStudent(Korisnik student) throws SQLException {
		if (student != null) {
			// create an SELECT SQL query
			String query = "DELETE FROM info WHERE userID = ?";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setInt(1, student.getUserID());

				// execute the query
				statement.executeUpdate();

				System.out.println("Student deleted from the database.");
			}
		}
	}

	@Override
	public void addStudent(int userID, String name, String lastname, int dob, String email) throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO info(name, lastname, dob, email) VALUES (?, ?, ?, ?)";

		// new Scanner
		java.util.Scanner input = new java.util.Scanner(System.in);

		System.out.print("Enter students first name: ");
		String name = input.next();

		System.out.print("Enter students last name: ");
		String lastname = input.next();

		System.out.print("Enter students DOB (YYYY-MM-DD): ");
		String dob = input.next();

		System.out.print("Enter students email: ");
		String email = input.next();

		// close the scanner
		input.close();

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setString(1, name);
			statement.setString(2, lastname);
			statement.setString(3, dob);
			statement.setString(4, email);

			// execute the query
			statement.executeUpdate();

			System.out.println("Student added to the database.");
		}

	}

	@Override
	public void printStudent(Korisnik student) {
		if (student != null) {
			System.out.println("userID: " + student.getUserID() + ", name: " + student.getName() + ", lastname: "
					+ student.getLastname() + ", DOB: " + student.getDob() + ", email: " + student.getEmail());
		} else {
			System.out.println("No student to print.");
		}
	}

	@Override
	public Korisnik getStudent(int userID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
*/



}
	
	