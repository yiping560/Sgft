package tw.sgft.m0400;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class M0400 extends AppCompatActivity {

    private Button b001;
    private Button b002;

    private Button b003,b004;
    private TextView mTxtResult;
    private EditText e001;
    private EditText e002;
    private ImageView img;
    private int ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0400);
        setupViewcomponent();


    }

    private void setupViewcomponent() {
        b001 =(Button)findViewById(R.id.m0400_b001);
        b002 =(Button)findViewById(R.id.m0400_b002);
        e001 =(EditText)findViewById(R.id.m0400_e001);
        e002 =(EditText)findViewById(R.id.m0400_e002);
        mTxtResult = (TextView) findViewById(R.id.m0400_ans);
        img = (ImageView) findViewById(R.id.m0400_b004);
//        b003 =(Button)findViewById(R.id.aleart_b001);
//        b004 =(Button)findViewById(R.id.aleart_b002);
        b001.setOnClickListener(b001On);
        b002.setOnClickListener(b002On);
        img.setOnClickListener(b003On);
 //顯示對話框
        AlertDialog.Builder builder = new AlertDialog.Builder(M0400.this);

        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
    }
    private View.OnClickListener b003On =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.m0400_b004:
                    intent.putExtra("class_title",getString(R.string.m0400_b004));
                    intent.setClass(M0400.this,M0402.class);
                    break;
            }
            startActivity(intent);

        }
    };
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "進用返回建", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }

    private Intent intent =new Intent();
    private Dialog dialog;
    private View.OnClickListener b001On =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0400_b001:
                    intent.putExtra("class_title",getString(R.string.m0400_b001));
                    intent.setClass(M0400.this,M0401.class);
                    break;

   //dialog1是我上面建立xml的檔名


            }
            startActivity(intent);
        }
//        public void cancel(View v){
//            Dialog dialog = null;
//            dialog.cancel();
//        }
//        public void login(View v){
//            Toast.makeText(getApplicationContext(), getText(R.string.m0400_t001), Toast.LENGTH_LONG).show();
//            Dialog dialog = null;
//            dialog.dismiss();
//        }
    };
    private Dialog mLoginDlg;
    private View.OnClickListener b002On =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mTxtResult.setText("");
            mLoginDlg = new Dialog(M0400.this);
            mLoginDlg.setCancelable(false);
            mLoginDlg.setContentView(R.layout.aleartdialog);
            Button loginBtnOK = (Button) mLoginDlg.findViewById(R.id.aleart_b002);
            Button loginBtnCancel = (Button) mLoginDlg.findViewById(R.id.aleart_b001);
            loginBtnOK.setOnClickListener(loginDlgBtnOKOnClkLis);
            loginBtnCancel.setOnClickListener(loginDlgBtnCancelOnClkLis);
            mLoginDlg.show();
        }
        private Button.OnClickListener loginDlgBtnOKOnClkLis = new Button.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.m0400_b002:
                        EditText edtUserName = (EditText) mLoginDlg.findViewById(R.id.m0400_e001);
                        EditText edtPassword = (EditText) mLoginDlg.findViewById(R.id.m0400_e002);
                        mTxtResult.setText(getString(R.string.m0400_ans) +
                                getString(R.string.m0400_e001) +
                                edtUserName.getText().toString() +" " +
                                getString(R.string.m0400_e002) +
                                edtPassword.getText().toString());
                        Toast.makeText(getApplicationContext(), getText(R.string.m0400_t001), Toast.LENGTH_LONG).show();
                        intent.putExtra("class_title",getString(R.string.m0400_b002));
                        intent.setClass(M0400.this,M0402.class);
                        break;
                }

 //

                mLoginDlg.cancel();

            }
        };
        private Button.OnClickListener loginDlgBtnCancelOnClkLis = new Button.OnClickListener() {
            public void onClick(View v) {

                //                mTxtResult.setText(getString(R.string.) + getString(R.string.m0905_btnCancel));
                mLoginDlg.cancel();
            }
        };
    };
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0400, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.item01:

                ss = 1;
                break;
            case R.id.item02:
                ss = 2;
                break;

            case R.id.item03:

                ss = 3;
                super.onBackPressed();
                break;

            case R.id.item04:
                ss = 4;
                break;
//            case R.id.item05:
//                ss = 5;
//                break;
        }

        return super.onOptionsItemSelected(item);
    }


    }

