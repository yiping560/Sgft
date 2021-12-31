package tw.sgft.m0100;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;


    List<String> moviesList;
    List<Integer> aaa;
    private Menu menu;
    private Menu menu1;
    private Button b001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         b001 =(Button)findViewById(R.id.rec_b001);
//         b001.setOnClickListener(b001On);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesList = new ArrayList<>();
        aaa =new ArrayList<>();
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        moviesList.add("用戶一");
        moviesList.add("使用者二");
        moviesList.add("第三個");
        moviesList.add("用戶四");
        moviesList.add("用戶者五");
        moviesList.add("用戶六");
        moviesList.add("用戶七");
        moviesList.add("用戶八");
        moviesList.add("用戶9");
        moviesList.add("用戶十");
        moviesList.add("用戶十一");
        aaa.add(R.drawable.aaa);
        aaa.add(R.drawable.bbb);
        aaa.add(R.drawable.ccc);
        aaa.add(R.drawable.abc);
        aaa.add(R.drawable.def);
        aaa.add(R.drawable.acd);
        aaa.add(R.drawable.photo2);
        aaa.add(R.drawable.bbb);
        aaa.add(R.drawable.ccc);
        aaa.add(R.drawable.acd);
        aaa.add(R.drawable.photo2);
//        moviesList.add("用戶八");
//        moviesList.add("用戶九");
//        moviesList.add("用戶十");
//        moviesList.add("用戶十一");
//        moviesList.add("用戶十二");
//        moviesList.add("用戶十三");
//        moviesList.add("用戶十四");
//        moviesList.add("用戶十五");
//        moviesList.add("用戶十六");
//        moviesList.add("用戶十七");
//        moviesList.add("用戶十八");
//        moviesList.add("用戶十九");
//        moviesList.add("用戶二十");
//        moviesList.add("用戶二一");
//        moviesList.add("用戶二二");
//        moviesList.add("用戶二三");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList,aaa);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
//        新的recycilerview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
//    private View.OnClickListener b001On =new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
//                case R.id.rec_b001:
//                    Toast.makeText(MainActivity.this,"以送出邀請", Toast.LENGTH_SHORT).show();
//            }
//        }
//    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
//    }    @Override
//    public boolean onCreateOptionsMenu(Menu menu1) {
//        this.menu1 = menu1;
////        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.m0500_itemmenu, menu);
//        return true;
//    }
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


}














