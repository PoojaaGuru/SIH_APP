package com.example.sih_app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private ArrayList<Object> items = new ArrayList<>();
    private final int HEADER_ITEM = 0;
    private final int CHILD_ITEM = 1;
    private Context context;
    private List<Object> filteredItems = new ArrayList<>();
    ItemsAdapter(Context context)
    {
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View headerView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_header, viewGroup, false);
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_items, viewGroup, false);
        switch (i) {
            case HEADER_ITEM: return new HeaderViewHolder(headerView);
            case CHILD_ITEM: return new ItemViewHolder(childView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case HEADER_ITEM:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
                headerViewHolder.headerTitle.setText(items.get(i).toString());
                break;

            case CHILD_ITEM:
                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                ItemsData data = (ItemsData) items.get(i);
                Picasso.with(context).load(data.image).placeholder(R.drawable.ic_image_place_holder).into(itemViewHolder.image);
                itemViewHolder.description.setText(data.itemName +"\n" + data.description + "\n" + data.price);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void setList(ArrayList<Object> items) {
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof String)
        {
            return HEADER_ITEM;
        }
        else
        {
            return CHILD_ITEM;
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder
    {
        TextView headerTitle;
        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.header_title);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView description;
        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, WayFindingActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredItems = items;
                } else {
                    List<Object> filteredList = new ArrayList<>();
                    List<Object> allCategory = new ArrayList<>();
                    List<Object> availableCategory = new ArrayList<>();
                    for (Object row : items) {
                        if(row instanceof String)
                        {
                            filteredList.add(row);
                            allCategory.add(row);
                        }
                        else
                        {
                            if (((ItemsData) row).getItemName().toLowerCase().contains(charString.toLowerCase()) || ((ItemsData) row).getDescription().toString().contains(charSequence)) {
                                filteredList.add(row);
                                availableCategory.add(((ItemsData) row).getCategory());
                            }
                        }
                    }
                    allCategory.removeAll(availableCategory);
                    filteredList.removeAll(allCategory);
                    filteredItems = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                items = (ArrayList<Object>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
