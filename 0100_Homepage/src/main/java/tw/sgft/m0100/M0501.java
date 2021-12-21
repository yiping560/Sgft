package tw.sgft.m0100;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0501 extends ListActivity {

    private TextView t001;
    private String[] t001a,t001b,t001c;
    private ArrayList<Map<String,Object>> mList;
    private int ss;
    private MediaPlayer startmusic;
    private LinearLayout l1,l2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);

       t001=(TextView)findViewById(R.id.m0501_t001);
       t001a=getResources().getStringArray(R.array.Attraction);
       t001b=getResources().getStringArray(R.array.Attrainformation);
       t001c=getResources().getStringArray(R.array.Attrainphone);
       l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);

       //---------------------------------開頭音樂
        startmusic= MediaPlayer.create(getApplication(),R.raw.music02);
        startmusic.start();


       //-------------------------------------------------
        mList=new ArrayList<>();

        for (int i =0;i<t001a.length;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            String idname="imag"+String.format("%02d",i+1);
            int resId = getResources().getIdentifier(idname, "drawable", getPackageName());

            item.put("imgView",resId);
            item.put("textView",t001a[i]);
            item.put("textView1",t001b[i]);
            item.put("textView2",t001c[i]);
            mList.add(item);
            SimpleAdapter adapter=new SimpleAdapter(
                   this,
                   mList,
                    R.layout.m0500_list_item,
                    new String[]{"imgView","textView","textView2","textView3"},
                    new int[]{R.id.imageView,R.id.m0501_t001a,R.id.m0501_t001b});

            //-------------------------------------------------------------------------
            setListAdapter(adapter);
            ListView Listview = getListView();
            Listview.setTextFilterEnabled(true);

            Listview.setOnItemClickListener(listON);

        }



    }
    AdapterView.OnItemClickListener listON=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            t001.setText(R.string.m0501_t001+t001a[position]);

        }
    };

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500_bottom_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.m0500_item02:
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
            
                break;
            case R.id.m0500_item01:
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}