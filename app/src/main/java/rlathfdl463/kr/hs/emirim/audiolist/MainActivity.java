package rlathfdl463.kr.hs.emirim.audiolist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button butPlay,butStop,butPause;
    TextView musicName;
    ProgressBar progress;
    String [] musics={"music1","music2","music3","music4","music5"};
    int [] musicResIds={R.raw.music1,R.raw.music2,R.raw.music3,R.raw.music4,R.raw.music5};
    int selectedMusicId;
    MediaPlayer mediaPlayer;
    boolean selectePauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list_music);
        butPlay=(Button)findViewById(R.id.but_play);
        butStop=(Button)findViewById(R.id.but_stop);
        butPause=(Button)findViewById(R.id.but_pause);
        musicName=(TextView)findViewById(R.id.music_name);
        progress=(ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,musics);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //여러개 항목중 하나만 선택 가능
        list.setItemChecked(0,true);
        selectedMusicId=musicResIds[0];
        mediaPlayer=mediaPlayer.create(this,selectedMusicId);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mediaPlayer.stop();
                selectedMusicId=musicResIds[position];
                progress.setVisibility(View.INVISIBLE);

            }
        });

        butPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectePauseButton) {
                    mediaPlayer.start();
                    selectePauseButton=false;
                }
                else
                    mediaPlayer=MediaPlayer.create(MainActivity.this,selectedMusicId);
                mediaPlayer.start();
                progress.setVisibility(View.VISIBLE);
            }
        });

        butStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                progress.setVisibility(View.INVISIBLE);
            }
        });

        butPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectePauseButton=true;
                mediaPlayer.pause();
                progress.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}