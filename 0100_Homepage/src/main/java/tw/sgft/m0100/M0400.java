package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0400 extends AppCompatActivity {

    private Intent intent = new Intent();
    private Button b001, b002, b003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0400);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (Button) findViewById(R.id.m0400_b001);
        b002 = (Button) findViewById(R.id.m0400_b002);
        b003 = (Button) findViewById(R.id.m0400_b003);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
    }

    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m0400_b001:
                    intent.putExtra("class_title",getString(R.string.m0400_b001));
                    intent.setClass(M0400.this, M0401.class);
                    break;
                case R.id.m0400_b002:
                    intent.putExtra("class_title",getString(R.string.m0400_b002));
                    intent.setClass(M0400.this, M0402.class);
                    break;
                case R.id.m0400_b003:
                    intent.putExtra("class_title",getString(R.string.m0400_b003));
                    intent.setClass(M0400.this, M0403.class);
                    break;
            }
            startActivity(intent);
        }
    };
}