function valid() {
var copies   = document.getElementById("copies").value;
var price   = document.getElementById("price").value;
if(copies<0)
{
	alert("enter a valid no of copies");
	return false;
}
if(price<0)
{
	alert("enter a valid price");
	return false;
}
return true;
}