package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    Button postBtn;
    TextView cropDescText;
    int resID;
    ImageView imageView;
    String format;
    SharedPreferences sharedPreferences;
    String imageID;
    int noOfPosts;
    EditText crop_type_edit_text,crop_price_edit_text,crop_quantity_edit_text;
    String crop_type,crop_price,crop_quantity;
    String unid,desc;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Calendar c=Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       format =df.format(c.getTime());
        postBtn=(Button)findViewById(R.id.post_sellcrop_button);
        postBtn.setOnClickListener(this);
        crop_type_edit_text=(EditText)findViewById(R.id.crop_type_edit_text_sell_crop);
        crop_price_edit_text=(EditText)findViewById(R.id.crop_quantity_edit_text_sell_crop);
        crop_quantity_edit_text=(EditText)findViewById(R.id.crop_price_edit_text_sell_crop);
        cropDescText=(TextView)findViewById(R.id.crop_desc_text_view);
        sharedPreferences=getSharedPreferences("id",Context.MODE_PRIVATE);
        unid= sharedPreferences.getString("uniqueid","");
        Log.e("unique ID on Second",unid);
        database=FirebaseDatabase.getInstance();
        Intent intent = getIntent();
        desc = intent.getStringExtra("description");
        imageView=(ImageView)findViewById(R.id.post_crop_farmer_image_view);
        imageID = desc.replaceAll("\\s+","").toLowerCase();
        Log.e("description second",imageID);
        resID = getResources().getIdentifier(imageID, "drawable", getPackageName());
        Log.e("resource id : ",String.valueOf(resID));
        //imageView.setImageDrawable(drawable);
        imageView.setBackgroundResource(resID);





    }

    @Override
    public void onClick(View view) {


        reference=database.getReference("user").child("farmer").child(unid);

        switch (view.getId()){


            case R.id.post_sellcrop_button:
                Toast.makeText(SecondActivity.this,"post added successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SecondActivity.this,SoldCropActivity.class);
               crop_price=crop_price_edit_text.getText().toString();
                crop_type=crop_type_edit_text.getText().toString();
                crop_quantity=crop_quantity_edit_text.getText().toString();
                String key=reference.child("my_posts").push().getKey();
                FarmerModel farmerModel = new FarmerModel(format,"key1",crop_price+" per kg",crop_quantity+" kg",crop_type,desc,resID);
                farmerModel.key=key;

                Log.i("generated Firebase Key ",key);
                Toast.makeText(getApplicationContext(),"post added successfully",Toast.LENGTH_LONG).show();
                reference.child("name").setValue("Raju");
                reference.child("my_posts").child(key).setValue(farmerModel);
                reference.child("noOfposts").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        noOfPosts=Integer.parseInt(dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                noOfPosts++;
                reference.child("noOfposts").setValue(noOfPosts);

                startActivity(intent);
                break;
        }





    }



}


