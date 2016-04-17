package vaio.test001;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;

public class ADDBList extends ListActivity{

    private SimpleCursorAdapter adapter;
    Button btnSearch;
    EditText EditSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addblist);
        btnSearch= (Button) findViewById(R.id.btnSearch);
        EditSearch= (EditText) findViewById(R.id.EditSearch);
        DB db=new DB(this);
        SQLiteDatabase DBRead=db.getReadableDatabase();
        Cursor cu =DBRead.query("ADDB", null, null, null, null, null, null);
        adapter=new SimpleCursorAdapter(this,R.layout.activity_addbcell,cu,new String[]{"_id","University","College","Position"},new int[]{R.id.ADName,R.id.ADUniversity,R.id.ADCollege,R.id.ADPosition});
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c=adapter.getCursor();
                c.moveToPosition(position);
                String ADID=c.getString(0);
                Intent i=new Intent(ADDBList.this,ADDetail.class);
                i.putExtra("ADID",ADID);
                startActivity(i);
                //System.out.println(ADID);

            }
        });
        /*getListView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i=new Intent(ADDBList.this,MainActivity.class);
                //startActivity(i);
            }
        });*/
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addblist, menu);
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
