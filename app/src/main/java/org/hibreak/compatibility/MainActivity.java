package org.hibreak.compatibility;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public final class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText(
            "HiBreak compatibility test 0.2\n\n" +
            "This screen opened successfully.\n\n" +
            "No Wi-Fi functions, permissions, receivers, " +
            "or background components."
        );
        text.setTextSize(22);
        text.setTextColor(0xff000000);
        text.setBackgroundColor(0xffffffff);

        int padding =
            (int) (24 * getResources().getDisplayMetrics().density);
        text.setPadding(padding, padding, padding, padding);

        setContentView(text);
    }
}
