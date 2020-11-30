package com.lepaya.test.ui.trainer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.lepaya.domain.interactors.TrainerInteractor
import com.lepaya.domain.models.Trainer
import com.lepaya.test.ui.trainer.detail.TrainerDetailsActivity
import com.lepaya.test.R
import com.lepaya.test.mvp.BaseMvpActivity
import com.lepaya.test.ui.trainer.adapter.TrainersAdapter
import com.lepaya.test.utils.startActivity
import kotlinx.android.synthetic.main.activity_trainer.*
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.inject

class TrainerListActivity : BaseMvpActivity(), TrainerListView {

    private val trainerInteractor: TrainerInteractor by inject()
    private val presenter: TrainerListPresenter by moxyPresenter {
        TrainerListPresenter(trainerInteractor)
    }
    private var trainersAdapter = TrainersAdapter {
        presenter.onTrainerClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)
        // Setup views
        setUpViews()
    }

    private fun setUpViews() {
        rvTrainer.layoutManager = LinearLayoutManager(this)
        rvTrainer.adapter = trainersAdapter
        listenSearches()
        
    }

    private fun listenSearches() {
        search_trainer!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                trainersAdapter.filter.filter(s.toString())
            }
        })
    }


    override fun showTrainerList(list: List<Trainer>) {
        trainersAdapter.setTrainersList(list)
    }

    override fun showTrainerDetailsActivity() {
        if (!isFinishing and !isDestroyed) {
            startActivity<TrainerDetailsActivity>()
        }
    }



    override fun showLoading(show: Boolean) {

    }
}

