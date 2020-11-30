package com.lepaya.test.ui.trainer.detail

import android.os.Bundle
import com.lepaya.domain.interactors.TrainerInteractor
import com.lepaya.domain.models.Trainer
import com.lepaya.test.R
import com.lepaya.test.mvp.BaseMvpActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_trainer_detail.*
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.inject

class TrainerDetailsActivity : BaseMvpActivity(), TrainerDetailsView {
    private val trainerInteractor: TrainerInteractor by inject()
    private val presenter: TrainerDetailsPresenter by moxyPresenter {
        TrainerDetailsPresenter(trainerInteractor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_detail)
    }

    override fun showTrainerDetails(selectedTrainer: Trainer?) {
        tvFullName.text = selectedTrainer?.fullName
        tvEmail.text = selectedTrainer?.email
        tvAvailability.text = selectedTrainer?.isAvailable.toString()
        tvFavoriteFruit.text = selectedTrainer?.favoriteFruit
        tvSkills.text = selectedTrainer?.tags
        tvCreatedAt.text = selectedTrainer?.createdAt
        Picasso.get().load(selectedTrainer?.picture).into(ivAvatar)

    }

    override fun showLoading(show: Boolean) {
    }
}