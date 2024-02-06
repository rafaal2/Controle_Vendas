function showProducts() {
    fetch('http://localhost:8080/Product')
        .then(response => response.json())
        .then(data => {
            const listaDiv = document.getElementById('Lista');
            listaDiv.innerHTML = '';

            data.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.innerHTML = `ID: ${product.code},
                    Nome: ${product.name},
                    Preço: ${product.price},
                    Quantidade: ${product.quantity}`;
                listaDiv.appendChild(productDiv);
            });
        })
        .catch(error => console.error('Erro:', error));
}

function deleteProduct(code) {
    console.log("Deleting product with code:", code);
    fetch(`http://localhost:8080/Product/${code}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            console.log('Produto excluído com sucesso!');
            showProducts(); // Atualiza a lista após a exclusão
        } else {
            console.error('Erro ao excluir o produto:', response.statusText);
        }
    })
    .catch(error => console.error('Erro:', error));
}

function findById(code) {
    console.log("Finding product by ID:", code);
    fetch(`http://localhost:8080/Product/${code}`)
        .then(response => response.json())
        .then(product => {
            const productDiv = document.createElement('div');
            productDiv.innerHTML = `ID: ${product.code},
                Nome: ${product.name},
                Preço: ${product.price},
                Quantidade: ${product.quantity}`;
            const listaDiv = document.getElementById('Lista');
            listaDiv.innerHTML = '';
            listaDiv.appendChild(productDiv);
        })
        .catch(error => console.error('Erro:', error));
}


document.getElementById('operation').addEventListener('submit', function (event) {
    event.preventDefault();

    const selectedOperation = document.getElementById('operationSelect').value;
    const code = document.getElementById('code').value;

    if (selectedOperation === 'findbyid') {
        findById(code);
    } else if (selectedOperation === 'delete') {
        deleteProduct(code);
    }else if (selectedOperation === 'find') {
             showProducts();
         }
});
document.addEventListener('DOMContentLoaded', function () {
    showProducts();
});
