package com.mfanir.themovidb.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mfanir.themovidb.BuildConfig.URL_POSTER
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var title: String = ""
    private var poster: String = ""
    private var overview: String = ""

    private lateinit var iv_poster: ImageView
    private lateinit var tv_title: TextView
    private lateinit var tv_overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            iv_poster = imageView{
            }.lparams{
                width = dip(250)
                gravity = Gravity.CENTER
                height = dip(250)
            }

            tv_title = textView()
            tv_overview = textView()

        }

        val i = intent
        title = i.getStringExtra("TITLE")
        overview = i.getStringExtra("OVERVIEW")
        poster = i.getStringExtra("POSTER")

        tv_title.text = title
        tv_overview.text = overview
        Glide.with(this).load(URL_POSTER + poster).into(iv_poster)
    }
}
