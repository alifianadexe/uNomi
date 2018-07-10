package alifianadexe.unomi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import alifianadexe.unomi.baseactivity.AppBaseActivity;


public class MainActivity extends AppBaseActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private Button btn_send;
    private EditText txt_send;

    DBuNomi db;
    Cursor cursor;
    UserMessage message;
    int randomNum = 1;
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

        final LinearLayoutManager mLinierLayout = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        mMessageRecycler.setLayoutManager(mLinierLayout);

        mMessageAdapter = new MessageListAdapter(messageList,this);
        mMessageRecycler.setAdapter(mMessageAdapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = new UserMessage(txt_send.getText().toString(),new User("","",MessageListAdapter.TYPE_FOR_SENDER), Calendar.getInstance().getTimeInMillis());
                messageList.add(message);

                String tanya =  txt_send.getText().toString().toLowerCase().trim();

                String query = "SELECT * FROM tbl_question WHERE question LIKE '%" + tanya +"%'";
                SQLiteDatabase database = db.getReadableDatabase();
                cursor = database.rawQuery(query,null);
                cursor.moveToFirst();

                try{
                    if(cursor.getCount() > 0){
                        if(cursor.getCount() > 1) {
                            cursor.moveToPosition(0);
                            ArrayList<String> answer = new ArrayList<String>();
                            while (cursor.moveToNext()) {
                                answer.add(cursor.getString(2));
                                Log.d("CURSOR", cursor.getString(2));
                            }
                            Random random = new Random();
                            int  total = answer.size();
                            int rand_temp  = random.nextInt(total) - 1;

                            while (randomNum == rand_temp){
                                rand_temp = random.nextInt(total) - 1;
                                Log.d("RAND TEMP", rand_temp + "");
                            }

                            randomNum = rand_temp;
                            Log.d("CURSOR", randomNum + "");

                            if(randomNum < 0){
                                randomNum = total - 1;
                            }
//                        Log.d("TOTAL", cursor.getCount() + "");
//
//                        if(randomNum == cursor.getCount()){
//                            randomNum = randomNum - 1;
//                        }


                            message = new UserMessage(answer.get(randomNum).toString(), new User("uNomi","",MessageListAdapter.TYPE_FOR_RECEIVED), Calendar.getInstance().getTimeInMillis());
                            messageList.add(message);
                            mMessageAdapter.notifyDataSetChanged();
                        }else{
                            cursor.moveToPosition(0);
                            message = new UserMessage(cursor.getString(2).toString(),new User("uNomi","",MessageListAdapter.TYPE_FOR_RECEIVED), Calendar.getInstance().getTimeInMillis());
                            messageList.add(message);
                            mMessageAdapter.notifyDataSetChanged();
                        }
                    }else{
                        message = new UserMessage("Maaf, uNomi tidak paham apa yang kamu katakan",new User("uNomi","",MessageListAdapter.TYPE_FOR_RECEIVED), Calendar.getInstance().getTimeInMillis());
                        messageList.add(message);
                        mMessageAdapter.notifyDataSetChanged();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                hideKeyboard();
                mMessageRecycler.smoothScrollToPosition(messageList.size()+1);
                Log.d("MESSAGE LIST",messageList.size()+"");
            }
        });


//        mMessageAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onItemRangeInserted(int positionStart, int itemCount) {
//                mLinierLayout.smoothScrollToPosition(mMessageRecycler,null, mMessageAdapter.getItemCount());
//            }
//        });

    }

    public void initData(){

        UserMessage message = new UserMessage("Hai,Aku uNomi! Bot AI dengan beberapa kemampuan berinteraksi dengan chat. Kalian bisa bertanya tentang apa saja denganku.",new User("uNomi","",102), Calendar.getInstance().getTimeInMillis());

        messageList.add(message);
    }

    public  void hideKeyboard(){
        txt_send.setText("");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
