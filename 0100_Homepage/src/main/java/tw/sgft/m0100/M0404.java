package tw.sgft.m0100;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class M0404 extends ListActivity {

    private TextView mTxtResult;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource;
    private String[] listFromResource02;
    private TextView ans01, ans02;
    private TextView t001,t002,t003,t004,t005,t006;
    private Button b001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0400);
        setupViewcomponent();
    }

    private void setupViewcomponent() {

        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("classs_title");
        this.setTitle(mode_title);
        t001 =(TextView)findViewById(R.id.m0404_t001);
        t002 =(TextView)findViewById(R.id.m0404_t002);
        t003 =(TextView)findViewById(R.id.m0404_t003);
        t004=(TextView)findViewById(R.id.m0404_t004);
        t005 =(TextView)findViewById(R.id.m0404_t005);
        t006 =(TextView)findViewById(R.id.m0404_t006);
        b001 =(Button)findViewById(R.id.m0404_b004);
        b001.setOnClickListener(b001On);
    }

    private Intent intent =new Intent();
    private View.OnClickListener b001On =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.m0404_b004:
                    intent.putExtra("class_title",getString(R.string.m0404_b004));
                    intent.setClass(M0404.this, M0402.class);
            }
//            startActivity(intent);
        }
    };
}
