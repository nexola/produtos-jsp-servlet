const btn = document.querySelector(".btn-form")
const formNewProduct = document.querySelector(".form-produto");

function validarForm(e) {

	let nome = formNewProduct.nome.value;
	let codigo = formNewProduct.codigo.value;
	let preco = formNewProduct.preco.value;
	
	if (isNaN(+preco) || +preco <= 0) {
		alert("O campo preço precisa de um valor numérico positivo")
		formNewProduct.nome.focus();
		e.preventDefault();
		return false;
	} else if (nome === "") {
		alert("Preencha o campo produto")
		formNewProduct.nome.focus();
		e.preventDefault();
		return false;
	} else if (codigo === "") {
		alert("Preencha o campo código")
		formNewProduct.codigo.focus();
		e.preventDefault();
		return false;
	} else if (preco === "") {
		alert("Preencha o campo preço")
		formNewProduct.preco.focus();
		e.preventDefault();
		return false;
	} else {
		document.forms["form-produto"].submit();
	} 

}

btn.addEventListener("click", validarForm)