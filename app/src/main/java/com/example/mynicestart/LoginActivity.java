package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
    /**Crea un activity con una animacion y unos campos que son necesarios para iniciar sesión
    en la aplicacion, si no se dispone de una cuenta, puede pulsar sobre el textView "Register"
    para crear una cuenta.
    @see RegisterActivity
    @see VentanaPrincipal
    * */
public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    TextView txtRegister;
    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.anim1);
        Animation vibrate = AnimationUtils.loadAnimation(this,R.anim.anim_logo);
        imgLogo.startAnimation(vibrate);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, VentanaPrincipal.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        txtRegister=(TextView)findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}