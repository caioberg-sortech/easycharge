import {valida} from './validacao.js'

const inputs = document.querySelectorAll('input')
const select = document.querySelector('#estado')

inputs.forEach(input =>{
    // if(input.dataset.tipo === 'renda') {
    //     SimpleMaskMoney.setMask(input, {
    //         prefix: 'R$ ',
    //         fixed: true,
    //         fractionDigits: 2,
    //         decimalSeparator: ',',
    //         thousandsSeparator: '.',
    //         cursor: 'end'
    //     })
    // }
    input.addEventListener('blur', (evento) =>{
        valida(evento.target)
    })

})

select.addEventListener('change',(evento) =>{
    valida(evento.target)
})