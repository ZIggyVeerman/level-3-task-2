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

  /**
   * Initialize the Ui of the activity
   */
  private fun initViews() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.title = "Create a Portal"
    // set click listener on the confirm button
    btConfirm.setOnClickListener { onConfirmClick() }

  }

  /**
   * handle the on confirm click
   */
  private fun onConfirmClick() {
    // get the linked list from the previous activity
    val linkList = intent.getParcelableArrayListExtra<Link>(SECOND_DATA)
    // create new link
    val link = Link(
      etLinkName.text.toString(),
      etUrl.text.toString()
    )
    // check if the linked listed received from the main activity contains a linkedlist
    if (linkList != null) {
      linkList.add(link)
      // pas the linked list to the main activity intent
      val linkIntent = Intent(this, MainActivity::class.java)
      linkIntent.putExtra(MainActivity.DATA, linkList)
      startActivity(linkIntent)
    }
    // if linkedlist was null fill the new linkedlist
    newLinkList.add(link)
    // and pass that to the main activity
    val linkIntent = Intent(this, MainActivity::class.java)
    linkIntent.putExtra(MainActivity.DATA, newLinkList)
    startActivity(linkIntent)
  }

  /**
   * handle the click on the back button
   */
  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    return when (item?.itemId) {
      android.R.id.home -> {
        finish()
        true
      }
      else -> return super.onOptionsItemSelected(item)
    }
  }

  companion object {
    const val SECOND_DATA = "DATA"

  }

}
