package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0403 extends AppCompatActivity {

    private Button b001, b002, b003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0403);
        setupViewComponent();
    }

    private void setupViewComponent() {

        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);

        b001 = (Button) findViewById(R.id.m0403_b001);
        b002 = (Button) findViewById(R.id.m0403_b002);
        b003 = (Button) findViewById(R.id.m0403_b003);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
    }
    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}