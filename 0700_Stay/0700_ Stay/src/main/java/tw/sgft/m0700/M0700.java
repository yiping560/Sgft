package tw.sgft.m0700;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import tw.sgft.m0700.M0701;
import tw.sgft.m0700.M0702;

public class M0700<intent> extends AppCompatActivity {


    private Button b003;
    private Button b005;
    private Intent intent =new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0700);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent =this.getIntent();
        b003 = (Button)findViewById(R.id.m0700_b003);
        b005 = (Button)findViewById(R.id.m0700_b005);
        b003.setOnClickListener(B7001On);
        b005.setOnClickListener(B7001On);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"禁用返回鍵",Toast.LENGTH_SHORT ).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(item.getItemId()){
            case R.id.action_settings:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private View.OnClickListener B7001On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m0700_b003:
                    intent.putExtra("class_title", getString(R.string.m0700_b003));
                    intent.setClass(M0700.this, M0701.class);
                    break;
                case R.id.m0700_b005:
                    intent.putExtra("class_title", getString(R.string.m0700_b005));
                    intent.setClass(M0700.this, M0702.class);
                    break;

            }
            startActivity(intent);
        }
    };
//    private  View.OnClickListener B002On = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.m0700_b005:
//                    intent.putExtra("class_title", getString(R.string.m0700_b005));
//                    intent.setClass(M0700.this, M0702.class);
//                    break;
//
//            }
//            startActivity(intent);
//        }
//    };

}
