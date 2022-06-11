package lib.ieris19.crypto;

/**
 * A class that can encrypt messages by utilizing various algorithms. Refer to each individual
 * subclass for more information.
 */
public interface Cipher {
	String encrypt(String original, int key);
	String decrypt(String encrypted, int key);
}