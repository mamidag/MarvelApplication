package com.example.marvelcharacters.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.R
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.databinding.FragmentCharacterDetailBinding
import com.example.marvelcharacters.dataresource.Status
import com.example.marvelcharacters.ui.characters.adapter.CharactersAdapter
import com.example.marvelcharacters.ui.detail.adapter.ComicAdapter
import com.example.marvelcharacters.util.keys.BundleKeys
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()

    lateinit var binding: FragmentCharacterDetailBinding

    lateinit var comicAdapter : ComicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_character_detail)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val character: Result = arguments?.get(BundleKeys.result) as Result

        binding.character = character

        binding.rvComic.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        viewModel.getCharacterDetails(character.id!!).observe(viewLifecycleOwner, {
            if (it.status == Status.SUCCESS) {
                comicAdapter = ComicAdapter(it.data!!.data.results)
                binding.rvComic.adapter = comicAdapter
            }
        })








    }
}