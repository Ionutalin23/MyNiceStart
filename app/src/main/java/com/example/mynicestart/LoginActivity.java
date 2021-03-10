package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        ImageView mycontext =findViewById(R.id.imgLogo);
        registerForContextMenu(mycontext);

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
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_context, menu);
        }
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                    item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.edit:
                    Toast toast = Toast.makeText(this,"going CONTEXT edit",
                            Toast.LENGTH_LONG );
                    toast.show();
                    return true;
                case R.id.remove:
                    Toast toast2 = Toast.makeText(this,"going CONTEXT remove",
                            Toast.LENGTH_LONG );
                    toast2.show();
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
        }
}