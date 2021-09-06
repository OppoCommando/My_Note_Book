package com.myself.mynotebook.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.myself.mynotebook.R
import com.myself.mynotebook.activities.MainActivity
import com.myself.mynotebook.activities.UserCredetialsActivity

class LoginFragment : Fragment() {

     var btn_login: AppCompatButton?=null
     var mActivity: UserCredetialsActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        instance(view)
        clickEvent()
        return view;
    }

    private fun clickEvent() {
        btn_login?.setOnClickListener(View.OnClickListener {
            var clickintent = Intent(mActivity, MainActivity::class.java)
            startActivity(clickintent)
        //mActivity?.setSnackBar("Login Failed")
        })
    }

    private fun instance(view: View) {
        btn_login=view.findViewById(R.id.btn_login)
        mActivity = activity as UserCredetialsActivity?
    }


}