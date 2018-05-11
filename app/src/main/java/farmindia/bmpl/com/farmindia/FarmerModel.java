package farmindia.bmpl.com.farmindia;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikhilgupta on 24/03/17.
 */

public class FarmerModel {
    public String key,price,quantity,cropVariety,cropName,date;
    public int imageURL;

    public FarmerModel(){

    }
    public Map<String,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("cropName",cropName);
        result.put("cropVariety",cropVariety);
        result.put("quantity",quantity);
        result.put("price",price);
        result.put("key",key);
        result.put("date",date);
        result.put("imageURL",imageURL);
        return result;
    }


    public String toString(){

        return "{"+"name: "+cropName+"variety: "+cropVariety + "}";
    }

    public FarmerModel(String date,String key, String price, String quantity, String cropVariety, String cropName, int imageURL) {
        this.price = price;
        this.date=date;
        this.quantity = quantity;
        this.cropVariety = cropVariety;
        this.cropName = cropName;
        this.imageURL = imageURL;
        this.key=key;
    }
}

