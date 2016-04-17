package vaio.test001;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalData extends AppCompatActivity {


    TextView UserName;
    TextView UserSex;
    TextView UserCity;
    TextView UserUniversity;
    TextView UserCollege;
    TextView UserPreference;
    Button btnExit;
    Button btnEditMyData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        /*DB db=new DB(this);
        SQLiteDatabase DBRead=db.getReadableDatabase();
        Cursor cu =DBRead.query("user", null, null, null, null, null, null);
        while(cu.moveToNext()) {
            String MyName = cu.getString(2);
            String MySex= cu.getString(3);
            String MyCity = cu.getString(4);
            String MyUniversity = cu.getString(5);
            String MyCollege = cu.getString(6);
            String MyPreference = cu.getString(7);
            UserName=(TextView)findViewById(R.id.MyName);
            UserSex=(TextView)findViewById(R.id.MySex);
            UserCity=(TextView)findViewById(R.id.MyCity);
            UserUniversity=(TextView)findViewById(R.id.MyUniversity);
            UserCollege=(TextView)findViewById(R.id.MyCollege);
            UserPreference=(TextView)findViewById(R.id.MyPreference);
            UserName.setText(MyName);
            UserSex.setText(MySex);
            UserCity.setText(MyCity);
            UserUniversity.setText(MyUniversity);
            UserCollege.setText(MyCollege);
            UserPreference.setText(MyPreference);
        }
        btnExit=(Button)findViewById(R.id.ExitMyData);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEditMyData=(Button)findViewById(R.id.EditMyData);
        btnEditMyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PersonalData.this,EditPersonalData.class);
                startActivity(i);
            }
        });
*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        DB db=new DB(this);
        SQLiteDatabase DBRead=db.getReadableDatabase();
        Cursor cu =DBRead.query("user", null, null, null, null, null, null);
        while(cu.moveToNext()) {
            String MyName = cu.getString(2);
            String MySex= cu.getString(3);
            String MyCity = cu.getString(4);
            String MyUniversity = cu.getString(5);
            String MyCollege = cu.getString(6);
            String MyPreference = cu.getString(7);
            UserName=(TextView)findViewById(R.id.MyName);
            UserSex=(TextView)findViewById(R.id.MySex);
            UserCity=(TextView)findViewById(R.id.MyCity);
            UserUniversity=(TextView)findViewById(R.id.MyUniversity);
            UserCollege=(TextView)findViewById(R.id.MyCollege);
            UserPreference=(TextView)findViewById(R.id.MyPreference);
            UserName.setText(MyName);
            UserSex.setText(MySex);
            UserCity.setText(MyCity);
            UserUniversity.setText(MyUniversity);
            UserCollege.setText(MyCollege);
            UserPreference.setText(MyPreference);
        }
        btnExit=(Button)findViewById(R.id.ExitMyData);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEditMyData=(Button)findViewById(R.id.EditMyData);
        btnEditMyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PersonalData.this,EditPersonalData.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personal_data, menu);
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
