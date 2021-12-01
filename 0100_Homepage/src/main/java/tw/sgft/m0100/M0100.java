package tw.sgft.m0100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0100 extends AppCompatActivity {

    private Button b001,b002,b003,b004;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0100);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        b001=(Button)findViewById(R.id.m0100_b001);
        b002=(Button)findViewById(R.id.m0100_b002);
        b003=(Button)findViewById(R.id.m0100_b003);
        b004=(Button)findViewById(R.id.m0100_b004);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
        b004.setOnClickListener(b001on);
    }


    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0100_b001:
                    intent.putExtra("class_title",getString(R.string.m0100_v001));
                    intent.setClass(M0100.this,M0202.class);
                    break;
                case R.id.m0100_b002:
                    intent.putExtra("class_title",getString(R.string.m0100_v002));
                    intent.setClass(M0100.this,M0300.class);
                    break;
                case R.id.m0100_b003:
                    intent.putExtra("class_title",getString(R.string.m0100_b003));
                    intent.setClass(M0100.this,M0400.class);
                    break;
                case R.id.m0100_b004:
                    intent.putExtra("class_title",getString(R.string.m0100_b004));
                    intent.setClass(M0100.this,M0500.class);
                    break;
            }
            startActivity(intent);
        }
    };
}