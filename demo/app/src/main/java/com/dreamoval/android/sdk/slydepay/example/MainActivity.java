package com.dreamoval.android.sdk.slydepay.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.dreamoval.android.sdk.slydepay.PayWithSlydepay;


public class MainActivity extends AppCompatActivity {


    public static final String AMOUNT_FONT      = "fonts/Roboto-Thin.ttf";
    View payWithSlyepay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//tell the os we need a full screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buy);

        initView();
    }//bundle

    private void initView()
    {
        //hide the action bar too
        getSupportActionBar().hide();

        payWithSlyepay = findViewById(R.id.layout_pay_with_slydepay);

        ((TextView)findViewById(R.id.amount_text)).setTypeface(UiUtils.getTypeface(AMOUNT_FONT,this));
        payWithSlyepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PayWithSlydepay.Pay(MainActivity.this,true,"iwallet@dreamoval.com", "bdVI+jtRl80PG4x6NMvYOwfZTZtwfN", "testE1", 2, 0, 0, 2, "Item purchase for le secreto santa", "airty50", "Item purchase for le santa secreto");

            }
        });
    }


    //Very Important section of the code. It listens for the results after a transaction call to the slydepay application
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==1)
            {
                switch (resultCode){
                    case RESULT_OK:
//                        imageView.setImageResource(com.dreamoval.iwallet_library.R.drawable.ic_success);
                        break;
                    case RESULT_CANCELED:
//                        imageView.setImageResource(com.dreamoval.iwallet_library.R.drawable.ic_failure);
                        break;
                    case RESULT_FIRST_USER:
//                        imageView.setImageResource(com.dreamoval.iwallet_library.R.drawable.ic_failure);
                        break;
                }
        }

    }



}//main
