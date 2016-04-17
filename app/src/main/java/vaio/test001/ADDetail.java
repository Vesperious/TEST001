package vaio.test001;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ADDetail extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addetail);
        Button btnExitADDetail;
        Button btnLikeAD;
        TextView ADName,ADPosition,ADUniversity,ADCollege,ADLecture,ADPreference;
        ADName= (TextView) findViewById(R.id.ADDName);
        ADPosition=(TextView)findViewById(R.id.ADDPosition);
        ADUniversity=(TextView)findViewById(R.id.ADDUniversity);
        ADCollege=(TextView)findViewById(R.id.ADDCollege);
        ADLecture=(TextView)findViewById(R.id.ADDLecture);
        ADPreference=(TextView)findViewById(R.id.ADDPreference);
        btnExitADDetail=(Button)findViewById(R.id.ExitADDetail);
        btnLikeAD=(Button)findViewById(R.id.LikeAD);
        final DB db=new DB(this);
        SQLiteDatabase DBRead=db.getReadableDatabase();


        final String ADID=getIntent().getStringExtra("ADID");
        //Cursor cu =DBRead.query("ADDB", null, selection, Args, null, null, null);
        final Cursor cu=DBRead.rawQuery("Select * from ADDB where Account=?", new String[]{ADID});
        cu.moveToNext();
            ADName.setText(cu.getString(2));
            ADPosition.setText(cu.getString(5));
            ADUniversity.setText(cu.getString(6));
            ADCollege.setText(cu.getString(7));
            ADLecture.setText(cu.getString(8));
            ADPreference.setText(cu.getString(9));



        Cursor cursor=DBRead.query("MyAttention",null,"Account=?",new String[]{ADID},null,null,null);
        if(cursor.getCount()>0){
            btnLikeAD.setText("取消关注");
            btnLikeAD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase DBWrite = db.getWritableDatabase();
                    DBWrite.delete("MyAttention", "Account=?", new String[]{ADID});
                    Toast toast=Toast.makeText(getApplicationContext(),"已取消关注",Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            });
        }
        else{
            btnLikeAD.setText("关注");
            btnLikeAD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase DBWrite=db.getWritableDatabase();
                    ContentValues cv=new ContentValues();
                    cv.put("Account",cu.getString(0));
                    cv.put("_id",cu.getString(2));
                    cv.put("Sex",cu.getString(3));
                    cv.put("City",cu.getString(4));
                    cv.put("Position", cu.getString(5));
                    cv.put("University", cu.getString(6));
                    cv.put("College",cu.getString(7));
                    cv.put("Lecture",cu.getString(8));
                    cv.put("Preference", cu.getString(9));
                    DBWrite.insert("MyAttention", null, cv);
                    Toast toast=Toast.makeText(getApplicationContext(),"已关注",Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            });
        }

        btnExitADDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        DBRead.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addetail, menu);
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
