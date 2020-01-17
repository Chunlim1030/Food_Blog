package com.example.foodblog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.foodblog.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_signup.*

/**
 * A simple [Fragment] subclass.
 */
class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSignupBinding>(inflater,
            R.layout.fragment_signup,container,false)
        binding.signupButton.setOnClickListener {
            createEmailId()
        }
//        binding.loginButton.setOnClickListener {
//            moveNextPage()
//        }
        binding.loginButton.setOnClickListener {
            loginEmail()
        }

        return binding.root
    }

    fun createEmailId() {
        var email = email_editText.text.toString()
        var password = password_editText.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                println("Sign up Success")
            }
        }
    }

    fun loginEmail(){
        var email = email_editText.text.toString()
        var password = password_editText.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                println("Login Success")
                view?.findNavController()?.navigate(R.id.action_signupFragment_to_eventFragment)
            }else{
                println("Login Fail")
                view?.findNavController()?.navigate(R.id.action_signupFragment_self)
            }
        }
    }

//    fun moveNextPage(){
//        var currentUser = FirebaseAuth.getInstance().currentUser
//        if(currentUser != null) {
//            view?.findNavController()?.navigate(R.id.action_signupFragment_to_eventFragment)
//        }else{
//            println("Login Failed")
//        }
//    }

}
