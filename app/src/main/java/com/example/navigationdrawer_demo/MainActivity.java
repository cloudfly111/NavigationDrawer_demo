package com.example.navigationdrawer_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView imageView;
    private View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      目的 : 建立側開表單 NavigationView，以buuton為觸發元件
//      reference : https://material.io/components/navigation-drawer/android#using-navigation-drawers
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_id);
        navigationView = (NavigationView) findViewById(R.id.navigationView_id);

//      預設headerLayout :
//      方法1 : 就是預設顯示頂端的貓貓圖片 + 下面兩行字 ，但是貓貓圖片就不能改
//      在 activity_main.xml 的 com.google.android.material.navigation.NavigationView
//      加上 這列 : app:headerLayout="@layout/header_navigation_drawer"
//      方法2 : 可以用 code 修改預設貓貓圖片，改成其他圖片，方法1加入的那列 app:headerLayout 要刪掉
        headerView = navigationView.inflateHeaderView(R.layout.header_navigation_drawer);
        imageView = headerView.findViewById(R.id.imageView_id);
        imageView.setImageResource(R.drawable.pearls);

//        按下 NavigationView 對應的 menu 會顯示 Toast
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String message ="";
                switch (item.getItemId()){
                    case R.id.item1:
                        message = "item1";
                        break;

                    case R.id.item2:
                        message = "item2";
                        break;

                    case R.id.item3:
                        message = "item3";
                        break;

                    case R.id.item4:
                        message = "item4";
                        break;

                    case R.id.item5:
                        message = "item5";
                        break;
                }
                Toast.makeText(MainActivity.this, message ,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    設定 drawerLayout 從左邊滑出
                    drawerLayout.openDrawer(GravityCompat.START);


            }
        });
    }
}