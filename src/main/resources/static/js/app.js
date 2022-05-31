import {valida} from './validacao.js'

const inputs = document.querySelectorAll('input')
const select = document.querySelector('#estado')
const form = document.querySelector('form')
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
        valida(evento.target)
    })

})

form.addEventListener('submit', (evento) =>{
    renda.value =  SimpleMaskMoney.formatToNumber(renda.value)
})

select.addEventListener('change',(evento) =>{
    valida(evento.target)
})