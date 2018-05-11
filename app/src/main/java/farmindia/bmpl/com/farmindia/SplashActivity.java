package farmindia.bmpl.com.farmindia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;
    Handler handler;
    int progressBarTimer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.img) ;
        progressBar=(ProgressBar)findViewById(R.id.progress);
        imageView.setBackgroundResource(R.drawable.farmindia);
      //  Toast.makeText(SplashActivity.this,"this is splash activity",Toast.LENGTH_LONG).show();
        handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressBarTimer<100){
                    progressBarTimer+=5;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressBarTimer);
                        }
                    });
                    try{
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(progressBarTimer==100){

                    //login integration by prakshal
                    Intent intent=new Intent(SplashActivity.this,RegistrationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        }).start();

    }
}
