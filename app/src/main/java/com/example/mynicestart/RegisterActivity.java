package com.example.mynicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**Permite crear un nuevo usuario para iniciar sesion en la aplicacion
 * @author Ionut Alin
 * @see LoginActivity
 */
public class RegisterActivity extends AppCompatActivity {
    TextView txtLogin;
    ImageView imgLogo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        imgLogo2 = (ImageView) findViewById(R.id.imgLogo2);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.anim1);
        Animation vibrate = AnimationUtils.loadAnimation(this,R.anim.anim_logo);
        imgLogo2.startAnimation(vibrate);

        txtLogin=(TextView)findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}