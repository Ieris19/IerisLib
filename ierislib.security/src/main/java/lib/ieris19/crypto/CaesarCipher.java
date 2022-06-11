package lib.ieris19.crypto;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * A Caesar cipher is a very weak form of encryption that will shift all the characters in the
 * message to form an encrypted one. In this particular implementation it will shift them in the
 * UTF-8 charset.
 */
public class CaesarCipher implements Cipher {
	/**
	 * Uses a numerical key in the range of -128 to 127 to shift the value of each character in the
	 * original string in the UTF 8 charset
	 *
	 * @param original String to be encrypted
	 * @param key      amount of slots to shift a message
	 *
	 * @return an encrypted message
	 */
	@Override public String encrypt(String original, int key) {
		if (validateKey(key))
		return process(original.getBytes(UTF_8), key);
		else throw new IllegalArgumentException("Key cannot be negative or 0");
	}

	/**
	 * Uses a numerical key in the range of -128 to 127 to shift the value of each character in the
	 * String in the UTF 8 charset. If the same key is used as the one used for encrypting the
	 * message, the message will be restored
	 *
	 * @param original String to be encrypted
	 * @param key      amount of slots to shift a message
	 *
	 * @return an encrypted message
	 */
	@Override public String decrypt(String original, int key) {
		if (validateKey(key))
		return process(original.getBytes(UTF_8), -key);
		else throw new IllegalArgumentException("Key cannot be negative or 0");
	}

	private boolean validateKey(int key) {
		return key >= 0;
	}
	private String process(byte[] binary, int key) {
		char[] processed = new char[binary.length];
		for (int i = 0; i < binary.length; i++) {
			processed[i] = (char) (binary[i] + key);
		}
		return new String(processed);
	}
}