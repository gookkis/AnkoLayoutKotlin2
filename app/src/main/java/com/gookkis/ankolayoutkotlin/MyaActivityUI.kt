package com.gookkis.ankolayoutkotlin

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MyActivityUI : AnkoComponent<MainActivity> {
    val idHasil = 1
    val idEditTahun = 2
    val btnHitung = 3
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {

            padding = dip(16)

            val hasil = textView {
                id = idHasil
                text = "0"
                textSize = 120F
            }.lparams {
                centerHorizontally()
            }
            val tahunLahir = editText {
                hint = "Masukan tahun lahir"
                id = idEditTahun
            }.lparams {

                below(idHasil)
                centerHorizontally()
            }
            button("Hitung Umur") {
                id = btnHitung
                onClick {
                    val thnLahir = tahunLahir.text.toString().toInt()
                    val thnSekarang = Calendar.getInstance().get(Calendar.YEAR)
                    hasil.text = (thnSekarang - thnLahir).toString()
                }
            }.lparams(width = wrapContent) {
                topMargin = dip(20)
                centerHorizontally()
                alignParentBottom()
            }


        }
    }
}