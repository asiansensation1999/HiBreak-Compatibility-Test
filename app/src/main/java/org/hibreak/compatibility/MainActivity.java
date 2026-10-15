package org.hibreak.compatibility;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public final class MainActivity extends Activity {
    private LinearLayout page;
    private TextView message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(0xffffffff);

        page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        int padding = dp(24);
        page.setPadding(padding, padding, padding, padding);
        scroll.addView(page);

        addText("HIBREAK CONNECTIONS", 16);
        addText("Wi-Fi", 32);
        addText("Version 0.3 — screen preview", 18);

        addText("\nCURRENT CONNECTION", 16);
        addText("Wi-Fi access is not enabled in this test.", 20);

        addButton("Add a network", "Network entry will be added later.");
        addButton("Scan nearby networks", "Scanning is disabled in this test.");

        addText("\nNEARBY NETWORKS", 16);
        addText("No scan has been performed.", 18);

        addText("\nMANAGED BY THIS APP", 16);
        addText("No networks have been added.", 18);

        message = addText(
            "\nThis version only displays a screen. " +
            "It requests no permissions and makes no Wi-Fi calls.",
            18
        );

        setContentView(scroll);
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    private TextView addText(String value, int size) {
        TextView text = new TextView(this);
        text.setText(value);
        text.setTextSize(size);
        text.setTextColor(0xff000000);
        text.setPadding(0, dp(8), 0, dp(8));
        page.addView(text);
        return text;
    }

    private void addButton(String label, String explanation) {
        Button button = new Button(this);
        button.setText(label);
        button.setAllCaps(false);
        button.setOnClickListener(view -> message.setText(explanation));
        page.addView(button);
    }
}
