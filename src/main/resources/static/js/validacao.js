
const validadores = {
    cpf:input => validaCPF(input),
    renda: input => validaRenda(input),
    telefone: input => formataTelefone(input)

}

export function valida(input){
    const tipoInput = input.dataset.tipo

    if(validadores[tipoInput]){
        validadores[tipoInput](input)
    }

    if(input.validity.valid){
        input.classList.remove('is-invalid')
        input.classList.add('is-valid')
        input.parentElement.querySelector('.invalid-feedback').innerHTML = ''
    }else {
        input.classList.add('is-invalid')
        input.classList.remove('is-valid')
        console.log(input.parentElement.querySelector('.invalid-feedback'))
        input.parentElement.querySelector('.invalid-feedback').innerHTML = mostraMensagemDeError(tipoInput,input)
    }
}

const tiposDeErro = [
    'valueMissing',
    'typeMismatch',
    'customError',
    'patternMismatch'
]

function validaRenda(input){
    const renda = input.value.replace(/(R\$\s)/g, '').replace(/\D/g ,'.' )
    let mensagem = ''
    if(renda <= 0.00){
        mensagem = 'A renda não pode ser zero'
    }

    input.setCustomValidity(mensagem)
}

const mensagensDeErro = {
    nome : {
        valueMissing: 'O campo nome não pode estar vazio'
    },
    cpf:{
        valueMissing: 'O campo CPF não pode estar vazio',
        customError: 'O CPF digitado não é válido'
    },
    telefone:{
        valueMissing: 'O campo telefone não pode estar vazio',
        patternMismatch: 'O número digitado está errado. Alguns exemplos aceitos:' +
            '\n(DDD) 9xxxx-xxxx, \nDDD 9xxxx-xxxx, \nDDD9xxxxxxxx'
    },
    email: {
        valueMissing: 'O campo email não pode estar vazio',
        typeMismatch: 'o email digitado não é válido'
    },
    profissao:{
        valueMissing: 'O campo profissão não pode estar vazio'
    },
    renda:{
        valueMissing: 'O campo renda não pode estar vazio',
        customError: 'A renda não pode ser zero'
    },
    rua:{
        valueMissing: 'O campo rua não pode estar vazio'
    },
    numero:{
        valueMissing: 'O campo número não pode estar vazio',
        patternMismatch: 'O numero digitado é inválido'
    },
    bairro:{
        valueMissing: 'O campo bairro não pode estar vazio '
    },
    cidade:{
        valueMissing: 'O campo cidade não pode estar vazio'
    },
    estado:{
        valueMissing:'O campo estado não pode estar vazio'
    }

}

function mostraMensagemDeError(tipoDeInput, input){

    let mensagem = ''

    tiposDeErro.forEach(erro => {
        if(input.validity[erro]){
            mensagem = mensagem + mensagensDeErro[tipoDeInput][erro] + ';\n'
        }
    })

    return mensagem
}

function validaCPF(input) {
    const cpfFormatado = input.value.replace(/\D/g, '')
    let mensagem = ''

    if(!checaCPFRepetido(cpfFormatado) || !checaEstruturaCPF(cpfFormatado)) {
        mensagem = 'O CPF digitado não é válido.'
    } else {
        input.value = cpfFormatado.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
    }

    input.setCustomValidity(mensagem)
}

function checaCPFRepetido(cpf) {
    const valoresRepetidos = [
        '00000000000',
        '11111111111',
        '22222222222',
        '33333333333',
        '44444444444',
        '55555555555',
        '66666666666',
        '77777777777',
        '88888888888',
        '99999999999'
    ]
    let cpfValido = true

    valoresRepetidos.forEach(valor => {
        if(valor == cpf) {
            cpfValido = false
        }
    })

    return cpfValido
}

function checaEstruturaCPF(cpf) {
    const multiplicador = 10

    return checaDigitoVerificador(cpf, multiplicador)
}

function checaDigitoVerificador(cpf, multiplicador) {
    if(multiplicador >= 12) {
        return true
    }
    let multiplicadorInicial = multiplicador
    let soma = 0
    const cpfSemDigitos = cpf.substr(0, multiplicador - 1).split('')
    const digitoVerificador = cpf.charAt(multiplicador - 1)
    for(let contador = 0; multiplicadorInicial > 1 ; multiplicadorInicial--) {
        soma = soma + cpfSemDigitos[contador] * multiplicadorInicial
        contador++
    }

    if(digitoVerificador == confirmaDigito(soma)) {
        return checaDigitoVerificador(cpf, multiplicador + 1)
    }

    return false
}

function confirmaDigito(soma) {
    return 11 - (soma % 11)
}

function formataTelefone(input) {
    const telNumeros = input.value.replace(/\D/g, '')
    input.value = telNumeros.replace(/(\d{2})(\d{5})(\d{4})/,'($1) $2-$3')
}