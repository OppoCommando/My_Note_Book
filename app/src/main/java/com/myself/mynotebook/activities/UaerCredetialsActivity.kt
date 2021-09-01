package com.myself.mynotebook.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.myself.mynotebook.R
import com.myself.mynotebook.fragments.LoginFragment
import com.myself.mynotebook.fragments.RegistrationFragment

class UaerCredetialsActivity : AppCompatActivity() {
    var viewpager_usercredential:ViewPager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uaer_credetials)

        instance();
        setUpViewPager();

    }

    private fun instance() {
        viewpager_usercredential =findViewById(R.id.viewpager_usercredential);
    }
    private fun setUpViewPager() {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(LoginFragment())
        adapter.addFragment( RegistrationFragment())

        // setting adapter to view pager.
        viewpager_usercredential?.adapter = adapter
    }

    // This "ViewPagerAdapter" class overrides functions which are
    // necessary to get information about which item is selected
    // by user, what is title for selected item and so on.*/
    class ViewPagerAdapter: FragmentPagerAdapter {
        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        private final var fragmentList: ArrayList<Fragment> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fragmentList.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }
}