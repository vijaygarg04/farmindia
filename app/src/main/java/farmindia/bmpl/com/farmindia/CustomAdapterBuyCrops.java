package farmindia.bmpl.com.farmindia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nikhilgupta on 29/03/17.
 */

public class CustomAdapterBuyCrops extends RecyclerView.Adapter<CustomAdapterBuyCrops.RetailerViewHolder>

{

    private List<BuyCropRetailerShowModel> list;
    private Context context;

    public CustomAdapterBuyCrops(List<BuyCropRetailerShowModel> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public CustomAdapterBuyCrops.RetailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       
        return new CustomAdapterBuyCrops.RetailerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom_adapter_buy_crops,parent,false));
    }

    @Override
    public void onBindViewHolder(final CustomAdapterBuyCrops.RetailerViewHolder holder, final int position) {
        final BuyCropRetailerShowModel buyCropModel=list.get(position);
        //accessing my componenets and setting their values
        Log.e("esxdrcftvgybhnj","dxcfgvhbjnkml");
       holder.textViewCropName.setText(buyCropModel.cropName.toString());
        holder.textViewCropVariety.setText(buyCropModel.cropVariety.toString());
        holder.textViewQuantity.setText(buyCropModel.quantity);
        holder.textViewPrice.setText(buyCropModel.price);
      //  buyCropModel.farmerName
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"position is : "+position,Toast.LENGTH_LONG).show();
            }
        });
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="tel:" +buyCropModel.contactNo.toString();

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);

            }
        });

        holder.payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PayFarmer.class);
                context.startActivity(intent);
            }
        });
        holder.locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showDirections(31.6340, 74.8723, 28.7041, 77.1025);
            }

            public void showDirections(double lat, double lng, double lat1, double lng1) {

                final Intent intent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?" +
                        "saddr=" + lat + "," + lng + "&daddr=" + lat1 + "," +
                        lng1));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                context.startActivity(intent);

            }




        });
        holder.textViewFarmerName.setText(buyCropModel.farmerName);
        holder.imageView.setImageResource(R.drawable.wheat);
        //holder.imageView.setImageResource(Integer.parseInt(buyCropModel.imageURL));
        holder.messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no=buyCropModel.contactNo.toString();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("smsto:"));
                intent.setType("vnd.android-dir/mms-sms");
                intent.putExtra("sms_body","write your message here");
                intent.putExtra("address",no);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RetailerViewHolder extends RecyclerView.ViewHolder{
         TextView textViewCropName
        ,textViewCropVariety
         ,textViewQuantity
         , textViewPrice,
         textViewFarmerName;
         ImageView imageView;
         Button callButton;
        Button messageButton;
         Button locationButton;
         Button payButton;

      //  GoogleApiClient client;


        public RetailerViewHolder(View itemView){
            super(itemView);
            textViewFarmerName=(TextView)itemView.findViewById(R.id.buy_crop_adapter_farmerName);
            textViewCropName=(TextView)itemView.findViewById(R.id.buy_crop_adapter_crop_name_text);
            textViewCropVariety=(TextView)itemView.findViewById(R.id.buy_crop_adapter_crop_variety_text);
            textViewPrice=(TextView)itemView.findViewById(R.id.buy_crop_adapter_price_text);
            textViewQuantity=(TextView)itemView.findViewById(R.id.buy_crop_adapter_quantity_text);
            callButton=(Button)itemView.findViewById(R.id.buy_crop_adapter_call_button);
            messageButton=(Button)itemView.findViewById(R.id.buy_crop_adapter_message_button);
            locationButton=(Button)itemView.findViewById(R.id.buy_crop_adapter_distance_button);
            payButton=(Button)itemView.findViewById(R.id.pay);
          //  client=new GoogleApiClient.Builder(context).addApi(AppIndex.API).build();
            imageView=(ImageView)itemView.findViewById(R.id.buy_crop_adapter_image_view);



        }
    }
}
