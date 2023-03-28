public class Main {
	public static void main(String[] args) {
		Aes256 aes256 = new Aes256();
		
		System.out.println(aes256.encrypt("react-java aes256"));
		System.out.println(aes256.decrypt("2CCcc2H0c6LpIZymYYcqD7VvKkA/6XwxJacNENaVE+M="));
	}
}