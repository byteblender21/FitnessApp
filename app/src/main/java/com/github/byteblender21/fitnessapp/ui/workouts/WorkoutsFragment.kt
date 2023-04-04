package com.github.byteblender21.fitnessapp.ui.workouts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.byteblender21.fitnessapp.R
import com.github.byteblender21.fitnessapp.databinding.FragmentWorkoutsBinding

class WorkoutsFragment : Fragment() {

    private lateinit var adapter: ArrayAdapter<String>
    private var _binding: FragmentWorkoutsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val workoutsViewModel =
            ViewModelProvider(this)[WorkoutsViewModel::class.java]

        _binding = FragmentWorkoutsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val context = this.requireContext()

        val workoutListView: ListView = binding.workoutListView
        adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayOf(
            "Upper Body",
            "Lower Body",
        ))

        workoutListView.setOnItemClickListener { parent, view, position, id ->
            val element = adapter.getItem(position) // The item that was clicked
            val intent = Intent(context, WorkoutDetailActivity::class.java)
            startActivity(intent)
        }

        workoutsViewModel.text.observe(viewLifecycleOwner) {
            workoutListView.adapter = adapter
//            workoutListView. = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}