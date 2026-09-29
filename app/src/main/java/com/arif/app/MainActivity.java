package com.arif.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
        mainLayout.setPadding(25, 35, 25, 30);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("Arif App");
        title.setTextSize(30);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        mainLayout.addView(title,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView subtitle = new TextView(this);
        subtitle.setText("فروشگاه یو سی پابجی");
        subtitle.setTextSize(19);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 15, 0, 25);

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

    private void addPackage(
            LinearLayout layout,
            String uc,
            String price) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(10, 8, 10, 8);

        TextView packageText = new TextView(this);
        packageText.setText(uc + "  -  " + price);
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
            dialogLayout.setPadding(40, 10, 40, 10);

            TextView selectedPackage =
                    new TextView(MainActivity.this);

            selectedPackage.setText(
                    "بسته انتخابی: " + uc +
                    "\nقیمت: " + price
            );

            selectedPackage.setTextSize(17);
            selectedPackage.setTypeface(null, Typeface.BOLD);

            dialogLayout.addView(selectedPackage);
            dialogLayout.addView(playerIdInput);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("ثبت سفارش")
                    .setView(dialogLayout)
                    .setPositiveButton("ادامه", (dialog, which) -> {

                        String playerId =
                                playerIdInput.getText().toString().trim();

                        if (playerId.isEmpty()) {

                            Toast.makeText(
                                    MainActivity.this,
                                    "لطفاً Player ID را وارد کنید",
                                    Toast.LENGTH_SHORT
                            ).show();

                        } else {

                            showPaymentDialog(
                                    uc,
                                    price,
                                    playerId
                            );
                        }
                    })
                    .setNegativeButton("لغو", null)
                    .show();
        });

        row.addView(buyButton);
        layout.addView(row);
    }

    private void showPaymentDialog(
            String uc,
            String price,
            String playerId) {

        LinearLayout paymentLayout =
                new LinearLayout(MainActivity.this);

        paymentLayout.setOrientation(LinearLayout.VERTICAL);
        paymentLayout.setPadding(35, 10, 35, 10);

        TextView orderInfo = new TextView(MainActivity.this);

        orderInfo.setText(
                "🛒 سفارش شما\n\n" +
                "بسته: " + uc + "\n" +
                "قیمت: " + price + "\n" +
                "Player ID: " + playerId
        );

        orderInfo.setTextSize(17);
        orderInfo.setTypeface(null, Typeface.BOLD);
        orderInfo.setPadding(0, 0, 0, 20);

        paymentLayout.addView(orderInfo);

        TextView paymentTitle = new TextView(MainActivity.this);

        paymentTitle.setText("💳 اطلاعات پرداخت");
        paymentTitle.setTextSize(20);
        paymentTitle.setTypeface(null, Typeface.BOLD);
        paymentTitle.setGravity(Gravity.CENTER);
        paymentTitle.setPadding(0, 10, 0, 15);

        paymentLayout.addView(paymentTitle);

        TextView maskan = new TextView(MainActivity.this);

        maskan.setText(
                "🏦 بانک مسکن\n\n" +
                "شماره کارت:\n" +
                "6280 2315 3296 4342\n\n" +
                "شماره شبا:\n" +
                "IR13 0140 0400 0411 0022 9212 02"
        );

        maskan.setTextSize(16);
        maskan.setPadding(15, 15, 15, 15);

        paymentLayout.addView(maskan);

        Button copyMaskan = new Button(MainActivity.this);
        copyMaskan.setText("کپی شماره کارت بانک مسکن");

        copyMaskan.setOnClickListener(v -> {

            ClipboardManager clipboard =
                    (ClipboardManager) getSystemService(
                            Context.CLIPBOARD_SERVICE);

            ClipData clip =
                    ClipData.newPlainText(
                            "شماره کارت",
                            "6280231532964342");

            clipboard.setPrimaryClip(clip);

            Toast.makeText(
                    MainActivity.this,
                    "شماره کارت کپی شد",
                    Toast.LENGTH_SHORT
            ).show();
        });

        paymentLayout.addView(copyMaskan);

        TextView shahr = new TextView(MainActivity.this);

        shahr.setText(
                "🏦 بانک شهر\n\n" +
                "شماره کارت:\n" +
                "5047 0611 5607 2601\n\n" +
                "شماره شبا:\n" +
                "IR20 0610 0000 0400 1023 4095 22"
        );

        shahr.setTextSize(16);
        shahr.setPadding(15, 20, 15, 15);

        paymentLayout.addView(shahr);

        Button copyShahr = new Button(MainActivity.this);
        copyShahr.setText("کپی شماره کارت بانک شهر");

        copyShahr.setOnClickListener(v -> {

            ClipboardManager clipboard =
                    (ClipboardManager) getSystemService(
                            Context.CLIPBOARD_SERVICE);

            ClipData clip =
                    ClipData.newPlainText(
                            "شماره کارت",
                            "5047061156072601");

            clipboard.setPrimaryClip(clip);

            Toast.makeText(
                    MainActivity.this,
                    "شماره کارت کپی شد",
                    Toast.LENGTH_SHORT
            ).show();
        });

        paymentLayout.addView(copyShahr);

        TextView instruction = new TextView(MainActivity.this);

        instruction.setText(
                "\nبعد از انتقال وجه، شماره پیگیری پرداخت را وارد کنید:"
        );

        instruction.setTextSize(16);

        paymentLayout.addView(instruction);

        EditText trackingInput = new EditText(MainActivity.this);
        trackingInput.setHint("شماره پیگیری پرداخت");
        trackingInput.setInputType(2);

        paymentLayout.addView(trackingInput);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("پرداخت سفارش")
                .setView(paymentLayout)
                .setPositiveButton(
                        "پرداخت کردم",
                        (dialog, which) -> {

                            String tracking =
                                    trackingInput.getText()
                                            .toString()
                                            .trim();

                            if (tracking.isEmpty()) {

                                Toast.makeText(
                                        MainActivity.this,
                                        "لطفاً شماره پیگیری را وارد کنید",
                                        Toast.LENGTH_LONG
                                ).show();

                            } else {

                                Toast.makeText(
                                        MainActivity.this,
                                        "سفارش ثبت شد\n" +
                                        "بسته: " + uc + "\n" +
                                        "Player ID: " + playerId + "\n" +
                                        "شماره پیگیری: " + tracking,
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        })
                .setNegativeButton("بستن", null)
                .show();
    }
}
