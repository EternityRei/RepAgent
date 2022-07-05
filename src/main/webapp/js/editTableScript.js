$(document).ready(function() {
    $('#edit-modal').on('show.bs.modal', function (event) {
        var btn = $(event.relatedTarget),
            id = btn.data('id');
            payment = btn.data('payment_id');
            work_status = btn.data('work_status_id');
            worker = btn.data('worker');

        $('#edit-modal').find('#edit-id').val(id);
        $('#edit-modal').find('#edit-payment').val(payment);
        $('#edit-modal').find('#edit-work-status').val(work_status);
        $('#edit-modal').find('#edit-worker').val(worker);
    })

    $('#delete-modal').on('show.bs.modal', function (event) {
        var btn = $(event.relatedTarget),
            title = btn.data('title');

        $('#delete-modal').find('#delete-title').text(title);
    })
})