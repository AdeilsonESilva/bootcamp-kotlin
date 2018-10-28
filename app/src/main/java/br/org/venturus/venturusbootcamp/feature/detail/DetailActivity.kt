package br.org.venturus.venturusbootcamp.feature.detail

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import br.org.venturus.venturusbootcamp.R
import android.support.v7.app.AppCompatActivity
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.databinding.ActivityDetailBinding
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by inject()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD { "onCreate savedInstanceState" }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        loadPerson()
    }

    private fun loadPerson() {

        // Seria necessário checar cada object se não era nulo, para enfim, pegar o id do objeto.
        // Com Kotlin, usando null safe basta colocar uma interrogação.
        val personId = intent?.extras?.getString(EXTRA_PERSON_ID)
        logD { "loadPerson = [$personId]" }

        personId?.let { viewModel.loadPersonInformation(it) }

    }

    companion object {

        private const val EXTRA_PERSON_ID = "extra_id"

        fun startActivity(activity: Activity, personId: String) {

            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(EXTRA_PERSON_ID, personId)
            activity.startActivity(intent)
        }
    }
}
