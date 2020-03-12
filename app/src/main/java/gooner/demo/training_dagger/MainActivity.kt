package gooner.demo.training_dagger

//import butterknife.ButterKnife

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import gooner.App
import gooner.factory.MainFactory
import gooner.model.Computer
import gooner.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.full_name)
    lateinit var fullName: TextView

    @BindView(R.id.username)
    lateinit var username: EditText

    @BindView(R.id.search)
    lateinit var search: Button

    lateinit var mUserViewModule: UserViewModel

    @Inject
    lateinit var mComputer: Computer


    override fun onCreate(savedInstanceState: Bundle?) {

        (application as App).mComputerComponent.inject(this)
        super.onCreate(savedInstanceState)

        mComputer.mName.showLog("MainActivity")

        setContentView(R.layout.activity_main)

        val a = 6
        val b = Integer.valueOf(a)

        val mainFactory = MainFactory(applicationContext as App)
        mUserViewModule = ViewModelProviders.of(this, mainFactory).get(UserViewModel::class.java)
        ButterKnife.bind(this)


    }


    override fun onStart() {
        super.onStart()

        search.setOnClickListener {
            mUserViewModule.gerUserByName(username.text.toString()).observe(this, Observer { user ->
                Log.d("MainActivity", "User here")
                user?.run {
                    fullName.text = user.name + " has blog at " + user.blog
                }
            })
        }
    }

    private fun <T> T.showLog(logName: String) {
        Log.d(logName, this.toString())
    }

//    fun scheduleNotification(tag: String, times: Long) {
//
//        var numbers = setOf(1, 2, 3)
//        numbers.plus(5)
//        numbers.iterator().forEach {
//            Log.d("Set", it.toString())
//        }
//
//        val data = workDataOf("shiftId" to "My-tag")
//
//        val constraint: Constraints = Constraints.Builder().apply {
//            setRequiredNetworkType(NetworkType.CONNECTED)
//        }.build()
//        val request: OneTimeWorkRequest = OneTimeWorkRequestBuilder<RemindWorker>()
//            .setInitialDelay(times, TimeUnit.SECONDS)
//            .setConstraints(constraint)
//            .addTag("My-tag")
//            .setInputData(data)
//            .build()
//
//        WorkManager.getInstance(this).enqueueUniqueWork(tag, ExistingWorkPolicy.REPLACE, request)
//    }


}
