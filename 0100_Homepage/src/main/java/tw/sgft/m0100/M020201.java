package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M020201 extends AppCompatActivity {

    private Button b004, b005;
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m020201);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b004 = (Button)findViewById(R.id.m020201_b004);
        b005 = (Button)findViewById(R.id.m020201_b005);
        b004.setOnClickListener(btnON);
        b005.setOnClickListener(btnON);
    }

    private View.OnClickListener btnON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.m020201_b004:
                    intent.putExtra("class_title",getString(R.string.m020201_b004));
                    intent.setClass(M020201.this, M020202.class);
                    break;
                case R.id.m020201_b005:
                    intent.putExtra("class_title",getString(R.string.m020201_b005));
                    intent.setClass(M020201.this, M020203.class);
                    break;
            }
            startActivity(intent);
        }
    };

}