package edu.csumb.quizzu;

/**
 * Created by richardisom on 2/25/16.
 */
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;
import android.database.DatabaseUtils;


    public class QuizzuSQLiteHelper extends SQLiteOpenHelper {
            // Database Name - QuizzuDB
            private static final String DATABASE_NAME = "QuizzuDB";

            // Table Name - quiz
            private static final String TABLE_NAME = "quizzu_table";

            // Columns Names of quiz Table
            public static final String COL_1 = "id";
            public static final String COL_2 = "name";
            public static final String COL_3 = "author";
            public static final String COL_4 = "question";
            public static final String COL_5 = "answer";
            public static final String COL_6 = "category";
            public static final String COL_7 = "difficulty";
            public static final String COL_8 = "created_at";

            // Database Version
            private static final int DATABASE_VERSION = 1;

            // Log TAG for debugging purpose
            private static final String TAG = "SQLiteAppLog";

            // Constructor
            public QuizzuSQLiteHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                // SQL statement to create a table called "quiz"
                String CREATE_QUIZ_TABLE = "CREATE TABLE "+ TABLE_NAME +
                        " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, "+
                        "author TEXT, "+
                        "question TEXT, "+
                        "answer TEXT, "+
                        "category TEXT, "+
                        "difficulty TEXT, "+
                        "created_at DATETIME DEFAULT CURRENT_TIMESTAMP )";

                // execute an SQL statement to create the table
                db.execSQL(CREATE_QUIZ_TABLE);
            }

            // onUpgrade() is invoked when you upgrade database
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // Drop older quiz table if existed
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

                // create fresh quiz table
                this.onCreate(db);
            }
            //---------------------------------------------------------------------

            public boolean insertQuiz(Quiz quiz){

                // get instance of writable database
                SQLiteDatabase db = this.getWritableDatabase();

                // collect values to be inserted
                ContentValues values = new ContentValues();
                values.put(COL_2, quiz.getName()); // get name
                values.put(COL_3, quiz.getAuthor()); // get author
                values.put(COL_4, quiz.getQuestion()); // get question
                values.put(COL_5, quiz.getAnswer()); // get answer
                values.put(COL_6, quiz.getCategory()); // get category
                values.put(COL_7, quiz.getDifficulty()); // get difficulty
                values.put(COL_8, quiz.getTimeStamp()); // get timestamp

                // result returns if the transaction failed
                long result = db.insert(TABLE_NAME, null, values);
                if(result == -1)
                    return false;
                else
                    return true;

            }


            public void addQuiz(Quiz quiz){
                Log.d(TAG, "addQuiz() - " + quiz.toString());
                // 1. get reference to writable DB
                SQLiteDatabase db = this.getWritableDatabase();

                // 2. create ContentValues to add key "column"/value
                ContentValues values = new ContentValues();
                values.put(COL_2, quiz.getName()); // get title
                values.put(COL_3, quiz.getAuthor()); // get author
                values.put(COL_4, quiz.getQuestion()); // get question
                values.put(COL_5, quiz.getAnswer()); // get answer
                values.put(COL_6, quiz.getCategory()); // get category
                values.put(COL_7, quiz.getDifficulty()); // get difficulty
                values.put(COL_8, quiz.getTimeStamp()); // get timestamp

                // 3. insert
                db.insert(TABLE_NAME, // table
                        null, //nullColumnHack
                        values); // key/value -> keys = column names/ values = column values

                // 4. close - release the reference of writable DB
                db.close();
            }

            // Get single quiz
            public Cursor getData(int id){
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor res =  db.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE id="+id+"", null );
                return res;
            }

            // Get all quiz from the database and put into array
            public ArrayList<Quiz> getAllQuestions() {
                ArrayList<Quiz> quizArray = new ArrayList<Quiz>();

                // 1. build the query
                String query = "SELECT  * FROM " + TABLE_NAME;

                // 2. get reference to writable DB
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(query, null);

                // 3. go over each row, build quiz and add it to list
                Quiz quiz = null;
                if (cursor.moveToFirst()) {
                    do {
                        quiz = new Quiz();
                        quiz.setId(Integer.parseInt(cursor.getString(0)));
                        quiz.setName(cursor.getString(1));
                        quiz.setAuthor(cursor.getString(2));
                        quiz.setQuestion(cursor.getString(3));
                        quiz.setAnswer(cursor.getString(4));
                        quiz.setCategory(cursor.getString(5));
                        quiz.setDifficulty(cursor.getString(6));
                        quiz.setCreated(cursor.getString(7));
                        // Add quiz to quiz
                        quizArray.add(quiz);
                    } while (cursor.moveToNext());
                }

                Log.d(TAG, "getAllQuestions() - " + quiz.toString());

                // return quiz
                return quizArray;
            }

            // Updating single quiz
            public int updateQuiz(Quiz quiz) {

                // 1. get reference to writable DB
                SQLiteDatabase db = this.getWritableDatabase();

                // 2. create ContentValues to add key "column"/value
                ContentValues values = new ContentValues();
                values.put("name", quiz.getName()); // get name
                values.put("author", quiz.getAuthor()); // get author
                values.put("question", quiz.getQuestion()); // get question
                values.put("answer", quiz.getAnswer()); // get answer
                values.put("category", quiz.getCategory()); // get category
                values.put("difficulty", quiz.getDifficulty()); // get difficulty

                // 3. updating row
                int i = db.update(TABLE_NAME, //table
                        values, // column/value
                        COL_1+" = ?", // selections
                        new String[] { String.valueOf(quiz.getId()) }); //selection args

                // 4. close
                db.close();

                return i;
            }

        public Cursor getAllQuizQuestions() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery( "SELECT * FROM " + TABLE_NAME, null );
            return res;
        }

        // Overload update quiz function that accepts quiz attributes
        public int updateQuiz(Integer id, String name, String author, String question, String answer, String category, String difficulty, String created_at) {

            // 1. get reference to writable DB
            SQLiteDatabase db = this.getWritableDatabase();

            // 2. create ContentValues to add key "column"/value
            ContentValues values = new ContentValues();
            values.put("name", name); // get name
            values.put("author", author); // get author
            values.put("question", question); // get question
            values.put("answer", answer); // get answer
            values.put("category", category); // get category
            values.put("difficulty", difficulty); // get difficulty
            values.put("created_at", created_at); // get difficulty

            // 3. updating row
            int i = db.update(TABLE_NAME, //table
                    values, // column/value
                    COL_1+" = ?", // selections
                    new String[] { String.valueOf(id) }); //selection args

            // 4. close
            db.close();

            return i;
        }

            // Deleting single quiz
            public void deleteQuiz(Quiz quiz) {

                // 1. get reference to writable DB
                SQLiteDatabase db = this.getWritableDatabase();

                // 2. delete
                db.delete(TABLE_NAME,
                        COL_1+" = ?",
                        new String[] { String.valueOf(quiz.getId()) });

                // 3. close
                db.close();

                Log.d(TAG, "deleteQuiz() - " + quiz.toString());
            }
        }