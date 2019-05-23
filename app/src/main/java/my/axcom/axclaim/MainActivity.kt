package my.axcom.axclaim

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.View.VISIBLE
import android.view.Window
import android.view.WindowManager
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_main.*
import my.axcom.axclaim.models.Auth
import my.axcom.axclaim.services.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast as Toast1

class MainActivity : AppCompatActivity() {

    private val generalRepository: GeneralRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        object : CountDownTimer(2000, 500) {
            override fun onFinish() {
                //bookITextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorSplashText))
                bookIconImageView.setImageResource(R.drawable.logo_black)
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()
    }

    private fun startAnimation() {
        bookIconImageView
            .animate().apply {
            x(210f)
            y(50f)
            duration = 1000
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE

                applyLoginEvent()


            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }

    private fun callPassswordEncryptApi(): Single<PasswordEncryptResponse> {
        return generalRepository!!.getPasswordEncrypt("123456")
    }

    private fun applyLoginEvent() {

        loginButton.setOnClickListener {

            android.widget.Toast.makeText(this@MainActivity, "Clicked !",
                android.widget.Toast.LENGTH_SHORT).show()

            val generalService = ServiceBuilder.buildService(GeneralService::class.java)

            val requestCall = callPassswordEncryptApi()
            println(requestCall);

            /*requestCall.enqueue(object : Callback<List<Auth>> {

                override fun onResponse(call: Call<List<Auth>>, response: Response<List<Auth>>) {

                    android.widget.Toast.makeText(this@MainActivity, "Responsed",
                        android.widget.Toast.LENGTH_SHORT).show()

                    println(response.code())

                    val response_code : String = response.code().toString()

                    if (response.isSuccessful()) {
                        val result_api = response.body()!!
                        println(result_api)
                        android.widget.Toast.makeText(this@MainActivity, result_api.toString(),
                        android.widget.Toast.LENGTH_SHORT).show()
                    }else{
                        android.widget.Toast.makeText(this@MainActivity, response_code,
                           android.widget.Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<Auth>>, t: Throwable) {

                    println(t.message?.toString())

                    android.widget.Toast.makeText(this@MainActivity, t.message?.toString(),
                        android.widget.Toast.LENGTH_SHORT).show()

                }
            })*/

        }


        android.widget.Toast.makeText(this@MainActivity, "Applying the Login Event",
            android.widget.Toast.LENGTH_SHORT).show()


    }
}
