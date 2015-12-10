function checkEmail()
{
var xmlhttp;
var k=document.getElementById("email").value;

var urls="checkEmail?email="+k;
 
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
      
        document.getElementById("checkEmail").innerHTML=xmlhttp.responseText;
 
    }
  };
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}