package patrickstar.com.highalevel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
//wewwwaaaasasas
public class Rating extends AppCompatActivity {
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        ratingBar=(RatingBar)findViewById(R.id.rating1);
        Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=ratingBar.getProgress();
                float rating=ratingBar.getRating();
                float step=ratingBar.getStepSize();
                Log.i("星级评分条","step="+step+"result="+result+"rating="+rating);
                Toast.makeText(Rating.this,"你得到了"+rating+"颗星",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
