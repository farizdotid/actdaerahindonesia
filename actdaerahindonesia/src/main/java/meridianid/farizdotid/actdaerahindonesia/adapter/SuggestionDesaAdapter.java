package meridianid.farizdotid.actdaerahindonesia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import meridianid.farizdotid.actdaerahindonesia.model.Desa;
import meridianid.farizdotid.actdaerahindonesia.util.JsonParse;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public class SuggestionDesaAdapter extends ArrayAdapter<String> {

    private static final String TAG = SuggestionDesaAdapter.class.getSimpleName();
    private List<String> suggestDesa;
    String namaKec;
    Context mContext;

    public SuggestionDesaAdapter(Activity context, String namaKec, String namaFilter){
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.mContext = context;
        suggestDesa = new ArrayList<>();
        this.namaKec = namaKec;
    }

    @Override
    public int getCount() {
        return suggestDesa.size();
    }

    @Nullable
    @Override
    public String getItem(int index) {
        return suggestDesa.get(index);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                JsonParse jp = new JsonParse(mContext);
                if (constraint != null){
                    List<Desa> new_suggestion = jp.getParseJsonDesa(constraint.toString());
                    suggestDesa.clear();
                    for (int i=0; i < new_suggestion.size(); i++){
                        suggestDesa.add(new_suggestion.get(i).getNama());
                    }

                    filterResults.values = suggestDesa;
                    filterResults.count = suggestDesa.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0){
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };

        return myFilter;
    }
}
