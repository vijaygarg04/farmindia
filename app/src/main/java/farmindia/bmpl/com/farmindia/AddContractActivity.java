package farmindia.bmpl.com.farmindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContractActivity extends AppCompatActivity {
    EditText priceEdit,quantityEdit,cropNameEdit,cropVarietyEdit,durationContractEdit,linkContractEdit;
    String price,quantity,cropName,cropVariety,duration,linkURL,key;
    Button postContractButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    ContractPostModel contractPostModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contract);
        priceEdit=(EditText)findViewById(R.id.add_contract_price);
        quantityEdit=(EditText)findViewById(R.id.add_contract_crop_quantity);
        cropNameEdit=(EditText)findViewById(R.id.add_contract_crop_name);
        cropVarietyEdit=(EditText)findViewById(R.id.add_contract_crop_variety);
        durationContractEdit=(EditText)findViewById(R.id.add_contract_duration);
        linkContractEdit=(EditText)findViewById(R.id.add_contract_link_to_contract);
        postContractButton=(Button)findViewById(R.id.add_contract_post_button);
        database=FirebaseDatabase.getInstance();
        //here the code for accessing database for FPI will be written
        reference=database.getReference("fpi");
        postContractButton.setBackgroundResource(R.drawable.post);
        postContractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price=priceEdit.getText().toString();
                quantity=quantityEdit.getText().toString();
                cropName=cropNameEdit.getText().toString();
                cropVariety=cropVarietyEdit.getText().toString();
                duration=durationContractEdit.getText().toString();
                linkURL=linkContractEdit.getText().toString();
                key=price.concat(quantity).substring(2).concat(duration).substring(0,2).concat(linkURL);
                contractPostModel=new ContractPostModel(cropName,cropVariety,key,"0",quantity,price,linkURL,duration);
                //reference to be set up
                //key will then be fetche dby getKey() method of firebase
                reference.child(key).setValue(contractPostModel);
                finish();

            }
        });



    }
}
