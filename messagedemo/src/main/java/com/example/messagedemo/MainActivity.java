package com.example.messagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private List<Msg> msgList = new ArrayList<>();
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private MsgAdapter mMsgAdapter;
    private Button mButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        mButton = (Button) findViewById(R.id.bt);
        mRecyclerView = (RecyclerView) findViewById(R.id.msg_rec);
        mEditText = (EditText) findViewById(R.id.edt);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mMsgAdapter = new MsgAdapter(msgList);
        mRecyclerView.setAdapter(mMsgAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    mMsgAdapter.notifyItemInserted(msgList.size()-1);
                    mRecyclerView.scrollToPosition(msgList.size()-1);
                    mEditText.setText("");
                }
        
            }
        });
    }
    
    private void initMsg() {
        Msg msg1 = new Msg("heelo guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("hey",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3  = new Msg("come on ",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
