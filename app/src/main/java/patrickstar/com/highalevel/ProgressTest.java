package patrickstar.com.highalevel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressTest extends AppCompatActivity {
    private ProgressBar horizonP;
    private ProgressBar circleP;
    private int mProgressStatus=0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        horizonP=(ProgressBar)findViewById(R.id.progressBar1);
        circleP=(ProgressBar)findViewById(R.id.progressBar2);
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if(msg.what==0x111){
                    horizonP.setProgress(mProgressStatus);
                }else {
                    Toast.makeText(ProgressTest.this,"耗时操作已经完成",Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE);
                    circleP.setVisibility(View.GONE);
                }
            }

        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgressStatus=doWork();
                    Message m=new Message();
                    if(mProgressStatus<100){
                        m.what=0x111;
                        mHandler.sendMessage(m);
                    }else{
                        m.what=0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }

            }

            private int doWork(){
                mProgressStatus+=Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgressStatus;
            }
        }).start();
    }

}
