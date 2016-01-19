package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.constellation.R;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Brand_B extends Fragment {

	private String tag = Brand_B.class.toString();

	private GridView gridView;

	private int[] images = { R.drawable.baiyang, R.drawable.jinniu,
			R.drawable.shuangzi, R.drawable.juxie, R.drawable.shizi,
			R.drawable.chunv, R.drawable.tianping, R.drawable.tianxie,
			R.drawable.sheshou,R.drawable.mojie,R.drawable.shuiping,R.drawable.shuangyu };
	private String[] text = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座" ,"摩羯座","水瓶座","双鱼座"};
    private String[] text1 ={"3.21-4.19","4.20-5.20","5.21-6.21","6.22-7.22","7.23-8.22","8.23-9.22"
    		,"9.23-10.23","10.24-11.22","11.23-12.21","12.22-1.19","1.20-2.18","2.19-3.20"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.brand_all, container, false);

		this.gridView = (GridView) view.findViewById(R.id.gridView_all);

		ArrayList<HashMap<String, Object>> imagelist = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 12; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("images", images[i]);
			map.put("text", text[i]);
			map.put("text1", text1[i]);
			imagelist.add(map);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
				imagelist, R.layout.brand_all_item, new String[] { "images",
						"text" ,"text1"}, new int[] { R.id.online_iv, R.id.online_tv ,R.id.online_tv1});
		gridView.setAdapter(simpleAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				
				
				Toast.makeText(getActivity(), "点击了"+(arg2+1)+"个", Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
