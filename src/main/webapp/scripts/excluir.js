const btn = document.querySelector(".btn-delete");

function confirmDeletion(id) {
	let response = confirm("Quer mesmo excluir esse produto?")
	if (response) window.location.href = "delete?id=" + id;
}