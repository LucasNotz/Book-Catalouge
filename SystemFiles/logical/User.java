package logical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class User {
	private static String user = "";
	public static String getUser() {
		try {
		Process process;
		process = Runtime.getRuntime().exec("whoami");
		
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line1;
		String user = "";
			while ((line1 = reader1.readLine()) != null) {
				User.user = line1;
			}
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
