package tw.sgft.m0200;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0200 extends AppCompatActivity {

          private Button b001, b002, b003;

          private Intent intent = new Intent();

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0200);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    b001 = (Button) findViewById(R.id.m0200_b001);
                    b002 = (Button) findViewById(R.id.m0200_b002);
                    b003 = (Button) findViewById(R.id.m0201_b003);

                    b001.setOnClickListener(buttonOn);
                    b002.setOnClickListener(buttonOn);
                    b003.setOnClickListener(buttonOn);
          }

          private View.OnClickListener buttonOn = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              switch (v.getId()) {
                                        case R.id.m0200_b001:
                                                  intent.putExtra("C_name", getString(R.string.m0201));
                                                  intent.setClass(M0200.this, M0201.class);
                                                  break;
                                        case R.id.m0200_b002:
                                                  intent.putExtra("C_name", getString(R.string.m0202));
                                                  intent.setClass(M0200.this, M0202.class);
                                                  break;
                                        case R.id.m0201_b003:
                                                  intent.putExtra("C_name", getString(R.string.m0203));
                                                  intent.setClass(M0200.this, M0203.class);
                                                  break;
                              }

                              startActivity(intent);
                    }
          };
}