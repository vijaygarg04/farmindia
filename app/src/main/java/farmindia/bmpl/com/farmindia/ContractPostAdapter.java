package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nikhilgupta on 26/03/17.
 */

public class ContractPostAdapter  extends RecyclerView.Adapter<ContractPostAdapter.ContractViewHolder> {

    private List<ContractPostModel> list;
    Context context;

    public ContractPostAdapter(List<ContractPostModel> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public ContractPostAdapter.ContractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContractPostAdapter.ContractViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contract_post,parent,false));
    }
    @Override
    public void onBindViewHolder(final ContractPostAdapter.ContractViewHolder holder, int position) {
        final ContractPostModel contractModel=list.get(position);
        holder.numberOfFarmer_text.setText(contractModel.URLforContract);
        //holder.date_text.setText("Date: "+farmer.date);
        holder.quantity_text.setText("Quantity: "+contractModel.quantity);
        holder.price_text.setText("Price: "+contractModel.price);
        holder.cropName_text.setText("Crop Name: "+contractModel.cropName);
        holder.numberOfFarmer_text.setText("No of farmers: " +contractModel.noOfFarmers);
        holder.cropVariety_text.setText("Variety: "+contractModel.cropVariety);
        holder.URLforContract_text.setText("URL: "+ contractModel.URLforContract);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ApplyContractActivity.class);
                context.startActivity(intent);
            }
        });
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

    class ContractViewHolder extends RecyclerView.ViewHolder{
        TextView cropName_text,cropVariety_text,price_text,quantity_text,numberOfFarmer_text,URLforContract_text;

        public ContractViewHolder(View itemView) {
            super(itemView);
            cropName_text=(TextView)itemView.findViewById(R.id.custom_layout_cropName_text_view);
            cropVariety_text=(TextView)itemView.findViewById(R.id.custom_layout_variety_text_view);
            price_text=(TextView)itemView.findViewById(R.id.custom_layout_price_text_view);
            quantity_text=(TextView)itemView.findViewById(R.id.custom_layout_quantity_text_view);
            URLforContract_text=(TextView)itemView.findViewById(R.id.custom_layout_URLforContract_text_view);
            numberOfFarmer_text=(TextView)itemView.findViewById(R.id.custom_layout_numberOfFarmer_text_view);


        }
    }

}

