public class Main {

	public static void main(String[] args) {
		
		String message = "Hallo liebe Welt, das ist 1 verschlüsselter Text.";
		String key = "abc";
		encrypt(message, key);
		
	}
	// hack
	static void encrypt(String message, String key) {
		key = key.toLowerCase();
		if (key.length()<1 || message.length()<1) {
			System.out.println("Key/Text dürfen nicht leer sein");
			return;
		} if (!key.matches("\\p{Alpha}+")) {
			System.out.println("Key darf nur aus Buchstaben bestehen");
			return;
		}
		
		// Schlüssel zu Int-Werten
		int[] keyIntArray = new int[key.length()];
		for (int i = 0; i < key.length(); i++) {
			int val = (int) key.charAt(i);
			keyIntArray[i] = val - 97;
		}

		// Encrypt Text
		String messageEncrypted = "";

		int keyIndex = 0; // damit nächster Key nur verwendet wird, wenn Zeichen A-Z ist
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c>64 && c<123) { // Range Alphabet
				c += keyIntArray[keyIndex];
				if (c > 122 || (c > 90 && c < 97)) {
					c -= 26; // korrektur wenn über z hinaus
				}
				keyIndex++;
				if (keyIndex > key.length()-1) {
					keyIndex = 0;
				}
			}
			messageEncrypted += c;
		}

		System.out.println("Text:\n" + message + "\n\nencrypted with \"" + key + "\":");
		System.out.println(messageEncrypted);
	}

}
