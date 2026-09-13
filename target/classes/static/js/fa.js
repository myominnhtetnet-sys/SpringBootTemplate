const editUserModal = document.getElementById('editUserModal');

if (editUserModal) {
    editUserModal.addEventListener('show.bs.modal', function(event) {
        const button = event.relatedTarget;
        const userId = button.getAttribute('data-id');

        fetch(`/user/edit/${userId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch user');
                }
                return response.json();
            })
            .then(user => {
                document.getElementById('editId').value = user.id;
                document.getElementById('editName').value = user.name;
                document.getElementById('editEmail').value = user.email;
                document.getElementById('editPhone').value = user.phoneNo;
                document.getElementById('editAddress').value = user.address;
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
}

document.getElementById("updateForm").addEventListener('submit', function(event) {
    event.preventDefault();

    const user = {

        id: document.getElementById("editId").value,
        name: document.getElementById("editName").value,
        email: document.getElementById("editEmail").value,
        phoneNo: document.getElementById("editPhone").value,
        address: document.getElementById("editAddress").value
    };
	fetch('/user/update', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(user)
	})
        .then(
            response => {
                if (response.ok) {
                    window.location.href = "/user/list"
                } else {
                    throw new Error("No response!");
                }
            }
        )
        .catch(error => {
            console.error('Error:', error);
        });
});