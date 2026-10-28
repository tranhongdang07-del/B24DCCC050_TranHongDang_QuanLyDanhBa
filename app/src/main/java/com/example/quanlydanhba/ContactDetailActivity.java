package com.example.quanlydanhba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView txtChiTietHoTen;
    private TextView txtChiTietSoDienThoai;
    private TextView txtChiTietNhom;
    private TextView txtChiTietGioiTinh;
    private TextView txtChiTietGhiChu;
    private TextView txtChiTietYeuThich;

    private Button btnGoiDien;
    private Button btnQuayLai;
    private Button btnXoaLienHe;

    private int viTri;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        txtChiTietHoTen = findViewById(R.id.txtChiTietHoTen);
        txtChiTietSoDienThoai =
                findViewById(R.id.txtChiTietSoDienThoai);

        txtChiTietNhom = findViewById(R.id.txtChiTietNhom);
        txtChiTietGioiTinh = findViewById(R.id.txtChiTietGioiTinh);
        txtChiTietGhiChu = findViewById(R.id.txtChiTietGhiChu);
        txtChiTietYeuThich =
                findViewById(R.id.txtChiTietYeuThich);

        btnGoiDien = findViewById(R.id.btnGoiDien);
        btnQuayLai = findViewById(R.id.btnQuayLai);
        btnXoaLienHe = findViewById(R.id.btnXoaLienHe);

        viTri = getIntent().getIntExtra("viTri", -1);

        if (viTri < 0
                || viTri >= ContactManager.danhSach.size()) {

            Toast.makeText(
                    this,
                    "Không tìm thấy liên hệ",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
            return;
        }

        contact = ContactManager.danhSach.get(viTri);

        hienThiChiTiet();

        btnQuayLai.setOnClickListener(v -> finish());

        btnGoiDien.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + contact.getSoDienThoai())
            );

            startActivity(intent);
        });

        btnXoaLienHe.setOnClickListener(v -> {

            ContactManager.danhSach.remove(contact);

            Toast.makeText(
                    this,
                    "Đã xóa liên hệ",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        });
    }

    private void hienThiChiTiet() {

        txtChiTietHoTen.setText(contact.getHoTen());

        txtChiTietSoDienThoai.setText(
                contact.getSoDienThoai()
        );

        txtChiTietNhom.setText(
                "Nhóm: " + contact.getNhom()
        );

        txtChiTietGioiTinh.setText(
                "Giới tính: " + contact.getGioiTinh()
        );

        String ghiChu = contact.getGhiChu();

        if (ghiChu == null || ghiChu.trim().isEmpty()) {
            ghiChu = "Không có ghi chú";
        }

        txtChiTietGhiChu.setText("Ghi chú: " + ghiChu);

        txtChiTietYeuThich.setText(
                contact.isYeuThich()
                        ? "★ Liên hệ yêu thích"
                        : "☆ Chưa yêu thích"
        );
    }
}