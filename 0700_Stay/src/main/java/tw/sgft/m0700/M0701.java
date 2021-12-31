package tw.sgft.m0700;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class M0701 extends AppCompatActivity {


    private TextView mTxtCity;
    private TextView mTxtArea;
    private Button mbtnDo;
    private Spinner mSpi1City;
    private Spinner mSpi2City;
    private String topName,bottomName;
    private ArrayAdapter<CharSequence> spls3;
    private ArrayAdapter<CharSequence> spls2;
    private ArrayAdapter<CharSequence> spls1;
    private ListView lv001;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0701);
        setupViewComponent();


    }

    private void setupViewComponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        mTxtCity = (TextView) findViewById(R.id.m0701_t002);
        mTxtArea = (TextView) findViewById(R.id.m0701_t003);
        mSpi1City = (Spinner) findViewById(R.id.m0701_sp001);
        mSpi2City = (Spinner) findViewById(R.id.m0701_sp002);
        mbtnDo = (Button) findViewById(R.id.m0701_b001);

        lv001=(ListView)findViewById(R.id.m0701_lv001);

        mSpi1City.setOnItemSelectedListener(mSpi1CityOn);
        mSpi2City.setOnItemSelectedListener(mSpi2CityOn);

        spls1 = ArrayAdapter.createFromResource(
                getApplicationContext(),
                R.array.city_list,
                R.layout.support_simple_spinner_dropdown_item);
        mSpi1City.setAdapter(spls1);


        mbtnDo.setOnClickListener(btnDoOnClick);
    }


    View.OnClickListener btnDoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0701_b001:
                    intent.setClass(M0701.this,M0702.class);
                    startActivity(intent);
                    break;

            }


        }
    };



    private AdapterView.OnItemSelectedListener mSpi1CityOn =new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0){return;}

            topName=String.format("m%1$02d", position);
            int srcID = getResources().getIdentifier(topName, "array", getPackageName());

            spls2 = ArrayAdapter.createFromResource(
                    getApplicationContext(),
                    srcID,
                    R.layout.support_simple_spinner_dropdown_item);
            mSpi2City.setAdapter(spls2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };



    private AdapterView.OnItemSelectedListener mSpi2CityOn =new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0)
                return;

            bottomName =topName+String.format("%1$02d", position);

            //Log.d("555",bottomName);
            int srcID = getResources().getIdentifier(bottomName, "array", getPackageName());
//            data = getResources().getStringArray(srcID);

            spls3  = ArrayAdapter.createFromResource(
                    getApplicationContext(),
                    srcID,
                    R.layout.support_simple_spinner_dropdown_item);
            lv001.setAdapter(spls3);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    @Override
    public void onBackPressed() {
        //  ----------- 下方禁用返回-----------------------
        //        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //------------------------返回-------------------
        // Inflate the menu; this adds items to the action bar if it is present.
        // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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

    NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.m0701_item01:
                    Toast.makeText(getApplicationContext(), "555", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };

}
