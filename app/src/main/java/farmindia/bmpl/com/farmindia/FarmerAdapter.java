package farmindia.bmpl.com.farmindia;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nikhilgupta on 24/03/17.
 */

public class FarmerAdapter  extends RecyclerView.Adapter<FarmerAdapter.FarmerViewHolder> {

    private List<FarmerModel> list;
    private Context mContext;
    int resID;

    public FarmerAdapter(List<FarmerModel> list,Context context) {
        this.list = list;
        this.mContext = context;
    }

    @Override
    public FarmerAdapter.FarmerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FarmerAdapter.FarmerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_item,parent,false));
    }
    @Override
    public void onBindViewHolder(final FarmerAdapter.FarmerViewHolder holder, int position) {
        FarmerModel farmer=list.get(position);
int i= R.drawable.apple;
        holder.date_text.setText("Date: "+farmer.date);
        holder.quantity_text.setText("Quantity: "+farmer.quantity);
        holder.price_text.setText("Price: "+farmer.price);
        holder.cropName_text.setText(farmer.cropName);
        holder.cropVariety_text.setText("Variety: "+farmer.cropVariety);
        resID =  ((Activity)mContext).getResources().getIdentifier(farmer.cropName, "drawable",((Activity)mContext).getPackageName());
        holder.imageView_image.setBackgroundResource(resID);
        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                Log.i("another check","hiyyaaa");
                contextMenu.add(holder.getAdapterPosition(),0,0,"delete");
                contextMenu.add(holder.getAdapterPosition(),1,0,"update");

            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class FarmerViewHolder extends RecyclerView.ViewHolder{
        TextView cropName_text,cropVariety_text,price_text,quantity_text,date_text;
        ImageView imageView_image;
        public FarmerViewHolder(View itemView) {
            super(itemView);
            imageView_image=(ImageView)itemView.findViewById(R.id.custom_layout_cropImage_image_view);
            cropName_text=(TextView)itemView.findViewById(R.id.custom_layout_cropName_text_view);
            cropVariety_text=(TextView)itemView.findViewById(R.id.custom_layout_variety_text_view);
            price_text=(TextView)itemView.findViewById(R.id.custom_layout_price_text_view);
            quantity_text=(TextView)itemView.findViewById(R.id.custom_layout_quantity_text_view);
            date_text=(TextView)itemView.findViewById(R.id.custom_layout_date_text_view);

        }
    }


}

