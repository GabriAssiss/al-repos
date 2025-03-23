/*/
let title = document.querySelector('h1');
let paragraph = document.querySelector('.texto__paragrafo');

title.innerHTML = "Jogo da Adivinhação";
paragraph.innerHTML = "Escolha um número entre 1 e 10:";
*/

let tentativas = 1;
let numero_secreto = geradorNumeroRandom();

function exibirTexto(tag, texto){
    let campo = document.querySelector(tag);
    campo.innerHTML = texto;
    responsiveVoice.speak(texto, 'Brazilian Portuguese Female', {rate:1.2});
}

function exibirMensagem(){
    exibirTexto('h1', "Jogo da Adivinhação");
    exibirTexto('.texto__paragrafo', "Escolha um número entre 1 e 10:");
}

exibirMensagem();

function geradorNumeroRandom(){
    return parseInt(Math.random() * 10 + 1);
}

function verificarChute(){
    let chute = document.querySelector('.container__input').value;
    console.log(numero_secreto == chute);
    if(numero_secreto == chute){
        exibirTexto('h1', "Você acertou!");
        let palabraTentativa = tentativas > 1 ? 'tentativas!' : 'tentativa!';
        let mensagem = `Você descobriu a número com ${tentativas} ${palabraTentativa}`;
        exibirTexto('.texto__paragrafo', mensagem);
        document.getElementById('reiniciar').removeAttribute('disabled');
    }
    else{
        if(chute > numero_secreto){
            exibirTexto('.texto__paragrafo', "O número secreto é menor do que o chute!");
        }
        else{
            exibirTexto('.texto__paragrafo', "O número secreto é maior do que o chute!");     
        }
        tentativas++;
        limparCampo();
    }
}

function limparCampo(){
    chute = document.querySelector('.container__input');
    chute.value = ""
}

function reiniciarJogo(){
    numero_secreto = geradorNumeroRandom();
    limparCampo();
    tentativas = 1;
    exibirMensagem();
    document.getElementById('reiniciar').setAttribute('diabeld', true);
}