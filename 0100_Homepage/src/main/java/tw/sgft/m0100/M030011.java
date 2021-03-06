package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M030011 extends AppCompatActivity {

    private Button b004, b005, b001, b003;
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m030011);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b004 = (Button)findViewById(R.id.m030011_b004);
        b005 = (Button)findViewById(R.id.m030011_b005);
        b001 = (Button)findViewById(R.id.m030011_b001);
        b003 = (Button)findViewById(R.id.m030011_b003);
        b004.setOnClickListener(btnON);
        b005.setOnClickListener(btnON);
        b001.setOnClickListener(btnON);
        b003.setOnClickListener(btnON);
    }

    private View.OnClickListener btnON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.m030011_b004:
                    intent.putExtra("class_title",getString(R.string.m030011_b004));
                    intent.setClass(M030011.this, M030020.class);
                    break;
                case R.id.m030011_b005:
                    intent.putExtra("class_title",getString(R.string.m030011_b005));
                    intent.setClass(M030011.this, M030040.class);
                    break;
                case R.id.m030011_b001:
                    intent.putExtra("class_title",getString(R.string.m030011_b001));
                    intent.setClass(M030011.this, M030012.class);
                    break;
                case R.id.m030011_b003:
                    intent.putExtra("class_title",getString(R.string.m030011_b003));
                    intent.setClass(M030011.this, M030010.class);
                    break;
            }
            startActivity(intent);
        }
    };

    //********************************************************
    @Override
    public void onBackPressed() {
        //      super.onBackPressed();  //???????????????
        Toast.makeText(getApplication(),"???????????????",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // ???onCreateOptionsMenu???onOptionsItemSelected???????????????????????????
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0300_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // ???onCreateOptionsMenu???onOptionsItemSelected???????????????????????????
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(item.getItemId()){
            case R.id.action_settings:
                this.finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
//********************************************************


}