package br.com.alura.owasp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/owasp?createDatabaseIfNotExist=true",
					"root", "leandro123");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
