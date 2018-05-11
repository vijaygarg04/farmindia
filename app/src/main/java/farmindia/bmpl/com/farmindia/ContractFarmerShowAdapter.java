package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nikhilgupta on 02/04/17.
 */

public class ContractFarmerShowAdapter  extends RecyclerView.Adapter<ContractFarmerShowAdapter.ContractShowViewHolder> {

    private List<ContractFarmerShowModel> list;
    Context context;

    public ContractFarmerShowAdapter(List<ContractFarmerShowModel> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public ContractFarmerShowAdapter.ContractShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContractFarmerShowAdapter.ContractShowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contract_post,parent,false));
    }
    @Override
    public void onBindViewHolder(final ContractFarmerShowAdapter.ContractShowViewHolder holder, int position) {
        final ContractFarmerShowModel contractModel=list.get(position);
        holder.numberOfFarmer_text.setText(contractModel.URLtoContract);
        //holder.date_text.setText("Date: "+farmer.date);
        holder.quantity_text.setText("Quantity: "+contractModel.quantity);
        holder.price_text.setText("Price: "+contractModel.price);
        holder.cropName_text.setText("Crop Name: "+contractModel.cropName);
        holder.numberOfFarmer_text.setText("No of farmers: " +contractModel.noOfFarmers);
        holder.cropVariety_text.setText("Variety: "+contractModel.cropVariety);
        holder.URLforContract_text.setText("URL: "+ contractModel.URLtoContract);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ApplyContractActivity.class);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ContractShowViewHolder extends RecyclerView.ViewHolder{
        TextView cropName_text,cropVariety_text,price_text,quantity_text,numberOfFarmer_text,URLforContract_text;

        public ContractShowViewHolder(View itemView) {
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

