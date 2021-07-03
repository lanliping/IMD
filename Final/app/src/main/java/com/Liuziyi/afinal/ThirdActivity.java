package com.Liuziyi.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThirdActivity extends AppCompatActivity {

    Bundle bundle;
    String s_data;
    JSONObject j_data;
    JSONArray steps;
    ImageView imageView = null;
    TextView dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ConstraintSet constraintSet = new ConstraintSet();
        bundle = getIntent().getExtras();
        s_data = (String)bundle.get("trans");
        try {
            j_data = new JSONObject(s_data);
            steps = (JSONArray) j_data.get("steps");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayout linear = (LinearLayout) super.findViewById(R.id.mylinear);//取得组件
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);//定义按钮的布局参数
        LinearLayout.LayoutParams imageParam = new LinearLayout.LayoutParams(600,
                400);//添加图片的大小
        imageParam.setMargins(225, 0, 0, 50);
        LinearLayout.LayoutParams titleparam = new LinearLayout.LayoutParams(700,
                150);//添加文字的大小
        titleparam.setMargins(250, 50, 0, 0);
        LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(200,
                100);//添加文字的大小
        textparam.setMargins(460, 50, 0, 0);
        LinearLayout.LayoutParams conparam = new LinearLayout.LayoutParams(800,
                120);//添加文字的大小
        conparam.setMargins(200, 0, 0, 60);


        // 添加菜品图片
        try {
             dish = new TextView(ThirdActivity.this);
            dish.setText(j_data.getString("cpName"));
            dish.setLayoutParams(titleparam);
            dish.setTextSize(20);
            imageView= new ImageView(ThirdActivity.this);
            imageView.setImageBitmap(returnBitMap((String)j_data.get("smallImg")));
            imageView.setId(0);
            imageView.setLayoutParams(imageParam);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        linear.addView(dish);
        linear.addView(imageView);

        // 添加步骤
        JSONObject jsontmp;
        String urltmp;
        String contmp;
        ImageView imgtmp;
        TextView step, con;
        Integer steptmp;
        for(int i = 0; i < steps.length(); i++){
            try {
                jsontmp = (JSONObject) steps.get(i);
                urltmp = jsontmp.getString("imgUrl");
                imgtmp = new ImageView(ThirdActivity.this);
                imgtmp.setImageBitmap(returnBitMap(urltmp));
                steptmp = jsontmp.getInt("orderNum");
                contmp = jsontmp.getString("content");
                imgtmp.setLayoutParams(imageParam);
                step = new TextView(ThirdActivity.this);
                step.setText("第" + steptmp.toString() + "步");
                step.setLayoutParams(textparam);
                contmp = jsontmp.getString("content");
                con = new TextView(ThirdActivity.this);
                con.setText(contmp);
                con.setLayoutParams(conparam);
                linear.addView(step);
                linear.addView(imgtmp);
                linear.addView(con);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
