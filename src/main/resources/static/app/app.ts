import valida from "./validacao.js";
declare global {
    class SimpleMaskMoney{
        static setMask(input: HTMLInputElement, config: any): void;
        static formatToNumber(value: string): string;
    }
}


const inputs  = document.querySelectorAll('input')
const select: HTMLInputElement = document.querySelector('#estado')
const form: HTMLFormElement  = document.querySelector('form')

inputs.forEach((input: HTMLInputElement) =>{
    if(input.dataset.tipo === 'renda') {
        SimpleMaskMoney.setMask(input, {
            prefix: 'R$ ',
            fixed: true,
            fractionDigits: 2,
            decimalSeparator: ',',
            thousandsSeparator: '.',
            cursor: 'end'
        })
        form.addEventListener('submit', (evento) =>{
            input.value = SimpleMaskMoney.formatToNumber(input.value)
        })
    }
    input.addEventListener('blur', function () {
        valida(input)
    })

})

select.addEventListener('change',function (){
    valida(select)
})