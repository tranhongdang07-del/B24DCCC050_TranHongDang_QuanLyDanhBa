package com.example.quanlydanhba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewLienHe;

    private TextView txtTongLienHe;
    private TextView txtTongYeuThich;

    private Button btnThemLienHe;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLienHe = findViewById(R.id.listViewLienHe);

        txtTongLienHe = findViewById(R.id.txtTongLienHe);
        txtTongYeuThich = findViewById(R.id.txtTongYeuThich);

        btnThemLienHe = findViewById(R.id.btnThemLienHe);

        ContactManager.khoiTaoDuLieuMau();

        adapter = new ContactAdapter(
                this,
                ContactManager.danhSach
        );

        listViewLienHe.setAdapter(adapter);

        capNhatThongKe();

        listViewLienHe.setOnItemClickListener(
                (parent, view, position, id) -> {

                    Intent intent = new Intent(
                            MainActivity.this,
                            ContactDetailActivity.class
                    );

                    intent.putExtra("viTri", position);

                    startActivity(intent);
                }
        );

        btnThemLienHe.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddContactActivity.class
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
            capNhatThongKe();
        }
    }

    private void capNhatThongKe() {

        int tongLienHe = ContactManager.danhSach.size();

        int tongYeuThich = 0;

        for (Contact contact : ContactManager.danhSach) {
            if (contact.isYeuThich()) {
                tongYeuThich++;
            }
        }

        txtTongLienHe.setText(String.valueOf(tongLienHe));

        txtTongYeuThich.setText(String.valueOf(tongYeuThich));
    }
}