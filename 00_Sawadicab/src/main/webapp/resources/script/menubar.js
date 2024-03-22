function date() {
    const date1 = document.getElementById("date1");
    const date2 = document.getElementById("date2");
    date2.setAttribute("min", date1.value);  
}