package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b003 = (Button)findViewById(R.id.m0700_b003);
        b005 = (Button)findViewById(R.id.m0700_b005);
        b003.setOnClickListener(B7001On);
        b005.setOnClickListener(B7001On);

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
