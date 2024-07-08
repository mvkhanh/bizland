function showSuccessMessage(message, redirectUrl) {
    Swal.fire({
        title: "Thành công!",
        text: message,
        icon: "success",
        timer: 1500,
        timerProgressBar: true,
        confirmButtonText: 'OK'
    }).then((result) => {
        if (result.dismiss === Swal.DismissReason.timer || result.isConfirmed) {
            if(redirectUrl !== '') window.location.href = redirectUrl;
        }
    });
}

function showErrorMessage(message) {
    Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
        confirmButtonText: 'OK'
    });
}