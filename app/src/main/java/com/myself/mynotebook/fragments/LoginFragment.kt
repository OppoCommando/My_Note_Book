package com.myself.mynotebook.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.myself.mynotebook.R
import com.myself.mynotebook.activities.MainActivity
import com.myself.mynotebook.activities.UserCredetialsActivity

class LoginFragment : Fragment() {

    var btn_login: AppCompatButton?=null
    var mActivity: UserCredetialsActivity? = null
    var et_phone: AppCompatEditText?=null
    var et_password: AppCompatEditText?=null
    var show_pass_btn: AppCompatImageView?=null
    var userPhone:String?=null
    var userPassword:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        instance(view)
        clickEvent()
       // textChangeEvent()
        return view;
    }



    private fun instance(view: View) {
        btn_login=view.findViewById(R.id.btn_login)
        et_phone=view.findViewById(R.id.et_phone)
        et_password=view.findViewById(R.id.et_password)
        show_pass_btn=view.findViewById(R.id.show_pass_btn)

        mActivity = activity as UserCredetialsActivity?
    }

    private fun clickEvent() {
        btn_login?.setOnClickListener(View.OnClickListener {
            /*var clickintent = Intent(mActivity, MainActivity::class.java)
            startActivity(clickintent)
            //mActivity?.setSnackBar("Login Failed")*/

            doUserLogin()
        })
    }

  /*  private fun textChangeEvent() {
        et_password?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(changePassword?.length==0){
                    show_pass_btn?.visibility=View.GONE
                }
                else{
                    show_pass_btn?.visibility=View.VISIBLE
                }
            }

            override fun afterTextChanged(changePassword: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }*/

    private fun doUserLogin() {
      userPhone=et_phone?.text.toString()
      userPassword=et_password?.text.toString()
      var isOkay = validFields()
      if(isOkay==true){
          var clickintent = Intent(mActivity, MainActivity::class.java)
          startActivity(clickintent)
      }
    }

    private fun validFields(): Boolean? {
        var isCheck:Boolean=false
        if(userPhone?.isEmpty() == true && userPassword?.isEmpty()==true){
            mActivity?.setSnackBar("Enter All Fields!!!")
            et_phone?.setBackgroundResource(R.drawable.et_errorcustom)
            et_password?.setBackgroundResource(R.drawable.et_errorcustom)
        }
       else if(userPhone?.isEmpty() == true){
            mActivity?.setSnackBar("Enter Phone Number")
            et_phone?.setBackgroundResource(R.drawable.et_errorcustom)
        }
        else if(userPhone?.length!=10 ){
            mActivity?.setSnackBar("Enter Valid Phone Number")
            et_phone?.setBackgroundResource(R.drawable.et_errorcustom)
        }
        else if(userPassword?.isEmpty() == true){
            mActivity?.setSnackBar("Enter Password")
            et_password?.setBackgroundResource(R.drawable.et_errorcustom)
        }
        else{
            isCheck=true
        }






       return isCheck
    }

}