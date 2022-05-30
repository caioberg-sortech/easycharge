import {valida} from './validacao.js'

const inputs = document.querySelectorAll('input')
const select = document.querySelector('#estado')
const button = document.querySelector('#cadastro')
const renda = document.querySelector('#renda')

inputs.forEach(input =>{
    if(input.dataset.tipo === 'renda') {
        SimpleMaskMoney.setMask(input, {
            prefix: 'R$ ',
            fixed: true,
            fractionDigits: 2,
            decimalSeparator: ',',
            thousandsSeparator: '.',
            cursor: 'end'
        })
    }
    input.addEventListener('blur', (evento) =>{
        valida(input)
    })
})
button.addEventListener('click' , (evento) =>{
    inputs.forEach(input =>{
        valida(input)
    })
    valida(select)

})

button.addEventListener('submit',(evento) =>{
    renda.value = renda.value.replace(/(R\$\s)/g, '').replace(/\D/g ,'.' )
})

select.addEventListener('change',(evento) =>{
    valida(evento.target)
})