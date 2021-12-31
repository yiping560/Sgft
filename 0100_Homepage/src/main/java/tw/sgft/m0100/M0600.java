package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.navigation.NavigationBarView;


public class M0600 extends AppCompatActivity implements OnMapReadyCallback {

    private Intent intent = new Intent();
    private TextView txt01;
    private NavigationBarView bottomBar;
    private Spinner sp001, sp002;
    private ArrayAdapter<CharSequence> spls1, spls2;
    private ListView lv001, collect001;
    private String[] data;
    private int[] imgRes;
    private String topName = "";
    private String bottomName = "";
    private ConstraintLayout l1;
    private LinearLayout l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0600);
        setupViewComponent();
    }
    private void setupViewComponent() {
        l1 = (ConstraintLayout) findViewById(R.id.L1);
        l2 = (LinearLayout) findViewById(R.id.L2);
        lv001 = (ListView) findViewById(R.id.restaurant);
        sp001 = (Spinner) findViewById(R.id.m0600_sp001);
        sp002 = (Spinner) findViewById(R.id.m0600_sp002);

        collect001 = (ListView) findViewById(R.id.collect0600);


        //------------------------------------
        ArrayAdapter<CharSequence> spls = ArrayAdapter.createFromResource(
                this,
                R.array.descr, //選擇"縣市"
                R.layout.spinner_item);
        sp001.setAdapter(spls);
        //-------------------------------------
        bottomBar = (NavigationBarView) findViewById(R.id.bottom_menu);
        bottomBar.setOnItemSelectedListener(bottomOn);
        // 設定 button 按鍵的事件
        sp001.setOnItemSelectedListener(sp001On);
        sp002.setOnItemSelectedListener(sp002On);
    }
    void getImgRes(String[] dataRes) {
        imgRes = new int[dataRes.length];
        for (int i = 0; i < dataRes.length; i++) {
            String idNme = "a" + String.format("%02d", i + 1);
            int resID = getResources().getIdentifier(idNme, "drawable", getPackageName());
            imgRes[i] = resID;
        }
    }
    //--------------------------------------------------
    private Button.OnClickListener btn01OnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };
    //-----------------------監聽sp001
    AdapterView.OnItemSelectedListener sp001On = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            topName = String.format("m%1$02d", position);
            int srcID = getResources().getIdentifier(topName, "array", getPackageName());
            spls2 = ArrayAdapter.createFromResource(
                    getApplicationContext(),
                    srcID,
                    R.layout.spinner_item);
            sp002.setAdapter(spls2);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    //-----------------------監聽sp002
    AdapterView.OnItemSelectedListener sp002On = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                lv001.setVisibility(View.INVISIBLE);
                return;
            }
            lv001.setVisibility(View.VISIBLE);
            bottomName = topName + String.format("%1$02d", position);
            //Log.d("555",bottomName);
            int srcID = getResources().getIdentifier(bottomName, "array", getPackageName());
            data = getResources().getStringArray(srcID);
            getImgRes(data);
            ListItem spls3 = new ListItem(getApplicationContext(), data, R.layout.list_item, imgRes);
            lv001.setAdapter(spls3);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    //------------------------返回
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.back0600, menu);
        return true;
    }
//

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        //Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

    NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.m0600_item01:
                    l1.setVisibility(View.INVISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    //Toast.makeText(getApplicationContext(), "555", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item02:
                    intent.setClass(M0600.this, M0600_Map.class);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), "555", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_settings:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
    }
}