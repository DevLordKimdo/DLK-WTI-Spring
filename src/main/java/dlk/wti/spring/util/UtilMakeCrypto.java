package dlk.wti.spring.util;

import java.security.SecureRandom;

public class UtilMakeCrypto {
	
	public String stringNum(int Digit) {
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
        SecureRandom random = new SecureRandom();
        StringBuilder cryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = random.nextInt(characters.length());
            cryptoNumber.append(characters.charAt(index));
        }
        
        return cryptoNumber.toString().toUpperCase();
	}
	
	public String numberOnly(int Digit) {
		
		String characters = "0123456789";
		
        SecureRandom random = new SecureRandom();
        StringBuilder cryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = random.nextInt(characters.length());
            cryptoNumber.append(characters.charAt(index));
        }
        
        return cryptoNumber.toString().toUpperCase();
	}
	
	public String stringOnly(int Digit) {
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
        SecureRandom random = new SecureRandom();
        StringBuilder cryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = random.nextInt(characters.length());
            cryptoNumber.append(characters.charAt(index));
        }
        
        return cryptoNumber.toString().toUpperCase();
	}
	
}
