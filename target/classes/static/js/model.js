const editUserModal = document.getElementById('editUserModal');
if (editUserModal) {
    editUserModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; 
        
        document.getElementById('editId').value = button.getAttribute('data-id');
        document.getElementById('editName').value = button.getAttribute('data-name');
        document.getElementById('editEmail').value = button.getAttribute('data-email');
        document.getElementById('editPhone').value = button.getAttribute('data-phone');
        document.getElementById('editAddress').value = button.getAttribute('data-address');
    });
}