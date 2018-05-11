package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MediatorActivity extends AppCompatActivity {
    String uniqueId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediator);

        Intent intent=getIntent();
        uniqueId=intent.getStringExtra("uniqueId");
        Toast.makeText(MediatorActivity.this,"unique ID is :"+uniqueId,Toast.LENGTH_LONG).show();
    }
}
