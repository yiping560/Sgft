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


public class M0702 extends AppCompatActivity {


    private Button b003;
    private Intent intent =new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0702);
        setupViewComponent();
    }

    private void setupViewComponent() {
//        Intent intent =this.getIntent();
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b003 = (Button)findViewById(R.id.m0702_b003);
        b003.setOnClickListener(B7201On);

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



    private View.OnClickListener B7201On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            switch (v.getId()){
//                case R.id.m0702_b003:
//                intent.putExtra("class_title", getString(R.string.m0000_b003));
//                intent.setClass(M0702.this, M0700.class);
//                break;
//            }
            startActivity(intent);
        }
    };
}