package com.example.moviemagic.ui.favourite;

import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.moviemagic.R;
import com.example.moviemagic.core.SimpleListViewHolder;
import com.example.moviemagic.data.MovieData;

import java.util.List;

/**
 * A simple adapter for fav list
 */

public class FavMoviesAdapter extends RecyclerView.Adapter<SimpleListViewHolder>
        implements SimpleListViewHolder.OnHolderClickListener {

    @VisibleForTesting
    OnInstanceSelectedListener listener;

    @VisibleForTesting
    List<MovieData> data;

    /**
     * Adapter creation
     *
     * @param listener
     */
    public FavMoviesAdapter(OnInstanceSelectedListener listener) {
        this.listener = listener;
    }

    /**
     * sets the data in the adapter and calls @notifyDataSetChanged
     *
     * @param favMovies
     */
    public void setData(List<MovieData> favMovies) {
        this.data = favMovies;
        notifyDataSetChanged();
    }

    @Override
    public SimpleListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleListViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_holder_simple_list, parent, false), this);
    }

    @Override
    public void onBindViewHolder(SimpleListViewHolder holder, int position) {
        holder.setData(data.get(position).getDisplayTitle(), position, false, null);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onClick(int position) {
        listener.onItemSelected(this.data.get(position));

    }

    /**
     * Listener callback to communicate that the user has selected an item in the list.
     */
    public interface OnInstanceSelectedListener {

        /**
         * called when the users click on the link thats not the edit team item.
         **/
        void onItemSelected(MovieData movieData);

    }

}
