package idv.star.homework3_2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView tvWriting;
    private Button btStart;
    private Button btEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }
    public void findViews(){
        tvWriting=(TextView)findViewById(R.id.tvWriting);
        btStart=(Button)findViewById(R.id.btStart);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvWriting.startAnimation(getAnimationSet());



            }
        });
        btEnd=(Button)findViewById(R.id.btEnd);
        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvWriting.clearAnimation();
                tvWriting.setText("文字君");


            }
        });





    }
    private RotateAnimation getRotateAnimation(){
        RotateAnimation rotateAnimation=new RotateAnimation(
                0,360,
                Animation.RELATIVE_TO_SELF,0.3f,
                Animation.RELATIVE_TO_SELF,0.3f
        );
        rotateAnimation.setDuration(600);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        return rotateAnimation;
    }
    private TranslateAnimation getTranslateAnimation(){
        View parentView=(View)tvWriting.getParent();
        float distance = parentView.getWidth() - parentView.getPaddingLeft() -
                parentView.getPaddingRight() - tvWriting.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0,distance,0,distance+150);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        return translateAnimation;



    }



    private AnimationSet getAnimationSet() {

        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = getRotateAnimation();

        animationSet.addAnimation(rotateAnimation);
        TranslateAnimation translateAnimation = getTranslateAnimation();
        animationSet.addAnimation(translateAnimation);


        return animationSet;
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
