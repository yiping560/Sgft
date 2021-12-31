package tw.sgft.m0400;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class M0402 extends AppCompatActivity implements Animation.AnimationListener {


    private ImageButton b001;

    private Button b003;
    private Button b004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0402);
        setupViewcomponent();


    }

    private void setupViewcomponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b001=(ImageButton)findViewById(R.id.m0402_b001);
        b003 =(Button)findViewById(R.id.m0402_b002);
        b004 =(Button)findViewById(R.id.m0404_b004);
        b001.setOnClickListener(b001On);
        b003.setOnClickListener(b001On);
        b003.setOnClickListener(b002On);

    }

    private Intent intent=new Intent();
    private View.OnClickListener b001On=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.m0402_b002:
                    intent.putExtra("class_title",getString(R.string.m0402_b002));
                    intent.setClass(M0402.this,MainActivity.class);

                case R.id.m0402_b001:
                    intent.putExtra("classs_title",getString(R.string.m0402_b001));
                    intent.setClass(M0402.this,M0404.class);
            }

            startActivity(intent);
        }
    };
    private View.OnClickListener b002On=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.m0402_b004:
                    intent.putExtra("class_title",getString(R.string.m0402_b004));
                    intent.setClass(M0402.this,M0404.class);

            }

            startActivity(intent);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500_itemmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
        int id = item.getItemId();
        switch (item.getItemId()) {

//            case R.id.m0500_item01:
//
////                l1.setVisibility(View.VISIBLE);
////                l2.setVisibility(View.INVISIBLE);
//
//                break;
//            case R.id.m0500_item02:
//                l1.setVisibility(View.INVISIBLE);
//                l2.setVisibility(View.VISIBLE);
//                intent.setClass(M0500.this,M0501.class);
//                startActivity(intent);
//                break;
            case R.id.m0500_finish:
                this.finish();
                break;
            case R.id.m0500_itemback:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}