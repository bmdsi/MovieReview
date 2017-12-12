package com.example.moviemagic.core;

import android.support.annotation.ColorRes;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviemagic.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * This is a simple, universal view holder that should serve well in a lot of different places in the app.
 */
public class SimpleListViewHolder extends BaseViewHolder {

    private OnHolderClickListener onHolderClickListener;
    @VisibleForTesting
    int position;

    @BindView(R.id.simple_list_arrowImageView)
    View arrowView;

    @BindView(R.id.thumb)
    ImageView thumbImageView;

    @BindView(R.id.simple_list_TitleTextView)
    TextView textView;

    public SimpleListViewHolder(View itemView, OnHolderClickListener onHolderClickListener) {
        super(itemView);
        this.onHolderClickListener = onHolderClickListener;
    }

    /**
     * Set the data on the Simple List View Holder. The arrow will be hidden from the view.
     *
     * @param title    Text to display
     * @param position Position in the RecyclerView. Used for the click.
     */
    public void setData(String title, int position, boolean showArrow, String imageUrl) {
        textView.setText(title);
        this.position = position;
        if (showArrow) {
            arrowView.setVisibility(View.VISIBLE);
        } else {
            arrowView.setVisibility(View.INVISIBLE);
        }
        if (imageUrl != null) {
            Glide.with(thumbImageView.getContext()).load(imageUrl)
                    .fitCenter()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(thumbImageView);
        }

    }

    @OnClick(R.id.simple_list_rootView)
    void onRootViewClick() {
        if (onHolderClickListener != null) {
            onHolderClickListener.onClick(position);
        }
    }

    /**
     * Set the color of the text on this holder.
     *
     * @param colorResource -
     */
    public void setTextColor(@ColorRes int colorResource) {
        textView.setTextColor(textView.getContext().getResources().getColor(colorResource));
    }

    /**
     * Set the background color of this holder.
     *
     * @param colorResource -
     */
    public void setBackgroundColor(@ColorRes int colorResource) {
        itemView.setBackgroundColor(itemView.getContext().getResources().getColor(colorResource));
    }

    public OnHolderClickListener getOnHolderClickListener() {
        return onHolderClickListener;
    }

    /**
     * On Click listener for when the root of the view holder is clicked.
     */
    public interface OnHolderClickListener {
        void onClick(int position);
    }
}
