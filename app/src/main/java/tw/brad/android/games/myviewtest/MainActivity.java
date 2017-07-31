package tw.brad.android.games.myviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView)findViewById(R.id.myView);
    }


    public void clearMyView(View view){
        myView.clear();
    }
    public void undoMyView(View view){
        myView.undo();
    }
    public void redoMyView(View view){
        myView.redo();
    }
}
