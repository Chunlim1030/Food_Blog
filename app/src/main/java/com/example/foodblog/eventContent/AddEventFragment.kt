package com.example.foodblog.eventContent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.foodblog.database.EventDatabase
import com.example.foodblog.R
import com.example.foodblog.databinding.FragmentAddEventBinding

/**
 * A simple [Fragment] subclass.
 */
class AddEventFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentAddEventBinding>(inflater,
            R.layout.fragment_add_event,container,false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = EventDatabase.getInstane(application).eventDatabaseDao
        val viewModelFactory = EventContentViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val eventContentViewModel = ViewModelProviders.of(this, viewModelFactory).get(EventContentViewModel::class.java)

        binding.eventContentViewModel = eventContentViewModel
        binding.setLifecycleOwner(this)

        binding.addEventButton.setOnClickListener {
            eventAdded()
        }

        binding.addCancelButton.setOnClickListener {
            cancelAdd()
        }
        return binding.root
    }

    private fun eventAdded(){
        println("Event added to database")
        view?.findNavController()?.navigate(R.id.action_addEventFragment_to_eventFragment)
    }

    fun cancelAdd(){
        view?.findNavController()?.navigate(R.id.action_addEventFragment_to_eventFragment)
    }


}
