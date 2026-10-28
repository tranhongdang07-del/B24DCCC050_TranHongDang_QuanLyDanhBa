package com.example.quanlydanhba;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    private EditText edtHoTen;
    private EditText edtSoDienThoai;
    private EditText edtGhiChu;

    private Spinner spnNhom;

    private RadioGroup rgGioiTinh;

    private CheckBox cbYeuThich;

    private Button btnLuuLienHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtGhiChu = findViewById(R.id.edtGhiChu);

        spnNhom = findViewById(R.id.spnNhom);

        rgGioiTinh = findViewById(R.id.rgGioiTinh);

        cbYeuThich = findViewById(R.id.cbYeuThich);

        btnLuuLienHe = findViewById(R.id.btnLuuLienHe);

        String[] cacNhom = {
                "Gia đình",
                "Bạn bè",
                "Công việc",
                "Khác"
        };

        ArrayAdapter<String> adapterNhom =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        cacNhom
                );

        adapterNhom.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spnNhom.setAdapter(adapterNhom);

        btnLuuLienHe.setOnClickListener(v -> luuLienHe());
    }

    private void luuLienHe() {

        String hoTen = edtHoTen.getText().toString().trim();

        String soDienThoai =
                edtSoDienThoai.getText().toString().trim();

        String ghiChu =
                edtGhiChu.getText().toString().trim();

        if (hoTen.isEmpty()) {
            edtHoTen.setError("Vui lòng nhập họ tên");
            edtHoTen.requestFocus();
            return;
        }

        if (!soDienThoai.matches("0[0-9]{9}")) {
            edtSoDienThoai.setError(
                    "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"
            );

            edtSoDienThoai.requestFocus();
            return;
        }

        for (Contact contact : ContactManager.danhSach) {

            if (contact.getSoDienThoai().equals(soDienThoai)) {

                edtSoDienThoai.setError(
                        "Số điện thoại đã tồn tại trong danh bạ"
                );

                edtSoDienThoai.requestFocus();
                return;
            }
        }

        String nhom = spnNhom.getSelectedItem().toString();

        int idGioiTinh = rgGioiTinh.getCheckedRadioButtonId();

        String gioiTinh;

        if (idGioiTinh == R.id.rbNam) {
            gioiTinh = "Nam";
        } else if (idGioiTinh == R.id.rbNu) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }

        boolean yeuThich = cbYeuThich.isChecked();

        Contact contactMoi = new Contact(
                hoTen,
                soDienThoai,
                nhom,
                gioiTinh,
                yeuThich,
                ghiChu
        );

        ContactManager.danhSach.add(contactMoi);

        Toast.makeText(
                this,
                "Thêm liên hệ thành công",
                Toast.LENGTH_SHORT
        ).show();

        finish();
    }
}