package ch.max246.imagesequence.activity.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import ch.max246.imagesequence.R;
import ch.max246.imagesequence.activity.view.ImageSeqView;


public class MainActivity extends ActionBarActivity {

    private ImageSeqView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageSeqView) findViewById(R.id.view);

        int[] sequence = {1,1,1,1,1};

        mImageView.loadAnimation(sequence);
    }



}
