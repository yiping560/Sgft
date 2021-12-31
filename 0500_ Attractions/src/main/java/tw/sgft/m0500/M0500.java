package tw.sgft.m0500;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0500 extends AppCompatActivity implements

        ViewSwitcher.ViewFactory,
        AdapterView.OnItemClickListener

{

    private Button btn001,btn002;
    private Intent intent=new Intent();
    private Spinner s001,s002;
    private int ss;
    private LinearLayout l1,l2,l3;
    private MediaPlayer startmusic;
    private RelativeLayout r_layout;
    private int currentPage;
    private BottomNavigationView bottomBar;
    private ListView lv001;
    private TextView t001;
    private String[] t001a,t001b,t001c;
    private ArrayList<Map<String,Object>> mList;
    private String topname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewComponent();
    }


    private void setupViewComponent() {
        currentPage = R.id.l2;
        ChangePage(R.id.l1);

//        btn001=(Button)findViewById(R.id.m0500_b001);
        btn002= (Button)findViewById(R.id.m0500_b002);
        s001=(Spinner)findViewById(R.id.m0500_s001);
        s002=(Spinner)findViewById(R.id.m0500_s002);
        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);

        //-----------------------------片頭音樂
        startmusic = MediaPlayer.create(getApplication(),R.raw.music01);
        startmusic.start();

        //----------------開機動畫
        r_layout = (RelativeLayout) findViewById(R.id.m0500_r001);
        r_layout.setBackgroundResource(R.drawable.back04);
        r_layout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_bounce));
        r_layout.setBackgroundResource(R.drawable.back04);

        bottomBar = findViewById(R.id.bottom_menu);
        bottomBar.setOnItemSelectedListener(bottomON);

//        btn001.setOnClickListener(b001On);
        btn002.setOnClickListener(b001On);

        lv001 = findViewById(R.id.m0501_l2_lv001);
//-------------------------------------------------------------------------------------------------------l2
        t001=(TextView)findViewById(R.id.m0501_t001);
        t001a=getResources().getStringArray(R.array.Attraction);
        t001b=getResources().getStringArray(R.array.Attrainformation);
        t001c=getResources().getStringArray(R.array.Attrainphone);

        mList=new ArrayList<>();

        for (int i =0;i<t001a.length;i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idname = "imag" + String.format("%02d", i + 1);
            int resId = getResources().getIdentifier(idname, "drawable", getPackageName());

            item.put("imgView", resId);
            item.put("textView", t001a[i]);
            item.put("textView1", t001b[i]);
            item.put("textView2", t001c[i]);
            mList.add(item);
            //----------------------------------------spinner1--------
            ArrayAdapter<CharSequence> spls = ArrayAdapter.createFromResource(
                    this,
                    R.array.county,
                    R.layout.spinner_item);

            s001.setAdapter(spls);
            //----------------------------------------spinner2-----------
            ArrayAdapter<CharSequence> spls2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.area,
                    R.layout.spinner_item);
            s002.setAdapter(spls2);

        }
        s001.setOnItemSelectedListener(s001ON);


            SimpleAdapter adapter=new SimpleAdapter(
                    this,
                    mList,
                    R.layout.m0500_list_item,
                    new String[]{"imgView","textView","textView2","textView3"},
                    new int[]{R.id.imageView,R.id.m0501_t001a,R.id.m0501_t001b});

            //-------------------------------------------------------------------------
            lv001.setAdapter(adapter);



    }


    AdapterView.OnItemSelectedListener s001ON=new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==0)
                                return;


                            topname=String.format("m%02d",position);
                            int resId = getResources().getIdentifier(topname, "array", getPackageName());
                            ArrayAdapter<CharSequence> spls2 = ArrayAdapter.createFromResource(
                                    getApplicationContext(),
                                    resId,
                                    R.layout.spinner_item);
                            s002.setAdapter(spls2);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    };
    private void ChangePage(int resID) {
        findViewById(currentPage).setVisibility(View.INVISIBLE);
        findViewById(resID).setVisibility(View.VISIBLE);
        currentPage=resID;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

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
    NavigationBarView.OnItemSelectedListener bottomON=new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.m0500_item01:
                    ChangePage(R.id.l1);
                    break;
                case R.id.m0500_item02:
                    ChangePage(R.id.l2);
//                    intent.setClass(M0500.this,M0501.class);
//                    startActivity(intent);
                    break;
                case R.id.m0500_item03:
                  intent.setClass(M0500.this, M0505_map.class);
                  startActivity(intent);
                    break;
            }
            return true;
        }
    };



    private View.OnClickListener b001On=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
//                case R.id.m0500_b001:
//                    intent.putExtra("class_title",getString(R.string.m0000_b0501));
//                    intent.setClass(M0500.this,M0501.class);

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
