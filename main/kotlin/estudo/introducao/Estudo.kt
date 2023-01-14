package estudo.introducao

class Estudo {//Classes não vão definir as funções como uma analise sequencial, eles só armazenam
    fun media(x:Double = 7.0,y:Double = 7.0) = (x+y)/2
    fun turma(alunos:Int):Double{
        var resultado:Double = 0.0
        for (i in 1..alunos){
            resultado += media()
        }
        return resultado/alunos
    }
}
fun main(){
    val estudo = Estudo()
    estudo.media(5.0,5.0)
    println("Media da turma: ${estudo.turma(30)}")//Como são considerados funções separadas, vai usar os valores padrões
}