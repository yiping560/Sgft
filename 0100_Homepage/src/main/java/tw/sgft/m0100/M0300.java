package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0300 extends AppCompatActivity {

    private Button btn001,btn002;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0300);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent=this.getIntent();
        btn001= (Button)findViewById(R.id.m0300_b001);
        btn002= (Button)findViewById(R.id.m0300_b002);

        btn001.setOnClickListener(b001On);
        btn002.setOnClickListener(b001On);

    }


    private View.OnClickListener b001On=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0300_b001:
                    intent.putExtra("class_title",getString(R.string.m0000_b0304));
                    intent.setClass(M0300.this,M0304.class);

                    break;
                case R.id.m0300_b002:
                    intent.putExtra("class_title",getString(R.string.m0000_b0302));
                    intent.setClass(M0300.this,M0302.class);
            }
            startActivity(intent);
        }
    };



}