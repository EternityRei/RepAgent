document.getElementById('top-up-btn').addEventListener('click',
    function(){
        document.querySelector('.bg-modal').style.display = 'flex';
    });

document.querySelector('.close').addEventListener('click',
    function (){
        document.querySelector('.bg-modal').style.display = 'none';
    });