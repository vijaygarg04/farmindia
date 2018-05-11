package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GovtActivity extends AppCompatActivity {

    Button graphs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt);
        graphs=(Button)findViewById(R.id.graphs);

        graphs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GovtActivity.this,GraphActivity.class);
                startActivity(intent);
            }
        });
    }
}
