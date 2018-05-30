package alifianadexe.unomi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private Button btn_send;
    private EditText txt_send;
    DBuNomi db;
    Cursor cursor;
    UserMessage message;

    ArrayList<UserMessage> messageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_message_list);

        btn_send = (Button) findViewById(R.id.button_chatbox_send);
        txt_send = (EditText) findViewById(R.id.edittext_chatbox);

        db = new DBuNomi(this);
        messageList = new ArrayList<UserMessage>();
        initData();

        mMessageRecycler = (RecyclerView) findViewById(R.id.recycler_view_message_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mMessageRecycler.setLayoutManager(layoutManager);

        mMessageAdapter = new MessageListAdapter(messageList,this);
        mMessageRecycler.setAdapter(mMessageAdapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = new UserMessage(txt_send.getText().toString(),new User("","",MessageListAdapter.TYPE_FOR_SENDER), Calendar.getInstance().getTimeInMillis());
                messageList.add(message);

                String query = "SELECT * FROM tbl_question WHERE question = '" + txt_send.getText().toString().toLowerCase() +"'";
                SQLiteDatabase database = db.getReadableDatabase();
                cursor = database.rawQuery(query,null);
                cursor.moveToFirst();

                if(cursor.getCount()>0){
                    cursor.moveToPosition(0);
                    message = new UserMessage(cursor.getString(2).toString(),new User("uNomi","",MessageListAdapter.TYPE_FOR_RECEIVED), Calendar.getInstance().getTimeInMillis());
                    messageList.add(message);
                    mMessageAdapter.notifyDataSetChanged();

                }else{
                    message = new UserMessage("Maaf , uNomi tidak paham apa yang kamu katakan",new User("uNomi","",MessageListAdapter.TYPE_FOR_RECEIVED), Calendar.getInstance().getTimeInMillis());
                    messageList.add(message);
                    mMessageAdapter.notifyDataSetChanged();

                }

                hideKeyboard();

            }
        });

    }

    public void initData(){

        UserMessage message = new UserMessage("Hai,aku uNomi! Senang berkenalan denganmu..",new User("uNomi","",102), Calendar.getInstance().getTimeInMillis());

        messageList.add(message);
    }

    public  void hideKeyboard(){
        txt_send.setText("");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
