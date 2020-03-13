package com.example.studentportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_create_link.*
import kotlinx.android.synthetic.main.activity_create_link.view.*
import java.net.URL

var newLinkList = ArrayList<Link>()

class CreateLink : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_link)
        initViews()
    }

    private fun initViews() {
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
      supportActionBar?.title = "Create a Portal"
      btConfirm.setOnClickListener { onConfirmClick() }

    }

    private fun onConfirmClick() {
      val linkList = intent.getParcelableArrayListExtra<Link>(SECOND_DATA)

      val link = Link(
        etLinkName.text.toString(),
        etUrl.text.toString()
      )

      if(linkList != null){
        linkList.add(link)

        val linkIntent = Intent(this, MainActivity::class.java)
        linkIntent.putExtra(MainActivity.DATA, linkList)
        startActivity(linkIntent)
      }

      newLinkList.add(link)

      val linkIntent = Intent(this, MainActivity::class.java)
      linkIntent.putExtra(MainActivity.DATA, newLinkList)
      startActivity(linkIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
      return when (item?.itemId) {
        android.R.id.home -> {
          finish()
          true
        }
        else -> return super.onOptionsItemSelected(item)
      }
    }

  companion object{
    const val SECOND_DATA = "DATA"

  }

}
