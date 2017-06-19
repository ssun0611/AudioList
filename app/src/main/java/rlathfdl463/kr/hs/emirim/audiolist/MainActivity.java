package rlathfdl463.kr.hs.emirim.audiolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay,butStop;
    TextView musicName;
    ProgressBar progress;
    String [] musics={"music1","music2","music3","music4","music5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list_music);
        butPlay=(Button)findViewById(R.id.but_play);
        butStop=(Button)findViewById(R.id.but_stop);
        musicName=(TextView)findViewById(R.id.music_name);
        progress=(ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,musics);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //여러개 항목중 하나만 선택 가능
        list.setItemChecked(0,true);

    }
}
