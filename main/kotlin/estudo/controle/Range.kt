package estudo.controle
//Range (analise de loops por Int), tambem funciona com valores Char
fun range(){
    //Retorna os valores crescentes de 0 até 3
    for(i in 0.. 3) print(i)
    println()
    //Retorna os valores crescentes de 0 até 2 (com 3 sendo aquele que termina o loop) [step]
    for(i in 0 until 3) print(i)
    println()
    //Retorna os valores entre 2 a 8, pulando de 2 em 2 [step]
    for(i in 2 .. 8 step 3) print(i)
    println()
    //Retorna os valores decrescente de 3 a 0 [downTo]
    for(i in 3 downTo 0) print(i)
    println()
}
fun range(x:Int){
    if(x in 0 .. 5){
        println("$x é um numero entre 0 e 5")
    }
    else if(x in 6 until 13 step 2){
        println("$x é um valor par entre 6 e 12")
    }
    else{
        println("$x não é um numero definido")
    }
}
fun testesIfWhen(x:Any){
    when(x){
        is Char -> if(x in 'a'..'z') print(x) else print("$x está em Maisculo")
        is Int -> if(x in 0.. 100) print(x) else print("$x é menor do que 0 ou maior do que 100")
        is String -> print(x)
        else -> println("Não faço ideia do que 'x' é")
    }
}
fun main(){
    range()
    range(7)
    testesIfWhen("Paulo Freire: 'Se a educação sozinha não transforma a sociedade, sem ela tampouco a sociedade muda.'")
}