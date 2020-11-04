package com.sophiamoraes.agora_vai
//gerador de dados randomicos da potencia da tomada
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class PowerPlugDataRepository {
    private val _plugpower = MutableLiveData<List<Power_Specificatios>>()
    val plugpower : LiveData<List<Power_Specificatios>> = _plugpower

    fun loadPowerPlug(){
        val randomValues = List(1){ Random.nextFloat().rem(100) * 1000 + 1}
        val powerplugItem = randomValues.map {randomValue ->
           Power_Specificatios(randomValue, getDescription(randomValue), getPriceValue(randomValue))
        }
        _plugpower.setValue(powerplugItem)
    }
}

private fun getDescription(plugpower: Float): String{
    return when(plugpower){
        in 0f.rangeTo(100f) -> "tensão abaixo do normal"
        in 100f.rangeTo(500f) -> "tensãp normal"
        in 500f.rangeTo(1000f) -> "tensão acima do normal"
        in 1000f.rangeTo(Float.MAX_VALUE) -> "TENSÃO ALTA"
        else -> "does not compute"
    }
}
private fun getPriceValue(plugpower: Float) : Float{
    val priceValue = plugpower/2
    return priceValue
}
