package test.notificationreader.settings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*
import test.notificationreader.R
import test.notificationreader.model.cache.Settings
import test.notificationreader.setup.InitialSetupActivity

class SettingsActivity : Activity(), SettingsView {
    private var mPresenter: SettingsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = SettingsPresenter()
        mPresenter?.onCreate(this, Settings(applicationContext))
    }

    override fun initViews() {
        setContentView(R.layout.activity_settings)

        justHeadphonesSwitch.setOnCheckedChangeListener({ v, check ->
            mPresenter?.onTogglePlayJustWithHeadphonesClick(check)
        })
    }

    override fun startSettingsView() {
        startActivity(Intent(applicationContext, InitialSetupActivity::class.java))
    }

    override fun close() {
        finish()
    }

    override fun setHeadphonesToggleCheck(checked: Boolean) {
        justHeadphonesSwitch.isChecked = checked
    }
}