package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0600 extends AppCompatActivity {

    private Intent intent = new Intent();
    private Button b001, b002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0600);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (Button) findViewById(R.id.m0600_b001);
        b002 = (Button) findViewById(R.id.m0600_b002);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
    }
    //-----------------------監聽intent
    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m0600_b001:
                    intent.putExtra("class_title",getString(R.string.m0600_b001));
                    intent.setClass(M0600.this,M0601.class);
                    break;
                case R.id.m0600_b002:
                    intent.putExtra("class_title",getString(R.string.m0600_b002));
                    intent.setClass(M0600.this,M0602.class);
                    break;
            }
            startActivity(intent);
        }
    };
    //--------------------------------------------------------------------------
    //------------------------返回
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu0600, menu);
        return true;
    }
//

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(),"禁用返回鍵",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.action_settings:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //-----------------------------------------------------------------------
}