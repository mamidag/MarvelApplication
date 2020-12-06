package com.example.marvelcharacters.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.R
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.databinding.FragmentCharactersBinding
import com.example.marvelcharacters.listener.IListener
import com.example.marvelcharacters.ui.characters.adapter.CharactersAdapter
import com.example.marvelcharacters.util.extensions.navigateSafe
import com.example.marvelcharacters.util.keys.BundleKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import androidx.lifecycle.lifecycleScope as scope

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CharactersFragment : Fragment(), IListener<Result> {

    private val charactersViewModel: CharactersViewModel by viewModels()
    lateinit var binding: FragmentCharactersBinding

    lateinit var characterAdapter: CharactersAdapter

    var lastFirstVisiblePosition = -1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_characters, container, false)

        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_characters)

        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        characterAdapter = CharactersAdapter(this)


        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = characterAdapter
        }



        characterAdapter.addLoadStateListener { loadState ->
            binding.rvCharacters.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
        }

        scope.launch {
            charactersViewModel.character.collectLatest {
                characterAdapter.submitData(it)
            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onPause() {
        super.onPause()
        lastFirstVisiblePosition =
            (binding.rvCharacters.getLayoutManager() as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

    }

    override fun onResume() {
        super.onResume()
        (binding.rvCharacters.getLayoutManager() as LinearLayoutManager).scrollToPosition(
            lastFirstVisiblePosition
        )

    }

    override fun onClick(result: Result) {
        val bundle = Bundle().apply {
            putParcelable(BundleKeys.result, result)
        }
        navigateSafe(R.id.action_charactersFragment_to_characterDetailFragment, bundle)
    }
}