package tw.sgft.m0200;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M020301 extends AppCompatActivity {
          Intent intent =new Intent();
          private Button b001;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m020301);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = this.getIntent();
                    String str = intent.getStringExtra("C_name");
                    this.setTitle(str);

                    b001=(Button)findViewById(R.id.m0203_01_b001);

                    b001.setOnClickListener(buttonOn);
          }

          private View.OnClickListener buttonOn =new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              Toast.makeText(getApplicationContext(),"正在分享照片給所有團友",Toast.LENGTH_SHORT).show();
                    }
          };
}