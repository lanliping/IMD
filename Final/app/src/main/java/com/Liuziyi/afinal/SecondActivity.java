package com.Liuziyi.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    String selected, selected2, selected3;
    List<String> list = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list3 = new ArrayList<String>();
    JSONObject j1, j2, transdata;
    ArrayAdapter<String> adapter1, adapter2, adapter3;
    Context context;
    Spinner sp1, sp2, sp3;
    String input, res;
    Button btn;
    JSONArray jsonArray;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        context = this;
        try {
            j1 = new JSONObject("{\"肉类\":{\"鸽子\":[\"鸽子\"],\"鸡\":[\"鸡\",\"鸡翅\",\"鸡胸\",\"鸡腿\",\"鸡爪\",\"鸡肉\",\"乌鸡\",\"鸡胗\",\"土鸡\",\"仔鸡\",\"三黄鸡\",\"鸡肝\",\"老母鸡\",\"鸡心\",\"柴鸡\",\"童子鸡\"],\"鹅\":[\"鹅\"],\"驴肉\":[\"驴肉\"],\"雪蛤\":[\"雪蛤\"],\"羊\":[\"羊\",\"羊肉\",\"羊排\",\"羊腿\",\"羊肉片\",\"羊蝎子\"],\"猪\":[\"猪\",\"猪肉\",\"排骨\",\"猪肉末\",\"五花肉\",\"猪蹄\",\"瘦肉\",\"里脊\",\"猪肝\",\"猪排\",\"猪肚\",\"猪皮\",\"猪骨\",\"肥肠\",\"猪油\",\"猪腰\",\"猪耳朵\",\"猪心\",\"猪血\",\"猪肺\",\"肉末\"],\"鸭\":[\"鸭\",\"鸭腿\",\"鸭肉\",\"老鸭\",\"鸭胗\",\"鸭血\",\"鸭掌\",\"鸭翅\",\"鸭舌\",\"鸭肠\",\"鸭脖\",\"鸭肝\",\"鸭爪\"],\"牛蛙\":[\"牛蛙\"],\"鹌鹑\":[\"鹌鹑\"],\"火鸡\":[\"火鸡\"],\"鹿肉\":[\"鹿肉\"],\"牛\":[\"牛\",\"牛肉\",\"牛腩\",\"牛排\",\"肥牛\",\"牛里脊\",\"牛腱\",\"牛尾\",\"牛肉末\",\"牛筋\",\"牛百叶\",\"牛骨\",\"牛肉馅\"],\"田鸡\":[\"田鸡\"],\"兔肉\":[\"兔肉\"]},\"热门专题\":{\"人群\":[\"儿童\",\"婴幼儿\",\"老人\",\"孕产妇\",\"宝宝食谱\"],\"功效\":[\"减肥\",\"美容\",\"润肺抗燥\",\"补血\",\"清热祛火\"],\"菜式\":[\"家常菜\",\"快手菜\",\"下饭菜\",\"素菜\",\"大鱼大肉\",\"下酒菜\",\"小清新\",\"创意菜\"],\"视频专题\":[\"味蕾工坊\"],\"特殊场合\":[\"早餐\",\"下午茶\",\"便当\",\"圣诞节\",\"年夜饭\",\"深夜食堂\",\"情人节\",\"宵夜\"],\"特色食品\":[\"小吃\",\"酱\",\"沙拉\",\"凉菜\",\"零食\",\"三明治\",\"月饼\",\"蒸蛋\",\"寿司\",\"粽子\",\"鸡蛋羹\"]},\"口味特色\":{\"烹调方法\":[\"煎\",\"蒸\",\"炖\",\"红烧\",\"炸\",\"卤\",\"干锅\",\"火锅\",\"免烤\"],\"器具\":[\"烤箱\",\"电饭煲\",\"微波炉\",\"平底锅\",\"塔吉锅\"],\"异国风味\":[\"日式\",\"韩式\",\"西式\",\"西餐\",\"东南亚\"],\"口味\":[\"辣\",\"咖喱\",\"糖醋\",\"蒜香\",\"酸甜\",\"奶香\",\"孜然\",\"鱼香\",\"五香\",\"清淡\"]},\"米面干果腌咸\":{\"腌咸制品\":[\"火腿\",\"香肠\",\"培根\",\"腊肉\",\"酸菜\",\"泡菜\",\"肉松\",\"梅干菜\",\"雪里蕻\",\"榨菜\",\"辣白菜\",\"笋干\",\"鱼丸\",\"橄榄菜\",\"咸菜\",\"萝卜干\",\"咸肉\",\"酸豇豆\",\"肉丸\",\"午餐肉\",\"蟹棒\",\"叉烧肉\",\"芽菜\",\"纳豆\",\"大头菜\",\"酸笋\",\"木鱼花\",\"冬菜\",\"玉兰片\",\"泡萝卜\",\"咸黄瓜\",\"叉烧\",\"酸豆角\"],\"米面类\":[\"面粉\",\"面条\",\"大米\",\"高筋面粉\",\"意大利面\",\"糯米\",\"低筋面粉\",\"年糕\",\"西米\",\"糯米粉\",\"粉丝\",\"燕麦\",\"米粉\",\"酒酿\",\"燕麦片\",\"乌冬面\",\"小米\",\"玉米面\",\"全麦粉\",\"黑米\",\"魔芋\",\"方便面\",\"粉条\",\"米线\",\"荞麦面\",\"油条\",\"黄豆面\",\"消化饼干\",\"面筋\",\"粘米粉\",\"凉粉\",\"糙米\",\"河粉\",\"紫米\",\"烤麸\",\"小麦胚芽\",\"澄面\",\"粉皮\",\"蕨根粉\",\"藕粉\",\"红曲米\",\"莜面\",\"黄米\",\"荞麦\",\"大麦\",\"高粱米\",\"红米\",\"澄粉\",\"黄豆粉\"],\"干果类\":[\"芝麻\",\"花生\",\"杏仁\",\"红豆\",\"枣\",\"核桃\",\"板栗\",\"蔓越莓\",\"绿豆\",\"黄豆\",\"薏米\",\"葡萄干\",\"莲子\",\"橄榄\",\"黑豆\",\"蜜豆\",\"芸豆\",\"腰果\",\"桃胶\",\"乌梅\",\"松仁\",\"无花果\",\"银杏果\",\"话梅\",\"榛子\",\"鹰嘴豆\",\"罗汉果\",\"芡实\",\"开心果\",\"干山楂\",\"南瓜子\",\"瓜子仁\",\"眉豆\",\"红腰豆\",\"松子\",\"山楂干\",\"白果\"]},\"汤粥主食\":{\"馒头\":[\"馒头\"],\"包子\":[\"包子\"],\"饺子\":[\"饺子\"],\"粥\":[\"粥\"],\"馄饨\":[\"馄饨\"],\"三明治\":[\"三明治\"],\"汤羹\":[\"汤羹\"],\"饼\":[\"饼\"],\"饭\":[\"饭\",\"炒饭\",\"饭团\",\"盖浇饭\",\"煲仔饭\",\"焗饭\",\"烩饭\"],\"面条\":[\"面条\",\"拌面\",\"炒面\",\"汤面\",\"凉面\",\"焖面\"]},\"烘焙甜品饮料\":{\"饮品\":[\"饮品\",\"咖啡\",\"豆浆\",\"奶茶\",\"酒\",\"果汁\",\"花草茶\"],\"甜品\":[\"甜品\",\"布丁\",\"冷饮\",\"果酱\",\"糖水\",\"冰淇淋\",\"果冻\"],\"烘焙\":[\"烘焙\",\"蛋糕\",\"面包\",\"饼干\",\"披萨\",\"派\",\"司康\",\"塔\",\"泡芙\",\"奶油霜\"]},\"蛋奶豆制品\":{\"蛋类\":[\"鸡蛋\",\"咸蛋\",\"皮蛋\",\"鹌鹑蛋\",\"鸭蛋\",\"咸鸭蛋\"],\"豆制品\":[\"豆腐\",\"香干\",\"豆渣\",\"千张\",\"腐竹\",\"素鸡\",\"油豆皮\",\"豆干\",\"豆腐皮\"],\"奶制品\":[\"牛奶\",\"黄油\",\"巧克力\",\"奶油\",\"奶酪\",\"酸奶\",\"黑巧克力\",\"淡奶油\",\"奶油奶酪\",\"炼乳\",\"奶粉\",\"马苏里拉奶酪\",\"白巧克力\",\"酸奶油\",\"酥油\",\"芝士\"]},\"蔬菜水果\":{\"水果\":[\"水果\",\"时令水果\",\"柠檬\",\"椰子\",\"草莓\",\"橙\",\"牛油果\",\"木瓜\",\"山楂\",\"蓝莓\",\"西瓜\",\"柚子\",\"火龙果\",\"樱桃\",\"榴莲\",\"西柚\",\"桃\",\"葡萄\",\"金橘\",\"黄桃\",\"百香果\",\"杨梅\",\"桔子\",\"荔枝\",\"无花果\",\"石榴\",\"杏子\",\"桑葚\",\"哈密瓜\",\"柿子\",\"李子\",\"青梅\",\"枇杷\",\"香瓜\",\"甘蔗\",\"覆盆子\",\"杨桃\",\"橘子\",\"金桔\",\"杏\"],\"根茎蔬菜\":[\"土豆\",\"萝卜\",\"紫薯\",\"红薯\",\"胡萝卜\",\"山药\",\"藕\",\"芋头\",\"笋\",\"茭白\",\"马蹄\",\"牛蒡\",\"菱角\"],\"叶类蔬菜\":[\"芹菜\",\"白菜\",\"韭菜\",\"菠菜\",\"西兰花\",\"圆白菜\",\"花椰菜\",\"莴苣\",\"青菜\",\"娃娃菜\",\"生菜\",\"甘蓝\",\"蒜薹\",\"紫甘蓝\",\"空心菜\",\"油菜\",\"荠菜\",\"香椿\",\"茼蒿\",\"菜心\",\"芥兰\",\"黄花菜\",\"韭黄\",\"苋菜\",\"紫苏\",\"芥菜\",\"油麦菜\",\"豌豆苗\",\"苦菊\",\"青蒜\",\"鱼腥草\",\"马兰\",\"蕨菜\",\"西洋菜\",\"水芹\",\"儿菜\",\"豌豆尖\",\"芝麻菜\",\"芦蒿\",\"穿心莲\",\"孢子甘蓝\",\"萝卜苗\",\"红菜苔\",\"牛至\",\"蒿子杆\",\"包菜\",\"莴笋\",\"花菜\",\"蒜苔\",\"豆苗\",\"披萨草\"],\"花朵植物类\":[\"茶叶\",\"桂花\",\"玫瑰\",\"薄荷\",\"菊花\",\"洛神花\",\"茉莉花\",\"槐花\",\"金银花\"],\"果实类蔬菜\":[\"彩椒\",\"番茄\",\"南瓜\",\"玉米\",\"茄子\",\"黄瓜\",\"豇豆\",\"青椒\",\"苦瓜\",\"冬瓜\",\"丝瓜\",\"秋葵\",\"西葫芦\",\"毛豆\",\"豌豆\",\"四季豆\",\"荷兰豆\",\"蚕豆\",\"圣女果\",\"扁豆\",\"刀豆\",\"瓠瓜\",\"玉米笋\",\"西红柿\"],\"菌菇类\":[\"香菇\",\"杏鲍菇\",\"银耳\",\"木耳\",\"金针菇\",\"蘑菇\",\"茶树菇\",\"平菇\",\"松茸\",\"鸡腿菇\",\"草菇\",\"竹荪\",\"蟹味菇\",\"花菇\",\"猴头菇\",\"牛肝菌\",\"灵芝\",\"榛蘑\",\"白玉菇\",\"姬松茸\",\"滑子菇\",\"发菜\",\"白灵菇\",\"袖珍菇\",\"双孢菇\",\"秀珍菇\"]},\"水产\":{\"螃蟹\":[\"螃蟹\",\"梭子蟹\",\"大闸蟹\",\"蟹肉\",\"蟹黄\"],\"鱼\":[\"鱼\",\"海水鱼\",\"淡水鱼\",\"鱼头\",\"鱼干\",\"鱼籽\",\"鱼肚\"],\"贝\":[\"蛤蜊\",\"干贝\",\"鲍鱼\",\"扇贝\",\"牡蛎\",\"青口\",\"蛏子\",\"鲜贝\",\"北极贝\",\"河蚌\"],\"虾\":[\"虾\",\"虾仁\",\"海米\",\"虾皮\",\"明虾\",\"基围虾\",\"龙虾\",\"小龙虾\",\"河虾\",\"海虾\",\"皮皮虾\",\"北极虾\",\"虾干\",\"青虾\",\"草虾\",\"海白虾\",\"虾米\",\"大虾\"]}}");
            Iterator iterator = j1.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                list.add(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp1  = (Spinner) findViewById(R.id.spinner);
        sp1.setAdapter(adapter1);

        // sp1的监听事件
        sp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selected = list.get(arg2);
                try {
                    list2.clear();
                    j2 = (JSONObject) j1.get(selected);
                    Iterator iterator2 = j2.keys();
                    while (iterator2.hasNext()) {
                        String key = (String) iterator2.next();
                        list2.add(key);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                adapter2 = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, list2);
                adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                sp2 = (Spinner) findViewById(R.id.spinner2);
                sp2.setAdapter(adapter2);
                sp2.setOnItemSelectedListener(new Spinner2ClickListener());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    // spinner2的监听事件
    public class Spinner2ClickListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selected2 = (String) adapterView.getItemAtPosition(i);
            try {
                String tmp1 = getAll(selected2);
                JSONObject jo = new JSONObject(tmp1);
                jo = (JSONObject)jo.get("showapi_res_body");
                jsonArray = (JSONArray) jo.get("datas");
                list3.clear();
                for(int j = 0; j < jsonArray.length(); j++){
                    JSONObject jt = (JSONObject) jsonArray.get(j);
                    String stmp = (String)jt.get("cpName");
                    list3.add(stmp);
                }
                adapter3 = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, list3);
                adapter3.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                sp3 = (Spinner) findViewById(R.id.spinner3);
                sp3.setAdapter(adapter3);
                sp3.setOnItemSelectedListener(new Spinner3ClickListener());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    // spinner3的监听事件
    public class Spinner3ClickListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            try {
                transdata = (JSONObject) jsonArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bundle = new Bundle();
            bundle.putString("trans", transdata.toString());
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    String getRes(String cla, String input) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = formatter.format(calendar.getTime());
        String s_url = "https://route.showapi.com/1164-1?cpName=" + input +
                "&maxResults=1&page=1&showapi_appid=683745.0&showapi_timestamp=" + time +
                "&type=" +
                cla + "&showapi_sign=aec201a5f6c88c2b4edfad1ba1ea60a0";
        URL u = new URL(s_url);
        InputStream in = u.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if ( in != null) {
                in.close();
            }
        }
        byte b[] = out.toByteArray();
        return new String(b, "utf-8");
    }

    public String getAll(String selected) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = formatter.format(calendar.getTime());
        String s_url = "https://route.showapi.com/1164-1?maxResults=50&page=1&showapi_appid=683745.0&showapi_timestamp=" +
                time + "&type=" + selected + "&showapi_sign=19458966a75141a18bde27a594b466f6";
        URL u = new URL(s_url);
        InputStream in = u.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if ( in != null) {
                in.close();
            }
        }
        byte b[] = out.toByteArray();
        return new String(b, "utf-8");
    }
    public void jump2(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}



