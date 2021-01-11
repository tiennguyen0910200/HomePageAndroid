package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.app.Adapter.PopularAdapter;
import com.example.app.Object.Student;
import com.example.app.Object.cart;
import com.example.app.SQL.SQL;
import com.example.app.frament.NewFragment;
import com.example.app.frament.ViewPageAdapter;
import com.example.app.model.FoodData;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;
import com.example.app.retrofit.ApiInterface;
import com.example.app.retrofit.RetrofitClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tabnavi extends AppCompatActivity {

    public static List<Popular> std=new ArrayList<>();
    public static List<Recommended> recoment=new ArrayList<>();
    public static List<cart> cart=new ArrayList<>();
    public static SQL sql;

    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
//    RecommendedAdapter recommendedAdapter;
//    AllmenuAdapter allmenuAdapter;



    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_tabnavi);

        //ánh xạ view vào
        viewPager =findViewById(R.id.view_pager);
        bottomNavigationView =findViewById(R.id.btnavi);

//        khai báo viewadapter vừa mới viết
        ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);



        //        sự kiện vuốt viewpager

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //thay đổi từng vị trí position trong navi
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_news).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_order).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // thay đổi từng giá trị fragment theo từng giá trị item icon
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_news:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_order:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_account:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        sql=new SQL(tabnavi.this);

//        std=sql.getAllPopular();
//        recoment=sql.getRecoment();
//        cart=sql.getCart();
//
//
//
//        Log.d("name",recoment.get(1).getName());


    }
}