package edu.csumb.quizzu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView;
import android.database.Cursor;



/**
 * Created by richardisom on 3/12/16.
 */
public class QuizLanding extends Activity  {
    public final static String KEY_EXTRA_QUIZ_ID = "KEY_EXTRA_QUIZ_ID";
    private ListView listView;
    QuizzuSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_landing);


        Button button = (Button) findViewById(R.id.button_showData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizLanding.this, QuizLanding.class);
                intent.putExtra(KEY_EXTRA_QUIZ_ID, 0);
                startActivity(intent);
            }
        });

        dbHelper = new QuizzuSQLiteHelper(this);

        final Cursor cursor = dbHelper.getAllQuizQuestions();
        String [] columns = new String[] {
                QuizzuSQLiteHelper.COL_2,
                QuizzuSQLiteHelper.COL_3,
                QuizzuSQLiteHelper.COL_4,
                QuizzuSQLiteHelper.COL_5,
                QuizzuSQLiteHelper.COL_6,
                QuizzuSQLiteHelper.COL_7,
                QuizzuSQLiteHelper.COL_8
        };
        int [] widgets = new int[] {
                R.id.questionList,
        };

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.activity_quiz_landing,
                cursor, columns, widgets, 0);
        listView = (ListView)findViewById(R.id.questionList);
        listView.setAdapter(cursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView listView, View view,
                                    int position, long id) {
                Cursor itemCursor = (Cursor) QuizLanding.this.listView.getItemAtPosition(position);
                int indexId = itemCursor.getInt(itemCursor.getColumnIndex(QuizzuSQLiteHelper.COL_1));
                Intent intent = new Intent(getApplicationContext(), QuizLanding.class);
                intent.putExtra(KEY_EXTRA_QUIZ_ID, indexId);
                startActivity(intent);
            }
        });

    }

}