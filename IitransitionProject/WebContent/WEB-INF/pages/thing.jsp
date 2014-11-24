<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

<script>   
function addInput() {
      var id = document.getElementById("default-id").value;
      id++;
      $("table[id=table]").append('<div id="div-' + id + '"><tr><td><input name="properties[]" id="input-' + id + '" value="' + id + '"></td></tr></div>');
      document.getElementById("default-id").value = id;
    }    
</script>
<title>Add thing</title>


<body>
    <h1>${title}</h1>
    <div>
        <h3>${message}</h3>                  
        <form name='thing' enctype="multipart/form-data"
            action="<c:url value='/thing' />" method='POST'>
            <input type="hidden" id="default-id" value="1">
            <table id='table'>
                <tr>
                    <td><input type="file" name="picture" accept="image/jpeg"  size="50" /></td>
                <tr>
                    <td><input id="name" type='text' name='name' value="enter name"></td>

                </tr>
                 <tr>
                    <td><input type="button" value="add parameter" id="add" onclick="addInput()" >
                </tr>                            
            </table>   
            <input type="submit" value="add thing">                             
        </form>
    </div>
</body>
</html>