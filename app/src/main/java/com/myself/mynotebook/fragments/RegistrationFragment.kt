package com.myself.mynotebook.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.myself.mynotebook.R
import com.myself.mynotebook.activities.MainActivity
import com.myself.mynotebook.activities.UserCredetialsActivity


class RegistrationFragment : Fragment() {

    var btn_register: AppCompatButton?=null
    var mActivity: UserCredetialsActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registration, container, false)
        instance(view)
        clickEvent()
        return view;
    }

    private fun instance(view: View) {
        btn_register=view.findViewById(R.id.btn_register)
        mActivity = activity as UserCredetialsActivity?
    }

    private fun clickEvent() {
        btn_register?.setOnClickListener(View.OnClickListener {
            var clickintent = Intent(mActivity, MainActivity::class.java)
            startActivity(clickintent)
            //mActivity?.setSnackBar("Login Failed")
        })
    }

}