package tw.sgft.m0200;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class M020103 extends AppCompatActivity {
          Intent intent = new Intent();

          private Spinner s001;

          private Button b001;
          private Spinner s002;
          private TextView t002;
          private TextView t003;
          private TextView t004;
          private TextView t009;
          private Button b002;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m020103);
                    setupViewcomponent();
          }

          private void setupViewcomponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);

                    s001 = (Spinner) findViewById(R.id.m020103_s001);
                    b001 = (Button) findViewById(R.id.m020103_b001);
                    s002 = (Spinner) findViewById(R.id.m020103_s002);
                    t002 = (TextView) findViewById(R.id.m020103_t002);
                    t003 = (TextView) findViewById(R.id.m020103_t002);
                    t004 = (TextView) findViewById(R.id.m020103_t004);
                    t009 = (TextView) findViewById(R.id.m020103_b002);
                    b002 = (Button) findViewById(R.id.m020103_b002);
                    b001.setOnClickListener(b001on);
                    b002.setOnClickListener(b001on);

                    ArrayAdapter<CharSequence> adapterSexList =
                              ArrayAdapter.createFromResource(
                                        this, R.array.m0201_03_a001, R.layout.support_simple_spinner_dropdown_item);

                    s001.setAdapter(adapterSexList);
                    s001.setOnItemSelectedListener(s001on);


          }

          private AdapterView.OnItemSelectedListener s001on = new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                              //sSex = parent.getSelectedItem().toString();                   //選擇的性別會放在暫存區,再看會使用者輸入幾歲

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }


          };

          private View.OnClickListener b001on = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              switch (v.getId()) {
                                        case R.id.m020103_b002:
                                                  break;


                              }

                    }
          };

}