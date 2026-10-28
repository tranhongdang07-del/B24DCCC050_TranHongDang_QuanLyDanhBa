package com.example.quanlydanhba;

import java.util.ArrayList;

public class ContactManager {

    public static final ArrayList<Contact> danhSach =
            new ArrayList<>();

    private static boolean daKhoiTao = false;

    public static void khoiTaoDuLieuMau() {

        if (daKhoiTao) {
            return;
        }

        danhSach.add(new Contact(
                "Nguyễn Văn An",
                "0901234567",
                "Bạn bè",
                "Nam",
                false,
                ""
        ));

        danhSach.add(new Contact(
                "Trần Thị Bình",
                "0912345678",
                "Gia đình",
                "Nữ",
                true,
                "Gọi khi rảnh"
        ));

        danhSach.add(new Contact(
                "Lê Minh Châu",
                "0987654321",
                "Công việc",
                "Nữ",
                false,
                "Đồng nghiệp"
        ));

        daKhoiTao = true;
    }
}