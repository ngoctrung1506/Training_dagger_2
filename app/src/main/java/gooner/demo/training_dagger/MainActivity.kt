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
import dagger.android.AndroidInjection
import gooner.App
import gooner.factory.MainFactory
import gooner.repository.UserRepo
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
    lateinit var mRepo: UserRepo


    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        Log.d("Repository ", mRepo.toString())

        setContentView(R.layout.activity_main)

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


}
