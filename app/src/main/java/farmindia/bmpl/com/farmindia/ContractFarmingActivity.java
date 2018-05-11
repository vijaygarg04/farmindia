package farmindia.bmpl.com.farmindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ContractFarmingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ContractFarmerShowModel> result;
    FirebaseDatabase database;
    DatabaseReference reference;
    private ContractFarmerShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_farming);

        database=FirebaseDatabase.getInstance();
        reference=database.getReference("users").child("fpi");

        result=new ArrayList<ContractFarmerShowModel>();
        recyclerView=(RecyclerView)findViewById(R.id.user_list_contract);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                       ContractFarmerShowModel contractFarmerShowModel=new ContractFarmerShowModel();
                        contractFarmerShowModel.FPIname= ds.child("name").getValue().toString();
                        contractFarmerShowModel.FPIcontactNo=ds.child("phone").getValue().toString();

                    int noOfposts=Integer.parseInt(ds.child("noOfposts").getValue().toString());
                    if (noOfposts!=0){
                        for (DataSnapshot post:dataSnapshot.child("contracts").getChildren()){
                            contractFarmerShowModel.cropName=post.child("cropName").getValue(String.class);
                            contractFarmerShowModel.cropVariety=post.child("cropVariety").getValue(String.class);
                            contractFarmerShowModel.noOfFarmers=post.child("noOfFarmers").getValue(String.class);
                            contractFarmerShowModel.price=post.child("price").getValue(String.class);
                            contractFarmerShowModel.quantity=post.child("quantity").getValue(String.class);
                            contractFarmerShowModel.URLtoContract=post.child("URLforContract").getValue(String.class);
                            contractFarmerShowModel.duration=post.child("toBedeliveredIn").getValue(String.class);
                            result.add(new ContractFarmerShowModel(contractFarmerShowModel));
                        }
                    }
                    else
                    {
                        Toast.makeText(ContractFarmingActivity.this,"the farmer hasn't posted anything yet",Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(ContractFarmingActivity.this,String.valueOf(result.size()),Toast.LENGTH_LONG).show();





                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        adapter=new ContractFarmerShowAdapter(result,ContractFarmingActivity.this);
        recyclerView.setAdapter(adapter);
       // updateList();
    }

    /*private void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(ContractFarmerShowModel.class));
                Toast.makeText(ContractFarmingActivity.this,"data added",Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/
    }


