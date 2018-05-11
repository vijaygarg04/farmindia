package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FarmerFunctioningActivity extends AppCompatActivity implements View.OnClickListener

{

    Button selcrp_btn, cldstr_btn, chkret_btn, sldcrp_btn, cntrtfarm_btn, discroom_btn;
    String uniqueId,shID;
    FirebaseDatabase database;
    SharedPreferences sharedPreferences;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_functioning);
        Toast.makeText(FarmerFunctioningActivity.this, "welcome", Toast.LENGTH_SHORT).show();
        sharedPreferences = getSharedPreferences("id", Context.MODE_PRIVATE);
        shID = sharedPreferences.getString("uniqueid","");
        selcrp_btn = (Button) findViewById(R.id.sellcrop_btn);
        chkret_btn = (Button) findViewById(R.id.checkret_btn);
        cldstr_btn = (Button) findViewById(R.id.chkcold_btn);
        sldcrp_btn = (Button) findViewById(R.id.stk_btn);
        cntrtfarm_btn = (Button) findViewById(R.id.cntrtfrm_btn);
        discroom_btn = (Button) findViewById(R.id.discroom_btn);
        selcrp_btn.setOnClickListener(this);
        chkret_btn.setOnClickListener(this);
        cldstr_btn.setOnClickListener(this);
        sldcrp_btn.setOnClickListener(this);
        cntrtfarm_btn.setOnClickListener(this);
        discroom_btn.setOnClickListener(this);
        Intent intent = getIntent();
        uniqueId = intent.getStringExtra("uniqueId");
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("user").child("farmer").child(uniqueId);
        Log.e("id from intent ",uniqueId);
        Log.e(" shared preferences",shID);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sellcrop_btn:
                Intent intent = new Intent(FarmerFunctioningActivity.this, SellActivity.class);
                intent.putExtra("uniqueId",uniqueId);
                startActivity(intent);

                break;

            case R.id.checkret_btn:
                Intent intent1 = new Intent(FarmerFunctioningActivity.this, MapsActivityCheckRetailer.class);

                intent1.putExtra("uniqueId",uniqueId);
                startActivity(intent1);

                break;

            case R.id.stk_btn:
                Intent intent2 = new Intent(FarmerFunctioningActivity.this, SoldCropActivity.class);

                intent2.putExtra("uniqueId", uniqueId);
                startActivity(intent2);

                break;

            case R.id.chkcold_btn:
                Intent intent3 = new Intent(FarmerFunctioningActivity.this, MapsActivityCheckColdStorage.class);
                startActivity(intent3);

                break;

            case R.id.cntrtfrm_btn:

                Intent intent4 = new Intent(FarmerFunctioningActivity.this, ContractFarmingActivity.class);
                intent4.putExtra("uniqueId",uniqueId);
                startActivity(intent4);

                break;

            case R.id.discroom_btn:

                Intent intent5 = new Intent(FarmerFunctioningActivity.this, ChatActivity.class);
                intent5.putExtra("uniqueId",uniqueId);
                startActivity(intent5);

                break;
        }
    }


    }

