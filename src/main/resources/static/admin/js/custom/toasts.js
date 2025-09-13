function toastSuccess(title, body) {
	$(document).Toasts('create', {
        class: 'bg-success',
        title: title,
		body: body,
        autohide: true,
        delay: 3000,
		icon: 'fas fa-info-circle fa-lg',
	});
}

function toastInfo(title, body) {
	$(document).Toasts('create', {
        class: 'bg-info',
        title: title,
		body: body,
        autohide: true,
        delay: 3000,
		icon: 'fas fa-info-circle fa-lg',
	});
}

function toastWarning(title, body) {
	$(document).Toasts('create', {
        class: 'bg-warning',
        title: title,
		body: body,
        autohide: true,
        delay: 3000,
		icon: 'fas fa-info-circle fa-lg',
	});
}

function toastError(title, body) {
	$(document).Toasts('create', {
        class: 'bg-danger',
        title: title,
		body: body,
        autohide: true,
        delay: 3000,
		icon: 'fas fa-info-circle fa-lg',
	});
}

function toastMaroon(title, body) {
	$(document).Toasts('create', {
        class: 'bg-maroon',
        title: title,
		body: body,
        autohide: true,
        delay: 3000,
		icon: 'fas fa-info-circle fa-lg',
	});
}
