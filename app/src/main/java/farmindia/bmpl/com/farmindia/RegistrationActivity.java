package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameEditText,phoneEditText,emailEditText;
    Button fpibtn,farmerbtn,retailerbtn,govtbtn;
        ModelClassForRegistration user;
    String uniqueId,subname,subphone;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String age;
    SharedPreferences settings;
    EditText age_edit_text;
    String name,phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        age_edit_text=(EditText)findViewById(R.id.age_registeration_edit_text);
        farmerbtn=(Button)findViewById(R.id.farmer_button_registration);
        retailerbtn=(Button)findViewById(R.id.retailer_button_registration);
        fpibtn=(Button)findViewById(R.id.fpi_button_registration);
        nameEditText=(EditText) findViewById(R.id.registeraton_name_edit_text);
        phoneEditText=(EditText) findViewById(R.id.registeration_phone_edit_text);
        emailEditText=(EditText) findViewById(R.id.registeration_email_edit_text);
        govtbtn=(Button)findViewById(R.id.govt_button_registration);
        settings=getSharedPreferences("id", Context.MODE_PRIVATE);
        fpibtn.setOnClickListener(this);
        retailerbtn.setOnClickListener(this);
        farmerbtn.setOnClickListener(this);
        govtbtn.setOnClickListener(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("user");


    }


    public void generateUniqueId(String subname,String subphone){

        uniqueId=subname.concat(subphone);
    }
public void registerFarmer(String name,String phone, String age,String email ){


    user=new ModelClassForRegistration(name,phone,age,email,true,1,"31.576955","74.990705");
    myRef.child("farmer").child(uniqueId).setValue(user);
    SharedPreferences.Editor editor = settings.edit();
    editor.putString("uniqueid", uniqueId);
    editor.commit();
    Log.e("check Saved ", "shared preferences are saved");

}

    public void registerRetailer(String name,String phone, String age,String email ){
        user=new ModelClassForRegistration(name,phone,age,email,true,2,"31.576955","74.990705");
        myRef.child("retailer").child(uniqueId).setValue(user);
    }
    public void registerFpi(String name,String phone,String age,String email){
        user=new ModelClassForRegistration(name,phone,age,email,true,3,"31.576955","74.990705");
        myRef.child("fpi").child(uniqueId).setValue(user);

    }


public boolean notEmpty(){

    int k=0;
    if (name.equals(null) || phone.equals(null) || email.equals(null) ||age.length()==0) {
        Toast.makeText(RegistrationActivity.this,"All Fields Compulsory",Toast.LENGTH_LONG).show();
         //return false;
        k++;
    }

    if (!(age.length()==0))
    {
    if(Integer.parseInt(age)<=30||Integer.parseInt(age)>=90 ){
        age_edit_text.setError("Age not applicable");
        k++;
    }
    }
    else {
        age_edit_text.setError("enter some age");
    }
        if (!phone.equals(null)){
    if (phone.length()<10||phone.length()>10){
        phoneEditText.setError("phone number invalid");
        k++;
    }
    }
     if(k!=0){
        return false;
    }

    else
    return true;


}

public void getValues(){


        name = nameEditText.getText().toString();
        phone = phoneEditText.getText().toString();
        email = emailEditText.getText().toString();
        age = age_edit_text.getText().toString();


}

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.farmer_button_registration:
                    getValues();
                Intent intent=new Intent(RegistrationActivity.this,FarmerFunctioningActivity.class);
                if(notEmpty()) {
                    subname = name.substring(0, 3);
                    subphone = phone.substring(7, 10);
                    generateUniqueId(subname, subphone);
                    registerFarmer(name, phone, age, email);
                    //this line would be commented
                    intent.putExtra("uniqueId",uniqueId);

                    startActivity(intent);
                }
                break;

            case R.id.retailer_button_registration:
                getValues();
                Intent intent1=new Intent(RegistrationActivity.this,RetailerFunctioningActivity.class);

                if(notEmpty()) {
                    subname = name.substring(0, 3);
                    subphone = phone.substring(7, 10);
                    generateUniqueId(subname, subphone);
                    registerRetailer(name, phone, age, email);

                    intent1.putExtra("uniqueId",uniqueId);
                    startActivity(intent1);
                }

                break;

            case R.id.fpi_button_registration:

                Intent intent2=new Intent(RegistrationActivity.this,FPIFunctioningActivity.class);

                    getValues();
                    subname = name.substring(0, 3);
                    subphone = phone.substring(7, 10);
                    generateUniqueId(subname, subphone);
                    registerFpi(name, phone, age, email);
                intent2.putExtra("uniqueid",uniqueId);
                    startActivity(intent2);


                break;

            case R.id.govt_button_registration:

                Intent intent3=new Intent(RegistrationActivity.this,GovtActivity.class);
                startActivity(intent3);

        }






    }





}
