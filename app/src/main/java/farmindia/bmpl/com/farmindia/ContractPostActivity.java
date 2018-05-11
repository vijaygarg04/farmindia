package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractPostActivity extends AppCompatActivity {
    Button add_button;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences ;
    private List<ContractPostModel> result;
    FirebaseDatabase database;
    DatabaseReference reference;

    private ContractPostAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_post);
        sharedPreferences = getSharedPreferences("id",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Intent intent = getIntent();
        String uniqueID=intent.getStringExtra("uniqueid");
        editor.putString("uniqueid",uniqueID);
        add_button=(Button)findViewById(R.id.contract_post_add_button);
        recyclerView=(RecyclerView)findViewById(R.id.user_list_contract);
        result=new ArrayList<ContractPostModel>();
        recyclerView=(RecyclerView)findViewById(R.id.user_list_contract);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        adapter=new ContractPostAdapter(result,ContractPostActivity.this);
        recyclerView.setAdapter(adapter);
        updateList();
        //database reference to be set up
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ContractPostActivity.this,AddContractActivity.class);
                startActivity(intent);

            }
        });
        //here an add button will come which when clicked post add screen is provided
        //whereas on this screen posts will be shown

    }
    private void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(ContractPostModel.class));
                Toast.makeText(ContractPostActivity.this,"data added",Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                ContractPostModel model=dataSnapshot.getValue(ContractPostModel.class);
                int index=getItemIndex(model);
                result.set(index,model);
                adapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                ContractPostModel model=dataSnapshot.getValue(ContractPostModel.class);
                int index=getItemIndex(model);
                result.remove(index);
                adapter.notifyItemRemoved(index);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(ContractPostActivity.this,"choose an option",Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case 0:
                removeUser(item.getGroupId());
                break;
            case 1:
                changeUser(item.getGroupId());
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void changeUser(int position){
        ContractPostModel user=result.get(position);
        user.cropName="gheeya";
        Map<String,Object> userValue=user.toMap();
        Map<String,Object> newUser=new HashMap<>();
        newUser.put(user.key,userValue);
        reference.updateChildren(newUser);
    }
    private void removeUser(int position){
        reference.child(result.get(position).key).removeValue();
    }
    private int getItemIndex(ContractPostModel user){

        int index=-1;
        for(int i =0;i<result.size();i++){
            if(result.get(i).key.equals(user.key)){
                index=i;
                break;
            }
        }
        return index;
    }
}
