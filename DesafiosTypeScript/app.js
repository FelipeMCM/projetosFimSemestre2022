"use strict";
//DESAFIOS DO CURSO INTRODUÇÃO PRÁTICA AO TYPESCRIPT MINISTRADO PELA DIO NO BOOTCAMP SANTANDER 2022;
//Desafio 1:
// Como podemos rodar isso em um arquivo .ts sem causar erros? 
/*

let employee = {};
employee.code = 10;
employee.name = "John";

*/
//Possível resolução do desafio 1:
/* let employee : {code: number, name: string} = {
    code: 45,
    name: 'As crônicas de Mazaroppi'

};
console.log(employee.code);
console.log(employee.name)

employee.code = 88;
employee.name = 'As crônicas de Nárnia';

*/
//Desafio 2:
/*

let pessoa1 = {};
pessoa1.nome = "maria";
pessoa1.idade = 29;
pessoa1.profissao = "atriz"

let pessoa2 = {}
pessoa2.nome = "roberto";
pessoa2.idade = 19;
pessoa2.profissao = "Padeiro";

let pessoa3 = {
    nome: "laura",
    idade: "32",
    profissao: "Atriz"
};

let pessoa4 = {
    nome = "carlos",
    idade = 19,
    profissao = "padeiro"
}

*/
//Possível resolução do desafio 2:
/* enum Profissao {
    Padeiro,
    Atriz,
    EngenheiroDeSoftware
}
interface Pessoa {
    nome: string,
    idade: number,
    profissao: Profissao
};

class Personagem implements Pessoa {
    nome = 'Felipe M. C. M.';
    idade = 24
    profissao = Profissao.EngenheiroDeSoftware;

    constructor(nome: string, idade: number, profissao: Profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }
}
console.log('A Personagem 1 foi substituída da peça "A noviça Rebelde". Seu dever é encontrar outra pessoa e setar seus atributos.');

const PersonagemSubstituta: Personagem = new Personagem('Maria Olívia', 23, Profissao.Atriz);

console.log('Substitua a personagem substituta porque ela não está conseguindo decorar as falas da peça');

const PersonagemSubstituta2: Personagem = new Personagem('Ortência', 19, Profissao.Atriz);

const OBJ : {nome: string, idade: number, profissao: Profissao} = {
    nome: PersonagemSubstituta2.nome,
    idade:PersonagemSubstituta2.idade,
    profissao: Profissao.EngenheiroDeSoftware & Profissao.Atriz
};

console.log('Descobrimos que a Ortência, além de atriz, é também engenheira de software como a primeira personagem');
console.log('Mostre o objeto com os atributos da personagem substituta2 atualizados');
console.log(OBJ);

*/
//Desafio 3:
// O código abaixo tem alguns erros e não funciona como deveria. Você pode identificar quais são e corrigi-los em um arquivo TS?
let botaoAtualizar = document.getElementById('atualizar-saldo');
let botaoLimpar = document.getElementById('limpar-saldo');
let soma = document.getElementById('soma');
let campoSaldo = document.getElementById('campo-saldo');
let saldoTotal = 0;
limparSaldo();
function somarAoSaldo(soma) {
    if (campoSaldo) {
        saldoTotal += soma;
        campoSaldo.innerHTML = saldoTotal.toString();
        limparCampoSoma();
    }
}
function limparCampoSoma() {
    soma.value = "";
}
function limparSaldo() {
    if (campoSaldo) {
        saldoTotal = 0;
        campoSaldo.innerHTML = saldoTotal.toString();
    }
}
if (botaoAtualizar) {
    botaoAtualizar.addEventListener('click', () => {
        somarAoSaldo(Number(soma.value));
    });
}
botaoLimpar.addEventListener('click', () => {
    limparSaldo();
});
limparSaldo();
/**
    <h4>Valor a ser adicionado: <input id="soma"> </h4>
    <button id="atualizar-saldo">Atualizar saldo</button>
    <button id="limpar-saldo">Limpar seu saldo</button>
    <h1>"Seu saldo é: " <span id="campo-saldo"></span></h1>
 */
