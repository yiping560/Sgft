package tw.sgft.m0100;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;




public class M0505_map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
//    private M0505MapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = M0505MapBinding.inflate(getLayoutInflater());
        setContentView(R.layout.m0505_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setMinZoomPreference(6.0f);
//        mMap.setMaxZoomPreference(5.0f);

        // Add a marker in Sydney and move the camera
        //從sydney位置到職訓局位置的地圖動畫效果
        LatLng sydney = new LatLng(-33.88,151.21);
//        LatLng mountainView = new LatLng(37.4, -122.1);
        LatLng tcnr = new LatLng(24.170748625653328, 120.61015518425178);
// Move the camera instantly to Sydney with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

// Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());

// Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

// Construct a CameraPosition focusing on 職訓局 and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(tcnr )      // Sets the center of the map to Mountain View
                .zoom(15)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//        LatLng tcnr = new LatLng(24.170748625653328, 120.61015518425178);
//        mMap.addMarker(new MarkerOptions().position(tcnr).title("台中職訓局"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(tcnr));
//         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tcnr, 15.0f));
//        1：全世界
//        5：自然景觀/大陸
//        10：城市
//        15：街道
//        20：建築
    }

    //彰基分享第一段
//    // 如果API Level大于等于23，即Android版本在6.0及以上，则需要进行动态权限申请
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        Log.i(TAG, "sdk >= 23 M");
//        // 检查您的应用是否具有给定的权限，以及该权限对应的App Ops是否被允许
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED
//                || ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            // 请求授予此应用程序的权限
//            String[] strings =
//                    {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
//            // 请求授予权限
//            ActivityCompat.requestPermissions(this, strings, 1);
//        }
//    }

//彰基分享第二段
// mMap.setMyLocationEnabled(true);
//    //我的位置按鈕開啟
//        mMap.getUiSettings().setMyLocationButtonEnabled(true);
//    //            右下角的導覽及開啟 Google Map功能
//        mMap.getUiSettings().setMapToolbarEnabled(true);
//
//        mMap.setOnMyLocationButtonClickListener(this);
//        mMap.setOnMapClickListener(this);

    //彰基分享第三段
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The actn bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        switch (item.getItemId()) {
//
//            case R.id.home: //首頁
//                intent.setClass(M_a_gps04.this, M_l001.class);
//                startActivity(intent);
//                break;
//            case R.id.action_back: //回上一頁
//                this.finish();
//                break;
//
//
//            case R.id.m_a_gps04_rb001:
////                新增了道路地圖的衛星照片資料。道路和功能標籤也可見。
//                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//                break;
//            case R.id.m_a_gps04_rb002:
////                沒有瓷磚。地圖將呈現為沒有載入圖塊的空網格。
//                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
//                break;
//            case R.id.m_a_gps04_rb003:
////                典型的路線圖。展示了道路，一些人造特徵以及河流等重要的自然景觀。道路和功能標籤也可見。
//                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//                break;
//            case R.id.m_a_gps04_rb004:
////                衛星照片資料。道路和功能標籤不可見。
//                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//                break;
//            case R.id.m_a_gps04_rb005:
////                地形資料。地圖包括顏色，輪廓線和標籤以及透視陰影。一些道路和標籤也可見。
//                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//                break;
//            case R.id.m_a_gps04_rb006:
//                mMap.setTrafficEnabled(true); //開啟路況
//                break;
//            case R.id.m_a_gps04_rb007:
//                mMap.setTrafficEnabled(false); //關閉路況
//                break;
//
//
//
//        }
//        return true;
//    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {

//            case R.id.m0500_item01:
//
////                l1.setVisibility(View.VISIBLE);
////                l2.setVisibility(View.INVISIBLE);
//
//                break;
//            case R.id.m0500_item02:
//                l1.setVisibility(View.INVISIBLE);
//                l2.setVisibility(View.VISIBLE);
//                intent.setClass(M0500.this,M0501.class);
//                startActivity(intent);
//                break;
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
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m0500_itemmenu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

    }
}