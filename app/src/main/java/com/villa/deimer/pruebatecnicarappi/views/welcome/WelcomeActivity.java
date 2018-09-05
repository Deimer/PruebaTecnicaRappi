package com.villa.deimer.pruebatecnicarappi.views.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import butterknife.BindView;
import android.widget.TextView;
import butterknife.ButterKnife;
import android.content.Context;
import android.widget.ImageView;
import android.graphics.Typeface;
import android.animation.Animator;
import com.villa.deimer.pruebatecnicarappi.R;
import android.support.v7.app.AppCompatActivity;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.Techniques;
import com.villa.deimer.pruebatecnicarappi.views.login.LoginActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Context context;

    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.lbl_title)
    TextView lbl_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        setupTimeAnimation();
        setupFontLabel();
    }

    private void setupFontLabel() {
        Typeface typefaceInidiana = Typeface.createFromAsset(
                getAssets(), "fonts/indiana.ttf");
        lbl_title.setTypeface(typefaceInidiana);
    }

    private void setupTimeAnimation() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animateLogo();
            }
        }, 1000);
    }

    private void animateLogo() {
        YoYo.with(Techniques.Pulse)
                .duration(900)
                .repeat(0)
                .onEnd(new animatorCallback())
                .playOn(imgLogo);
    }

    private class animatorCallback implements YoYo.AnimatorCallback {
        @Override
        public void call(Animator animator) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(context, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }, 1300);
        }
    }

}
