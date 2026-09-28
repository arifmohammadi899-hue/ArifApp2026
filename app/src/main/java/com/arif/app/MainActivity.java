package com.arif.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        TextView t = new TextView(this);
        t.setText("Arif App\nفروشگاه دیجیتال\n\nBackend: متصل و آماده");
        t.setTextSize(22);
        t.setPadding(40, 100, 40, 40);

        setContentView(t);
    }
}
