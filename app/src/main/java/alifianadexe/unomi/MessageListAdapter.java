package alifianadexe.unomi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by ditya on 5/26/18.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder>{

    private ArrayList<UserMessage> mMessageList;
    private Context context;


    public static final int VIEW_TYPE_MESSAGE_SENT = 1;
    public static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    public static final int TYPE_FOR_SENDER = 101;
    public static final int TYPE_FOR_RECEIVED = 102;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }

    public MessageListAdapter(ArrayList<UserMessage> messageList, Context context){
        this.context = context;
        mMessageList = messageList;
    }


    @Override
    public int getItemViewType(int position) {
        UserMessage message = mMessageList.get(position);
        Log.d("MessageAS", position+"");
        if (message.getSender().getUserID() == TYPE_FOR_SENDER) {
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        if(viewType == VIEW_TYPE_MESSAGE_SENT){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent,parent,false);
            return new SentMessageHolder(v);
        }else if(viewType == VIEW_TYPE_MESSAGE_RECEIVED){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received,parent,false);
            return new ReceivedMessageHolder(v);
        }
        Log.d("Message View",viewType+"");
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        UserMessage message = mMessageList.get(position);
        Log.d("MessageAdexe", position+"");
        switch (holder.getItemViewType()){
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
        }

    }

    @Override
    public int getItemCount() {
        Log.d("MessageSize", mMessageList.size()+""); return mMessageList.size();
    }


    private class SentMessageHolder extends ViewHolder {
        TextView messageText, timeText;
        private SimpleDateFormat simpledate;
        private Calendar calender;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);

        }

        void bind(UserMessage message) {
            Log.d("Messageasd",message.getMessage());
            messageText.setText(message.getMessage());

            timeText.setText(DateUtils.formatDateTime(message.getCreatedAt()));
        }
    }

    private class ReceivedMessageHolder extends  ViewHolder{
        TextView messageText, timeText, nameText;
        ImageView profileImage;

        private SimpleDateFormat simpledate;
        private Calendar calender;


        ReceivedMessageHolder(View itemView){
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
            nameText = (TextView) itemView.findViewById(R.id.text_message_name);
            profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }

        void bind(UserMessage message){

            Log.d("Messageww",message.getMessage());
            messageText.setText(message.getMessage());


            timeText.setText(DateUtils.formatDateTime(message.getCreatedAt()));
            nameText.setText("uNomi");
        }


    }


}
