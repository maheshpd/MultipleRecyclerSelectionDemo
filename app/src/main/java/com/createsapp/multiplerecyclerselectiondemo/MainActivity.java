package com.createsapp.multiplerecyclerselectiondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TVShowsListener {

    private Button buttonAddToWatchlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView tvShowsRecyclerView = findViewById(R.id.tvShowsRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchList);

        List<TvShow> tvShow = new ArrayList<>();

        TvShow the100 = new TvShow();
        the100.image = R.drawable.the_100;
        the100.name = "The 100";
        the100.rating = 5f;
        the100.createdBy = "Jason Rothenberg";
        the100.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earth.";
        tvShow.add(the100);

        TvShow lostInSpace = new TvShow();
        lostInSpace.image = R.drawable.lost_in_space;
        lostInSpace.name = "Lost in Space";
        lostInSpace.rating = 4.5f;
        lostInSpace.createdBy = "Irwin Allen, Malt Sazama, Burk Sharpless";
        lostInSpace.story = "Set 30 years in the future, colonization in space is now a reality, and the Robinson family is among those.";
        tvShow.add(lostInSpace);

        TvShow vikings = new TvShow();
        vikings.image = R.drawable.vikings;
        vikings.name = "Vikings";
        vikings.rating = 4.5f;
        vikings.createdBy = "Michael Hirst";
        vikings.story = "The advent of a Ragnar Lothbrok: the greatest hero of his age.";
        tvShow.add(vikings);

        TvShow travelers = new TvShow();
        travelers.image = R.drawable.travellers;
        travelers.name = "Travelers";
        travelers.rating = 4f;
        travelers.createdBy = "Brad Wright";
        travelers.story = "Hundreds of years from now, the last surviving humans discover the means of sending consciousness back through time";
        tvShow.add(travelers);

        TvShow futureMan = new TvShow();
        futureMan.image = R.drawable.future_man;
        futureMan.name = "Future Man";
        futureMan.rating = 4f;
        futureMan.createdBy = "Kyle Hunter, Howard Overman, Ariel Shaffir";
        futureMan.story = "Josh Futurman, a janitor by day and a gamer by night, is recruited by mysterious visitors to travel through time.";
        tvShow.add(futureMan);

        TvShow breakingBad = new TvShow();
        breakingBad.image = R.drawable.breaking_bad;
        breakingBad.name = "Breaking Bad";
        breakingBad.rating = 4f;
        breakingBad.createdBy = "Vince Gilligan";
        breakingBad.story = "When chemistry teacher walter White is diagnosed with Stage III cancer and given only two years to live.";
        tvShow.add(breakingBad);

        TvShow theExpanse = new TvShow();
        theExpanse.image = R.drawable.the_expanse;
        theExpanse.name = "The Expanse";
        theExpanse.rating = 4f;
        theExpanse.createdBy = "Mark Fergus, Hawk Ostby";
        theExpanse.story = "Two hundred years in the future, in a fully colonized solar system, police detective Josephus Muller (Thomas Jane).";
        tvShow.add(theExpanse);

        TvShow theWalkingDead = new TvShow();
        theWalkingDead.image = R.drawable.the_walking_dead;
        theWalkingDead.name = "The Walking Dead";
        theWalkingDead.rating = 4.5f;
        theWalkingDead.createdBy = "Frank Darabont, Angela Kang";
        theWalkingDead.story = "Sheriff Deputy Rick Grimes gets shot and falls into a coma, When awoken he finds himself in a Zombie Apocalypse.";
        tvShow.add(theWalkingDead);

        TvShow theRain = new TvShow();
        theRain.image = R.drawable.the_rain;
        theRain.name = "The Rain";
        theRain.rating = 4f;
        theRain.createdBy = "Jannik Tai Mosholt, Christian Potalivo, Esben Toft Jacobsen";
        theRain.story = "The world as we know it has ended. Six years after a brutal virus carried by the rain wiped out almost all.";
        tvShow.add(theRain);

        TvShow lost = new TvShow();
        lost.image = R.drawable.lost;
        lost.name = "Lost";
        lost.rating = 4.5f;
        lost.createdBy = "J.J. Abrams, Jeffrey Lieher, Damon Lindelof";
        lost.story = "The past, present, and future lives of surving Oceanic flight 815 passengers are dramatically intertwined as a fight.";
        tvShow.add(lost);

        final TvShowsAdapter tvShowsAdapter = new TvShowsAdapter(tvShow, this);
        tvShowsRecyclerView.setAdapter(tvShowsAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Following is the list of selected items in recycler View;
                List<TvShow> selectedTvShow = tvShowsAdapter.getSelectedTvShow();

                StringBuilder tvShowName = new StringBuilder();
                for (int i = 0; i < selectedTvShow.size(); i++) {
                    if (i == 0) {
                        tvShowName.append(selectedTvShow.get(i).name);
                    } else {
                        tvShowName.append("\n").append(selectedTvShow.get(i).name);
                    }
                }

                Toast.makeText(MainActivity.this, tvShowName.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTvShowAction(Boolean isSelected) {
        if (isSelected) {
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}