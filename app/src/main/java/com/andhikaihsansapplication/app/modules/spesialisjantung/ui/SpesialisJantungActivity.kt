package com.andhikaihsansapplication.app.modules.spesialisjantung.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySpesialisJantungBinding
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.ListbrawijayauniveRowModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.viewmodel.SpesialisJantungVM
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakit
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitAdapter
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitClickListener
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SpesialisJantungActivity :
    BaseActivity<ActivitySpesialisJantungBinding>(R.layout.activity_spesialis_jantung), RumahSakitClickListener {
  private val viewModel: SpesialisJantungVM by viewModels<SpesialisJantungVM>()
  private lateinit var viewModelRS: RumahSakitViewModel


  private lateinit var recyclerView: RecyclerView
  private lateinit var rumahSakitAdapter: RumahSakitAdapter

  override fun onResume() {
    super.onResume()

    val listHeaderText = findViewById<TextView>(R.id.listHeaderText)
    val kategori = intent.getStringExtra("CURRENT_KATEGORI").toString()
    listHeaderText.text = kategori

    // firebase realtime
    var database = FirebaseDatabase.getInstance()
    var servicesRef = database.getReference("services")
    var rsRef = database.getReference("hospitals")

    viewModelRS = ViewModelProvider(this).get(RumahSakitViewModel::class.java)

    viewModelRS.rumahSakitList.observe(this) { list ->
      list?.let {
        recyclerView = findViewById(R.id.recyclerListbrawijayaunive)
        recyclerView.layoutManager = LinearLayoutManager(this)
        rumahSakitAdapter = RumahSakitAdapter(list, this)
        recyclerView.adapter = rumahSakitAdapter

      }
    }

    // Tambahkan data baru ke dalam LiveData
    servicesRef.child(kategori).addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(snapshot: DataSnapshot) {
        val rumahSakitList = mutableListOf<RumahSakit>() // Buat list baru

        // Menggunakan Coroutine untuk mengumpulkan data dari snapshot
        CoroutineScope(Dispatchers.IO).launch{
          for (rsSnapshot in snapshot.children) {
            rsRef.child(rsSnapshot.key.toString()).addListenerForSingleValueEvent(object : ValueEventListener {
              override fun onDataChange(snapshotRS: DataSnapshot) {
                val snapshotValue = snapshotRS.getValue() // Mengambil nilai dari snapshot
                val map: Map<String, Any>? = snapshotValue as? Map<String, Any>

                var namaRS = map?.get("nama_rs").toString()
                var alamatRS = map?.get("address").toString()
                var noRS = map?.get("er_contact").toString()

                val rumahSakit = RumahSakit(namaRS, alamatRS, noRS)
                rumahSakitList.add(rumahSakit) // Tambahkan ke list lokal
              }
              override fun onCancelled(error: DatabaseError) {}
            })
          }
          delay(1000) // Tambahkan delay jika dibutuhkan untuk menunggu pengambilan data selesai
          withContext(Dispatchers.Main) {
            viewModelRS.tambahRumahSakitList(rumahSakitList) // Tambahkan semua data ke dalam LiveData
          }
        }
      }
      override fun onCancelled(error: DatabaseError) {}
    })
  }

  override fun onRumahSakitClicked(rumahSakit: RumahSakit) {
    // Handle klik pada item rumah sakit di sini
    // Contoh: Tampilkan pesan Toast
    Toast.makeText(this, "Anda memilih ${rumahSakit.nama}", Toast.LENGTH_SHORT).show()
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listbrawijayauniveAdapter =
    ListbrawijayauniveAdapter(viewModel.listbrawijayauniveList.value?:mutableListOf())
    binding.recyclerListbrawijayaunive.adapter = listbrawijayauniveAdapter
    listbrawijayauniveAdapter.setOnItemClickListener(
    object : ListbrawijayauniveAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListbrawijayauniveRowModel) {
        onClickRecyclerListbrawijayaunive(view, position, item)
      }
    }
    )
    viewModel.listbrawijayauniveList.observe(this) {
      listbrawijayauniveAdapter.updateData(it)
    }
    binding.spesialisJantungVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListbrawijayaunive(
    view: View,
    position: Int,
    item: ListbrawijayauniveRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SPESIALIS_JANTUNG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SpesialisJantungActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
