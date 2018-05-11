package farmindia.bmpl.com.farmindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewCropsActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    private static String TAG= "on cancelled";
    private RecyclerView recyclerView;
    private CustomAdapterBuyCrops adapter;
    List<BuyCropRetailerShowModel> list;
    //this is the buy crops activity
    //here all the crops would be visible to the retailer

    //now writing the code for showing the data in a custom adapter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_crops);
        list=new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewBuyCrops);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        reference=database.getReference("user").child("farmer");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    BuyCropRetailerShowModel buyCropRetailerShowModel=new BuyCropRetailerShowModel();
                    buyCropRetailerShowModel.farmerName=postSnapshot.child("name").getValue(String.class);
                    buyCropRetailerShowModel.farmerMail=postSnapshot.child("email").getValue(String.class);
                    buyCropRetailerShowModel.contactNo=postSnapshot.child("phone").getValue(String.class);



                        for (DataSnapshot ds:postSnapshot.child("my_posts").getChildren()) {


                            buyCropRetailerShowModel.cropName = ds.child("cropName").getValue(String.class);
                            buyCropRetailerShowModel.cropVariety = ds.child("cropVariety").getValue(String.class);
                            buyCropRetailerShowModel.date = ds.child("date").getValue(String.class);
                            buyCropRetailerShowModel.price =ds.child("price").getValue(String.class);
                            buyCropRetailerShowModel.imageURL = ds.child("imageURL").getValue(String.class);
                            buyCropRetailerShowModel.quantity = ds.child("quantity").getValue(String.class);
                            list.add(new BuyCropRetailerShowModel(buyCropRetailerShowModel));


                        }
                    Toast.makeText(ViewCropsActivity.this,String.valueOf(list.size()),Toast.LENGTH_LONG).show();


                    //list.add(postSnapshot.getValue(BuyCropRetailerShowModel.class));
                    //error
                   //Toast.makeText(ViewCropsActivity.this,postSnapshot.getValue(FarmerModel.class).toString(),Toast.LENGTH_LONG).show();
                  // HashMap<String,Object> t=postSnapshot.getValue();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        adapter = new CustomAdapterBuyCrops(list,ViewCropsActivity.this);
        recyclerView.setAdapter(adapter);
        updateList();


    }

    public void updateList(){
        list.clear();
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             list.add(dataSnapshot.getValue(BuyCropRetailerShowModel.class));
               adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                //adapter.notifyItemRemoved(index);
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
