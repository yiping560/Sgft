package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0403 extends AppCompatActivity {

    private Intent intent = new Intent();
    private Button b002;
    private int ss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0403);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b002=(Button)findViewById(R.id.m0403_b002);
b002.setOnClickListener(b001On);
    }
private View.OnClickListener b001On=new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.m0403_b002:
                intent.putExtra("class_title",getString(R.string.m0403_b002));
                intent.setClass(M0403.this, M0402.class);
                break;
        }
        startActivity(intent);
    }
};
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0400, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.item01:

                ss = 1;
                break;
            case R.id.item02:
                ss = 2;
                break;

            case R.id.item03:

                ss = 3;
                super.onBackPressed();
                break;

            case R.id.item04:
                ss = 4;
                break;
//            case R.id.item05:
//                ss = 5;
//                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "進用返回建", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }

}
