package tw.sgft.m0100;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M0200 extends AppCompatActivity {

          private Button b001, apply, cancel, cb001, cb002, ilist_b001;
          private Travel data;
          //行程和團友，先用List<Stiring>
          private List<String> targetdata, matedata;

          //顯示暫存用
          private List<String> showList;
          private ListView showListView;
          private ArrayAdapter<String> showListAdapter;

          BaseAdapter adapter;
          CustomLabelAdapter mateitemadapter, targetitemadapter;
          private ListView lv001;
          private RecyclerView itemlistview;
          private BottomNavigationView _bottomBar;
          //          private AppBarConfiguration _appBarConfiguration;
          RelativeLayout mainlayout;
          //          private LinearLayout listpPage, editPage;
          private EditText e001;

          //狀態機試寫
          //目前狀態(頁面)
          private int currentPageID;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0200);

                    setupViewComponent();
          }

          private void setupViewComponent() {

                    data = TestDataRepository.getInstance().getData();

                    showList = new ArrayList<>();

                    //抓物件，整個Layout(現在沒用)
                    mainlayout = (RelativeLayout) findViewById(R.id.m0200_main_layout);
                    //抓物件，各set
//                    listpPage = (LinearLayout) findViewById(R.id.m0200_layout_list);
//                    editPage = (LinearLayout) findViewById(R.id.m0200_layout_edit);
                    currentPageID = R.id.m0200_layout_team_manager;
                    ChangePage(R.id.m0200_layout_list);

                    _bottomBar = findViewById(R.id.m0200_bottombar);
                    _bottomBar.setOnItemSelectedListener(bottomOn);

//                    _appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.m0200_team_info,R.id.m0200_team_list}).build();

                    lv001 = (ListView) findViewById(R.id.m0200_listview_lv001);
                    showListView = (ListView) findViewById(R.id.m0200_edit_showlist);
                    itemlistview = (RecyclerView) findViewById(R.id.m0200_item_list);

                    e001 = (EditText) findViewById(R.id.m0200_set002_e001);

                    b001 = findViewById(R.id.m0200_set001_b001);

                    apply = findViewById(R.id.m0200_set002_apply_button);
                    cancel = findViewById(R.id.m0200_set002_cancel_button);
                    cb001 = findViewById(R.id.m0200_set002_select_b001);
                    cb002 = findViewById(R.id.m0200_set002_select_b002);
                    ilist_b001 = findViewById(R.id.m0200_item_list_b001);

                    b001.setOnClickListener(buttonOn);
                    apply.setOnClickListener(buttonOn);
                    cancel.setOnClickListener(buttonOn);
                    cb001.setOnClickListener(buttonOn);
                    cb002.setOnClickListener(buttonOn);
                    ilist_b001.setOnClickListener(buttonOn);

                    //載入data和adapter
                    if (data != null) {
                              adapter = new CustomAdapter(this, data.HappySet, R.layout.m0200_custom_listview_container);
                              lv001.setAdapter(adapter);
                              lv001.setOnItemClickListener(itemOn);
                              lv001.setOnItemLongClickListener(itemLongOn);
                    }

                    targetdata = Arrays.asList(getResources().getStringArray(R.array.m0200_dummy_date));
                    matedata = Arrays.asList(getResources().getStringArray(R.array.m0200_dummy_userName));

                    mateitemadapter = new CustomLabelAdapter(matedata, R.layout.m0200_lite_label);
                    targetitemadapter = new CustomLabelAdapter(targetdata, R.layout.m0200_lite_label);

                    showListAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,showList);

          }

          private View.OnClickListener buttonOn = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              switch (v.getId()) {
                                        case R.id.m0200_set001_b001:
                                                  ChangePage(R.id.m0200_layout_edit);
                                                  Toast.makeText(getApplicationContext(), "444", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_set002_apply_button:
                                                  if (e001.getText().toString().length() <= 0) {
                                                            Toast.makeText(getApplicationContext(), "請輸入名稱", Toast.LENGTH_SHORT).show();
                                                            break;
                                                  }
                                                  createNewData();
                                                  ChangePage(R.id.m0200_layout_list);
                                                  adapter.notifyDataSetChanged();
                                                  Toast.makeText(getApplicationContext(), "新增儲存後回主介面", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_set002_cancel_button:
                                                  ChangePage(R.id.m0200_layout_list);
                                                  Toast.makeText(getApplicationContext(), "什麼都不做回主介面", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_set002_select_b001:
                                                  itemlistview.setAdapter(targetitemadapter);
                                                  ChangePage(R.id.m0200_layout_item_listview);
                                                  Toast.makeText(getApplicationContext(), "選擇行程", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_set002_select_b002:
                                                  itemlistview.setAdapter(mateitemadapter);
                                                  itemlistview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                                                  ChangePage(R.id.m0200_layout_item_listview);
                                                  Toast.makeText(getApplicationContext(), "選擇好友", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_item_list_b001:
                                                  for (int i = 0; i < mateitemadapter.getItemCount(); i++) {
                                                            String str = mateitemadapter.getItem(i);
                                                            //List<>().contains(object o)回傳一個boolean，如果List內包含該物件
                                                            if (mateitemadapter.getItemChecked(i) && !showList.contains(str)) {
                                                                      showList.add(str);
                                                            }
                                                  }
                                                  showListView.setAdapter(showListAdapter);
                                                  ChangePage(R.id.m0200_layout_edit);
                                                  break;
                              }

                    }

          };

          private void createNewData() {
                    String str1, str2, str3;
                    str1 = e001.getText().toString();
//                    str2 =

                    TestTeamData ttData = new TestTeamData(str1, "假裝去旅遊", "準備中");
                    data.HappySet.add(ttData);
          }

          private AdapterView.OnItemClickListener itemOn = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                              switch (parent.getId()) {
                                        case R.id.m0200_listview_lv001:
                                                  Toast.makeText(getApplicationContext(), "888", Toast.LENGTH_SHORT).show();
                                                  break;
                                        case R.id.m0200_item_list:

                                                  Toast.makeText(getApplicationContext(), "999", Toast.LENGTH_SHORT).show();
                                                  break;
                              }
                    }
          };

          private AdapterView.OnItemLongClickListener itemLongOn = new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                              Toast.makeText(getApplicationContext(), "Hold Item", Toast.LENGTH_SHORT).show();
                              return false;
                    }
          };

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


          private NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                              switch (item.getItemId()) {
                                        case R.id.m0200_team_info:
                                                  ChangePage(R.id.m0200_layout_team_manager);
                                                  break;
                                        case R.id.m0200_team_list:
                                                  ChangePage(R.id.m0200_layout_list);
                                                  break;
                              }
                              return true;
                    }
          };

          //
          public void ChangePage(int pageID) {
                    if (currentPageID == pageID) {
                              return;
                    }

                    findViewById(currentPageID).setVisibility(View.INVISIBLE);
                    findViewById(pageID).setVisibility(View.VISIBLE);

                    currentPageID = pageID;
          }
}