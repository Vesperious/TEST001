package vaio.test001;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditPersonalData extends AppCompatActivity {

    private Spinner EditUniversitySpinner=null;
    private ArrayAdapter<CharSequence> ArrayUniversityAdapter=null;
    private Spinner EditCollegeSpinner=null;
    private ArrayAdapter<CharSequence> ArrayCollegeAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_data);
        //setContentView(R.layout.activity_edit_personal_data);
        final TextView EditMyAccount;
        final EditText EditMyName;
        final EditText EditMyPassword;
        final EditText EditMySex;
        final EditText EditMyCity;
        final EditText EditMyPreference;
        Button btnExitEditMyData;
        Button btnSaveMyData;
        final DB db=new DB(this);
        SQLiteDatabase DBRead=db.getReadableDatabase();
        Cursor cu =DBRead.query("user", null, null, null, null, null, null);
        cu.moveToNext();
            final String MyAccount=cu.getString(0);
            final String MyPassword=cu.getString(1);
            final String MyName = cu.getString(2);
            final String MySex= cu.getString(3);
            final String MyCity = cu.getString(4);
            final String MyUniversity = cu.getString(5);
            final String MyCollege = cu.getString(6);
            final String MyPreference = cu.getString(7);
            EditMyAccount=(TextView)findViewById(R.id.EditMyAccount);
            EditMyPassword=(EditText)findViewById(R.id.EditMyPassword);
            EditMyName=(EditText)findViewById(R.id.EditMyName);
            EditMySex=(EditText)findViewById(R.id.EditMySex);
            EditMyCity=(EditText)findViewById(R.id.EditMyCity);
            EditMyPreference=(EditText)findViewById(R.id.EditMyPreference);
            btnExitEditMyData= (Button) findViewById(R.id.ExitEditMyData);
            btnSaveMyData= (Button) findViewById(R.id.SaveMyData);

            EditMyAccount.setText(MyAccount);
            EditMyPassword.setText(MyPassword);
            EditMyName.setText(MyName);
            EditMyCity.setText(MyCity);
            EditMySex.setText(MySex);
            EditMyPreference.setText(MyPreference);

        EditUniversitySpinner=(Spinner)findViewById(R.id.UniversitySpinner);
        ArrayUniversityAdapter=ArrayUniversityAdapter.createFromResource(this,R.array.ArrayUniversity,R.layout.support_simple_spinner_dropdown_item);
        EditUniversitySpinner.setAdapter(ArrayUniversityAdapter);
        EditCollegeSpinner=(Spinner)findViewById(R.id.CollegeSpinner);
        ArrayCollegeAdapter=ArrayCollegeAdapter.createFromResource(this,R.array.ArrayCollege,R.layout.support_simple_spinner_dropdown_item);
        EditCollegeSpinner.setAdapter(ArrayCollegeAdapter);
        btnExitEditMyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSaveMyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase DBWrite = db.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("Account", EditMyAccount.getText().toString());
                cv.put("Password", EditMyPassword.getText().toString());
                cv.put("Name", EditMyName.getText().toString());
                cv.put("Sex", EditMySex.getText().toString());
                cv.put("City",EditMyCity.getText().toString());
                cv.put("University",MyUniversity);
                cv.put("College", MyCollege);
                cv.put("Preference",EditMyPreference.getText().toString());
                DBWrite.delete("user", "Account=?", new String[]{MyAccount});
                DBWrite.insert("user", null, cv);
                DBWrite.close();
                finish();
            }
        });
        DBRead.close();
        db.close();
        cu.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_personal_data, menu);
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
