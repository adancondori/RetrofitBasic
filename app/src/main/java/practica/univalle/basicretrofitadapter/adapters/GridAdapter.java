package practica.univalle.basicretrofitadapter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import practica.univalle.basicretrofitadapter.R;
import practica.univalle.basicretrofitadapter.models.Items;

public class GridAdapter extends ArrayAdapter {
    ArrayList<Items> list;
    int custom_layout_id;

    public GridAdapter(@NonNull Context context, int resource, ArrayList list) {
        super(context, resource);
        custom_layout_id = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            // getting reference to the main layout and initializing
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(custom_layout_id, null);
        }

        // initializing the imageview and textview and setting data
        ImageView imageView = view.findViewById(R.id.imgPhoto);
        TextView textView = view.findViewById(R.id.txtTitle);

        // get the item using the  position param
        Items item = list.get(position);

        imageView.setImageResource(item.getImage_id());
        textView.setText(item.getText());
        return view;
    }
}
