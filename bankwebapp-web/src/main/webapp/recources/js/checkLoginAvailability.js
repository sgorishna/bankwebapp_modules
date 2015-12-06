function loadXMLDoc()
{
var xmlhttp;
var k=document.getElementById("login").value;
var urls="../pass.jsp?ver="+k;
 
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
      
        document.getElementById("err").innerHTML=xmlhttp.responseText;
 
    }
  };
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}