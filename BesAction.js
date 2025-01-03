

// const mont_device =










function Search(){
    var dop = document.querySelector('.pain .searchBar');
    dop.style.display = dop.style.display == "block" ? "none" : "block";
    console.log(dop.style.display);
}
function burgerSnap(){
var dop = document.querySelector('nav')
dop.classList.toggle('snap')
document.querySelector('.pain .searchBar').style.display = "none";
}

var arr = {
    0: "tokyoghoulafter.jpg",
    1: "monsterafter.jpg",
    2: "berserkafter.jpg",
    3: "claymoreafter.png",
    4: "vagabondafter.jpg",
    5: "dragonballafter.jpg",
    6: "GTOafter.jpg",
    7: "AOTafter.jpg",
    8: "narutoafter.jpg",
    9: "hajimenoippoafter.jpg",
    10: "onepunchmanafter.png",
    11: "demonslayerafter.jpg",
    12: "chainsawmanafter.jpg",
    13: "Jujutsukaisenafter.jpg",
    14: "vinlandafter.jpg",
    15: "fullmetalafter.jpg",
    16: "paradiseafter.jpg",
    17: "firepunchafter.jpg",
}
// $('.card').click(function (e) { 
//     
//     console.log(e.target.childNodes[1].childNodes[5]);

// });
var cards = document.querySelectorAll('.card');
var el = document.querySelector('.card');
var _cache_div;

for(let i=0; i<cards.length;i++){
    cards[i].addEventListener('click', e => {
        console.log(el.className, "example card", e.target.className);
        if(el.className == e.target.className || e.target.className == "example card" || e.target.className == "card example"){
        if(_cache_div == undefined){
            _cache_div = e.target.childNodes[1].childNodes[5];
        }
        else{
            _clear_cache(_cache_div);
        }
        $('.card').addClass('example');
        $('.card').removeClass('example1');
        e.target.classList.toggle("example") 
        e.target.classList.toggle("example1")
        // e.target.classList.toggle("example1")
        e.target.childNodes[1].childNodes[5].classList.toggle('after');
        e.target.childNodes[1].childNodes[5].classList.toggle('after1');
        e.target.childNodes[1].style.backgroundImage = `url(src/${arr[i]})`
        setTimeout(() => {
            $('html, body').animate({
                scrollTop: cards[i].offsetTop
            }, 500);
        }, 200);
        _cache_div = e.target.childNodes[1].childNodes[5];
    }
            
    })
}
function _clear_cache(_cache_div) {
    _cache_div.classList.toggle('after');
    _cache_div.classList.toggle('after1');
}