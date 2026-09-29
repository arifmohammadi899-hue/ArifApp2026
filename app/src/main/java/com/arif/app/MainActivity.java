package com.arif.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(30, 40, 30, 30);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("Arif App");
        title.setTextSize(28);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        mainLayout.addView(title,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView subtitle = new TextView(this);
        subtitle.setText("فروشگاه یو سی پابجی");
        subtitle.setTextSize(18);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 20, 0, 30);

        mainLayout.addView(subtitle);

        addPackage(mainLayout, "60 UC", "230,000 تومان");
        addPackage(mainLayout, "120 UC", "450,000 تومان");
        addPackage(mainLayout, "325 UC", "1,150,000 تومان");
        addPackage(mainLayout, "385 UC", "1,355,555 تومان");
        addPackage(mainLayout, "720 UC", "2,530,000 تومان");
        addPackage(mainLayout, "1800 UC", "5,730,000 تومان");
        addPackage(mainLayout, "8100 UC", "22,500,000 تومان");
        addPackage(mainLayout, "16200 UC", "45,000,000 تومان");

        setContentView(mainLayout);
    }

    private void addPackage(LinearLayout layout, String uc, String price) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(10, 10, 10, 10);

        TextView packageText = new TextView(this);
        packageText.setText(uc + " - " + price);
        packageText.setTextSize(17);
        packageText.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams textParams =
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1);

        row.addView(packageText, textParams);

        Button buyButton = new Button(this);
        buyButton.setText("خرید");

        buyButton.setOnClickListener(v -> {

            EditText playerIdInput = new EditText(MainActivity.this);
            playerIdInput.setHint("Player ID پابجی");
            playerIdInput.setInputType(2);

            LinearLayout dialogLayout =
                    new LinearLayout(MainActivity.this);

            dialogLayout.setOrientation(LinearLayout.VERTICAL);
            dialogLayout.setPadding(50, 20, 50, 10);

            TextView selectedPackage =
                    new TextView(MainActivity.this);

            selectedPackage.setText(
                    "بسته انتخابی: " + uc +
                    "\nقیمت: " + price
            );

            selectedPackage.setTextSize(17);

            dialogLayout.addView(selectedPackage);
            dialogLayout.addView(playerIdInput);

            new android.app.AlertDialog.Builder(
                    MainActivity.this)

                    .setTitle("ثبت سفارش")

                    .setView(dialogLayout)

                    .setPositiveButton(
                            "ادامه",
                            (dialog, which) -> {

                        String playerId =
                                playerIdInput
                                .getText()
                                .toString()
                                .trim();
