package farmindia.bmpl.com.farmindia;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckFarmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_farmer);

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(CheckFarmerActivity.this);

        alertDialog.setMessage("Switch on GPS");
        alertDialog.setPositiveButton("Yes",new  DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                int off = 0;
                try {
                    off = Settings.Secure.getInt(getContentResolver(), Settings.Secure.LOCATION_MODE);
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }
                if(off==0){
                    Intent onGPS = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(onGPS);
                }
                Intent intent=new Intent(CheckFarmerActivity.this,MapsActivityCheckFarmer.class);
                startActivity(intent);

            }
        });

        alertDialog.show();



    }
}
