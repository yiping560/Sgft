package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity  {

    private Button b001,b002;
    private Intent intent=new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);

        b001=(Button)findViewById(R.id.m0502_b001);
        b002=(Button)findViewById(R.id.m0502_b002);

        b001.setOnClickListener(b001ON);
        b002.setOnClickListener(b001ON);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(),"禁用返回鍵",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){

            case R.id.action_settings:
                this.finish();
                break;
            case R.id.m0500_itemback:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener b001ON=new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           switch (v.getId())
           {
               case R.id.m0502_b002:
                   intent.putExtra("class_title",getString(R.string.m0000_b050301));
                   intent.setClass(M0502.this,M050301.class);
               break;
               case R.id.m0502_b001:
                   intent.putExtra("class_title",getString(R.string.m0000_b050203));
                   intent.setClass(M0502.this,M0504.class);
               break;
           }
           startActivity(intent);
       }
   };
//
//    private View.OnClickListener boo1ON=new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//                case R.id.m0300_b001:
//                    intent.putExtra("class_title",getString(R.string.0300))
//                    break;
//                case
//                    break;
//            }

        }
//    }
//}