package com.feranstirman.evaluacion2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.feranstirman.evaluacion2.Fragments.ButtonsFragment
import com.feranstirman.evaluacion2.Fragments.ImageFragment

class MainActivity : AppCompatActivity(), ButtonsFragment.OnButtonInteractionListener,ImageFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction() {
        Log.d("prueba","probando")
    }


    var currentImage = 1

    override fun onButtonPrevInteraction() {
        currentImage= currentImage - 1
        if(currentImage<=0){
            currentImage=3
        }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_fragment_imagenes,ImageFragment.newInstance(currentImage))
                .commit()
    }

    override fun onButtonNextInteraction() {
        currentImage = currentImage + 1
        if(currentImage>=4){
            currentImage=1
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_fragment_imagenes,ImageFragment.newInstance(currentImage))
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CREACION DEL FRAGMENTO DE LOS BOTONES
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment_botones, ButtonsFragment.newInstance())
                .commit()

        //CREACION DE UNA IMAGEN INICAL
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment_imagenes,ImageFragment.newInstance(currentImage))
                .commit()
    }
}
