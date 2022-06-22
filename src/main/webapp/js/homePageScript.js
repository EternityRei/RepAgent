let text = document.getElementById('text');
window.addEventListener('scroll', function (){
    let value = window.scrollY;
    text.style.marginTop = value * 4 + 'px';
})