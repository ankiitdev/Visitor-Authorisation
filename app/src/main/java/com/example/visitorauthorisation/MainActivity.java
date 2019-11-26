package com.example.visitorauthorisation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.addAll(Arrays.asList(new Fragment1(), new Fragment2(), new Fragment3()));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.POSITION_NONE, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

            tabLayout.getTabAt(0).setText("Details");
            tabLayout.getTabAt(1).setText("Chat");
            tabLayout.getTabAt(2).setText("Action");

    }
}

