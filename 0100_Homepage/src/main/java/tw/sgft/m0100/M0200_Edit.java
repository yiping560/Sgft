package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class M0200_Edit extends AppCompatActivity {

          private Button applyButton, cancelButton;
          private Intent intent;
          private EditText e001;

          //？？？
          private Travel data;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
//                    setContentView(R.layout.m0200_edit_team_data);

                    setupViewComponent();
          }

          private void setupViewComponent() {
                    intent = new Intent();

                    data = TestDataRepository.getInstance().getData();

//                    e001 = (EditText) findViewById(R.id.m0200_edit_e001);
//                    applyButton = (Button) findViewById(R.id.m0200_edit_apply_button);
//                    cancelButton = (Button) findViewById(R.id.m0200_edit_cancel_button);

                    applyButton.setOnClickListener(buttonOn);
                    cancelButton.setOnClickListener(buttonOn);
          }

          private View.OnClickListener buttonOn = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                              switch (v.getId()) {
//                                        case R.id.m0200_edit_apply_button:
//                                                  if (e001.getText().toString().length() <= 0) {
//                                                            Toast.makeText(getApplicationContext(), R.string.m0200_edit_e001_hint, Toast.LENGTH_SHORT).show();
//                                                  } else {
//                                                            createNewData();
//                                                  }
//                                                  break;
//                                        case R.id.m0200_edit_cancel_button:
////                                                  intent.setClass(M0200_Edit.this, M0200.class);
////                                                  startActivity(intent);
//                                                  finish();
//                                                  break;
//                              }
                    }
          };

          private void createNewData() {

//                    TestTeamData ttData = new TestTeamData(e001.getText().toString());
//                    data.HappySet.add(ttData);
                    finish();
          }


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