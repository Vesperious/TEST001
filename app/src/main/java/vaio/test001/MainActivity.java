package vaio.test001;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /********************判断是否载入数据************/

        /*************************************************/

        DB dbb=new DB(this);
        SQLiteDatabase DBBRead=dbb.getReadableDatabase();
        Cursor cu=DBBRead.query("ADDB", null, null, null, null, null, null);
        if(cu.getCount()==0){
            DB db=new DB(this);
            SQLiteDatabase DBWrite=db.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("Account","Muxin");
            cv.put("Password","Muxin123");
            cv.put("Name","木心");
            cv.put("Sex","男");
            cv.put("City", "长春");
            cv.put("University", "吉林大学");
            cv.put("College", "软件学院");
            cv.put("Preference", "网络安全");
            DBWrite.insert("user", null, cv);


            ContentValues cv2=new ContentValues();
            cv2.put("Account","Weixiaohui");
            cv2.put("Password","Weixiaohui123");
            cv2.put("_id","魏晓辉");
            cv2.put("Sex","男");
            cv2.put("City","长春");
            cv2.put("Position","博士生导师");
            cv2.put("University", "吉林大学");
            cv2.put("College", "计算机学院");
            cv2.put("Lecture", "计算机网络、网格计算");
            cv2.put("Preference", "分布式系统、集群计算和网格技术");
            DBWrite.insert("ADDB", null, cv2);

            ContentValues cv3=new ContentValues();
            cv3.put("Account","Yangyongjian");
            cv3.put("Password","Yangyongjian123");
            cv3.put("_id","杨永健");
            cv3.put("Sex","男");
            cv3.put("City","长春");
            cv3.put("Position","博士生导师");
            cv3.put("University", "吉林大学");
            cv3.put("College", "计算机学院");
            cv3.put("Lecture", "无线网络与移动计算");
            cv3.put("Preference", "计算机网络");
            DBWrite.insert("ADDB", null, cv3);


            ContentValues cv4=new ContentValues();
            cv4.put("Account","Weida");
            cv4.put("Password","Weida123");
            cv4.put("_id","魏达");
            cv4.put("Sex","男");
            cv4.put("City","长春");
            cv4.put("Position","教授");
            cv4.put("University", "吉林大学");
            cv4.put("College", "计算机学院");
            cv4.put("Lecture", "数字逻辑电路");
            cv4.put("Preference", "车载通信、移动计算、网络管理、网络安全");
            DBWrite.insert("ADDB", null, cv4);

            ContentValues cv5=new ContentValues();
            cv5.put("Account","Guanrenchu");
            cv5.put("Password","Guanrenchu123");
            cv5.put("_id","管任初");
            cv5.put("Sex","男");
            cv5.put("City","长春");
            cv5.put("Position","副教授");
            cv5.put("University", "吉林大学");
            cv5.put("College", "计算机学院");
            cv5.put("Lecture", "计算方法、机器学习");
            cv5.put("Preference", "机器学习、文本挖掘");
            DBWrite.insert("ADDB", null, cv5);

            ContentValues cv6=new ContentValues();
            cv6.put("Account","Wangjian");
            cv6.put("Password","Wangjian123");
            cv6.put("_id","王健");
            cv6.put("Sex","男");
            cv6.put("City","长春");
            cv6.put("Position","副教授");
            cv6.put("University", "吉林大学");
            cv6.put("College", "计算机学院");
            cv6.put("Lecture", "无线网络技术");
            cv6.put("Preference", "车联网、移动通信、无线网络安全");
            DBWrite.insert("ADDB", null, cv6);



            ContentValues cv7=new ContentValues();
            cv7.put("Account","Liuxiahua");
            cv7.put("Password","Liuxiaohua123");
            cv7.put("_id","刘小华");
            cv7.put("Sex","女");
            cv7.put("City", "长春");
            cv7.put("Position", "副教授");
            cv7.put("University", "吉林大学");
            cv7.put("College", "计算机学院");
            cv7.put("Lecture", "计算机应用技术");
            cv7.put("Preference", "计算智能");
            DBWrite.insert("ADDB", null, cv7);


            ContentValues cv8=new ContentValues();
            cv8.put("Account","Yangyongjian" );
            cv8.put("_id","杨永健");
            cv8.put("Sex","男");
            cv8.put("City","长春");
            cv8.put("Position","博士生导师");
            cv8.put("University","吉林大学");
            cv8.put("College", "计算机学院");
            cv8.put("Lecture", "无线网络与移动计算");
            cv8.put("Preference", "计算机网络");
            DBWrite.insert("MyAttention", null, cv8);

            ContentValues cv9=new ContentValues();
            cv9.put("Account","Guanrenchu");
            cv9.put("_id","管任初");
            cv9.put("Sex","男");
            cv9.put("City","长春");
            cv9.put("Position","副教授");
            cv9.put("University","吉林大学");
            cv9.put("College", "计算机学院");
            cv9.put("Lecture", "计算方法、机器学习");
            cv9.put("Preference", "机器学习、文本挖掘");
            DBWrite.insert("MyAttention", null, cv9);

            ContentValues cv10=new ContentValues();
            cv10.put("Account","Guanrenchu");
            cv10.put("_id","管任初");
            cv10.put("Sex", "男");
            cv10.put("City","长春");
            cv10.put("Position","副教授");
            cv10.put("University","吉林大学");
            cv10.put("College","计算机学院");
            cv10.put("Lecture", "计算方法、机器学习");
            cv10.put("Preference", "机器学习、文本挖掘");
            DBWrite.insert("LikeMe", null, cv10);

            ContentValues cv11=new ContentValues();
            cv11.put("Account","Wangjian");
            cv11.put("_id","王健");
            cv11.put("Sex", "男");
            cv11.put("City","长春");
            cv11.put("Position","副教授");
            cv11.put("University","吉林大学");
            cv11.put("College","计算机学院");
            cv11.put("Lecture", "无线网络技术");
            cv11.put("Preference", "车联网、移动通信、无线网络安全");
            DBWrite.insert("Recommend", null, cv11);


            ContentValues cv12=new ContentValues();
            cv12.put("Account","Weida");
            cv12.put("_id","魏达");
            cv12.put("Sex", "男");
            cv12.put("City","长春");
            cv12.put("Position","教授");
            cv12.put("University","吉林大学");
            cv12.put("College","计算机学院");
            cv12.put("Lecture", "数字逻辑电路");
            cv12.put("Preference", "车载通信、移动计算、网络管理、网络安全");
            DBWrite.insert("Recommend", null, cv12);
            DBWrite.close();

        }
        DBBRead.close();

        /****************读取数据库**************************/
        /*******************************************************/
        /********************************************************/
        /*SQLiteDatabase DBRead=db.getReadableDatabase();
        Cursor cu =DBRead.query("user", null, null, null, null, null, null);
        while(cu.moveToNext()){
            String Account=cu.getString(cu.getColumnIndex("Account"));
            System.out.println(Account);
        }*/

        /*************个人资料按钮***************/
        findViewById(R.id.btnPersonalData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent i=new Intent(MainActivity.this,PersonalData.class);
                        startActivity(i);
            }
        });

        /*************导师库按钮**********************/
        findViewById(R.id.btnAdvisorDB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ADDBList.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnMyAttention).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MyAttentionList.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnLikeMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LikeMeList.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnRecommend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RecommendList.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
