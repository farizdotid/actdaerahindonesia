package meridianid.farizdotid.actdaerahindonesia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import meridianid.farizdotid.actdaerahindonesia.model.Kecamatan;
import meridianid.farizdotid.actdaerahindonesia.util.JsonParse;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public class SuggestionKecAdapter extends ArrayAdapter<String> {

    private static final String TAG = SuggestionKecAdapter.class.getSimpleName();
    private List<String> suggestKec;
    String namaKab;
    Context mContext;

    public SuggestionKecAdapter(Activity context, String namaKab, String namaFilter){
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.mContext = context;
        suggestKec = new ArrayList<>();
        this.namaKab = namaKab;
    }

    @Override
    public int getCount() {
        return suggestKec.size();
    }

    @Nullable
    @Override
    public String getItem(int index) {
        return suggestKec.get(index);
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
                    List<Kecamatan> new_suggestion = jp.getParseJsonKec(constraint.toString());
                    suggestKec.clear();
                    for (int i=0; i<new_suggestion.size(); i++){
                        suggestKec.add(new_suggestion.get(i).getNama());
                    }

                    filterResults.values = suggestKec;
                    filterResults.count = suggestKec.size();
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
