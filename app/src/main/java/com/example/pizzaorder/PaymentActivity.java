package com.example.pizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentActivity extends AppCompatActivity {
    RadioGroup rgpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSummary = findViewById(R.id.tvSummary);
        Intent intent = getIntent();
        String size = intent.getStringExtra("size");
        String crust = intent.getStringExtra("Crust");
        int price = intent.getIntExtra("price",0);

        tvSummary.setText("ההזמנה שלך: פיצה " + size + " ," + crust + "  נדרש לתשלום:  "  +  price);
        rgpay = findViewById(R.id.rgPay);
        int checkedId = rgpay.getCheckedRadioButtonId();

        String str;
        if (checkedId == R.id.rbCash) {
            str = "מזומן";
        }
        else {
            str ="אשראי";
        }

        Button btnPay = findViewById(R.id.btnPaym);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this,   "ההזמנה שולמה באמצעות  " + str, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}