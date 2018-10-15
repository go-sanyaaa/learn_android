package info.goodline.department.learnandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLinearLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnRelativeLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnFrameLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnScrollViewScreen).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnLinearLayoutScreen:
                intent = new Intent(this, LinearLayoutActivity.class);
                break;
            case R.id.btnRelativeLayoutScreen:
                intent = new Intent(this, RelativeLayoutActivity.class);
                break;
            case R.id.btnFrameLayoutScreen:
                intent = new Intent(this, FrameLayoutActivity.class);
                break;
            case R.id.btnScrollViewScreen:
                intent = new Intent(this, ScrollViewActivity.class);
                break;
        }

        if (intent == null) {
            return;
        }

        startActivity(intent);
    }
}
