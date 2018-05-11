package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.payUMoney.sdk.PayUmoneySdkInitilizer;
import com.payUMoney.sdk.SdkConstants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.payUMoney.sdk.SdkSession.TAG;

public class PayFarmer extends AppCompatActivity {
    GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_farmer);
        //payButton.setOnClickListener(new View.OnClickListener() {
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        float ammount = 10;
        PayUmoneySdkInitilizer.PaymentParam.Builder builder = new
                PayUmoneySdkInitilizer.PaymentParam.Builder()
                .setMerchantId("5771953")
                .setKey("uKDkGTok")
                .setIsDebug(false) // for Live mode - setIsDebug(false)
                .setAmount(ammount)
                .setTnxId("0nf7" + System.currentTimeMillis())
                .setPhone("9654772898")
                .setProductName("lol")
                .setFirstName("shivam")
                .setEmail("shivam.aggarwal1597@gmail.com")
                .setsUrl("https://www.PayUmoney.com/mobileapp/PayUmoney/success.php")
                .setfUrl("https://www.PayUmoney.com/mobileapp/PayUmoney/failure.php")
                .setUdf1("")
                .setUdf2("")
                .setUdf3("")
                .setUdf4("")
                .setUdf5("");

        String hashSequence =
                "uKDkGTok" + "|" + "" + "|" + ammount + "|" + "lol" + "|" + "shivam" + "|" + "shivam.aggarwal1597@gmail.com" + "||||||" + "uEUD0LtoG2";
        String serverCalculatedHash = hashCal("SHA-512", hashSequence);
        PayUmoneySdkInitilizer.PaymentParam pay = builder.build();
        pay.setMerchantHash(serverCalculatedHash);

        PayUmoneySdkInitilizer.startPaymentActivityForResult(PayFarmer.this, pay);}


//        PayUmoneySdkInitilizer.PaymentParam paymentParam = builder.build();


    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        if (requestCode ==
                PayUmoneySdkInitilizer.PAYU_SDK_PAYMENT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //Log.i(, "Success - Payment ID : " +
                //      data.getStringExtra(SdkConstants.PAYMENT_ID));
                String paymentId =
                        data.getStringExtra(SdkConstants.PAYMENT_ID);
            } else if (resultCode == RESULT_CANCELED) {
                Log.i(TAG, "cancelled");
            } else if (resultCode == PayUmoneySdkInitilizer.RESULT_FAILED) {
                Log.i(TAG, "failure");
            } else if (resultCode == PayUmoneySdkInitilizer.RESULT_BACK) {
                Log.i(TAG, "User returned without login");
            }
        }
    }

    public static String hashCal(String type, String str) {
        byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for
                    (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if
                        (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return hexString.toString();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}






