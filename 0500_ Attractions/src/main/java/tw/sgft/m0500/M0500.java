package tw.sgft.m0500;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class M0500 extends AppCompatActivity implements

        ViewSwitcher.ViewFactory,
        AdapterView.OnItemClickListener

{

    private Button btn001,btn002;
    private Intent intent=new Intent();
    private Spinner s001,s002;
    private int ss;
    private LinearLayout l1,l2;
    private MediaPlayer startmusic;
    private RelativeLayout r_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewComponent();
    }


    private void setupViewComponent() {

        Intent intent=this.getIntent();
        btn001=(Button)findViewById(R.id.m0500_b001);
        btn002= (Button)findViewById(R.id.m0500_b002);
        s001=(Spinner)findViewById(R.id.m0500_s001);
        s002=(Spinner)findViewById(R.id.m0500_s002);
        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);

        //-----------------------------片頭音樂
        startmusic = MediaPlayer.create(getApplication(),R.raw.music01);
        startmusic.start();

        //----------------開機動畫
        r_layout = (RelativeLayout) findViewById(R.id.m0500_r001);
        r_layout.setBackgroundResource(R.drawable.back04);
        r_layout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_bounce));
        r_layout.setBackgroundResource(R.drawable.back04);



        btn001.setOnClickListener(b001On);
        btn002.setOnClickListener(b001On);



    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
        int id = item.getItemId();
        switch (item.getItemId()) {

            case R.id.m0500_item01:
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);

                break;
            case R.id.m0500_item02:
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
                intent.setClass(M0500.this,M0501.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                this.finish();
                break;
            case R.id.m0500_itemback:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    private View.OnClickListener b001On=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0500_b001:
                    intent.putExtra("class_title",getString(R.string.m0000_b0501));
                    intent.setClass(M0500.this,M0501.class);

                case R.id.m0500_b002:
                    intent.putExtra("class_title",getString(R.string.m0000_b0502));
                    intent.setClass(M0500.this,M0502.class);
            }

            startActivity(intent);
        }
    };


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public View makeView() {
        return null;
    }
}