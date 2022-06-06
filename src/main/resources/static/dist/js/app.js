import valida from "./validacao.js";
const inputs = document.querySelectorAll('input');
const select = document.querySelector('#estado');
const form = document.querySelector('form');
inputs.forEach(input => {
    if (input.dataset.tipo === 'renda') {
        /*SimpleMaskMoney.setMask(input, {
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
        valida(input);
    });
});
select.addEventListener('change', function () {
    valida(select);
});
