const btn = document.querySelector(".btn-form")
const formNewProduct = document.querySelector(".form-produto");

function validarForm() {


	let nome = formNewProduct.nome.value;
	let codigo = formNewProduct.codigo.value;
	let preco = formNewProduct.preco.value;

	if (nome === "") {
		alert("Preencha o campo produto")
		formNewProduct.nome.focus();
		return false
	} else if (codigo === "") {
		alert("Preencha o campo código")
		formNewProduct.codigo.focus();
		return false
	} else if (preco === "") {
		alert("Preencha o campo preço")
		formNewProduct.preco.focus();
		return false
	} else {
		document.forms["form-produto"].submit();
	}

}

btn.addEventListener("click", validarForm)