package tw.sgft.m0300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0302 extends AppCompatActivity {

    private Button b001,b002;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0302);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);

        b001=(Button)findViewById(R.id.m0300_b001);
        b002=(Button)findViewById(R.id.m0300_b002);

//        b001.setOnClickListener(b001ON);
    }

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