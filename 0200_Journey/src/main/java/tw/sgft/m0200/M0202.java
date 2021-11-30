package tw.sgft.m0200;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class M0202 extends AppCompatActivity {
          Intent intent = new Intent();

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0202);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);
          }
}