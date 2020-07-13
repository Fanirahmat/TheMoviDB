package com.mfanir.themovidb.Main

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mfanir.themovidb.BuildConfig.URL_POSTER
import com.mfanir.themovidb.Model.Movie
import com.mfanir.themovidb.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(
    private val result: List<Movie>,
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        ContextAdapter = parent.context
        return MovieViewHolder(MovieUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(result[position], listener, ContextAdapter)
    }

    override fun getItemCount(): Int = result.size

}

    class MovieUI : AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>) : View {
            return with(ui) {
                linearLayout{
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(5)
                    orientation = LinearLayout.VERTICAL

                    imageView{
                        id = R.id.movie_poster
                    }.lparams{
                        height = dip(250)
                        width = wrapContent
                    }

                    textView {
                        id = R.id.movie_title
                        textSize = 16f
                    }.lparams{
                        margin = dip(16)
                    }


                }
            }
        }
    }

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val moviePoster : ImageView = view.find(R.id.movie_poster)
        private val movieTitle : TextView = view.find(R.id.movie_title)

        fun bindItem(movies: Movie, listener: (Movie) -> Unit, ContextAdapter: Context) {
            //Picasso.get().load(URL_POSTER + movies.poster).into(moviePoster)
            Glide.with(ContextAdapter).load(URL_POSTER + movies.poster).into(moviePoster);
            movieTitle.text = movies.title
            Log.i("Gambar", "url = "+ URL_POSTER + movies.poster)

            moviePoster.onClick {
                listener(movies)
            }
        }
    }