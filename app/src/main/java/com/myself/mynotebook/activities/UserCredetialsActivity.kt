package com.myself.mynotebook.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import com.myself.mynotebook.R
import com.myself.mynotebook.adapters.AuthenticationPagerAdapter
import com.myself.mynotebook.fragments.LoginFragment
import com.myself.mynotebook.fragments.RegistrationFragment
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import android.widget.Toast





class UserCredetialsActivity : AppCompatActivity() {
    var viewpager_usercredential:ViewPager?=null
    var rel_cre:RelativeLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uaer_credetials)

        instance();
        setUpViewPager();

    }

    private fun instance() {
        viewpager_usercredential =findViewById(R.id.viewpager_usercredential);
        rel_cre=findViewById(R.id.rel_cre);
    }
    private fun setUpViewPager() {
        var adapter: AuthenticationPagerAdapter = AuthenticationPagerAdapter(supportFragmentManager)

        adapter.addFragment(LoginFragment())
        adapter.addFragment( RegistrationFragment())

        // setting adapter to view pager.
        viewpager_usercredential?.adapter = adapter
    }
    public fun setSnackBar(ShowMsg : String)
    {
        // create an instance of the snackbar
        val snackbar = rel_cre?.let { Snackbar.make(it, "", Snackbar.LENGTH_LONG) };
        // inflate the custom_snackbar_view created previously
        val customSnackView: View = layoutInflater.inflate(com.myself.mynotebook.R.layout.custom_snackbar_view, null)
        snackbar?.setBackgroundTint(Color.TRANSPARENT)

        // now change the layout of the snackbar
        val snackbarLayout = snackbar!!.view as SnackbarLayout
        // set padding of the all corners as 0
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.setBackgroundColor(Color.TRANSPARENT)
        // register the button from the custom_snackbar_view layout file
        val btn_dismiss: AppCompatButton = customSnackView.findViewById(R.id.btn_dismiss)
        val txt_msg: AppCompatTextView =customSnackView.findViewById(R.id.txt_msg)
        txt_msg.setText(ShowMsg)

        // now handle the same button with onClickListener
        btn_dismiss.setOnClickListener(View.OnClickListener {
            //Toast.makeText(applicationContext, "Redirecting to Website", Toast.LENGTH_SHORT).show()
            snackbar.dismiss()
        })

        // add the custom snack bar layout to snackbar layout
        snackbarLayout.addView(customSnackView, 0);
        snackbar.show();


    }


}