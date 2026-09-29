    private void addPackage(LinearLayout layout, String uc, String price) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(10, 10, 10, 10);

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

        buyButton.setOnClickListener(v ->
                Toast.makeText(
                        MainActivity.this,
                        "انتخاب شد: " + uc,
                        Toast.LENGTH_SHORT
                ).show());

        row.addView(buyButton);
        layout.addView(row);
    }
}
