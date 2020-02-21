package com.smartex.buyit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "home";

    private Button login,singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");
        initView();
        login.setOnClickListener(this);
    }

    private void initView() {
        login = (Button) findViewById(R.id.login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login :
                Intent intent = new Intent(this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userName","Taksh");
                bundle.putString("emailId","takshtax@gmail.com");
                intent.putExtra("userInfo",bundle);
                startActivity(intent);
                break;
        }

    }
}
