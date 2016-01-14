function checkLogin()
{
var xmlhttp;
var k=document.getElementById("login").value;


var urls = getContextPath()+"/checkLogin?login="+k;

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
      
        document.getElementById("checkLogin").innerHTML=xmlhttp.responseText;
 
    }
  };
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}