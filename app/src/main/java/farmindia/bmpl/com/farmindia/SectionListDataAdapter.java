package farmindia.bmpl.com.farmindia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nikhilgupta on 17/03/17.
 */

class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {
    private ArrayList<SingleItemModel> itemsList;
    String passingText,hunger;
    private Context mContext;
    SharedPreferences sharedPreferences;
    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

        final SingleItemModel singleItem = itemsList.get(i);

        passingText=singleItem.getName();
        hunger=singleItem.getUniqueId();
        holder.tvTitle.setText(passingText);
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences=mContext.getSharedPreferences("id",Context.MODE_PRIVATE);
                String shID =sharedPreferences.getString("uniqueid","");
                String passedVal = holder.tvTitle.getText().toString();
                String imageURL = String.valueOf(singleItem.getUrl());
                String description = singleItem.getDescription();
                Intent it=new Intent(mContext,SecondActivity.class);
                it.putExtra("passedValue",passedVal);
                it.putExtra("uniqueId",shID);
                it.putExtra("imageURL",imageURL);
                it.putExtra("description",description);
                Log.e("final*** passed value",passedVal);
                Log.e("final*** imageURL",imageURL);
                Log.e("final*** description",description);
                Log.e("final*** uniqueID",shID);
                //here the code for updating to database would come
                mContext.startActivity(it);
                ((Activity)mContext).finish();
            }
        });

        //Intent intent8 = new Intent("my.action.string");
       // intent8.putExtra("extra", singleItem.getUniqueId());
        //mContext.sendBroadcast(intent8);
        holder.itemImage.setBackgroundResource(singleItem.getUrl());
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"this is a check",Toast.LENGTH_SHORT).show();
            }
        });


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }
    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);




        }

    }
}

