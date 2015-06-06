package com.org.chat;

import java.util.ArrayList;
import java.util.List;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private TextView chat;
	private TextView find;
	private TextView friend;
	private ViewPager id_viewpager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> list;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		 chat=(TextView)findViewById(R.id.chat);
		 find=(TextView)findViewById(R.id.find);
		 friend=(TextView)findViewById(R.id.friend);
		
		id_viewpager=(ViewPager)findViewById(R.id.id_viewpager);
		
		ChatMainTabFragment top01=new ChatMainTabFragment();
		FriendMainTabFragment top02=new FriendMainTabFragment();
		ContactMainTabFragment top03=new ContactMainTabFragment();
		
		list=new ArrayList<Fragment>();
		list.add(top01);
		list.add(top02);
		list.add(top03);
		mAdapter= new FragmentPagerAdapter(getSupportFragmentManager()) {
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return list.get(arg0);
			}
		};
		id_viewpager.setAdapter(mAdapter);
		
		id_viewpager.setOnPageChangeListener(new OnPageChangeListener()
		{
			
			public void onPageSelected(int position)
			{
				System.out.println(position);
				resetTextView();
				switch (position)
				{
				case 0:
					chat.setTextColor(Color.parseColor("#008000"));
					break;
				case 1:
					friend.setTextColor(Color.parseColor("#008000"));
					break;
				case 2:
					find.setTextColor(Color.parseColor("#008000"));
					break;

				}
			}
			private void resetTextView() {
				chat.setTextColor(Color.BLACK);
				find.setTextColor(Color.BLACK);
				friend.setTextColor(Color.BLACK);
				
			}
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
