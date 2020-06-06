package com.tsdev.tsandroid.base

import android.app.Activity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tsdev.tsandroid.R
import com.tsdev.tsandroid.eventbus.RxEventBus
import com.tsdev.tsandroid.eventbus.RxEventBusImpl
import com.tsdev.tsandroid.ui.viewmodel.BaseViewModel
import com.tsdev.tsandroid.ui.viewmodel.MainViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

abstract class BaseActivity<VM : BaseViewModel, BINDING : ViewDataBinding> :
    AppCompatActivity() {

    protected val disposable = CompositeDisposable()

    abstract val viewModel: VM

    abstract val binding: BINDING

//    protected val rxJavaEvent by inject<RxEventBus>()

    inline fun movieSetDataBinding(
        @LayoutRes layoutInt: Int, activity: Activity,
        crossinline layoutBinding: (BINDING) -> BINDING
    ) =
        lazy { layoutBinding(DataBindingUtil.setContentView(activity, layoutInt)) }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}