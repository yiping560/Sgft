package tw.sgft.m0100;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0201 extends AppCompatActivity {
          private Spinner sp001, sp002;
          private Button b001;
          private String target, mesage;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0201);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    sp001 = (Spinner) findViewById(R.id.m0201_team_manager_sp001);
                    sp002 = (Spinner) findViewById(R.id.m0201_team_manager_sp002);

                    b001 = (Button) findViewById(R.id.m0201_team_manager_b001);

                    sp001.setOnItemSelectedListener(toTarget);
                    sp002.setOnItemSelectedListener(getMesage);

                    b001.setOnClickListener(buttonOn);
          }

          private AdapterView.OnItemSelectedListener toTarget = new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                              String[] arr = getResources().getStringArray(R.array.m0201_select_mesage_to);
                              target = arr[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
          };

          private AdapterView.OnItemSelectedListener getMesage = new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                              String[] arr = getResources().getStringArray(R.array.m0201_select_mesage_info);
                              mesage = arr[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
          };

          private View.OnClickListener buttonOn = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              Toast.makeText(getApplicationContext(), "對"+target+"說：" + mesage, Toast.LENGTH_SHORT).show();
                    }
          };

          @Override
          public boolean onCreateOptionsMenu(Menu menu) {
//                    return super.onCreateOptionsMenu(menu);
                    getMenuInflater().inflate(R.menu.m0200_menu, menu);
                    return true;
          }

          @Override
          public boolean onOptionsItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                              case R.id.action_settings:
                                        this.finish();
                                        break;
                    }

                    return super.onOptionsItemSelected(item);
          }

}