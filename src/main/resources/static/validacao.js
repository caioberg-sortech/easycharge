const validadores = {
    cpf:input => validaCPF(input)
}

export function valida(input){
    const tipoInput = input.dataset.tipo

    if(validadores[tipoInput]){
        validadores[tipoInput](input)
    }

    if(input.validity.valid){

    }
}

const mensagensDeErro = {
    nome : {
        valueMissing: 'O campo nome não pode estar vazio'
    },
    cpf:{
        valueMissing: 'O campo CPF não pode estar vazio'
    },
    telefone:{
        valueMissing: 'O campo telefone não pode estar vazio'
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


