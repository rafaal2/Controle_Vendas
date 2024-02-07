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
            showProducts();
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
function createProduct(name, price, quantity) {
    const productData = {
        name: name,
        price: price,
        quantity: quantity
    };

    fetch('http://localhost:8080/Product', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(productData)
    })
    .then(response => {
        if (response.ok) {
            console.log('Produto criado com sucesso!');
            showProducts();
        } else {
            console.error('Erro ao criar o produto:', response.statusText);
        }
    })
    .catch(error => console.error('Erro:', error));
}

function AttProduct() {
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


document.getElementById('codeEntry').addEventListener('submit', function (event) {
    event.preventDefault();

    const selectedOperation = document.getElementById('operationSelect').value;

    if (selectedOperation === 'findbyid') {
        const code = document.getElementById('code').value;
        findById(code);
    } else if (selectedOperation === 'delete') {
        const code = document.getElementById('code').value;
        deleteProduct(code);
        showProducts();
    }
});

document.getElementById('operation').addEventListener('submit', function (event) {
    event.preventDefault();

    const selectedOperation = document.getElementById('operationSelect').value;

    if (selectedOperation === 'find') {
        showProducts();
    } else if (selectedOperation === 'create') {
        const name = document.getElementById('name').value;
        const price = document.getElementById('price').value;
        const quantity = document.getElementById('quantity').value;

        createProduct(name, price, quantity);
        showProducts();
    } else if (selectedOperation === 'update') {
        AttProduct();
        showProducts();
    }
});

// Manipulador de evento change para ocultar ou exibir o formulário de código e o formulário oculto
document.getElementById('operationSelect').addEventListener('change', function (event) {
    const selectedOperation = event.target.value;

    const codeEntryForm = document.getElementById('codeEntry');
    const hiddenForm = document.getElementById('hiddenForm');

    // Verifica se a operação selecionada requer a entrada de código
    if (selectedOperation === 'findbyid' || selectedOperation === 'delete') {
        codeEntryForm.classList.remove('hidden2');
    } else {
        codeEntryForm.classList.add('hidden2');
    }

    // Verifica se a operação selecionada requer o formulário oculto
    if (selectedOperation === 'create' || selectedOperation === 'update') {
        hiddenForm.classList.remove('hidden');
    } else {
        hiddenForm.classList.add('hidden');
    }
});

document.addEventListener('DOMContentLoaded', function () {
    showProducts();
});