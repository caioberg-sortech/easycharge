function validaCPF(input) {
    
}

const validadores = {
    cpf:input => validaCPF(input)
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
        input.parentElement.querySelector('.invalid-feedback').innerHTML = mostraMensagemDeError(tipoInput,input)
    }
}

const tiposDeErro = [
    'valueMissing',
    'typeMismatch',
    'customError',
    'patternMismatch'
]

const mensagensDeErro = {
    nome : {
        valueMissing: 'O campo nome não pode estar vazio'
    },
    cpf:{
        valueMissing: 'O campo CPF não pode estar vazio'
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
        valueMissing: 'O campo email não pode estar vazio'
    },
    rua:{
        valueMissing: 'O campo rua não pode estar vazio'
    },
    numero:{
        valueMissing: 'O campo número não pode estar vazio'
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
            mensagem = mensagem + mensagensDeErro[tipoDeInput][erro] + ';'
        }
    })

    return mensagem

}
