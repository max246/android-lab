package ch.max246.imagesequence.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import ch.max246.imagesequence.R;
import ch.max246.imagesequence.view.ImageSeqView;


public class MainActivity extends ActionBarActivity {

    private ImageSeqView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageSeqView) findViewById(R.id.view);

        int[] sequence = {R.drawable.image0,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4
                ,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9
                ,R.drawable.image10,R.drawable.image11,R.drawable.image12,R.drawable.image13,R.drawable.image14
                ,R.drawable.image15,R.drawable.image16,R.drawable.image17,R.drawable.image18,R.drawable.image19
                ,R.drawable.image20,R.drawable.image21};

        mImageView.loadAnimation(sequence);
    }



}
