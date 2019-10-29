package edu.temple.lab_7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookInterface {

    boolean singlePane;
    BookDetailsFragment detailsFragment;
    ViewPagerFragment viewPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePane = findViewById(R.id.container_2) == null;
        detailsFragment = new BookDetailsFragment();
        BookListFragment listFragment = new BookListFragment();
        viewPagerFragment = new ViewPagerFragment();

        if(!singlePane){
            addFragment(listFragment, R.id.container_1);
            addFragment(detailsFragment, R.id.container_2);
        } else {
            addFragment(viewPagerFragment, R.id.container_3);
        }
    }

    public void addFragment(Fragment fragment, int id) {
        getSupportFragmentManager().
                beginTransaction().
                replace(id, fragment).
                addToBackStack(null).
                commit();
    }

    @Override
    public void bookSelected(String book) {
        detailsFragment.displayBook(book);
    }
}