import valida from "./validacao.js";

const inputs  = document.querySelectorAll('input')
const select: HTMLInputElement = document.querySelector('#estado')
const form: HTMLFormElement  = document.querySelector('form')
//import * as _SimpleMaskMoney from 'simple-mask-money'
//const SimpleMaskMoney = require('simple-mask-money') as _SimpleMaskMoney

inputs.forEach(input =>{
    if(input.dataset.tipo === 'renda') {
       /* SimpleMaskMoney.setMask(input, {
            prefix: 'R$ ',
            fixed: true,
            fractionDigits: 2,
            decimalSeparator: ',',
            thousandsSeparator: '.',
            cursor: 'end'
        })
        form.addEventListener('submit', (evento) =>{
            input.value = SimpleMaskMoney.formatToNumber(input.value)
        })*/
    }
    input.addEventListener('blur', function () {
        valida(input)
    })

})

select.addEventListener('change',function (){
    valida(select)
})