package farmindia.bmpl.com.farmindia;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikhilgupta on 26/03/17.
 */

public class ContractPostModel {



        public String cropName;
        public String cropVariety;
       public String key;
        public String noOfFarmers;
       public String quantity;
        public String price;
       public String URLforContract;
        public String toBeDeliveredIn;

        public ContractPostModel() {

        }
        public Map<String,Object> toMap(){
            HashMap<String,Object> result=new HashMap<>();
            result.put("cropName",cropName);
            result.put("cropVariety",cropVariety);
            result.put("quantity",quantity);
            result.put("price",price);
            result.put("key",key);
            result.put("toBeDeliveredIn",toBeDeliveredIn);
            result.put("URLforContract",URLforContract);
            result.put("noOfFarmers",noOfFarmers);
            return result;

        }
        public ContractPostModel(String cropName, String cropVariety, String key, String noOfFarmers, String quantity, String price, String URLforContract, String toBeDeliveredIn) {
            this.cropName = cropName;
            this.cropVariety = cropVariety;
            this.key = key;
            this.noOfFarmers = noOfFarmers;
            this.quantity = quantity;
            this.price = price;
            this.URLforContract = URLforContract;
            this.toBeDeliveredIn = toBeDeliveredIn;
        }


}
