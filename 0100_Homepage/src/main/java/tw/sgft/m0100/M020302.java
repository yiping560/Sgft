package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M020302 extends AppCompatActivity {
          Intent intent =new Intent();
          private Button b001;
          private Spinner sp001;
          private String str;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m020302);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);

                    sp001=(Spinner)findViewById(R.id.m0203_02_sp001);
                    b001=(Button)findViewById(R.id.m0203_02_b001);

                    ArrayAdapter<CharSequence> adapter =
                              ArrayAdapter.createFromResource(getApplicationContext(),
                                        R.array.m0203_02_sp001,
                                        R.layout.support_simple_spinner_dropdown_item);

                    sp001.setAdapter(adapter);
                    sp001.setOnItemSelectedListener(itemOn);

                    b001.setOnClickListener(buttonOn);
          }

          private View.OnClickListener buttonOn =new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                    }
          };

          private AdapterView.OnItemSelectedListener itemOn =new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                              String[] arr = getResources().getStringArray(R.array.m0203_02_sp001);
                              str ="通知大家"+ arr[position]+"!!";
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
          };
}