package com.example.quanlydanhba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edtTenDangNhap;
    private EditText edtMatKhau;
    private TextView txtThongBao;
    private Button btnDangNhap;

    private final String TAI_KHOAN = "admin";
    private final String MAT_KHAU = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTenDangNhap =
                findViewById(R.id.edtTenDangNhap);

        edtMatKhau =
                findViewById(R.id.edtMatKhau);

        txtThongBao =
                findViewById(R.id.txtThongBao);

        btnDangNhap =
                findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(v -> xuLyDangNhap());
    }

    private void xuLyDangNhap() {

        String tenDangNhap =
                edtTenDangNhap.getText().toString().trim();

        String matKhau =
                edtMatKhau.getText().toString().trim();

        if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {

            txtThongBao.setText(
                    "Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu"
            );

            return;
        }

        if (tenDangNhap.equals(TAI_KHOAN)
                && matKhau.equals(MAT_KHAU)) {

            ContactManager.khoiTaoDuLieuMau();

            Intent intent = new Intent(
                    LoginActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();

        } else {

            txtThongBao.setText(
                    "Sai tên đăng nhập hoặc mật khẩu"
            );
        }
    }
}