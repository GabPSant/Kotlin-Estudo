package estudo.introducao

class Estudo {
    fun aluno(nota1:Double = 0.0,nota2:Double = 0.0):Double{//Nota de cada Aluno
        return (nota1+nota2)/2
    }
    fun turma(alunos:Int = 0):Int{// Quantidade de alunos na turma de tal professor
        return alunos
    }
    fun media():Double{// Media geral da turma
        // Preciso entender como fazer o for
        var resultado:Double = 0.0
        for(i in 1..turma()){
            resultado =+ aluno()
        }
        return resultado/turma()
    }
}
fun main(){
    // Não compreendo esse erro
    val estudo = Estudo()
    estudo.aluno(7.0,7.0)
    println("Alunos na turma: ${estudo.turma(30)}\nMedia geral: ${estudo.media()}")
}