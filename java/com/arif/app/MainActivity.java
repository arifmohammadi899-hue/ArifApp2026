package com.arif.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float v) {
        return (int)(v * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView title(String text, float size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(Color.WHITE);
        t.setGravity(Gravity.CENTER);
        t.setTypeface(null, Typeface.BOLD);
        t.setPadding(dp(15), dp(20), dp(15), dp(20));
        return t;
    }

    private Button product(final String name, final String price) {
        Button b = new Button(this);

        b.setText(name + "\n" + price + " تومان");
        b.setTextSize(16);
        b.setTextColor(Color.WHITE);
        b.setAllCaps(false);
        b.setBackgroundColor(Color.rgb(25, 118, 210));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, dp(75));

        p.setMargins(dp(12), dp(6), dp(12), dp(6));
        b.setLayoutParams(p);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "سفارش انتخاب شد:\n" +
                        name + "\n" +
                        price + " تومان",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        return b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(0, dp(20), 0, dp(30));
        main.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView header = title("عارف آپ\nفروشگاه دیجیتال", 27);
        header.setBackgroundColor(Color.rgb(18, 52, 86));
        main.addView(header);

        TextView section = new TextView(this);
        section.setText("محصولات و خدمات");
        section.setTextSize(22);
        section.setTextColor(Color.DKGRAY);
        section.setTypeface(null, Typeface.BOLD);
        section.setGravity(Gravity.CENTER);
        section.setPadding(10, dp(20), 10, dp(10));
        main.addView(section);

        main.addView(product("🎮 پابجی — 60 UC", "190"));
        main.addView(product("🎮 پابجی — 120 UC", "320"));
        main.addView(product("🎮 پابجی — 320 UC", "قیمت به‌زودی"));
        main.addView(product("🎮 پابجی — 385 UC", "قیمت به‌زودی"));
        main.addView(product("🎮 پابجی — 720 UC", "1900"));
        main.addView(product("🎮 پابجی — 1800 UC", "4100"));
        main.addView(product("🎮 پابجی — 8100 UC", "18900"));

        main.addView(product("💎 الماس IMO", "انتخاب بسته"));
        main.addView(product("💎 جم کلش", "انتخاب بسته"));
        main.addView(product("🪙 سکه تیک‌تاک", "انتخاب بسته"));
        main.addView(product("📱 شارژ سیم‌کارت ایران", "انتخاب مبلغ"));
        main.addView(product("🇦🇫 شارژ سیم‌کارت افغانستان", "انتخاب مبلغ"));
        main.addView(product("🌐 بسته اینترنت افغانستان", "انتخاب بسته"));

        TextView footer = new TextView(this);
        footer.setText("Arif App\nپرداخت و ثبت سفارش");
        footer.setTextSize(17);
        footer.setTextColor(Color.DKGRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(10, dp(30), 10, dp(20));
        main.addView(footer);

        scroll.addView(main);
        setContentView(scroll);
    }
}
