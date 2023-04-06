const form = document.forms.AddBill;
const typeSelect = form.elements.type;
const numberInput = form.elements.number;
const productSelect = form.elements.opProduct;

form.addEventListener('submit', function(event) {
  const selectedProduct = productSelect.options[productSelect.selectedIndex].text;
  const availableAmount = selectedProduct.split(' - ')[1].split(' ')[0];
  
  if (typeSelect.value === '1') {
    // check if input number exceeds available amount
    if (Number(numberInput.value) > Number(availableAmount)) {
      alert(`Số lượng không thể vượt quá ${availableAmount}`);
      numberInput.value = availableAmount; // reset input value to available amount
      event.preventDefault();
    }
  }

  if (Number(numberInput.value) <= 0) {
    alert('Số lượng không thể nhỏ hơn 0');
    numberInput.value = 0; 
    event.preventDefault();
  }
});

typeSelect.addEventListener('change', () => {
  const selectedProduct = productSelect.options[productSelect.selectedIndex].text;
  const availableAmount = selectedProduct.split(' - ')[1].split(' ')[0];
  
  if (typeSelect.value === '1') {
    // check if input number exceeds available amount
    if (Number(numberInput.value) > Number(availableAmount)) {
      alert(`Số lượng không thể vượt quá ${availableAmount}`);
      numberInput.value = availableAmount; // reset input value to available amount
    }
  }

  if (Number(numberInput.value) <= 0) {
    alert('Số lượng không thể nhỏ hơn 0');
    numberInput.value = 0; 
  }
});