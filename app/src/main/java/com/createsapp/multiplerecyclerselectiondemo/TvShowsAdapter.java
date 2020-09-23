package com.createsapp.multiplerecyclerselectiondemo;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

public class TvShowsAdapter {
    class TvShowViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layoutTvShow;
        View viewBackground;
        RoundedImageView imageTvShow;
        TextView textName, textCreatedBy, textStory;
        RatingBar ratingBar;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
