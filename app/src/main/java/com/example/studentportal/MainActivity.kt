package com.example.studentportal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsIntent.COLOR_SCHEME_SYSTEM
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

  private val links : ArrayList<Link> = arrayListOf()
  private val linkAdapter = LinkAdapter(links) { linkItem : Link -> linkItemClicked(linkItem)}

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    fab.setOnClickListener {
      val createLinkActivityIntent = Intent(this, CreateLink::class.java)
      createLinkActivityIntent.putExtra(CreateLink.SECOND_DATA, links)
      startActivity(createLinkActivityIntent)
    }

    initViews()
  }

  private fun initViews() {
    rvLinks.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
    rvLinks.adapter =  linkAdapter

    val intent = intent

    if(intent != null){
      intent.getParcelableArrayListExtra<Link>(DATA)?.forEach { link ->
        links.add(Link(link.name, link.url))
      }
    }
    linkAdapter.getItemId(links.size)

    linkAdapter.notifyDataSetChanged()
  }


  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> true
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun createTestData() : List<Link> {
    val linkedList = ArrayList<Link>()
    linkedList.add(Link("A", "LED Green 568 nm, 5mm"))
    linkedList.add(Link("AA", "Aluminium Capacitor 4.7μF"))
    linkedList.add(Link("AAA", "Potentiometer 500kΩ"))
    return linkedList
  }


  private fun linkItemClicked(linkItem: Link) {
    Toast.makeText(this, "clicked: ${linkItem.name}", Toast.LENGTH_LONG).show()
  }

  private fun openCustomTab(url: String) {
    val intent: CustomTabsIntent = CustomTabsIntent.Builder()
      .setToolbarColor(ResourcesCompat.getColor(resources, R.color.colorPrimary, null))
      .setColorScheme(COLOR_SCHEME_SYSTEM)
      .build()

    intent.launchUrl(this, Uri.parse(url))
  }

  companion object{
    const val DATA = "DATA"
  }

}
