package example.hello.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    SharedPreferences preferences;
    ListView listView;

    EditText editText;
    Button buttonSend;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.et_message);
        buttonSend = (Button) findViewById(R.id.btn_send);

        arrayAdapter = new ArrayAdapter<String>(
                ChatActivity.this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChatActivity.this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                arrayAdapter.add(message);
                editText.setText("");
            }
        });

        preferences = getSharedPreferences("pref", MODE_PRIVATE);
        String nickname = preferences.getString("key", "Not found");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == 200) {
            String nickname = data.getStringExtra("nickname");
        }
    }
}















