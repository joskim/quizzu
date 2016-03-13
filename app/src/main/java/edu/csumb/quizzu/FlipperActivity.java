package edu.csumb.quizzu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;
/**
 * Created by richardisom on 3/13/16.
 */
public class FlipperActivity extends Activity{


    ViewFlipper viewFlipper;
    Button Next, Previous;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper);

        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01);

        Next = (Button) findViewById(R.id.Next);
        Previous = (Button) findViewById(R.id.Previous);

        Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                viewFlipper.showNext();
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                viewFlipper.showPrevious();
            }
        });
    }
}