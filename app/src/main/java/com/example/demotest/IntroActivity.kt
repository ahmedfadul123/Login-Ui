package com.example.demotest

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.demotest.databinding.ActivityIntroBinding
import com.example.demotest.login.LoginActivity
import com.example.demotest.main.MainActivity
import com.example.demotest.otp.OtpActivity
import com.example.demotest.register.RegistrationActivity
import com.example.demotest.room.Account.Dao.AccountsDao
import com.example.demotest.room.Account.entity.Account
import com.example.demotest.room.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding
    var layout : ViewGroup? = null;
    var appDatabase : AppDatabase? = null;
    var accountDao  :AccountsDao? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityIntroBinding.inflate(layoutInflater)
        layout= binding.activitySplashScreen
        setContentView(binding.root)
        appDatabase = AppDatabase(this);
        accountDao = appDatabase!!.getAccountDao();

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        window.setFormat(PixelFormat.RGBA_8888)
    }

    override fun onResume() {
        super.onResume()
        animateSplashScreen(this)
    }

    private fun animateSplashScreen(context : Context){

        val anim = AnimationUtils.loadAnimation(context, R.anim.alpha)
        anim.reset()
        layout?.clearAnimation()
        layout?.startAnimation(anim)

        lifecycleScope.launch (Dispatchers.IO){
            var waited = 0
            while (waited < 2000) {
                try {
                    delay(1000)
                    waited += 1000
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }


          val accountList =  accountDao!!.getAccount() as List<Account>;

            if(accountList.isNotEmpty()){
                val Reg = accountList[0].Reg
                val AccountStatus = accountList[0].AccountStatus
                if (Reg == 1 && AccountStatus == 1){
                    withContext(Dispatchers.Main){
                        val intent = Intent(this@IntroActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }
                } else if (AccountStatus == 0){
                    withContext(Dispatchers.Main){
                        val intent = Intent(this@IntroActivity, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }

                }else if (AccountStatus ==  1){
                    withContext(Dispatchers.Main){

                        val intent = Intent(this@IntroActivity, OtpActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()

                    }
                }else if (AccountStatus == 2){
                    withContext(Dispatchers.Main){

                        val intent = Intent(
                            this@IntroActivity,
                            RegistrationActivity::class.java
                        )
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()

                    }
                }else if (AccountStatus == 3){
                    withContext(Dispatchers.Main){
                        val intent = Intent(this@IntroActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }
                }else if (AccountStatus == 4){
                    withContext(Dispatchers.Main){
                        /*
                        val intent = Intent(this@IntroActivity, ComfermActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                         */
                    }
                } else if (AccountStatus == 5){
                    withContext(Dispatchers.Main){
                       /*
                        val intent = Intent(this@IntroActivity, TrackOrderActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                        */
                    }
                }else if (AccountStatus == 6){
                    withContext(Dispatchers.Main){
                       /*
                        val intent = Intent(this@IntroActivity, RatingActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                        */
                    }
                }

            }else{
                withContext(Dispatchers.Main){
                    goToLogin();
                }
            }



        }

    }


    private fun goToLogin(){
        val intent = Intent(this@IntroActivity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()

    }


}