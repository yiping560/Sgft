package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M020303 extends AppCompatActivity {
          Intent intent = new Intent();

          private ListView tv001;
          private String[] list = new String[]{"小明", "阿松", "雄哥"};

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m020303);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);

                    tv001 = (ListView) findViewById(R.id.m0203_03_lv001);

                    ArrayAdapter<String> adapter =
                              new ArrayAdapter<String>(getApplicationContext(),
                                        R.layout.support_simple_spinner_dropdown_item,
                                        list);

                    tv001.setAdapter(adapter);
                    tv001.setOnItemClickListener(list_viewOn);
          }

          private AdapterView.OnItemClickListener list_viewOn = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                              String str = "邀請" + list[position] + "加入行程";
                              Toast.makeText(parent.getContext(), str, Toast.LENGTH_SHORT).show();
                    }
          };
}