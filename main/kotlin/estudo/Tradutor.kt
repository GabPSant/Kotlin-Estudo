import java.util.*

fun conversor(ingles:String = "dog"):String{
    var prefixo = ""
    var radical = ""
    if(ingles.isNotBlank()){
        for(i in 1..ingles.length){
            if(ingles[i] == 'a' || ingles[i] == 'e' || ingles[i] == 'i' || ingles[i] == 'o' || ingles[i] == 'u' || ingles[i] == 'y'){
                prefixo = ingles.substring(0,i)
                radical = ingles.substring(i,ingles.length)
                if(ingles[0].uppercaseChar() == ingles[0]){
                    prefixo = ingles.substring(0,1).lowercase() + ingles.substring(1,i);
                    radical = ingles.substring(i,i+1).uppercase() + ingles.substring(i+1);
                }
            }
            if(prefixo.isNotEmpty() || radical.isNotEmpty()) break
        }
        return radical + prefixo + "ay"
    }
    return "Não foi colocada uma palavra"
}
fun main(){
    println(conversor())
}