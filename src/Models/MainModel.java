package Models;

import javafx.scene.Scene;

public class MainModel {

	private static String Role;
	private static String Username;
	private static String Password;

	public static String getRole() {
		return Role;
	}
	public static void setRole(String role) {
		Role = role;
	}
	public static String getUsername() {
		return Username;
	}
	public static void setUsername(String username) {
		Username = username;
	}
	public static String getPassword() {
		return Password;
	}
	public static void setPassword(String password) {
		Password = password;
	}
	
}
