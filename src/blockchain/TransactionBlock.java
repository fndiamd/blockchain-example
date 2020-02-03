package blockchain;

/**
 *
 * @author fndiamd
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionBlock {
    public int index;
    public long timestamp;
    public Object data;
    public String prevHash;
    public String nonce;
    public int target;
    public String currentHash;
    
    public TransactionBlock(int index, long timestamp, Object data,
            String prevHash, String nonce, int target){
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.prevHash = prevHash;
        this.nonce = nonce;
        this.target = target;
    }
    
    public static String stringify(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    
}
