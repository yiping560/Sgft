package tw.sgft.m0100;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class M0400 extends AppCompatActivity implements Animation.AnimationListener{

    private Button b001;
    private Button b002;

    private Button b003,b004;
    private TextView mTxtResult;
    private EditText e001;
    private EditText e002;
    private ImageView img;
    private int ss;
    private int currentPage;
    private int resID;
    private LinearLayout l1;
    private LinearLayout l2;
    private BottomNavigationView bottomBar;
    private MediaPlayer startmusic;
    private RelativeLayout r_layout;
    private RelativeLayout l3;
    private Button b005;
    private Button sb002;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0400);
        setupViewcomponent();


    }

    private void setupViewcomponent() {
//        b001 =(Button)findViewById(R.id.m0400_b001);
        currentPage = R.id.l2;
        ChangePage(R.id.l1);
//        currentPage = R.id.l3;
        b002 =(Button)findViewById(R.id.m0400_b002);
        e001 =(EditText)findViewById(R.id.m0400_e001);
        e002 =(EditText)findViewById(R.id.m0400_e002);
        mTxtResult = (TextView) findViewById(R.id.m0400_ans);
        img = (ImageButton) findViewById(R.id.m0400_b004);

        sb002 =(Button)findViewById(R.id.m0403_b002);
        l1 = (LinearLayout)findViewById(R.id.l1);
        l2 = (LinearLayout)findViewById(R.id.l2);
        l3 = (RelativeLayout)findViewById(R.id.l3);
        b003 =(Button)findViewById(R.id.aleart_b001);
//        b004 =(Button)findViewById(R.id.aleart_b002);
        sb002.setOnClickListener(b001On);
        b002.setOnClickListener(b002On);
//        b004.setOnClickListener(b003On);
//        img.setOnClickListener(b003On);
 //顯示對話框
        AlertDialog.Builder builder = new AlertDialog.Builder(M0400.this);
        img.setOnClickListener(imgOn);
        bottomBar = findViewById(R.id.bottom_menu); //底部按鈕
        bottomBar.setOnItemSelectedListener(bottomOn);
        startmusic=MediaPlayer.create(getApplication(),R.raw.abc);
        startmusic.start();

        r_layout = (RelativeLayout) findViewById(R.id.m0400_b003);
        r_layout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_trans_bounce));
    }

    private void ChangePage(int resID) {
        findViewById(currentPage).setVisibility(View.INVISIBLE);
        findViewById(resID).setVisibility(View.VISIBLE);
        currentPage=resID;
    }

    NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.item01:
                    ChangePage(R.id.l1);

                    break;
                case R.id.item02:
                    ChangePage(R.id.l2);
//                layout_show(2);
//                l01.setVisibility(View.INVISIBLE);
//                l02.setVisibility(View.VISIBLE);
                    break;
                case R.id.item03:
//                layout_show(3);
                    ChangePage(R.id.l3);
            }
//            startActivity(intent);
            return true;
        }
    };
    private View.OnClickListener b001On =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0403_b002:
                    intent.putExtra("class_title",getString(R.string.m0403_b002));
                    intent.setClass(M0400.this, MainActivity.class);
            }
        startActivity(intent);
        }
    };


    private View.OnClickListener imgOn=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
//                case R.id.m0500_b001:
//                    intent.putExtra("class_title",getString(R.string.m0000_b0501));
//                    intent.setClass(M0500.this,M0501.class);

                case R.id.m0400_b004:
                    intent.putExtra("class_title",getString(R.string.m0400_b004));
                    intent.setClass(M0400.this, M0402.class);
            }

            startActivity(intent);
        }
    };
//    private View.OnClickListener b003On=new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
////                case R.id.m0500_b001:
////                    intent.putExtra("class_title",getString(R.string.m0000_b0501));
////                    intent.setClass(M0500.this,M0501.class);
//
//                case R.id.aleart_b002:
//                    intent.putExtra("class_title",getString(R.string.aleart_b002));
//                    intent.setClass(M0400.this,M0402.class);
//            }
//
//            startActivity(intent);
//        }
//    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500_itemmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
        int id = item.getItemId();
        switch (item.getItemId()) {

            case R.id.m0500_finish:
                this.finish();
                break;
            case R.id.m0500_itemback:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "進用返回建", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }
    private Dialog dialog;
//    private Intent intent =new Intent();

//    private View.OnClickListener b001On =new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
////                case R.id.m0400_b001:
////                    intent.putExtra("class_title",getString(R.string.m0400_b001));
////                    intent.setClass(M0400.this,M0401.class);
////                    break;
//
//   //dialog1是我上面建立xml的檔名
//
//
//            }
//            startActivity(intent);
//        }
//        public void cancel(View v){
//            Dialog dialog = null;
//            dialog.cancel();
////        }
////        public void login(View v){
////            Toast.makeText(getApplicationContext(), getText(R.string.m0400_t001), Toast.LENGTH_LONG).show();
////            Dialog dialog = null;
////            dialog.dismiss();
////        }
//    };
    private Dialog mLoginDlg;
    private Intent intent =new Intent();
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
//            @SuppressLint("SetTextI18n")
            @SuppressLint({"SetTextI18n"})
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
                        intent.putExtra("class_title",getString(R.string.aleart_b002));
                        intent.setClass(M0400.this,M0402.class);
                        break;
                }
                mLoginDlg.cancel();
                startActivity(intent);
            }
        };
        private Button.OnClickListener loginDlgBtnCancelOnClkLis = new Button.OnClickListener() {
            public void onClick(View v) {
                mTxtResult.setText(getString(R.string.m0400_ans) + getString(R.string.aleart1_b001));
                mLoginDlg.cancel();
            }
        };
    };




    @Override
    public void onAnimationStart(Animation animation) {
        l1.setVisibility(View.VISIBLE);

        if (startmusic.isPlaying()) {
            startmusic.stop();
        };
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


    }

