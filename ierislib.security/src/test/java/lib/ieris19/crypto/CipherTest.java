package lib.ieris19.crypto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName ("Cipher Test") class CipherTest {
	Cipher cipher;

	@Nested @DisplayName ("Caesar Cipher") class CaesarCipherTest {
		@BeforeEach void caesarSetup() {
			cipher = new lib.ieris19.crypto.CaesarCipher();
		}

		@Nested @DisplayName ("Encrypt") class CaesarEncryptTest {
			@Test @DisplayName ("Correct positive offset") void offsetPositiveTest() {
				String original = "a";
				byte key = 1;
				String ciphered = cipher.encrypt(original, key);
				assertEquals("b", ciphered);
			}

			@Test @DisplayName ("Correct negative offset") void offsetNegativeTest() {
				String original = "c";
				byte key = -1;
				String ciphered = cipher.encrypt(original, key);
				assertEquals("b", ciphered);
			}

			@Test @DisplayName("Correct message with symbols") void helloWorld() {
				String original = "Hello, World!";
				byte key = 3;
				String ciphered = cipher.encrypt(original, key);
				assertEquals("Khoor/#Zruog$", ciphered);
			}
		}
		@Nested @DisplayName("Decrypting") class CaesarDecryptTest {
			@Test @DisplayName("Correct positive offset") void offsetPositiveTest() {
				String encrypted = "b";
				byte key = 1;
				String decrypted = cipher.decrypt(encrypted, key);
				assertEquals("a", decrypted);
			}

			@Test @DisplayName("Correct negative offset") void offsetNegativeTest() {
				String encrypted = "#";
				byte key = 3;
				String decrypted = cipher.decrypt(encrypted, key);
				assertEquals(" ", decrypted);
			}

			@Test @DisplayName("Correct message with symbols") void helloWorld() {
				String encrypted = "Lipps0$[svph%";
				byte key = 4;
				String decrypted = cipher.decrypt(encrypted, key);
				assertEquals("Hello, World!", decrypted);
			}
		}
	}
}