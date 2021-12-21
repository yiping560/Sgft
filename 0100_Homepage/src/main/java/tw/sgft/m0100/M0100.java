package tw.sgft.m0100;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class M0100 extends AppCompatActivity {

    private Button b001,b002,b003,b004,b005,b006;
    private Intent intent=new Intent();
    private MediaPlayer startmusic;
    private RelativeLayout r_layout;
    private int ss;
    private RelativeLayout r1_laout;
    private Intent intent2,intent3;
    private BottomNavigationView bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0100);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        b001=(Button)findViewById(R.id.m0100_b001);
        b002=(Button)findViewById(R.id.m0100_b002);
        b003=(Button)findViewById(R.id.m0100_b003);
        b004=(Button)findViewById(R.id.m0100_b004);
        b005=(Button)findViewById(R.id.m0100_b005);
        b006=(Button)findViewById(R.id.m0100_b006);
        bottomBar=findViewById(R.id.bottom_menu);
        bottomBar.setOnItemSelectedListener(bottomOn);


        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0100_linear01);
        r_layout.setBackgroundResource(R.drawable.back03);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back03);

        r1_laout=(RelativeLayout)findViewById(R.id.m0100_linear01);

        // --開啟時片頭音樂-----
        startmusic = MediaPlayer.create(getApplication(), R.raw.startmusic);
        startmusic.start();

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
        b004.setOnClickListener(b001on);
        b005.setOnClickListener(b001on);
        b006.setOnClickListener(b001on);
    }

    NavigationBarView.OnItemSelectedListener bottomOn=new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.Item1:
                    intent3=new Intent(M0100.this,M0500.class);
                    intent3.putExtra("class_title",getString(R.string.m0100_b001));
                    intent3.setClass(M0100.this,M0500.class);
//                ChangePage(R.id.m0500d_layout);
//                    layout_show(1);
//                l01.setVisibility(View.VISIBLE);
//                l02.setVisibility(View.INVISIBLE);
                    break;
                case R.id.Item2:
                    intent3=new Intent(M0100.this,M0600.class);
                    intent3.putExtra("class_title",getString(R.string.m0100_b002));
                    intent3.setClass(M0100.this,M0600.class);
//                ChangePage(R.id.m0500f_layout);
//                    layout_show(2);
//                l01.setVisibility(View.INVISIBLE);
//                l02.setVisibility(View.VISIBLE);
                    break;
                case R.id.Item3:
                    intent3=new Intent(M0100.this,M0700.class);
                    intent3.putExtra("class_title",getString(R.string.m0100_b003));
                    intent3.setClass(M0100.this,M0700.class);
//                layout_show(3);
                    break;
            }
            startActivity(intent3);
            return true;
        }
    };

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (startmusic.isPlaying()) startmusic.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0100, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
        int id = item.getItemId();
        switch (id) {
            case R.id.Item1:
//                b001.setVisibility(View.VISIBLE);
//                b002.setVisibility(View.INVISIBLE);
//                b003.setVisibility(View.INVISIBLE);
//                intent2=new Intent(this,M0500.class);
//                intent2.putExtra("class_title",getString(R.string.m0100_b001));
//                intent2.setClass(M0100.this,M0500.class);
//                return true;
//                r_layout.setVisibility(View.INVISIBLE);
//                r1_laout.setVisibility(View.VISIBLE);  這行賄閃退
                ss=1;
                break;
            case R.id.Item2:
//                intent2=new Intent(this,M0600.class);
//                intent2.putExtra("class_title",getString(R.string.m0100_b002));
//                intent2.setClass(M0100.this,M0600.class);
                ss=2;
                break;
            case R.id.Item3:
//                intent2=new Intent(this,M0700.class);
//                intent2.putExtra("class_title",getString(R.string.m0100_b003));
//                intent2.setClass(M0100.this,M0700.class);
                ss=3;
                break;
            case R.id.Item4:
                intent2=new Intent(this,M0700.class);
                intent2.putExtra("class_title",getString(R.string.m0100_b004));
                intent2.setClass(M0100.this,M0400.class);
                ss=4;
                break;
            case R.id.Item5:
                intent2=new Intent(this,M0700.class);
                intent2.putExtra("class_title",getString(R.string.m0100_b005));
                intent2.setClass(M0100.this,M0300   .class);
                ss=5;
                break;
            case R.id.Item6:
                intent2=new Intent(this,M0700.class);
                intent2.putExtra("class_title",getString(R.string.m0100_b006));
                intent2.setClass(M0100.this,M0200.class);
                ss=6;
                break;
            case R.id.action_settings:
                this.finish();
                break;

        }
        startActivity(intent2);
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0100_b001:  //景點
                    intent.putExtra("class_title",getString(R.string.m0100_b001));
                    intent.setClass(M0100.this,M0500.class);
                    break;
                case R.id.m0100_b002:  //美食
                    intent.putExtra("class_title",getString(R.string.m0100_b002));
                    intent.setClass(M0100.this,M0600.class);
                    break;
                case R.id.m0100_b003:  //飯店民宿
                    intent.putExtra("class_title",getString(R.string.m0100_b003));
                    intent.setClass(M0100.this,M0700.class);
                    break;
                case R.id.m0100_b004:  //團友管理
                    intent.putExtra("class_title",getString(R.string.m0100_b004));
                    intent.setClass(M0100.this,M0400.class);
                    break;

                case R.id.m0100_b005:  //行程管理
                    intent.putExtra("class_title",getString(R.string.m0100_b002));
                    intent.setClass(M0100.this,M0300.class);
                    break;

                case R.id.m0100_b006:  //出團管理
                    intent.putExtra("class_title",getString(R.string.m0100_b002));
                    intent.setClass(M0100.this,M0200.class);
                    break;
            }
            startActivity(intent);
        }
    };
}