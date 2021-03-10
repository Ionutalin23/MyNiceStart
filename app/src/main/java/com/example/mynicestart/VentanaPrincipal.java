package com.example.mynicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomappbar.BottomAppBar;

/**Muestra el perfil del usuario logeado. Para ver el contenido de la
 * aplicación, se deberá pulsar sobre el botón "Acceder"
 * @author Ionut Alin
 * @see MainActivity
 */
public class VentanaPrincipal extends AppCompatActivity {
    Button btn_ok;
    ImageView imgPerfil;
    BottomAppBar bottomAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);
        getSupportActionBar().hide();
        imgPerfil= findViewById(R.id.imgPerfil);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VentanaPrincipal.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
                Log.d("pulsado","Se ha pulsado el fab");
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VentanaPrincipal.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
                Log.d("pulsado","Se ha pulsado el menu");
            }


        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(VentanaPrincipal.this, "Share clicked.", Toast.LENGTH_SHORT).show();
                        Log.d("pulsado","Se ha pulsado el share");
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(VentanaPrincipal.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        Log.d("pulsado","Se ha pulsado el search");
                        break;
                }
                return false;
            }
        });
        imgPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAlerta(VentanaPrincipal.this);
            }
        });
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
    public void mostrarAlerta(VentanaPrincipal view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
                null));
        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();


    }
}