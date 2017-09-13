package patrickstar.com.highalevel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  static final String[] COUNTRIES =new String[]{
            "白色鞋子","白色体恤","白色裙子","白色袜子","白色"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.auto1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        textView.setAdapter(adapter);

        Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
