package com.khusnia.mylaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.khusnia.mylaundry.home.HomeAdapter
import com.khusnia.mylaundry.home.Item
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    private var dataList = ArrayList<Item>()
    val displayList = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_popular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        getData()


        rv_popular.adapter = HomeAdapter(displayList) {
            val intent = Intent(this, DetailKontrakan::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

        dataList.add(
            Item(
                "Jalan Dukuh Kupang Barat 1 No 146, Surabaya.",
                "GloryGoLaundry, laundry express hanya 1 jam dengan sistem drop off dan self service!",
                "Rp.5.000/kg",
                "Gloria Charity",
                "GloryGoLaundry kini hadir sebagai solusi untuk membantu Anda mencuci, mengeringkan, hingga menggosok pakaian. Kami menyediakan 2 pilihan laundry yaitu drop off (full service) atau self service (cuci sendiri).\n" +
                        "Kami menyediakan banyak plihan sesuai dengan kebutuhan Anda, diantaranya :\n" +
                        "- Cuci saja / kering saja / cuci kering\n" +
                        "- Cuci kering lipat\n" +
                        "- Cuci setrika",
                "7.00",
                "03199534237",
                "1 jam",
                "5",
                R.drawable.toko1,
                "https://www.google.co.id/maps/place/Glory+Go+Laundry/@-7.2814447,112.7082243,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd7fdfde1716089:0x5da2930f0c895d75!8m2!3d-7.28145!4d112.710413",
                "Safitri",
                "Bersih dan cepat",
                "Yudith",
                "Murah dan bersih",
                "Novita Sari",
                "Cepat, bersih, dan wangi"
            )
        )
        dataList.add(
            Item(
                "Jalan Darmo Indah Timur G 64B, Tandes Kidul, Surabaya.",
                "I Do Coin Laundry, laundry dengan sistem layanan koin yang mudah dan praktis!",
                "Rp.15.000/5kg",
                "Stefani Ayu",
                "I Do Coin Laundry kini hadir sebagai solusi untuk membantu Anda mencuci, mengeringkan, hingga menggosok pakaian. Kami menyediakan 2 pilihan laundry yaitu i do service (full service) atau self service (cuci sendiri).",
                "7.00",
                "081293133002",
                "6 jam",
                "1",
                R.drawable.toko2,
                "https://www.google.co.id/maps/place/I+Do+Laundry+Darmo+Indah/@-7.2638829,112.6841668,17z/data=!4m12!1m6!3m5!1s0x2dd7ffd7ec6a4d5b:0x84dcbccd2ea886a3!2sI+Do+Laundry+Darmo+Indah!8m2!3d-7.2637598!4d112.6841789!3m4!1s0x2dd7ffd7ec6a4d5b:0x84dcbccd2ea886a3!8m2!3d-7.2637598!4d112.6841789",
                "Eka",
                "Murah dan bersih",
                "Aldo",
                "Pelayanan cukup baik dan hasilnya bersih"

            )
        )
        dataList.add(
            Item(
                "Jalan Griya Kebraon Tengah No. J-21, Kebraon, Surabaya.",
                "Shinchan Laundry, cuci setrika 5x gratis 1x dengan layanan antar-jemput!",
                "Rp.5.000/kg",
                "Yohana",
                "Shinchan Laundry melayani laundry kiloan, laundry satuan, serta gratis antar-jemput untuk wilayah Surabaya Barat. Tersedia juga Paket Member seharga Rp.200.000/40Kg",
                "7.00",
                "082228018822",
                "-",
                "1",
                R.drawable.toko3,
                "https://www.google.co.id/maps/place/Shinchan+laundry/@-7.3304758,112.6976248,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd7fdd0a23030e5:0xe1d0e8a55cddf541!8m2!3d-7.3304811!4d112.6998135"
            )
        )
        dataList.add(
            Item(
                "Jalan Raya Sukomanunggal  Jaya, Komplek Ruko Platinum 2B, Surabaya.",
                "Brite Laundry & DryClean",
                "Mulai dari Rp.25.000",
                "Lily",
                "Brite Laundry & DryClean bergerak dibidang jasa Laundry & Dryclean, dimana didukung dengan peralatan serta tenaga ahli yang telah profesional. Kami dapat membantu anda untuk mencuci pakian, tas, sepatu, stroller, karpet, dan berbagai jenis barang lainnya dengan didukung oleh chemical ramah lingkungan dan berkualitas tinggi, sehingga menjaga kualitas barang Anda.",
                "8.00",
                "085931318391",
                "-",
                "1",
                R.drawable.toko4,
                "https://www.google.co.id/maps/place/BRITE+LAUNDRY+%26+DRYCLEAN/@-7.2694125,112.6924148,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd7fea081dbc7e9:0x1bcad748e70e8ed7!8m2!3d-7.2694178!4d112.6946035",
                "Stefani",
                "ngk perlu ribet antar kesana krn ada free pick-up & delivery"
            )
        )
        dataList.add(
            Item(
                "Dukuh Gemol 1B Mangga, Wiyung, Surabaya.",
                "Sherly Laundry",
                "Rp.5.000/kg",
                "Sherly",
                "Sherly Laundry menerima segala macam cucian & dry clean dengan berbagai macam pilihan mulai dari cuci basah, cuci kering, cuci setrika, dan setrika saja.",
                "6.30",
                "081248686173",
                "-",
                "1",
                R.drawable.toko5,
                "https://www.google.co.id/maps/place/Kripik+Usus+Kasus/@-7.3112189,112.7044866,19z/data=!3m1!4b1!4m5!3m4!1s0x2dd7fc6120a1435f:0x68dbbb52cf093a42!8m2!3d-7.3112202!4d112.7050338"
            )
        )
        dataList.add(
            Item(
                "Jalan Babatan UNESA 6 No. 19E, Surabaya.",
                "Classy Expert Badding Laundry",
                "Mulai dari Rp.15.000",
                "Classy",
                "Classy Laundry, 7 years expert bedding laundry. Free Pickup & Delivery.",
                "7.00",
                "082233443678",
                "-",
                "5",
                R.drawable.toko6,
                "https://www.google.co.id/maps/place/Classy+Loundry+%26+Dryclean/@-7.3081847,112.6720213,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd7fc56b64a2b97:0xc58e62093e7d6097!8m2!3d-7.30819!4d112.67421"
            )
        )


        displayList.addAll(dataList)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView

            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Cari berdasarkan harga..."

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()){

                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        dataList.forEach {
                            if (it.harga.toLowerCase(Locale.getDefault()).contains(search)){
                                displayList.add(it)
                            }
                        }

                        rv_popular.adapter!!.notifyDataSetChanged()
                    }

                    else{
                        displayList.clear()
                        displayList.addAll(dataList)
                        rv_popular.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


}
