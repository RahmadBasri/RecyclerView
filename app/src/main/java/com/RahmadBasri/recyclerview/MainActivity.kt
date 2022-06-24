package com.RahmadBasri.recyclerview


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.RahmadBasri.recyclerview.adapter.AdapterTeamBola
import com.AyuAndira.myapplication.model.Pemain
import com.RahmadBasri.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Gareth Bale",R.drawable.bel, "Actor", "185cm",", Cardiff, Britania Raya","16 Juli 1989"))
        listPemain.add(Pemain("Erling Haaland",R.drawable.hallan, "Striker Bola", "194cm","Leeds, Britania Raya","21 Juli 2000"))
        listPemain.add(Pemain("Mesut Özil",R.drawable.ozil, "Playmaker Bola", "180cm","Gelsenkirchen, Jerman","15 Oktober 1988"))
        listPemain.add(Pemain("Darwin Núñez",R.drawable.nunez, "Striker Bola", "177cm"," Artigas, Uruguay"," March 27, 1997"))
        listPemain.add(Pemain("Jürgen Norbert Klopp",R.drawable.kloop, "Pelatih Sepak Bola", "191cm","Stuttgart, Jerman Barat"," 16 Juni 1967"))

        binding.list.adapter = AdapterTeamBola(this, listPemain,object : AdapterTeamBola.OnClikListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtnama)

                    val profesi = this.findViewById<TextView>(R.id.txtprofesi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    profesi.text = "${item?.profesi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"


                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })
    }
}