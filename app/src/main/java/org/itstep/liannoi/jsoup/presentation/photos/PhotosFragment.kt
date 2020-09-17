package org.itstep.liannoi.jsoup.presentation.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.itstep.liannoi.jsoup.databinding.FragmentPhotosBinding

@AndroidEntryPoint
class PhotosFragment : Fragment() {

    private val viewModel: PhotosViewModel by viewModels()
    private lateinit var viewDataBinding: FragmentPhotosBinding
    private lateinit var listAdapter: PhotosAdapter
    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentPhotosBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        setupList()
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun setupList() {
        listAdapter = PhotosAdapter(viewDataBinding.viewmodel ?: return)
        viewDataBinding.photosList.adapter = listAdapter

        viewDataBinding.photosList.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Companion object
    ///////////////////////////////////////////////////////////////////////////

    companion object {
        private const val TAG: String =
            "org.itstep.liannoi.jsoup.presentation.photos.PhotosFragment"
    }
}
