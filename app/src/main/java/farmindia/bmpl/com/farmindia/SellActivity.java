package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {
    ArrayList<SectionDataModel> allSampleData;
    ArrayList<String> headerData=new ArrayList<>();
    String uniqueId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        allSampleData = new ArrayList<SectionDataModel>();
        headerData.add("VEGETABLES");
        headerData.add("SPICES");
        headerData.add("FRUITS");
        headerData.add("CEREALS");
        headerData.add("PULSES");
        headerData.add("VEGETABLES");
        createDummyData();

        Intent intent=getIntent();
        uniqueId=intent.getStringExtra("uniqueId");


        //Toast.makeText(SellActivity.this,"Id is: "+uniqueId,Toast.LENGTH_LONG).show();

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    public void createDummyData() {

        SectionDataModel dm1=new SectionDataModel();
        String head1=headerData.get(0);
        dm1.setHeaderTitle(head1);
        ArrayList<SingleItemModel> singleItem=new ArrayList<>();
        singleItem.add(new SingleItemModel("ladyfinger",R.drawable.bhindi,uniqueId));
        singleItem.add(new SingleItemModel("bitter gourd",R.drawable.bittergourd,uniqueId));
        singleItem.add(new SingleItemModel("bottle gaurd",R.drawable.bottelgourd,uniqueId));
        singleItem.add(new SingleItemModel("brinjal",R.drawable.brinjal,uniqueId));
        singleItem.add(new SingleItemModel("cabbage",R.drawable.cabbage,uniqueId));
        singleItem.add(new SingleItemModel("capscicum",R.drawable.capsicum,uniqueId));
        singleItem.add(new SingleItemModel("cowliflower",R.drawable.cauliflower,uniqueId));
        singleItem.add(new SingleItemModel("onion",R.drawable.onion,uniqueId));
        singleItem.add(new SingleItemModel("potato",R.drawable.potato,uniqueId));
        singleItem.add(new SingleItemModel("tomato",R.drawable.tomato,uniqueId));
        singleItem.add(new SingleItemModel("lemon",R.drawable.lemon,uniqueId));
        singleItem.add(new SingleItemModel("soyabean",R.drawable.soyabean,uniqueId));
        singleItem.add(new SingleItemModel("chilli",R.drawable.chilly,uniqueId));
        singleItem.add(new SingleItemModel("raddish",R.drawable.radish,uniqueId));
        singleItem.add(new SingleItemModel("beans",R.drawable.beans,uniqueId));
        singleItem.add(new SingleItemModel("cucumber",R.drawable.cucumber,uniqueId));
        singleItem.add(new SingleItemModel("beet root",R.drawable.beetroot,uniqueId));
        singleItem.add(new SingleItemModel("pumpkin",R.drawable.pumpkin,uniqueId));
        singleItem.add(new SingleItemModel("ladyfinger",R.drawable.bhindi,uniqueId));
        singleItem.add(new SingleItemModel("green peas",R.drawable.greenpea,uniqueId));
        singleItem.add(new SingleItemModel("raw banana",R.drawable.rawbanana,uniqueId));
        singleItem.add(new SingleItemModel("drum sticks",R.drawable.drumstickes,uniqueId));
        singleItem.add(new SingleItemModel("yam",R.drawable.yam,uniqueId));
        singleItem.add(new SingleItemModel("mushrooms",R.drawable.mushroom,uniqueId));
        dm1.setAllItemsInSection(singleItem);
        allSampleData.add(dm1);


        SectionDataModel dm2=new SectionDataModel();
        String head2=headerData.get(1);
        dm2.setHeaderTitle(head2);
        ArrayList<SingleItemModel> singleItem1=new ArrayList<>();
        singleItem1.add(new SingleItemModel("Black Pepper",R.drawable.blackpepper,uniqueId));
        singleItem1.add(new SingleItemModel("Corriander ",R.drawable.corianderseed,uniqueId));
        singleItem1.add(new SingleItemModel("Cummin Seeds",R.drawable.cumminseed,uniqueId));
        singleItem1.add(new SingleItemModel("Dry Chillies",R.drawable.drychilli,uniqueId));
        singleItem1.add(new SingleItemModel("Garlic",R.drawable.garlic,uniqueId));
        singleItem1.add(new SingleItemModel("Methi Seeds",R.drawable.methiseed,uniqueId));
        singleItem1.add(new SingleItemModel("Turmeric",R.drawable.turmeric,uniqueId));
        singleItem1.add(new SingleItemModel("Ginger",R.drawable.ginger,uniqueId));
        singleItem1.add(new SingleItemModel("Cinnamon",R.drawable.cinnamon,uniqueId));
        singleItem1.add(new SingleItemModel("Nutmeg",R.drawable.nutmeg,uniqueId));
        singleItem1.add(new SingleItemModel("Mace",R.drawable.mace,uniqueId));
        singleItem1.add(new SingleItemModel("Clove",R.drawable.clove,uniqueId));
        singleItem1.add(new SingleItemModel("Mustard Seeds",R.drawable.mustardseed,uniqueId));
        singleItem1.add(new SingleItemModel("Bay Leaf",R.drawable.bayleaf,uniqueId));
        singleItem1.add(new SingleItemModel("Carrom Seeds",R.drawable.caromseed,uniqueId));
        singleItem1.add(new SingleItemModel("Star Anise",R.drawable.staranise,uniqueId));
        singleItem1.add(new SingleItemModel("Brown Cardamom",R.drawable.cardamom,uniqueId));
        singleItem1.add(new SingleItemModel("Heeng",R.drawable.asafoetida,uniqueId));
        singleItem1.add(new SingleItemModel("Cardamom",R.drawable.cardamom,uniqueId));
        singleItem1.add(new SingleItemModel("Tamarind",R.drawable.tamarind,uniqueId));
        dm2.setAllItemsInSection(singleItem1);
        allSampleData.add(dm2);


        SectionDataModel dm3=new SectionDataModel();
        String head3=headerData.get(2);
        dm3.setHeaderTitle(head3);
        ArrayList<SingleItemModel> singleItem2=new ArrayList<>();
        singleItem2.add(new SingleItemModel("apple",R.drawable.apple,uniqueId));
        singleItem2.add(new SingleItemModel("banana",R.drawable.banana,uniqueId));
        singleItem2.add(new SingleItemModel("grapes",R.drawable.grapes,uniqueId));
        singleItem2.add(new SingleItemModel("mango",R.drawable.mango,uniqueId));
        singleItem2.add(new SingleItemModel("orange",R.drawable.orange,uniqueId));
        singleItem2.add(new SingleItemModel("papaya",R.drawable.papaya,uniqueId));
        singleItem2.add(new SingleItemModel("pineapple",R.drawable.pineapple,uniqueId));
        singleItem2.add(new SingleItemModel("promogrenate",R.drawable.pomegranate,uniqueId));
        singleItem2.add(new SingleItemModel("spota",R.drawable.spota,uniqueId));
        singleItem2.add(new SingleItemModel("Water Melon",R.drawable.watermelon,uniqueId));
        singleItem2.add(new SingleItemModel("Guava",R.drawable.guava,uniqueId));
        singleItem2.add(new SingleItemModel("Musk Melon",R.drawable.muskmelon,uniqueId));
        singleItem2.add(new SingleItemModel("Kiwi",R.drawable.kiwifruit,uniqueId));
        singleItem2.add(new SingleItemModel("Pear Fruit",R.drawable.pearfruit,uniqueId));
        singleItem2.add(new SingleItemModel("Blue Berry",R.drawable.blueberry,uniqueId));
        singleItem2.add(new SingleItemModel("Blackberry",R.drawable.blackberry,uniqueId));
        singleItem2.add(new SingleItemModel("Cherry",R.drawable.cherry,uniqueId));
        singleItem2.add(new SingleItemModel("Fig",R.drawable.fig,uniqueId));
        singleItem2.add(new SingleItemModel("Jackfruit",R.drawable.jackfruit,uniqueId));
        singleItem2.add(new SingleItemModel("Peach",R.drawable.peach,uniqueId));
        singleItem2.add(new SingleItemModel("Plum",R.drawable.plum,uniqueId));
        singleItem2.add(new SingleItemModel("Carambola",R.drawable.carambola,uniqueId));
        singleItem2.add(new SingleItemModel("Strawberry",R.drawable.strawberry,uniqueId));
        singleItem2.add(new SingleItemModel("Butter Furit",R.drawable.butterfruit,uniqueId));
        dm3.setAllItemsInSection(singleItem2);
        allSampleData.add(dm3);


        SectionDataModel dm4=new SectionDataModel();
        String head4=headerData.get(3);
        dm4.setHeaderTitle(head4);
        ArrayList<SingleItemModel> singleItem3=new ArrayList<>();
        singleItem3.add(new SingleItemModel("Bajra",R.drawable.bajra,uniqueId));
        singleItem3.add(new SingleItemModel("Jowar",R.drawable.sorgham,uniqueId));
        singleItem3.add(new SingleItemModel("Maize",R.drawable.maize,uniqueId));
        singleItem3.add(new SingleItemModel("Paddy",R.drawable.paddy,uniqueId));
        singleItem3.add(new SingleItemModel("Ragi",R.drawable.ragi,uniqueId));
        singleItem3.add(new SingleItemModel("Rice",R.drawable.rice,uniqueId));
        singleItem3.add(new SingleItemModel("Wheat",R.drawable.wheat,uniqueId));
        singleItem3.add(new SingleItemModel("Barley Rice",R.drawable.barleyrice,uniqueId));
        dm4.setAllItemsInSection(singleItem3);
        allSampleData.add(dm4);


        SectionDataModel dm5=new SectionDataModel();
        String head5=headerData.get(4);
        dm5.setHeaderTitle(head5);
        ArrayList<SingleItemModel> singleItem4=new ArrayList<>();
        singleItem4.add(new SingleItemModel("Arhar",R.drawable.arhar,uniqueId));
        singleItem4.add(new SingleItemModel("BengalGram",R.drawable.bengalgram,uniqueId));
        singleItem4.add(new SingleItemModel("Black Gram",R.drawable.blackgram,uniqueId));
        singleItem4.add(new SingleItemModel("Green Gram",R.drawable.greengram,uniqueId));
        singleItem4.add(new SingleItemModel("Horse Gram",R.drawable.horsegram,uniqueId));
        singleItem4.add(new SingleItemModel("Lentil",R.drawable.lentil,uniqueId));
        singleItem4.add(new SingleItemModel("Red Gram",R.drawable.redgram,uniqueId));
        singleItem.add(new SingleItemModel("Soyabean",R.drawable.soyabean,uniqueId));
        singleItem4.add(new SingleItemModel("Chavily/Lobia",R.drawable.chawli,uniqueId));
        singleItem4.add(new SingleItemModel("Broken Wheat",R.drawable.brokenwheat,uniqueId));
        singleItem4.add(new SingleItemModel("Chana",R.drawable.blackgram,uniqueId));
        singleItem4.add(new SingleItemModel("Puffed Rice",R.drawable.puffedrice,uniqueId));
        singleItem4.add(new SingleItemModel("Pea",R.drawable.pea,uniqueId));
        singleItem4.add(new SingleItemModel("Beaten Rice",R.drawable.beatenrice,uniqueId));
        singleItem4.add(new SingleItemModel("Kidney Bean",R.drawable.kidneybean,uniqueId));
        singleItem4.add(new SingleItemModel("Sesame",R.drawable.sesame,uniqueId));
        singleItem4.add(new SingleItemModel("Ground Nut Seeds",R.drawable.groundnut,uniqueId));
        dm5.setAllItemsInSection(singleItem4);
        allSampleData.add(dm5);



    }
}
