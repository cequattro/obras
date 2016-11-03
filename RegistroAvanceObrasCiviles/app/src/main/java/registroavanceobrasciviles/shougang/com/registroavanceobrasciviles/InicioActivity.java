package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class InicioActivity extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 5000;

    protected  boolean mbActive;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mProgressBar = (ProgressBar)findViewById(R.id.pbCarga);

        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < TIMER_RUNTIME)){
                        sleep(200);
                        if(mbActive){
                            waited +=200;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent login = new Intent(InicioActivity.this,LoginActivity.class);
                    startActivity(login);
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timePassed){
        if(null != mProgressBar){
            final int progress = mProgressBar.getMax() * timePassed / TIMER_RUNTIME;
            mProgressBar.setProgress(progress);
        }
    }
}