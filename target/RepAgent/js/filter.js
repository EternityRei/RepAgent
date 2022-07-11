function getUniqueValuesFromColumn() {

    var unique_col_values_dict = {}

    allFilters = document.querySelectorAll(".table-filter")

    allFilters.forEach(filter_i => {
        col_index = filter_i.parentElement.getAttribute("col-index");
        const rows = document.getElementById("#sortTable > tbody > tr")

        rows.forEach((row) => {
            console.log(row.querySelector("td:nth-child(+col_index)"));
        })
    });
};