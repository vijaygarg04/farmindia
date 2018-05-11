package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RetailerFunctioningActivity extends AppCompatActivity implements View.OnClickListener{
    Button buycrop_btn,chkfarmer_btn;
    String uniqueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_functioning);

        buycrop_btn=(Button)findViewById(R.id.buy_crop_btn);
        chkfarmer_btn=(Button)findViewById(R.id.check_farmer_btn);

        buycrop_btn.setOnClickListener(this);
        chkfarmer_btn.setOnClickListener(this);

        Intent intent=getIntent();
        uniqueId=intent.getStringExtra("uniqueId");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buy_crop_btn:

                Intent intent=new Intent(RetailerFunctioningActivity.this,ViewCropsActivity.class);
                //Toast.makeText(getApplicationContext(),"dufjhvujgdhfcg",Toast.LENGTH_LONG).show();
                intent.putExtra("uniqueId",uniqueId);
                startActivity(intent);

                break;

            case R.id.check_farmer_btn:

                Intent intent1=new Intent(RetailerFunctioningActivity.this,MapsActivityCheckFarmer.class);
                intent1.putExtra("uniqueId",uniqueId);
                startActivity(intent1);

                break;
        }
    }
}
