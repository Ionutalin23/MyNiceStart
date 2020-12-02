package com.example.mynicestart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**Crea un Activity con el logo de la app y arranca la aplicacion
 * @author Ionut Alin Bozintan
 * @see LoginActivity
 * @version 0.1
 */

public class SplashScreen extends Activity {
    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        imgLogo= findViewById(R.id.img2);
        Glide.with(this)
                .load(R.drawable.logo)
                .transition(DrawableTransitionOptions.withCrossFade(500))
               //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.darkblue)))
                .into(imgLogo);

//        // sets a Pretty Custom Font
//        Typeface myFont = Typeface.createFromAsset(getAssets(), "bromello.otf");
//        myTitle.setTypeface(myFont);

        //Typeface typeface = getResources().getFont(R.font.bromello);
        //myTitle.setTypeface(typeface);

        //implements and starts animation


        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(com.example.mynicestart.SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}
