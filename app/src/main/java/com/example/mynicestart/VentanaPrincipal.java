package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class VentanaPrincipal extends AppCompatActivity {
    Button btn_ok;
    ImageView imgPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);
        getSupportActionBar().hide();
        imgPerfil= findViewById(R.id.imgPerfil);
        Glide.with(this)
                .load(R.drawable.gym)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.darkblue)))
                .circleCrop()
                .into(imgPerfil);

        btn_ok = (Button)findViewById(R.id.materialbtn);
        btn_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(VentanaPrincipal.this, MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}