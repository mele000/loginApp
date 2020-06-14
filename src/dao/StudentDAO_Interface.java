package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Korisnik;

public interface StudentDAO_Interface {

	public Korisnik dobijKorisnikaPrekoEmaila(String email) throws SQLException;

	public void updateStudent(Korisnik student,String name,String info) throws SQLException;
	
	public void deleteStudent(Korisnik korisnik) throws SQLException;

	public void addStudent(String first_name, String last_name, String email,String password) throws SQLException;

	public void printStudent(Korisnik user);

}
