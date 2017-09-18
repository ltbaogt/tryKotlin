package vn.ryutb.trykotlin.module.signin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.adapter.MovieAdapter
import vn.ryutb.trykotlin.model.Movie
import vn.ryutb.trykotlin.module.base.BaseActivity

class MovieListActivity : BaseActivity(), MovieMvp.View {
    override fun setIsLastPage(isLp: Boolean) {
        this.isLastPage = true
    }

    override fun setIsLoading(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    companion object {
        val PAGE_SIZE = 19
    }

    // region Member Variables
    private var isLastPage = false
    private var currentPage = 0
    private var isLoading = false
    private lateinit var mPresenter: MovieListPresenter
    private lateinit var mMovieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MovieListPresenter()
        mPresenter.attach(this, null)
        loadMoreItems()

        val layoutManager = LinearLayoutManager(this)
        mMovieAdapter = MovieAdapter()
        mMovieAdapter.addFooter()
        movieList.layoutManager = layoutManager
        movieList.adapter = mMovieAdapter
        movieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val slInfo: String = "visibleItemCount=$visibleItemCount, totalItemCount=$totalItemCount, firstVisibleItemPosition=$firstVisibleItemPosition"
                Log.d("Baolt", slInfo)
                scrolledInfo.text = slInfo

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= PAGE_SIZE) {
                        loadMoreItems()
                    }
                }
            }
        })
    }

    private fun loadMoreItems() {
        Log.d("Baolt", "loadMoreItems")
        isLoading = true
        currentPage += 1
        Toast.makeText(applicationContext, "loadMoreItems for page=$currentPage", Toast.LENGTH_SHORT).show()
        mPresenter.loadData(currentPage)

    }

    //    fun MovieListActivity.setText(text: String) {
//        tv01.text = text
//    }
    //    override fun setCount(withCount: Int) {
//
//        this.setText(withCount.toString())
//        tv01.setOnClickListener { v: View? -> Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show() }
//    }
//
//    override fun setTitle(withTitle: String) {
//        (findViewById(R.id.tv01) as TextView).text = withTitle
//    }

    override fun setMovieList(withList: List<Movie>) {
        mMovieAdapter.addList(withList)
    }
}
