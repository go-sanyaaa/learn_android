package info.goodline.department.learnandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
        findViewById(R.id.btnUserList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUser();
            }
        });
    }

    private void showUser() {
        Intent intent =  new Intent(this, UserListActivity.class);
        startActivity(intent);
    }
}
