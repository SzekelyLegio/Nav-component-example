package hu.adikaindustries.navigationComonentExample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class money(val amount: BigDecimal):Parcelable
