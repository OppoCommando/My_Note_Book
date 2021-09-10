package com.myself.mynotebook.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
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
    var userCheckPhone:String?=null
    var userPassword:String?=null
    var isPasswordHide:Boolean?=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        instance(view)
        clickEvent()
        textChangeEvent()
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

        show_pass_btn?.setOnClickListener(View.OnClickListener {
            setPasswordHideShow()
        })
    }

    private fun setPasswordHideShow() {
        if(isPasswordHide==false){
            et_password?.transformationMethod = PasswordTransformationMethod.getInstance()
            isPasswordHide=true
            show_pass_btn?.setImageResource(R.drawable.ic_eye_line)
        }
        else {
            et_password?.transformationMethod = HideReturnsTransformationMethod.getInstance()
            show_pass_btn?.setImageResource(R.drawable.ic_eye_off_line)
            isPasswordHide=false
        }
    }

    private fun textChangeEvent() {


        var count:Int=0
           et_phone?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setEditBackGraund("Phone")

            }

            override fun afterTextChanged(changePassword: Editable?) {

            }

        })
           et_password?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                userCheckPhone=et_phone?.text.toString()
                if(userCheckPhone?.length==0 && count==0){
                    setErrorMsg("Phone","Enter Phone Number!!!")
                    count = 1
                }
            }

            override fun onTextChanged(changePassword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setEditBackGraund("Password")
                if(changePassword?.length==0){

                    show_pass_btn?.visibility=View.GONE
                    //count = 0
                }
                else{
                    show_pass_btn?.visibility=View.VISIBLE
                }
            }

            override fun afterTextChanged(changePassword: Editable?) {

            }

        })
    }

    private fun doUserLogin() {
        userPassword=et_password?.text.toString()
        userPhone=et_phone?.text.toString()
      var isOkay = validFields()
      if(isOkay==true){
          var clickintent = Intent(mActivity, MainActivity::class.java)
          startActivity(clickintent)
      }
    }

    private fun validFields(): Boolean? {
        var isCheck:Boolean=false
        if(userPhone?.isEmpty() == true && userPassword?.isEmpty()==true){
            setErrorMsg("All","Enter All Fields!!!")
        }
       else if(userPhone?.isEmpty() == true){
            setErrorMsg("Phone","Enter Phone Number!!!")
        }
        else if(userPhone?.length!=10 ){

            setErrorMsg("Phone","Enter Valid Phone Number!!!")
        }
        else if(userPassword?.isEmpty() == true){
            setErrorMsg("Password","Enter Password!!!")
        }
        else{
            isCheck=true
        }






       return isCheck
    }

    private fun setErrorMsg(indicator:String,Msg:String){
        if(indicator == "Phone"){
            mActivity?.setSnackBar(Msg)
            et_phone?.setBackgroundResource(R.drawable.et_errorcustom)
        }
        else if(indicator=="Password"){
            mActivity?.setSnackBar(Msg)
            et_password?.setBackgroundResource(R.drawable.et_errorcustom)
        }
        else{
            mActivity?.setSnackBar(Msg)
            et_phone?.setBackgroundResource(R.drawable.et_errorcustom)
            et_password?.setBackgroundResource(R.drawable.et_errorcustom)
        }
    }
    private fun setEditBackGraund(indicator:String){
        if(indicator=="Phone"){
            et_phone?.setBackgroundResource(R.drawable.et_custom)
        }
        else if(indicator=="Password"){
            et_password?.setBackgroundResource(R.drawable.et_custom)
        }
        else{
            et_phone?.setBackgroundResource(R.drawable.et_custom)
            et_password?.setBackgroundResource(R.drawable.et_custom)
        }

    }

}