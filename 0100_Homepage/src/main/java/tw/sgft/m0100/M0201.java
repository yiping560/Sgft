package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0201 extends AppCompatActivity {
          Intent intent = new Intent();
          private Button b001, b002,b003;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0201);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);

                    b001 = (Button) findViewById(R.id.m0201_b001);
                    b002 = (Button) findViewById(R.id.m0201_b002);
                    b003 = (Button) findViewById(R.id.m0201_b003);

                    b001.setOnClickListener(buttonOn);
                    b002.setOnClickListener(buttonOn);
                    b003.setOnClickListener(buttonOn);
          }

          private View.OnClickListener buttonOn = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              switch (v.getId()) {
                                        case R.id.m0201_b001:
                                                  intent.putExtra("C_name",getString(R.string.m0201_01) );
                                                  intent.setClass(M0201.this, M020101.class);
                                                  break;
                                        case R.id.m0201_b002:
                                                  intent.putExtra("C_name",getString(R.string.m0201_02) );
                                                  intent.setClass(M0201.this, M020102.class);
                                                  break;
                                        case R.id.m0201_b003:
                                                  intent.putExtra("C_name",getString(R.string.m0201_03) );
                                                  intent.setClass(M0201.this, M020103.class);
                                                  break;
                              }

                              startActivity(intent);
                    }
          };
}