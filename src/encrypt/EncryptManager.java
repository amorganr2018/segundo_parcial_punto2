package encrypt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface EncryptManager {
	
	public void createKey(String name) throws Exception;
	
	public void encryptMessage(String messageName, String message, String keyName) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
	
	public void decryptMessage(String messageName, String keyName) throws FileNotFoundException, IOException, Exception;	

}
