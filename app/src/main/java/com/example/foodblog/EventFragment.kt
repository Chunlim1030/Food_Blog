package com.example.foodblog


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.foodblog.databinding.FragmentEventBinding
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 */
class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEventBinding>(inflater,
            R.layout.fragment_event,container,false)
        //The complete onClickListener with Navigation
        binding.addButton.setOnClickListener {
            addEvent()
        }

        binding.logoutButton.setOnClickListener {
            logoutEmail()
        }
        return binding.root
    }

    fun addEvent(){
        view?.findNavController()?.navigate(R.id.action_eventFragment_to_addEventFragment)
    }

    fun logoutEmail(){
        FirebaseAuth.getInstance().signOut()
        view?.findNavController()?.navigate(R.id.action_eventFragment_to_signupFragment)

    }


}
