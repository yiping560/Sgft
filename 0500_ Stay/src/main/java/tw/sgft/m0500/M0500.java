package tw.sgft.m0500;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0500 extends AppCompatActivity {


    private Button b003;
    private Intent intent =new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent =this.getIntent();
        b003 = (Button)findViewById(R.id.m0500_b003);
        b003.setOnClickListener(B001On);

    }


    private View.OnClickListener B001On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0500_b003:
                intent.putExtra("class_title", getString(R.string.m0000_b003));
                intent.setClass(M0500.this,M0501.class);
                break;
            }
            startActivity(intent);
        }
    };
}