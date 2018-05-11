package farmindia.bmpl.com.farmindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ApplyContractActivity extends AppCompatActivity {
    EditText quantityEditText;
    Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_contract);
        quantityEditText=(EditText)findViewById(R.id.edit_text_apply_for_contract);
        applyButton=(Button)findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quantity=  quantityEditText.getText().toString();
                Toast.makeText(ApplyContractActivity.this,"you have been added to the chat with id  hula hual",Toast.LENGTH_LONG).show();
            }
        });

    }

}
