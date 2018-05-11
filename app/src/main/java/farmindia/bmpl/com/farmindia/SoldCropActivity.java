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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoldCropActivity extends AppCompatActivity {

    private FirebaseDatabase database;

    SharedPreferences sharedPreferences;
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    //change done******************************************************************************************
    private List<FarmerModel> result;
    Button addButton;
    private FarmerAdapter adapter;
    int noOfposts;;
    String unid;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(SoldCropActivity.this, "choose an option", Toast.LENGTH_SHORT).show();

        switch (item.getItemId()) {
            case 0:
                removeUser(item.getGroupId());
                break;
            case 1:
                changeUser(item.getGroupId());
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_crop);

        result = new ArrayList<>();
       sharedPreferences=getSharedPreferences("id", Context.MODE_PRIVATE);
       unid= sharedPreferences.getString("uniqueid","");
        database = FirebaseDatabase.getInstance();


        reference = database.getReference("user").child("farmer").child(unid);

        addButton=(Button)findViewById(R.id.farmer_post_add_button);

        recyclerView = (RecyclerView) findViewById(R.id.user_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        reference.child("my_posts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FarmerModel model = dataSnapshot1.getValue(FarmerModel.class);
                    result.add(model);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               noOfposts=Integer.parseInt(dataSnapshot.child("noOfposts").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //change***************************************************************************
        adapter = new FarmerAdapter(result,SoldCropActivity.this);
        recyclerView.setAdapter(adapter);
      //  updateList();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SoldCropActivity.this,SellActivity.class);
                startActivity(intent1);

            }
        });
    }



    private void updateList() {
        result.clear();
       if (noOfposts>=0) {
           reference.child("my_posts").addChildEventListener(new ChildEventListener() {

               @Override
               public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                   result.add(dataSnapshot.getValue(FarmerModel.class));
                   //increaseNoOfPosts();
                   adapter.notifyDataSetChanged();
               }

               @Override
               public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                   FarmerModel model = dataSnapshot.getValue(FarmerModel.class);
                   int index = getItemIndex(model);
                   result.set(index, model);
                   adapter.notifyItemChanged(index);
               }

               @Override
               public void onChildRemoved(DataSnapshot dataSnapshot) {

                   FarmerModel model = dataSnapshot.getValue(FarmerModel.class);
                   int index = getItemIndex(model);
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

    }

    private void changeUser(int position) {
        FarmerModel user = result.get(position);
        user.cropName = "gheeya";
        Map<String, Object> userValue = user.toMap();
        Map<String, Object> newUser = new HashMap<>();
        newUser.put(user.key, userValue);
        reference.updateChildren(newUser);
        adapter.notifyDataSetChanged();
    }

    private void removeUser(int position) {
        reference.child(result.get(position).key).removeValue();
        adapter.notifyDataSetChanged();
        noOfposts--;
        reference.child("noOfposts").setValue(noOfposts);

    }
    private int getItemIndex(FarmerModel user) {

        int index = -1;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).key.equals(user.key)) {
                index = i;
                break;
            }
        }
        return index;
    }

}

