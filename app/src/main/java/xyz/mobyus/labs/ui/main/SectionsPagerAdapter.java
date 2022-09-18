package xyz.mobyus.labs.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import xyz.mobyus.labs.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3,
            R.string.tab_text_4,
            R.string.tab_text_5,
            R.string.tab_text_6
    };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return PlaceholderFragmentOne.newInstance("", "");
            case 1:
                return PlaceholderFragmentTwo.newInstance("", "");
            case 2:
                return PlaceholderFragmentThree.newInstance("", "");
            case 3:
                return PlaceholderFragmentFour.newInstance("", "");
            case 4:
                return PlaceholderFragmentFive.newInstance("", "");
            case 5:
                return PlaceholderFragmentSix.newInstance("", "");
            default:
                return PlaceholderFragment.newInstance(0);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 6;
    }
}