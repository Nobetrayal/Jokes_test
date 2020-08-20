package ru.makskol.jokes.ui.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_jokes.*
import ru.makskol.jokes.R
import ru.makskol.jokes.adapters.JokesAdapter
import ru.makskol.jokes.ui.webapi.setActivityTitle


class JokesFragment : Fragment() {

    private lateinit var jokesViewModel: JokesViewModel
    private lateinit var recyclerViewJokes: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setActivityTitle(getString(R.string.jokes_fragment_title))
        val root = inflater.inflate(R.layout.fragment_jokes, container, false)
        val adapter = JokesAdapter()
        recyclerViewJokes = root.findViewById(R.id.RecyclerViewJokes)
        recyclerViewJokes.adapter = adapter

        jokesViewModel = ViewModelProvider(this).get(JokesViewModel::class.java)

        jokesViewModel.jokes.observe(viewLifecycleOwner, Observer {
            adapter.jokes = it
        })

        val buttonReload: Button = root.findViewById(R.id.buttonReload)
        buttonReload.setOnClickListener {
            val countString = editTextCount.text.toString()

            jokesViewModel.loadJokes(countString)
        }

        return root
    }


}