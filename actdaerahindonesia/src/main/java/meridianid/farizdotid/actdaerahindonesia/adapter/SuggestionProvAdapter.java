package meridianid.farizdotid.actdaerahindonesia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import meridianid.farizdotid.actdaerahindonesia.model.Provinsi;
import meridianid.farizdotid.actdaerahindonesia.util.JsonParse;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public class SuggestionProvAdapter extends ArrayAdapter<String> {

    private static final String TAG = SuggestionProvAdapter.class.getSimpleName();
    private List<String> suggesProv;
    Context mContext;

    public SuggestionProvAdapter(Activity context, String nameFilter){
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.mContext = context;
        suggesProv = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return suggesProv.size();
    }

    @Nullable
    @Override
    public String getItem(int index) {
        return suggesProv.get(index);
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
                    List<Provinsi> new_suggestion = jp.getParseJsonProv(constraint.toString());
                    suggesProv.clear();
                    for (int i=0; i < new_suggestion.size(); i++){
                        suggesProv.add(new_suggestion.get(i).getNama());
                    }
                    filterResults.values = suggesProv;
                    filterResults.count = suggesProv.size();
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
