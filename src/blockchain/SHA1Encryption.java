package blockchain;

/**
 *
 * @author fndiamd
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA1Encryption {
    public static final String SHA1 = "SHA-1";
    public final static char[] hexArray = "0123456789abcdef".toCharArray();
    
    public static String bytesToHex(byte[] bytes){
        char[] hexChars = new char[bytes.length * 2];
        for(int i=0; i<bytes.length; i++){
            int values = bytes[i] & 0xff;
            hexChars[i * 2] = hexArray[values >>> 4];
            hexChars[i * 2 + 1] = hexArray[values & 0x0f];
        }
        return new String(hexChars);
    }
    
    public static String generateHash(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA1);
        messageDigest.update(data.getBytes());
        byte[] hash = messageDigest.digest();
        messageDigest.reset();
        return bytesToHex(hash);
    }
}
