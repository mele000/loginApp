package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Korisnik;

public interface StudentDAO_Interface {

	/*// method to get all students
	public ArrayList<Korisnik> getStudents() throws SQLException;

	// method to get a specific student
	public Korisnik getStudent(int userID) throws SQLException;

	// method to delete a specific student
	public void deleteStudent(Korisnik student) throws SQLException;

	// method to add a student
	public void addStudent(int userID, String name, String lastname, int dob, String email) throws SQLException;

	// method to print a specific student
	public void printStudent(Korisnik student);
*/	
	public Korisnik dobijKorisnikaPrekoEmaila(String email) throws SQLException;

	public void updateStudent(Korisnik student,String name) throws SQLException;

}
