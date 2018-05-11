package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FPIFunctioningActivity extends AppCompatActivity implements View.OnClickListener{

    Button crop_adv, cold_strg,cntrct_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpifunctioning);

        crop_adv=(Button)findViewById(R.id.crp_adv);
        cold_strg=(Button)findViewById(R.id.cld_storage_fpi);
        cntrct_post=(Button)findViewById(R.id.cntrctpost_btn);

        crop_adv.setOnClickListener(this);
        cold_strg.setOnClickListener(this);
        cntrct_post.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.crp_adv:

                Intent intent=new Intent(FPIFunctioningActivity.this,BuyFarmerCrops.class);

                startActivity(intent);
                break;

            case R.id.cld_storage_fpi:

                Intent intent1=new Intent(FPIFunctioningActivity.this,MapsActivityCheckColdStorage.class);

                startActivity(intent1);
                break;

            case R.id.cntrctpost_btn:

                Intent intent2=new Intent(FPIFunctioningActivity.this,ContractPostActivity.class);

                startActivity(intent2);
                break;
        }
    }
}
