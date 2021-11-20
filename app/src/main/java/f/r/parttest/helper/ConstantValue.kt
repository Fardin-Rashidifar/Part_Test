package f.r.parttest.helper

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConstantValue @Inject constructor(){
    companion object{
        const val SERVER_ADDRESS = "https://reqres.in/"
    }
}