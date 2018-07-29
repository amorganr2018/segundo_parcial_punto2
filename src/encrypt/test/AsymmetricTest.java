package encrypt.test;

import static org.junit.Assert.*;

import org.junit.Test;

import encrypt.Asymmetric;
import encrypt.EncryptManager;

public class AsymmetricTest {
	
	EncryptManager manager = new Asymmetric();
	String keyName = "Curso";
	String messageName = "Pruebas";
	String message = "Esto es una prueba del examen";

	@Test
	public void createKeyTest() throws Exception {		
		manager.createKey(keyName);	
	}
	
	@Test
	public void encryptMessageTest() throws Exception {
		manager.createKey(keyName);	
		manager.encryptMessage(messageName, message, keyName);
	}
	
	@Test
	public void decryptMessageTest() throws Exception {
		manager.createKey(keyName);	
		manager.encryptMessage(messageName, message, keyName);
		manager.decryptMessage(messageName, keyName);
	}

}
