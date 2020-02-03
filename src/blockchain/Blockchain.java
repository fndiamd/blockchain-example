package blockchain;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fndiamd
 */
public class Blockchain {
    
    public static void main(String[] args) throws JsonProcessingException, 
            UnsupportedEncodingException, NoSuchAlgorithmException {
        Date date = new Date();
        long time = date.getTime();
        
        ArrayList<TransactionBlock> block = new ArrayList<TransactionBlock>();
        ArrayList<String> hashNode = new ArrayList<String>();
        
        block.add(new TransactionBlock(0, time - 600, "Fandi Ahmad", 
                "0000000000000000000000000", "Random nonce", 8));
        hashNode.add(SHA1Encryption.generateHash(TransactionBlock.stringify(block.get(0))));
        
        block.add(new TransactionBlock(1, time, "New Transaction", 
                hashNode.get(0), "Random nonce", 8));
        hashNode.add(SHA1Encryption.generateHash(TransactionBlock.stringify(block.get(1))));
        
        for(int i=0; i<block.size(); i++){
            System.out.println("Index : " + block.get(i).index);
            System.out.println("Timestamp : " + block.get(i).timestamp);
            System.out.println("Data : " + block.get(i).data);
            System.out.println("Prev Node Hash : " + block.get(i).prevHash);
            System.out.println("Nonce : " + block.get(i).nonce);
            System.out.println("Target : " + block.get(i).target);
            System.out.println("Current Hash : " + hashNode.get(i));
            System.out.println("==============================================");
        }
        
    }
    
}
