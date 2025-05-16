
var admin =document.getElementById("adminModal");

admin.style.display = "none";
function Admin(){
    if(admin.style.display === "none"){
        admin.style.display = "flex";
    }else{
        admin.style.display = "none";
    }
}