package com.example.quanlydanhba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_contact, parent, false);
        }

        Contact contact = getItem(position);

        TextView txtChuCaiDau =
                convertView.findViewById(R.id.txtChuCaiDau);

        TextView txtHoTen =
                convertView.findViewById(R.id.txtHoTen);

        TextView txtSoDienThoai =
                convertView.findViewById(R.id.txtSoDienThoai);

        TextView txtNhom =
                convertView.findViewById(R.id.txtNhom);

        TextView txtYeuThich =
                convertView.findViewById(R.id.txtYeuThich);

        if (contact != null) {

            String hoTen = contact.getHoTen().trim();

            String chuCaiDau = hoTen.isEmpty()
                    ? "?"
                    : hoTen.substring(0, 1).toUpperCase();

            txtChuCaiDau.setText(chuCaiDau);
            txtHoTen.setText(contact.getHoTen());
            txtSoDienThoai.setText(contact.getSoDienThoai());
            txtNhom.setText(contact.getNhom());

            if (contact.isYeuThich()) {
                txtYeuThich.setVisibility(View.VISIBLE);
            } else {
                txtYeuThich.setVisibility(View.GONE);
            }
        }

        return convertView;
    }
}